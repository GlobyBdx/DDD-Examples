package fr.ubordeaux.ddd.cargoshippingsystem.domain.model.customer;

import java.util.Set;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.billing.InvoiceID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.shipping.CargoTrackingID;

/**
 * Repository
 * 
 */

public abstract class CustomerRepository {
	public abstract void store(Customer customer);
	public abstract Set<Customer> findAll();
	public abstract Customer findByCustomerID(CustomerID customerID);
	public abstract Customer findByCustomerName(CustomerName customerName);
	public abstract Set<Customer> findByCustomerBook(CustomerBook customerBook);
	public abstract Set<Customer> findByCargoTrackingID(CargoTrackingID cargoTrackingID);
	public abstract Set<Customer> findByInvoiceID(InvoiceID invoiceID);
}