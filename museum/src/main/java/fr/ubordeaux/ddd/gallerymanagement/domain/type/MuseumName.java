package fr.ubordeaux.ddd.gallerymanagement.domain.type;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.ubordeaux.ddd.gallerymanagement.domain.exception.GalleryManagementException;

/**
 * Value Object 
 * 
 */

public class MuseumName {
	private String value;

	public MuseumName(String value) {
		this.setValue(value);
	}

	private void setValue(String value)  {
		Pattern pattern = Pattern.compile("[a-zA-Z]{1,10}");
		Matcher matcher = pattern.matcher(value);
		if (!matcher.matches()) throw new GalleryManagementException("A Travel Guide name should have less than 10 alphabetical characters.");
		this.value = value;
	}

	@Override
	public boolean equals(Object other) {
		if (! (other instanceof MuseumName)) return false;
		return this.value.compareTo(((MuseumName)other).value) == 0;
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