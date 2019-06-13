package fr.ubordeaux.ddd.cargoshippingsystem.userinterface;

/**
 * Service interface
 * 
 */

public interface IncidentLoggingInterface {
	public void cargoHasBeenSent(String cargoTrackingID, String fromLocationID, String toLocationID);
	public void cargoHasBeenReceived(String cargoTrackingID);
}