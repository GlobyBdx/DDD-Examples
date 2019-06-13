package fr.ubordeaux.ddd.gallerymanagement.application;

public interface CommandMonitor {
	public void commandIsExecuted(String commandId);
}