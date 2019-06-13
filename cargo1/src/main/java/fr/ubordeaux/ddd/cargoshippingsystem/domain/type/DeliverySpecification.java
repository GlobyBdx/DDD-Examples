package fr.ubordeaux.ddd.cargoshippingsystem.domain.type;

import java.util.Objects;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.exception.CargoException;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.LocationID;

/**
 * Value Object
 * 
 */

public class DeliverySpecification {
	private LocationID destinationID;
	private EventType deliveryStatus;

	public DeliverySpecification(LocationID destinationID, EventType deliveryStatus) {
		this.setDestinationID(destinationID);
		this.setDeliveryStatus(deliveryStatus);
	}

	private void setDestinationID(LocationID destinationID) {
		if (destinationID == null) throw new CargoException("Cannot create DeliverySpecification without LocationID.");
		this.destinationID = destinationID;
	}

	private void setDeliveryStatus(EventType deliveryStatus) {
		if (deliveryStatus == null) throw new CargoException("Cannot create DeliverySpecification without DeliveryStatus.");
		this.deliveryStatus = deliveryStatus;
	}

	public LocationID getDestinationID() {
		return this.destinationID;
	}

	public EventType getDeliveryStatus() {
		return this.deliveryStatus;
	}

	@Override
	public boolean equals(Object other) {
		if (! (other instanceof DeliverySpecification)) return false;
		return (this.destinationID.equals(((DeliverySpecification) other).destinationID)
				&& this.deliveryStatus.equals(((DeliverySpecification) other).deliveryStatus));
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.toString());
	}

	@Override
	public String toString() {
		return this.destinationID.toString() + ":" + this.deliveryStatus.toString();
	}
}