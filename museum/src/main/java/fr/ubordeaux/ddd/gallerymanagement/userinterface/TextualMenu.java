package fr.ubordeaux.ddd.gallerymanagement.userinterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

import fr.ubordeaux.ddd.gallerymanagement.domain.model.Gallery;
import fr.ubordeaux.ddd.gallerymanagement.domain.model.Museum;
import fr.ubordeaux.ddd.gallerymanagement.domain.type.GeographicCoordinate;
import fr.ubordeaux.ddd.gallerymanagement.domain.type.MuseumName;
import fr.ubordeaux.ddd.gallerymanagement.infrastructure.persistence.inmemory.MuseumImplementation;

public class TextualMenu {
	private BufferedReader in;
	private PrintWriter out;
	private Museum rootMuseum;

	protected TextualMenu(BufferedReader in , PrintWriter out) {
		this.in = in;
		this.out = out;
		initCollection();
	}

	protected TextualMenu(InputStream in, PrintStream out) {
		this.in = new BufferedReader(new InputStreamReader(in));
		this.out = new PrintWriter(out, true);
		initCollection();
	}

	private void initCollection() {
		rootMuseum = new MuseumImplementation(new MuseumName("root"));
	}

	protected void handleUserInstructions() throws IOException {
		boolean end = false;
		while (! end) {
			out.println("(1) Add new gallery to museum, (2) Exit");
			out.println("Your choice 1-2:");
			String choice = in.readLine();
			switch (choice) {
			case "1" : createPointOfInterestAndAddItToGuideTravel();
			break;
			case "2" : end = true;
			default :
			}
		}
	}

	private void createPointOfInterestAndAddItToGuideTravel() throws IOException {
		out.println("You ask to create a new gallery and add it to the root museum!");
		out.println("Gallery ID (any string, must be unique): ");
		String galleryId = in.readLine();
		out.println("Gallery Name: ");
		String galleryName = in.readLine();
		out.println("Gallery Description : ");
		String galleryDescription = in.readLine();
		out.println("Coordinate: ");
		out.println("--- Latitude: ");
		String coordinateLatitude = in.readLine();
		out.println("--- Longitude: ");
		String coordinateLongitude = in.readLine();
		out.println("--- Elevation: ");
		String coordinateElevation = in.readLine();
		GeographicCoordinate galleryCoordinate = new GeographicCoordinate(Integer.parseInt(coordinateLatitude), Integer.parseInt(coordinateLongitude), Integer.parseInt(coordinateElevation));
		Gallery gallery = new Gallery(galleryId, galleryName, galleryDescription, galleryCoordinate);

		rootMuseum.addGallery(gallery);
		out.println("Gallery (" + galleryId + ") has been created and added to the root museum!");
	}
}