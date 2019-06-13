package fr.ubordeaux.ddd.gallerymanagement.domain.model;

import java.util.Set;

import fr.ubordeaux.ddd.gallerymanagement.domain.type.MuseumName;

/**
 * Repository 
 * 
 */

public abstract class Museum {
	public abstract MuseumName getName();
	public abstract Set<Museum> getSubMuseums();
	public abstract Museum getSubMuseumByName(MuseumName name);
	public abstract Museum createSubMuseum(MuseumName name);
	public abstract int size();
	public abstract Set<Gallery> getGalleries();
	public abstract Gallery findGalleryById(String id);
	public abstract void addGallery(Gallery pointOfInterest);
	public abstract void removeGallery(Gallery pointOfInterest);
}