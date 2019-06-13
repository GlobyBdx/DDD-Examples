package fr.ubordeaux.ddd.gallerymanagement.domain.model;

import java.util.Objects;

import fr.ubordeaux.ddd.gallerymanagement.domain.exception.GalleryManagementException;
import fr.ubordeaux.ddd.gallerymanagement.domain.type.GeographicCoordinate;

/**
 * Entity
 * 
 */

public class Gallery {
	private String id;
	private String name;
	private String description;
	private GeographicCoordinate coordinate;

	public Gallery(String id, String name, String description, GeographicCoordinate coordinate) {
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
		this.setCoordinate(coordinate);
	}

	private void setId(String id) {
		if (id == null) throw new GalleryManagementException("Cannot create gallery with null as id.");
		this.id = id;
	}

	private void setName(String name) {
		if (name == null) throw new GalleryManagementException("Cannot create gallery with null as name.");
		this.name = name;
	}

	private void setDescription(String description) {
		if (description == null) throw new GalleryManagementException("Cannot create gallery with null as description.");
		this.description = description;
	}

	private void setCoordinate(GeographicCoordinate coordinate) {
		if (coordinate == null) throw new GalleryManagementException("Cannot create gallery with null as coordinate.");
		this.coordinate = coordinate;
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public GeographicCoordinate getCoordinate() {
		return this.coordinate;
	}

	@Override
	public boolean equals(Object other) {
		if (! (other instanceof Gallery)) return false;
		return this.getId().compareTo(((Gallery)other).getId()) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getId());
	}

	@Override
	public String toString() {
		return this.getId();
	}
}