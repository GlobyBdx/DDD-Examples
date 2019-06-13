package fr.ubordeaux.ddd.cargoshippingsystem.domain.model;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.Port;

/**
 * Factory
 * 
 */

public class LocationFactory {
	private final LocationRepository locationRepository;

	public LocationFactory(final LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	public Location newLocation() {
		return new Location(this.locationRepository.generateNextLocationID());
	}

	public Location newLocation(Port port) {
		Location location = this.newLocation();
		location.setPort(port);
		return location;
	}
}