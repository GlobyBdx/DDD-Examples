package fr.ubordeaux.ddd.cargoshippingsystem.application;

import java.util.Set;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.exception.CargoException;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.exception.CustomerException;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.exception.LocationException;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.Cargo;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.CargoFactory;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.CargoRepository;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.Customer;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.CustomerRepository;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.HandlingEvent;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.HandlingEventFactory;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.HandlingEventRepository;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.LocationRepository;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CargoCustomer;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CargoTrackingID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.DeliverySpecification;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.EventType;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.LocationID;

/**
 * Service implementation
 * 
 */

public class BookingImplementation extends Booking {
	private final CargoRepository cargoRepository;
	private final CustomerRepository customerRepository;
	private final LocationRepository locationRepository;
	private final HandlingEventRepository handlingEventRepository;

	private final CargoFactory cargoFactory;
	private final HandlingEventFactory handlingEventFactory;

	public BookingImplementation(CargoRepository cargoRepository, CustomerRepository customerRepository, LocationRepository locationRepository, HandlingEventRepository handlingEventRepository) {
		this.cargoRepository = cargoRepository;
		this.customerRepository = customerRepository;
		this.locationRepository = locationRepository;
		this.handlingEventRepository = handlingEventRepository;
		this.cargoFactory = new CargoFactory(cargoRepository);
		this.handlingEventFactory = new HandlingEventFactory();
	}

	@Override
	public CargoTrackingID bookCargo(Set<CargoCustomer> cargoCustomers, LocationID locationID) {
		if (this.locationRepository.findByLocationID(locationID) == null) {
			throw new LocationException("Location with given ID not found.");
		}
		Cargo cargo = this.cargoFactory.newCargo(cargoCustomers);
		DeliverySpecification deliverySpecification = new DeliverySpecification(locationID, EventType.RECEIVED);
		cargo.setDeliverySpecification(deliverySpecification);
		HandlingEvent handlingEvent = this.handlingEventFactory.newBookingHandlingEvent(cargo.getCargoTrackingID(), null);
		this.handlingEventRepository.store(handlingEvent);
		cargo.getDeliveryHistory().addHandlingEvent(handlingEvent);
		this.cargoRepository.store(cargo);
		for (CargoCustomer cargoCustomer : cargoCustomers) {
			Customer customer = this.customerRepository.findByCustomerID(cargoCustomer.getCustomerID());
			if (customer == null) {
				throw new CustomerException("Customer with given ID not found.");
			}
			customer.addCargoTrackingID(cargo.getCargoTrackingID());
		}
		return cargo.getCargoTrackingID();
	}

	@Override
	public CargoTrackingID bookAnotherCargo(CargoTrackingID cargoTrackingID, LocationID locationID) {
		if (this.locationRepository.findByLocationID(locationID) == null) {
			throw new LocationException("Location with given ID not found.");
		}
		Cargo cargo = this.cargoRepository.findByCargoTrackingID(cargoTrackingID);
		if (cargo == null) {
			throw new CargoException("Cargo with given ID not found.");
		}
		Cargo anotherCargo = this.cargoFactory.newCargo(cargo);
		DeliverySpecification deliverySpecification = new DeliverySpecification(locationID, EventType.RECEIVED);
		anotherCargo.setDeliverySpecification(deliverySpecification);
		HandlingEvent handlingEvent = this.handlingEventFactory.newBookingHandlingEvent(cargo.getCargoTrackingID(), null);
		this.handlingEventRepository.store(handlingEvent);
		anotherCargo.getDeliveryHistory().addHandlingEvent(handlingEvent);
		this.cargoRepository.store(anotherCargo);
		for (CargoCustomer cargoCustomer : anotherCargo.getCargoCustomers()) {
			Customer customer = this.customerRepository.findByCustomerID(cargoCustomer.getCustomerID());
			if (customer == null) {
				throw new CustomerException("Customer with given ID not found.");
			}
			customer.addCargoTrackingID(anotherCargo.getCargoTrackingID());
		}
		return anotherCargo.getCargoTrackingID();
	}

	@Override
	public void cancelBookedCargo(CargoTrackingID cargoTrackingID) {
		Cargo cargo = this.cargoRepository.findByCargoTrackingID(cargoTrackingID);
		if (cargo == null) {
			throw new CargoException("Cargo with given ID not found.");
		}
		if (cargo.getDeliverySpecification() == null) {
			throw new BookingException("Cargo with given ID not booked.");
		}
		HandlingEvent handlingEvent = this.handlingEventFactory.newCancelingHandlingEvent(cargo.getCargoTrackingID(), null);
		this.handlingEventRepository.store(handlingEvent);
		cargo.getDeliveryHistory().addHandlingEvent(handlingEvent);
		this.cargoRepository.store(cargo);
	}

	@Override
	public void changeBookedCargoDestination(CargoTrackingID cargoTrackingID, LocationID locationID) {
		Cargo cargo = this.cargoRepository.findByCargoTrackingID(cargoTrackingID);
		if (cargo == null) {
			throw new CargoException("Cargo with given ID not found.");
		}
		if (cargo.getDeliverySpecification() == null) {
			throw new BookingException("Cargo with given ID not booked.");
		}
		if (this.locationRepository.findByLocationID(locationID) == null) {
			throw new LocationException("Location with given ID not found.");
		}
		DeliverySpecification deliverySpecification = new DeliverySpecification(locationID, cargo.getDeliverySpecification().getDeliveryStatus());
		cargo.setDeliverySpecification(deliverySpecification);
		this.cargoRepository.store(cargo);
	}
}