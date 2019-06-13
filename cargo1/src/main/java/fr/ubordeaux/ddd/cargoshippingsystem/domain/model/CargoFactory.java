package fr.ubordeaux.ddd.cargoshippingsystem.domain.model;

import java.util.Set;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CargoCustomer;

/**
 * Factory ("Repeat Business" scenario)
 * 
 */

public class CargoFactory {
	private final CargoRepository cargoRepository;

	public CargoFactory(final CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public Cargo newCargo() {
		return new Cargo(this.cargoRepository.generateNextCargoTrackingID());
	}

	public Cargo newCargo(Set<CargoCustomer> cargoCustomers) {
		Cargo cargo = this.newCargo();
		cargo.setCargoCustomers(cargoCustomers);
		return cargo;
	}

	public Cargo newCargo(Cargo prototype) {
		return this.newCargo(prototype.getCargoCustomers());
	}
}