package fr.ubordeaux.ddd.cargoshippingsystem.domain.model.shipping;

import java.util.Set;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.location.LocationID;

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