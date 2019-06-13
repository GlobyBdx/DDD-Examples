package fr.ubordeaux.ddd.cargoshippingsystem.domain.model.billing;

import java.util.Set;

/**
 * Repository
 * 
 */

public abstract class InvoiceRepository {
	public abstract void store(Invoice invoice);
	public abstract Set<Invoice> findAll();
	public abstract Money findTotalMoneyCollected();
	public abstract Invoice findByInvoiceID(InvoiceID invoiceID);
}