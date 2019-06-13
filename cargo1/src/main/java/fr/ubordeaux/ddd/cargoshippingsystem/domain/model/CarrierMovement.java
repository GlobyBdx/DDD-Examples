package fr.ubordeaux.ddd.cargoshippingsystem.domain.model;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.exception.CarrierMovementException;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.LocationID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.ScheduleID;

/**
 * Entity
 * 
 */

public class CarrierMovement {
	private ScheduleID scheduleID;
	private LocationID fromLocationID;
	private LocationID toLocationID;

	public CarrierMovement(ScheduleID scheduleID) {
		this.setScheduleID(scheduleID);
	}

	private void setScheduleID(ScheduleID scheduleID) {
		if (scheduleID == null) throw new CarrierMovementException("Cannot create CarrierMovement with a null ScheduleID.");
		this.scheduleID = scheduleID;
	}

	public void setFromLocationID(LocationID fromLocationID) {
		this.fromLocationID = fromLocationID;
	}

	public void setToLocationID(LocationID toLocationID) {
		this.toLocationID = toLocationID;
	}

	public ScheduleID getScheduleID() {
		return this.scheduleID;
	}

	public LocationID getFromLocationID() {
		return this.fromLocationID;
	}

	public LocationID getToLocationID() {
		return this.toLocationID;
	}

	@Override
	public boolean equals(Object other) {
		if (! (other instanceof CarrierMovement)) return false;
		return this.scheduleID.equals(((CarrierMovement)other).scheduleID);
	}

	@Override
	public int hashCode() {
		return this.scheduleID.hashCode();
	}

	@Override
	public String toString() {
		return this.scheduleID.toString();
	}
}