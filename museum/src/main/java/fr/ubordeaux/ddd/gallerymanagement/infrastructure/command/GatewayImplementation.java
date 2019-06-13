package fr.ubordeaux.ddd.gallerymanagement.infrastructure.command;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import fr.ubordeaux.ddd.gallerymanagement.application.Command;
import fr.ubordeaux.ddd.gallerymanagement.application.Gateway;
import fr.ubordeaux.ddd.gallerymanagement.application.Handler;
import fr.ubordeaux.ddd.gallerymanagement.domain.exception.GalleryManagementException;

public class GatewayImplementation implements Gateway {
	private Set<Handler> handlers;
	private Random random;

	public GatewayImplementation() {
		this.handlers = new HashSet<Handler>();
		this.random = new Random();
	}

	@Override
	public void pushCommand(Command command) {
		int index = random.nextInt(handlers.size());
		int i = 0;
		for (Handler handler : handlers) {
			if (i == index) {
				handler.handle(command);
				return;
			}
		}
	}

	@Override
	public void addCommandHandler(Handler handler) {
		if (handler == null) throw new GalleryManagementException("Cannot add null handler.");
		this.handlers.add(handler);
	}
}