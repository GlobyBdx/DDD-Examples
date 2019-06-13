package fr.ubordeaux.ddd.cargoshippingsystem.domain.model;

import java.util.Set;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CargoCustomer;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CargoTrackingID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CustomerID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CustomerRole;

/**
 * Repository (Auto-generated CargoTrackingID must be a new unique ID or an already existing not in use ID)
 * 
 */

public abstract class CargoRepository {
	public abstract void store(Cargo cargo);
	public abstract Set<Cargo> findAll();
	public abstract Cargo findByCargoTrackingID(CargoTrackingID cargoTrackingID);
	public abstract Set<Cargo> findByCargoCustomer(CargoCustomer cargoCustomer);
	public abstract Set<Cargo> findByCustomerID(CustomerID customerID);
	public abstract Set<Cargo> findByCustomerRole(CustomerRole customerRole);
	public abstract CargoTrackingID generateNextCargoTrackingID();
}