package net.coffeedriven.alfred.spi;

public class PluginException extends Exception {

	public PluginException(String message) {
		super(message);
	}

	public PluginException(String message, Exception e) {
		super(message, e);
	}
}