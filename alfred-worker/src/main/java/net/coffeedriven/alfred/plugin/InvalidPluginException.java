package net.coffeedriven.alfred.plugin;

public class InvalidPluginException extends Exception {

	public InvalidPluginException(String message) {
		super(message);
	}

	public InvalidPluginException(String message, Exception e) {
		super(message, e);
	}
}