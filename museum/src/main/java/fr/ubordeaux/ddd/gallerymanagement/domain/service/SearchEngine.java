package fr.ubordeaux.ddd.gallerymanagement.domain.service;

import java.util.HashSet;
import java.util.Set;

import fr.ubordeaux.ddd.gallerymanagement.domain.exception.GalleryManagementException;
import fr.ubordeaux.ddd.gallerymanagement.domain.model.Gallery;
import fr.ubordeaux.ddd.gallerymanagement.domain.model.Museum;

/**
 * Service
 * 
 */

public class SearchEngine {
	private Museum rootMuseum;

	public SearchEngine(Museum rootMuseum) {
		this.setRootTravelGuide(rootMuseum);
	}

	public Gallery searchPointOfInterestById(String id) {
		for (Gallery gallery : this.rootMuseum.getGalleries()) {
			if (gallery.getId().compareTo(id) == 0) {
				return gallery;
			}
		}
		throw new GalleryManagementException("Cannot find gallery, id does not exist.");
	}

	public Set<Gallery> searchPointsOfInterestByName(String name) {
		Set<Gallery> foundGalleries = new HashSet<Gallery>();
		for (Gallery gallery : this.rootMuseum.getGalleries()) {
			if (gallery.getName().compareTo(name) == 0) {
				foundGalleries.add(gallery);
			}
		}
		return foundGalleries;
	}

	private void setRootTravelGuide(Museum rootMuseum) {
		if (rootMuseum == null) throw new GalleryManagementException("Cannot create search engine with null as root museum.");
		this.rootMuseum = rootMuseum;
	}
}