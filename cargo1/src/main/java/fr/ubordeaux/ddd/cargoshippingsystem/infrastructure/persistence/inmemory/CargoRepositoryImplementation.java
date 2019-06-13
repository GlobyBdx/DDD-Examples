package fr.ubordeaux.ddd.cargoshippingsystem.infrastructure.persistence.inmemory;

import java.util.HashSet;
import java.util.Set;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.Cargo;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.CargoRepository;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CargoCustomer;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CargoTrackingID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CustomerID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CustomerRole;

/**
 * Repository implementation
 * 
 */

public class CargoRepositoryImplementation extends CargoRepository {
	private Set<Cargo> cargoes;

	public CargoRepositoryImplementation() {
		this.cargoes = new HashSet<>();
	}

	@Override
	public void store(Cargo cargo) {
		if (this.findAll().contains(cargo)) {
			this.cargoes.remove(cargo);
		}
		this.cargoes.add(cargo);
	}

	@Override
	public Set<Cargo> findAll() {
		return cargoes;
	}

	@Override
	public Cargo findByCargoTrackingID(CargoTrackingID cargoTrackingID) {
		for (Cargo cargo : this.findAll()) {
			if (cargo.getCargoTrackingID().equals(cargoTrackingID)) {
				return cargo;
			}
		}
		return null;
	}

	@Override
	public Set<Cargo> findByCargoCustomer(CargoCustomer cargoCustomer) {
		Set<Cargo> cargoes = new HashSet<>();
		for (Cargo cargo : this.findAll()) {
			for (CargoCustomer customer : cargo.getCargoCustomers()) {
				if (customer.equals(cargoCustomer)) {
					cargoes.add(cargo);
				}
			}
		}
		return cargoes;
	}

	@Override
	public Set<Cargo> findByCustomerID(CustomerID customerID) {
		Set<Cargo> cargoes = new HashSet<>();
		for (Cargo cargo : this.findAll()) {
			for (CargoCustomer customer : cargo.getCargoCustomers()) {
				if (customer.getCustomerID().equals(customerID)) {
					cargoes.add(cargo);
				}
			}
		}
		return cargoes;
	}

	@Override
	public Set<Cargo> findByCustomerRole(CustomerRole customerRole) {
		Set<Cargo> cargoes = new HashSet<>();
		for (Cargo cargo : this.findAll()) {
			for (CargoCustomer customer : cargo.getCargoCustomers()) {
				if (customer.getCustomerRole().equals(customerRole)) {
					cargoes.add(cargo);
				}
			}
		}
		return cargoes;
	}

	@Override
	public CargoTrackingID generateNextCargoTrackingID() {
		// TODO Auto-generated method stub
		return null;
	}
}