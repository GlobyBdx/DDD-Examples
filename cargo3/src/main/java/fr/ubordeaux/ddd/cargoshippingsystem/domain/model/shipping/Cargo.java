package fr.ubordeaux.ddd.cargoshippingsystem.domain.model.shipping;

import java.util.HashSet;
import java.util.Set;

/**
 * Entity/Root of Aggregate (Cargo, DeliveryHistory and DeliverySpecification)
 * 
 */

public class Cargo {
	private CargoTrackingID cargoTrackingID;
	private Set<CargoCustomer> cargoCustomers;
	private DeliveryHistory deliveryHistory;
	private DeliverySpecification deliverySpecification;

	public Cargo(CargoTrackingID cargoTrackingID) {
		this.setCargoTrackingID(cargoTrackingID);
		this.cargoCustomers = new HashSet<>();
		this.deliveryHistory = new DeliveryHistory(this);
		this.deliverySpecification = null;
	}

	private void setCargoTrackingID(CargoTrackingID cargoTrackingID) {
		if (cargoTrackingID == null) throw new CargoException("Cannot create Cargo with a null CargoTrackingID.");
		this.cargoTrackingID = cargoTrackingID;
	}

	public void setCargoCustomers(Set<CargoCustomer> cargoCustomers) {
		this.cargoCustomers = cargoCustomers;
	}

	public void setDeliverySpecification(DeliverySpecification deliverySpecification) {
		this.deliverySpecification = deliverySpecification;
	}

	public CargoTrackingID getCargoTrackingID() {
		return this.cargoTrackingID;
	}

	public Set<CargoCustomer> getCargoCustomers() {
		return this.cargoCustomers;
	}

	public DeliveryHistory getDeliveryHistory() {
		return this.deliveryHistory;
	}

	public DeliverySpecification getDeliverySpecification() {
		return this.deliverySpecification;
	}

	@Override
	public boolean equals(Object other) {
		if (! (other instanceof Cargo)) return false;
		return this.cargoTrackingID.equals(((Cargo)other).cargoTrackingID);
	}

	@Override
	public int hashCode() {
		return this.cargoTrackingID.hashCode();
	}

	@Override
	public String toString() {
		return this.cargoTrackingID.toString();
	}
}