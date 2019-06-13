package fr.ubordeaux.ddd.gallerymanagement.application;

import fr.ubordeaux.ddd.gallerymanagement.domain.exception.GalleryManagementException;
import fr.ubordeaux.ddd.gallerymanagement.domain.model.Museum;
import fr.ubordeaux.ddd.gallerymanagement.domain.type.MuseumName;

/**
 * Service
 * 
 */

public class CreateSubMuseum extends Command {
	private Museum rootMuseum;
	private MuseumName museumName;
	private MuseumName parentMuseumName;

	public CreateSubMuseum(String id, Museum rootMuseum, MuseumName museumName, MuseumName parentMuseumName) {
		super(id);
		this.setRootMuseum(rootMuseum);
		this.setMuseumName(museumName);
		this.setParentMuseumName(parentMuseumName);
	}

	@Override
	public void executeCommand() {
		Museum parentTravelGuide = this.rootMuseum.getSubMuseumByName(this.parentMuseumName);
		parentTravelGuide.createSubMuseum(museumName);
	}

	private void setRootMuseum(Museum rootMuseum) {
		if (rootMuseum == null) throw new GalleryManagementException("Cannot create command without root museum.");
		this.rootMuseum = rootMuseum;
	}

	private void setMuseumName(MuseumName museumName) {
		if (museumName == null) throw new GalleryManagementException("Cannot create command without museum name.");
		this.museumName = museumName;
	}

	private void setParentMuseumName(MuseumName parentMuseumName) {
		if (parentMuseumName == null) throw new GalleryManagementException("Cannot create command without parent museum name.");
		this.parentMuseumName = parentMuseumName;
	}
}