package fr.ubordeaux.ddd.cargoshippingsystem.application;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.location.LocationID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.location.Port;

/**
 * Service
 * 
 */

public abstract class AddingLocation {
	public abstract void addLocation(LocationID locationID);
	public abstract void addLocation(LocationID locationID, Port port);
}