package fr.ubordeaux.ddd.gallerymanagement.application;

public interface Gateway {
	public void pushCommand(Command command);
	public void addCommandHandler(Handler handler);
}