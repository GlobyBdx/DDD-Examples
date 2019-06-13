package fr.ubordeaux.ddd.cargoshippingsystem.domain.model;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.LocationID;

/**
 * Factory
 * 
 */

public class CarrierMovementFactory {
	private final CarrierMovementRepository carrierMovement;

	public CarrierMovementFactory(final CarrierMovementRepository carrierMovement) {
		this.carrierMovement = carrierMovement;
	}

	public CarrierMovement newCarrierMovement() {
		return new CarrierMovement(this.carrierMovement.generateNextScheduleID());
	}

	public CarrierMovement newCarrierMovement(LocationID fromLocationID, LocationID toLocationID) {
		CarrierMovement carrierMovement = this.newCarrierMovement();
		carrierMovement.setFromLocationID(fromLocationID);
		carrierMovement.setToLocationID(toLocationID);
		return carrierMovement;
	}
}