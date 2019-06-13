package fr.ubordeaux.ddd.cargoshippingsystem.domain.model;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.type.CustomerName;

/**
 * Factory
 * 
 */

public class CustomerFactory {
	private final CustomerRepository customerRepository;

	public CustomerFactory(final CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer newCustomer() {
		return new Customer(this.customerRepository.generateNextCustomerID());
	}

	public Customer newCustomer(CustomerName customerName) {
		Customer customer = this.newCustomer();
		customer.setCustomerName(customerName);
		return customer;
	}
}