package fr.ubordeaux.ddd.cargoshippingsystem.application;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.customer.CustomerID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.customer.CustomerName;

/**
 * Service
 * 
 */

public abstract class AddingCustomer {
	public abstract void addCustomer(CustomerID customerID);
	public abstract void addCustomer(CustomerID customerID, CustomerName customerName);
}