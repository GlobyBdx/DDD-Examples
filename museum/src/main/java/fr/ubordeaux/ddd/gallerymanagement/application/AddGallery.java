package fr.ubordeaux.ddd.gallerymanagement.application;

import fr.ubordeaux.ddd.gallerymanagement.domain.exception.GalleryManagementException;
import fr.ubordeaux.ddd.gallerymanagement.domain.model.Gallery;
import fr.ubordeaux.ddd.gallerymanagement.domain.model.Museum;

/**
 * Service
 * 
 */

public class AddGallery extends Command {
	private Gallery gallery;
	private Museum rootMuseum;

	public AddGallery(String id, Gallery gallery, Museum rootMuseum) {
		super(id);
		this.setGallery(gallery);
		this.setRootMuseum(rootMuseum);
	}

	@Override
	public void executeCommand() {
		this.rootMuseum.addGallery(this.gallery);
	}

	private void setGallery(Gallery gallery) {
		if (gallery == null) throw new GalleryManagementException("Cannot create command with null gallery.");
		this.gallery = gallery;
	}

	private void setRootMuseum(Museum rootMuseum) {
		if (rootMuseum == null) throw new GalleryManagementException("Cannot create command without root museum.");
		this.rootMuseum = rootMuseum;
	}
}