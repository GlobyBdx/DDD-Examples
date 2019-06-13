package fr.ubordeaux.ddd.cargoshippingsystem.domain.model;

import java.util.Set;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CargoTrackingID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CustomerID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CustomerName;

/**
 * Repository
 * 
 */

public abstract class CustomerRepository {
	public abstract void store(Customer customer);
	public abstract Set<Customer> findAll();
	public abstract Customer findByCustomerID(CustomerID customerID);
	public abstract Customer findByCustomerName(CustomerName customerName);
	public abstract Set<Customer> findByCargoTrackingID(CargoTrackingID cargoTrackingID);
	public abstract CustomerID generateNextCustomerID();
}