package fr.ubordeaux.ddd.cargoshippingsystem.userinterface;

/**
 * Service interface
 * 
 */

public interface AddingInvoiceInterface {
	public void addInvoice(String invoiceID);
	public void addInvoice(String invoiceID, double price, String currency);
}