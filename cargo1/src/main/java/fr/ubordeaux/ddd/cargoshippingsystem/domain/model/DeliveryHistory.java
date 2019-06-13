package fr.ubordeaux.ddd.cargoshippingsystem.domain.model;

import java.util.HashSet;
import java.util.Objects;

/**
 * Entity
 * 
 */

import java.util.Set;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.exception.CargoException;

public class DeliveryHistory {
	private Cargo rootCargo;
	private Set<HandlingEvent> handlingEvents;
	private HandlingEvent lastHandlingEvent;

	public DeliveryHistory(Cargo rootCargo) {
		this.setRootCargo(rootCargo);
		this.handlingEvents = new HashSet<>();
	}

	private void setRootCargo(Cargo rootCargo) {
		if (rootCargo == null) throw new CargoException("Cannot create DeliveryHistory without a root Cargo.");
		this.rootCargo = rootCargo;
	}

	public Cargo getRootCargo() {
		return this.rootCargo;
	}

	public Set<HandlingEvent> getHandlingEvents() {
		return this.handlingEvents;
	}

	public HandlingEvent getLastHandlingEvent() {
		return this.lastHandlingEvent;
	}

	public void addHandlingEvent(HandlingEvent handlingEvent) {
		this.handlingEvents.add(handlingEvent);
		if (handlingEvent.getScheduleID() != null) {
			this.lastHandlingEvent = handlingEvent;
		}
	}

	@Override
	public boolean equals(Object other) {
		if (! (other instanceof DeliveryHistory)) return false;
		return this.getRootCargo().equals(((DeliveryHistory)other).getRootCargo());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this);
	}

	@Override
	public String toString() {
		return this.getRootCargo().toString();
	}
}