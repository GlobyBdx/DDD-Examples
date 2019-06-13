package fr.ubordeaux.ddd.cargoshippingsystem.domain.model;

import java.util.Date;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CargoTrackingID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.EventType;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.ScheduleID;

/**
 * Factory
 * 
 */

public class HandlingEventFactory {
	private static final Date LONG_TIME = new Date(Long.MAX_VALUE);

	public HandlingEvent newHandlingEvent(CargoTrackingID cargoTrackingID, Date completionTime, EventType eventType) {
		return new HandlingEvent(cargoTrackingID, completionTime, eventType);
	}

	public HandlingEvent newBookingHandlingEvent(CargoTrackingID cargoTrackingID, Date completionTime) {
		HandlingEvent handlingEvent = this.newHandlingEvent(cargoTrackingID, LONG_TIME, EventType.BOOKED);
		return handlingEvent;
	}

	public HandlingEvent newSendingHandlingEvent(CargoTrackingID cargoTrackingID, Date completionTime, ScheduleID scheduleID) {
		HandlingEvent handlingEvent = this.newHandlingEvent(cargoTrackingID, LONG_TIME, EventType.SENT);
		handlingEvent.setScheduleID(scheduleID);
		return handlingEvent;
	}

	public HandlingEvent newReceivingHandlingEvent(CargoTrackingID cargoTrackingID, Date completionTime) {
		HandlingEvent handlingEvent = this.newHandlingEvent(cargoTrackingID, LONG_TIME, EventType.RECEIVED);
		return handlingEvent;
	}

	public HandlingEvent newCancelingHandlingEvent(CargoTrackingID cargoTrackingID, Date completionTime) {
		HandlingEvent handlingEvent = this.newHandlingEvent(cargoTrackingID, LONG_TIME, EventType.CANCELED);
		return handlingEvent;
	}
}