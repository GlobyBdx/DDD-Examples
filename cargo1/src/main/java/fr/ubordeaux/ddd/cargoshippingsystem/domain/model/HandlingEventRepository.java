package fr.ubordeaux.ddd.cargoshippingsystem.domain.model;

import java.util.Date;
import java.util.Set;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CargoTrackingID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.EventType;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.ScheduleID;

/**
 * Repository
 * 
 */

public abstract class HandlingEventRepository {
	public abstract void store(HandlingEvent handlingEvent);
	public abstract Set<HandlingEvent> findAll();
	public abstract Set<HandlingEvent> findByCargoTrackingID(CargoTrackingID cargoTrackingID);
	public abstract Set<HandlingEvent> findByCargoTrackingIDType(CargoTrackingID cargoTrackingID, EventType type);
	public abstract HandlingEvent findMostRecentByCargoTrackingIDType(CargoTrackingID cargoTrackingID, EventType type);
	public abstract HandlingEvent findByCargoTrackingIDCompletionTimeType(CargoTrackingID cargoTrackingID, Date completionTime, EventType type);
	public abstract HandlingEvent findByScheduleID(ScheduleID scheduleID);
}