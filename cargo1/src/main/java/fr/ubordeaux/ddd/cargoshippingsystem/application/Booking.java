package fr.ubordeaux.ddd.cargoshippingsystem.application;

import java.util.Set;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CargoCustomer;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CargoTrackingID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.LocationID;

/**
 * Service
 * 
 */

public abstract class Booking {
	public abstract CargoTrackingID bookCargo(Set<CargoCustomer> cargoCustomers, LocationID locationID);
	public abstract CargoTrackingID bookAnotherCargo(CargoTrackingID cargoTrackingID, LocationID locationID);
	public abstract void cancelBookedCargo(CargoTrackingID cargoTrackingID);
	public abstract void changeBookedCargoDestination(CargoTrackingID cargoTrackingID, LocationID locationID);
}