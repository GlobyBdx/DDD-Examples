package fr.ubordeaux.ddd.gallerymanagement.domain.type;

import java.util.Objects;

import fr.ubordeaux.ddd.gallerymanagement.domain.exception.GalleryManagementException;

/**
 * Value Object 
 * 
 */

public class GeographicCoordinate {
	private static final int LATITUDE_DEGREE_RANGE = 90;
	private static final int LONGITUDE_DEGREE_RANGE = 180;
	private int latitude;
	private int longitude;
	private int elevation;

	public GeographicCoordinate(int latitude, int longitude, int elevation) {
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		this.setElevation(elevation);
	}

	public GeographicCoordinate(int latitude, int longitude) {
		this(latitude, longitude, 0);
	}

	private void setLatitude(int latitude) {
		if (latitude < -LATITUDE_DEGREE_RANGE || latitude > LATITUDE_DEGREE_RANGE) throw new GalleryManagementException("Latitudes are in degrees, and therefore must be between -90 and 90.");
		this.latitude = latitude;
	}

	private void setLongitude(int longitude) {
		if (longitude < -LONGITUDE_DEGREE_RANGE || longitude > LONGITUDE_DEGREE_RANGE) throw new GalleryManagementException("Longitudes are in degrees, and therefore must be between -180 and 180.");
		this.longitude = longitude;
	}

	private void setElevation(int elevation) {
		this.elevation = elevation;
	}

	public int getLatitude() {
		return this.latitude;
	}

	public int getLongitude() {
		return this.longitude;
	}

	public int getElevation() {
		return this.elevation;
	}

	@Override
	public boolean equals(Object other) {
		if (! (other instanceof GeographicCoordinate)) return false;
		return (this.latitude == ((GeographicCoordinate)other).latitude
				&& this.longitude == ((GeographicCoordinate)other).longitude
				&& this.elevation == ((GeographicCoordinate)other).elevation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.toString());
	}

	@Override
	public String toString() {
		return String.valueOf(this.getLatitude()) + ":" + String.valueOf(this.getLongitude()) + ":" + String.valueOf(this.getElevation());
	}
}