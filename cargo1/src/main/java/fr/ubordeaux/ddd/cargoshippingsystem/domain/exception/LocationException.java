package fr.ubordeaux.ddd.cargoshippingsystem.domain.exception;

/**
 * Exception
 * 
 */

public class LocationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public LocationException(String message) {
		super(message);
	}
}