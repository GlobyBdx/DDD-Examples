package fr.ubordeaux.ddd.cargoshippingsystem.application;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.billing.InvoiceID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.billing.Money;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.billing.State;

/**
 * Service
 * 
 */

public abstract class AddingInvoice {
	public abstract void addInvoice(InvoiceID invoiceID);
	public abstract void addInvoice(InvoiceID invoiceID, Money money, State state);
}