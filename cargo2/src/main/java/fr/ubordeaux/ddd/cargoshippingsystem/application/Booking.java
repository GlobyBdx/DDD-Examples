package fr.ubordeaux.ddd.cargoshippingsystem.application;

import java.util.Set;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.billing.InvoiceID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.location.LocationID;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.shipping.CargoCustomer;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.shipping.CargoTrackingID;

/**
 * Service
 * 
 */

public abstract class Booking {
	public abstract CargoTrackingID bookCargo(InvoiceID invoiceID, Set<CargoCustomer> cargoCustomers, LocationID locationID);
	public abstract CargoTrackingID bookAnotherCargo(InvoiceID invoiceID, CargoTrackingID cargoTrackingID, LocationID locationID);
	public abstract void cancelBookedCargo(InvoiceID invoiceID, CargoTrackingID cargoTrackingID);
	public abstract void changeBookedCargoDestination(CargoTrackingID cargoTrackingID, LocationID locationID);
}