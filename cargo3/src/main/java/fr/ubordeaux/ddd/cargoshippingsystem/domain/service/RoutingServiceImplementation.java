package fr.ubordeaux.ddd.cargoshippingsystem.domain.service;

import java.util.List;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.location.Location;
import fr.ubordeaux.ddd.cargoshippingsystem.domain.model.shipping.DeliverySpecification;

/**
 * Service implementation
 *
 */

public class RoutingServiceImplementation implements RoutingService {
	@Override
	public List<Location> fetchRoutesForDeliverySpecification(DeliverySpecification deliverySpecification) {
		return null;
	}
}