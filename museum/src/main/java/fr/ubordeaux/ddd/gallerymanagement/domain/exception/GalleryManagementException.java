package fr.ubordeaux.ddd.gallerymanagement.domain.exception;

public class GalleryManagementException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GalleryManagementException(String message) {
		super(message);
	}
}