package fr.ubordeaux.ddd.cargoshippingsystem.application;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.shipping.CargoTrackingID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.shipping.HandlingEvent;

/**
 * Service
 * 
 */

public abstract class TrackingQuery {
	public abstract HandlingEvent inspectCargo(CargoTrackingID cargoTrackingID);
}