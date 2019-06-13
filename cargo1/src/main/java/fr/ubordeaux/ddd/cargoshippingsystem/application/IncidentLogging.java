package fr.ubordeaux.ddd.cargoshippingsystem.application;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CargoTrackingID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.LocationID;

/**
 * Service
 * 
 */

public abstract class IncidentLogging {
	public abstract void cargoHasBeenSent(CargoTrackingID cargoTrackingID, LocationID fromLocationID, LocationID toLocationID);
	public abstract void cargoHasBeenReceived(CargoTrackingID cargoTrackingID);
}