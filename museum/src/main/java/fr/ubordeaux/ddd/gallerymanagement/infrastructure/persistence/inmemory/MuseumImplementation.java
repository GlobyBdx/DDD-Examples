package fr.ubordeaux.ddd.gallerymanagement.infrastructure.persistence.inmemory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.ubordeaux.ddd.gallerymanagement.domain.exception.GalleryManagementException;
import fr.ubordeaux.ddd.gallerymanagement.domain.model.Gallery;
import fr.ubordeaux.ddd.gallerymanagement.domain.model.Museum;
import fr.ubordeaux.ddd.gallerymanagement.domain.type.MuseumName;

/**
 * Repository implementation
 * 
 */

public class MuseumImplementation extends Museum {
	private MuseumName name;
	private Map<MuseumName, Museum> subMuseums;  
	private Map<String, Gallery> galleries;

	public MuseumImplementation(MuseumName name) {
		this.setName(name);
		subMuseums = new HashMap<>();
		this.galleries = new HashMap<>();
	}

	private void setName(MuseumName name) {
		this.name = name;
	}

	@Override
	public MuseumName getName() {
		return this.name;
	}

	@Override
	public Set<Museum> getSubMuseums() {
		Set<Museum> result = new HashSet<>();
		result.addAll(this.subMuseums.values());
		return result;
	}

	@Override
	public Museum getSubMuseumByName(MuseumName name) {
		if (this.getName().equals(name)) return this;
		for (Museum sub : this.getSubMuseums()) {
			try {
				Museum catalog = sub.getSubMuseumByName(name);
				return catalog;
			} catch (GalleryManagementException ex) {}
		}
		throw new GalleryManagementException("Cannot find sub museum with name " + name.toString() + ".");
	}

	@Override
	public Museum createSubMuseum(MuseumName name) {
		for (Museum sub : this.getSubMuseums()) {
			if (sub.getName().equals(name)) throw new GalleryManagementException("Cannot add sub gallery with same name.");
		}
		Museum sub = new MuseumImplementation(name);
		this.subMuseums.put(name, sub);
		return sub;
	}

	@Override
	public int size() {
		return this.galleries.size();
	}

	@Override
	public Set<Gallery> getGalleries() {
		Set<Gallery> result = new HashSet<>();
		result.addAll(this.galleries.values());
		return result;
	}

	@Override
	public Gallery findGalleryById(String id) {
		if (! this.galleries.containsKey(id)) throw new GalleryManagementException("Cannot find gallery, id unknown.");
		return this.galleries.get(id);
	}

	@Override
	public void addGallery(Gallery pointOfInterest) {
		this.galleries.put(pointOfInterest.getId(), pointOfInterest);
	}

	@Override
	public void removeGallery(Gallery pointOfInterest) {
		this.galleries.remove(pointOfInterest.getId());
	}
}