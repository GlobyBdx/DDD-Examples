package fr.ubordeaux.ddd.gallerymanagement.infrastructure.command;

import fr.ubordeaux.ddd.gallerymanagement.application.Command;
import fr.ubordeaux.ddd.gallerymanagement.application.Handler;

public class HandlerImplementation implements Handler {
	@Override
	public void handle(Command command) {
		command.execute();
	}
}