package net.coffeedriven.alfred.plugin;

public class PluginInstantiationException extends Exception {

	public PluginInstantiationException(String message) {
		super(message);
	}

	public PluginInstantiationException(String message, Exception e) {
		super(message, e);
	}
}