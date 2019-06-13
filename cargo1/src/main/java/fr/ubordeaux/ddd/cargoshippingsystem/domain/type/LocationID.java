package fr.ubordeaux.ddd.cargoshippingsystem.domain.type;

import java.util.Objects;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.exception.LocationException;

/**
 * Value Object 
 * 
 */

public class LocationID {
	private String value;

	public LocationID(String value) {
		this.setValue(value);
	}

	private void setValue(String value)  {
		if (value == null) throw new LocationException("Cannot create LocationID with a null value.");
		this.value = value;
	}

	@Override
	public boolean equals(Object other) {
		if (! (other instanceof LocationID)) return false;
		return this.value.compareTo(((LocationID)other).value) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.value);
	}

	@Override
	public String toString() {
		return this.value;
	}
}