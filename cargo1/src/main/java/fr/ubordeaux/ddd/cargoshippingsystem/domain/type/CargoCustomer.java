package fr.ubordeaux.ddd.cargoshippingsystem.domain.type;

import java.util.Objects;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.exception.CargoException;

/**
 * Value Object 
 * 
 */

public class CargoCustomer {
	private CustomerID customerID;
	private CustomerRole customerRole;

	public CargoCustomer(CustomerID customerID, CustomerRole customerRole) {
		this.setCustomerID(customerID);
		this.setCustomerRole(customerRole);
	}

	private void setCustomerID(CustomerID customerID)  {
		if (customerID == null) throw new CargoException("Cannot create CargoCustomer with a null CustomerID.");
		this.customerID = customerID;
	}

	private void setCustomerRole(CustomerRole customerRole)  {
		if (customerRole == null) throw new CargoException("Cannot create CargoCustomer with a null CustomerID.");
		this.customerRole = customerRole;
	}

	public CustomerID getCustomerID()  {
		return this.customerID;
	}

	public CustomerRole getCustomerRole()  {
		return this.customerRole;
	}

	@Override
	public boolean equals(Object other) {
		if (! (other instanceof CargoCustomer)) return false;
		return (this.customerID.equals(((CargoCustomer)other).customerID)
				&& this.customerRole.equals(((CargoCustomer)other).customerRole));
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.toString());
	}

	@Override
	public String toString() {
		return this.customerID.toString() + ":" + this.customerRole.toString();
	}
}