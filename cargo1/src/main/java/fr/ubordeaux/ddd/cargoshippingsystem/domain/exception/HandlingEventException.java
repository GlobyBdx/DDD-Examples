package fr.ubordeaux.ddd.cargoshippingsystem.domain.exception;

/**
 * Exception
 * 
 */

public class HandlingEventException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public HandlingEventException(String message) {
		super(message);
	}
}