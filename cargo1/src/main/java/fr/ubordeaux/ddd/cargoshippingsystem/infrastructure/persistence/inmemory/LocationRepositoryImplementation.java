package fr.ubordeaux.ddd.cargoshippingsystem.infrastructure.persistence.inmemory;

import java.util.HashSet;
import java.util.Set;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.Location;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.LocationRepository;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.LocationID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.Port;

/**
 * Repository implementation
 * 
 */

public class LocationRepositoryImplementation extends LocationRepository {
	private Set<Location> locations;

	public LocationRepositoryImplementation() {
		this.locations = new HashSet<>();
	}

	@Override
	public void store(Location location) {
		if (this.findAll().contains(location)) {
			this.locations.remove(location);
		}
		this.locations.add(location);
	}

	@Override
	public Set<Location> findAll() {
		return this.locations;
	}

	@Override
	public Location findByLocationID(LocationID locationID) {
		for (Location location : this.findAll()) {
			if (location.getLocationID().equals(locationID)) {
				return location;
			}
		}
		return null;
	}

	@Override
	public Location findByPort(Port port) {
		for (Location location : this.findAll()) {
			if (location.getPort().equals(port)) {
				return location;
			}
		}
		return null;
	}

	@Override
	public LocationID generateNextLocationID() {
		// TODO Auto-generated method stub
		return null;
	}
}