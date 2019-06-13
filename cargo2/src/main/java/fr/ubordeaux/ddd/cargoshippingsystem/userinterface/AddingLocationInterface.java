package fr.ubordeaux.ddd.cargoshippingsystem.userinterface;

/**
 * Service interface
 * 
 */

public interface AddingLocationInterface {
	public void addLocation(String locationID);
	public void addLocation(String locationID, String cityName, String portCode);
}