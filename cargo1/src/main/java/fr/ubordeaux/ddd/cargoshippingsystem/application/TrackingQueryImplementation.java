package fr.ubordeaux.ddd.cargoshippingsystem.application;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.exception.CargoException;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.Cargo;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.CargoRepository;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.HandlingEvent;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CargoTrackingID;

/**
 * Service implementation
 * 
 */

public class TrackingQueryImplementation extends TrackingQuery {
	private final CargoRepository cargoRepository;

	public TrackingQueryImplementation(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	@Override
	public HandlingEvent inspectCargo(CargoTrackingID cargoTrackingID) {
		Cargo cargo = this.cargoRepository.findByCargoTrackingID(cargoTrackingID);
		if (cargo == null) {
			throw new CargoException("Cargo with given ID not found.");
		}
		return cargo.getDeliveryHistory().getLastHandlingEvent();
	}
}