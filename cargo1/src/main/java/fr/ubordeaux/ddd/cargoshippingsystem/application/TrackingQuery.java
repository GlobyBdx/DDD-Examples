package fr.ubordeaux.ddd.cargoshippingsystem.application;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.HandlingEvent;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CargoTrackingID;

/**
 * Service
 * 
 */

public abstract class TrackingQuery {
	public abstract HandlingEvent inspectCargo(CargoTrackingID cargoTrackingID);
}