package net.coffeedriven.alfred.plugin;

public class PluginExecutionException extends Exception {

	public PluginExecutionException(String message) {
		super(message);
	}

	public PluginExecutionException(String message, Exception e) {
		super(message, e);
	}
}