package fr.ubordeaux.ddd.cargoshippingsystem.infrastructure.persistence.inmemory;

import java.util.HashSet;
import java.util.Set;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.Customer;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.CustomerRepository;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CargoTrackingID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CustomerID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CustomerName;

/**
 * Repository implementation
 * 
 */

public class CustomerRepositoryImplementation extends CustomerRepository {
	private Set<Customer> customers;

	public CustomerRepositoryImplementation() {
		this.customers = new HashSet<>();
	}

	@Override
	public void store(Customer customer) {
		if (this.findAll().contains(customer)) {
			this.customers.remove(customer);
		}
		this.customers.add(customer);
	}

	@Override
	public Set<Customer> findAll() {
		return this.customers;
	}

	@Override
	public Customer findByCustomerID(CustomerID customerID) {
		for (Customer customer : this.findAll()) {
			if (customer.getCustomerID().equals(customerID)) {
				return customer;
			}
		}
		return null;
	}

	@Override
	public Customer findByCustomerName(CustomerName customerName) {
		for (Customer customer : this.findAll()) {
			if (customer.getCustomerName().equals(customerName)) {
				return customer;
			}
		}
		return null;
	}

	@Override
	public Set<Customer> findByCargoTrackingID(CargoTrackingID cargoTrackingID) {
		Set<Customer> customers = new HashSet<>();
		for (Customer customer : this.findAll()) {
			for (CargoTrackingID trackingID : customer.getCargoesTrackingID()) {
				if (trackingID.equals(cargoTrackingID)) {
					customers.add(customer);
				}
			}
		}
		return customers;
	}

	@Override
	public CustomerID generateNextCustomerID() {
		// TODO Auto-generated method stub
		return null;
	}
}