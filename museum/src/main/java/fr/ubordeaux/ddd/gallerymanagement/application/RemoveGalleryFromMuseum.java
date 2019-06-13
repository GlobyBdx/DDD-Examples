package fr.ubordeaux.ddd.gallerymanagement.application;

import fr.ubordeaux.ddd.gallerymanagement.domain.exception.GalleryManagementException;
import fr.ubordeaux.ddd.gallerymanagement.domain.model.Gallery;
import fr.ubordeaux.ddd.gallerymanagement.domain.model.Museum;
import fr.ubordeaux.ddd.gallerymanagement.domain.type.MuseumName;

/**
 * Service
 * 
 */

public class RemoveGalleryFromMuseum extends Command {
	private Gallery gallery;
	private Museum rootMuseum;
	private MuseumName museumName;

	public RemoveGalleryFromMuseum(String id, Gallery gallery, Museum rootMuseum, MuseumName museumName) {
		super(id);
		this.setGallery(gallery);
		this.setRootMuseum(rootMuseum);
		this.setMuseumName(museumName);
	}

	@Override
	public void executeCommand() {
		Museum museum = this.rootMuseum.getSubMuseumByName(this.museumName);
		museum.removeGallery(this.gallery);
	}

	private void setGallery(Gallery gallery) {
		if (gallery == null) throw new GalleryManagementException("Cannot create command with null gallery.");
		this.gallery = gallery;
	}

	private void setRootMuseum(Museum rootMuseum) {
		if (rootMuseum == null) throw new GalleryManagementException("Cannot create command without root museum.");
		this.rootMuseum = rootMuseum;
	}

	private void setMuseumName(MuseumName museumName) {
		if (museumName == null) throw new GalleryManagementException("Cannot create command without museum name.");
		this.museumName = museumName;
	}
}