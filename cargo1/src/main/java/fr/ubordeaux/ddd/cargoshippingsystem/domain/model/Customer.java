package fr.ubordeaux.ddd.cargoshippingsystem.domain.model;

import java.util.HashSet;
import java.util.Set;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.exception.CustomerException;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CargoTrackingID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CustomerID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CustomerName;

/**
 * Entity
 * 
 */

public class Customer {
	private CustomerID customerID;
	private CustomerName customerName;
	private Set<CargoTrackingID> cargoesTrackingID;

	public Customer(CustomerID customerID) {
		this.setCustomerID(customerID);
		this.cargoesTrackingID = new HashSet<>();
	}

	private void setCustomerID(CustomerID customerID) {
		if (customerID == null) throw new CustomerException("Cannot create Customer with a null CustomerID.");
		this.customerID = customerID;
	}

	public void setCustomerName(CustomerName customerName) {
		this.customerName = customerName;
	}

	public CustomerID getCustomerID() {
		return this.customerID;
	}

	public CustomerName getCustomerName() {
		return this.customerName;
	}

	public Set<CargoTrackingID> getCargoesTrackingID() {
		return this.cargoesTrackingID;
	}

	public void addCargoTrackingID(CargoTrackingID cargoTrackingID) {
		this.cargoesTrackingID.add(cargoTrackingID);
	}

	@Override
	public boolean equals(Object other) {
		if (! (other instanceof Customer)) return false;
		return this.customerID.equals(((Customer)other).customerID);
	}

	@Override
	public int hashCode() {
		return this.customerID.hashCode();
	}

	@Override
	public String toString() {
		return this.customerID.toString();
	}
}