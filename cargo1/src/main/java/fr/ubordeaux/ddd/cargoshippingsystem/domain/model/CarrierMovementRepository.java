package fr.ubordeaux.ddd.cargoshippingsystem.domain.model;

import java.util.Set;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.LocationID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.ScheduleID;

/**
 * Repository
 * 
 */

public abstract class CarrierMovementRepository {
	public abstract void store(CarrierMovement carrierMovement);
	public abstract Set<CarrierMovement> findAll();
	public abstract CarrierMovement findByScheduleID(ScheduleID scheduleID);
	public abstract Set<CarrierMovement> findByFromToLocationID(LocationID fromLocationID, LocationID toLocationID);
	public abstract ScheduleID generateNextScheduleID();
}