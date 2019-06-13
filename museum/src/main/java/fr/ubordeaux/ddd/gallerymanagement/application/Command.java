package fr.ubordeaux.ddd.gallerymanagement.application;

import java.util.HashSet;
import java.util.Set;

import fr.ubordeaux.ddd.gallerymanagement.domain.exception.GalleryManagementException;

public abstract class Command {
	private String id;
	private Set<CommandMonitor> commandMonitorSet;

	public Command(String id ) {
		this.setId(id);
		commandMonitorSet = new HashSet<CommandMonitor>();
	}

	public void addMonitor(CommandMonitor commandMonitor) {
		if (commandMonitor == null) throw new GalleryManagementException("Cannot add null monitor.");
		commandMonitorSet.add(commandMonitor);
	}

	public void execute() {
		executeCommand();
		notifyMonitor();
	}

	private void setId(String id) {
		if (id == null) throw new GalleryManagementException("Cannot create command with null id.");
		this.id = id;
	}

	private void notifyMonitor() {
		for (CommandMonitor monitor : commandMonitorSet) {
			monitor.commandIsExecuted(id);
		}
	}

	protected abstract void executeCommand();
}