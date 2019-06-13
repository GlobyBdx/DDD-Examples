package fr.ubordeaux.ddd.cargoshippingsystem.domain.type;

import java.util.Objects;

import fr.ubordeaux.ddd.cargoshippingsystem.domain.exception.CustomerException;

/**
 * Value Object 
 * 
 */

public class CustomerRole {
	private String value;

	public CustomerRole(String value) {
		this.setValue(value);
	}

	private void setValue(String value)  {
		if (value == null) throw new CustomerException("Cannot create CustomerRole with a null value.");
		this.value = value;
	}

	@Override
	public boolean equals(Object other) {
		if (! (other instanceof CustomerRole)) return false;
		return this.value.compareTo(((CustomerRole)other).value) == 0;
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