package fr.ubordeaux.ddd.cargoshippingsystem.domain.model.location;

import java.util.Set;

/**
 * Repository
 * 
 */

public abstract class LocationRepository {
	public abstract void store(Location location);
	public abstract Set<Location> findAll();
	public abstract Location findByLocationID(LocationID locationID);
	public abstract Location findByPort(Port port);
	public abstract Location findByCityName(CityName cityName);
	public abstract Location findByPortCode(PortCode portCode);
}