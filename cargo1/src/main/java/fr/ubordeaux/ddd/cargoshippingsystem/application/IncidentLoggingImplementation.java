package fr.ubordeaux.ddd.cargoshippingsystem.application;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.exception.CargoException;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.exception.LocationException;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.Cargo;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.CargoRepository;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.CarrierMovement;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.CarrierMovementFactory;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.CarrierMovementRepository;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.HandlingEvent;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.HandlingEventFactory;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.HandlingEventRepository;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.LocationRepository;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CargoTrackingID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.LocationID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.ScheduleID;

/**
 * Service implementation
 * 
 */

public class IncidentLoggingImplementation extends IncidentLogging {
	private final CargoRepository cargoRepository;
	private final CarrierMovementRepository carrierMovementRepository;
	private final LocationRepository locationRepository;
	private final HandlingEventRepository handlingEventRepository;

	private final CarrierMovementFactory carrierMovementFactory;
	private final HandlingEventFactory handlingEventFactory;

	public IncidentLoggingImplementation(CargoRepository cargoRepository, LocationRepository locationRepository, CarrierMovementRepository carrierMovementRepository, HandlingEventRepository handlingEventRepository) {
		this.cargoRepository = cargoRepository;
		this.locationRepository = locationRepository;
		this.carrierMovementRepository = carrierMovementRepository;
		this.handlingEventRepository = handlingEventRepository;
		this.carrierMovementFactory = new CarrierMovementFactory(carrierMovementRepository);
		this.handlingEventFactory = new HandlingEventFactory();
	}

	@Override
	public void cargoHasBeenSent(CargoTrackingID cargoTrackingID, LocationID fromLocationID, LocationID toLocationID) {
		Cargo cargo = this.cargoRepository.findByCargoTrackingID(cargoTrackingID);
		if (cargo == null) {
			throw new CargoException("Cargo with given ID not found.");
		}
		if (cargo.getDeliverySpecification() == null) {
			throw new BookingException("Cargo with given ID not booked.");
		}
		if (this.locationRepository.findByLocationID(fromLocationID) == null) {
			throw new LocationException("FromLocation with given ID not found.");
		}
		if (this.locationRepository.findByLocationID(toLocationID) == null) {
			throw new LocationException("ToLocation with given ID not found.");
		}
		CarrierMovement carrierMovement = this.carrierMovementFactory.newCarrierMovement(fromLocationID, toLocationID);
		this.carrierMovementRepository.store(carrierMovement);
		HandlingEvent handlingEvent = this.handlingEventFactory.newSendingHandlingEvent(cargo.getCargoTrackingID(), null, carrierMovement.getScheduleID());
		this.handlingEventRepository.store(handlingEvent);
		cargo.getDeliveryHistory().addHandlingEvent(handlingEvent);
		this.cargoRepository.store(cargo);
	}

	@Override
	public void cargoHasBeenReceived(CargoTrackingID cargoTrackingID) {
		Cargo cargo = this.cargoRepository.findByCargoTrackingID(cargoTrackingID);
		if (cargo == null) {
			throw new CargoException("Cargo with given ID not found.");
		}
		if (cargo.getDeliverySpecification() == null) {
			throw new BookingException("Cargo with given ID not booked.");
		}
		ScheduleID scheduleID = cargo.getDeliveryHistory().getLastHandlingEvent().getScheduleID();
		if (scheduleID == null) {
			throw new IncidentLoggingException("Cargo with given ID cannot be located.");
		}
		if (this.carrierMovementRepository.findByScheduleID(scheduleID).getToLocationID() != cargo.getDeliverySpecification().getDestinationID()) {
			throw new IncidentLoggingException("Cargo with given ID cannot be received.");
		}
		HandlingEvent handlingEvent = this.handlingEventFactory.newReceivingHandlingEvent(cargo.getCargoTrackingID(), null);
		this.handlingEventRepository.store(handlingEvent);
		cargo.getDeliveryHistory().addHandlingEvent(handlingEvent);
		this.cargoRepository.store(cargo);
	}
}