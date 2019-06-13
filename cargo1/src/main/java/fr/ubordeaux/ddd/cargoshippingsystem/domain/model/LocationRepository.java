package fr.ubordeaux.ddd.cargoshippingsystem.domain.model;

import java.util.Set;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.LocationID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.Port;

/**
 * Repository
 * 
 */

public abstract class LocationRepository {
	public abstract void store(Location location);
	public abstract Set<Location> findAll();
	public abstract Location findByLocationID(LocationID locationID);
	public abstract Location findByPort(Port port);
	public abstract LocationID generateNextLocationID();
}