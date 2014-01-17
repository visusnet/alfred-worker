package net.coffeedriven.alfred.plugin;

import net.coffeedriven.alfred.spi.AbstractWorkflowPlugin;
import net.coffeedriven.alfred.spi.AlfredWorkflowPlugin;
import net.coffeedriven.alfred.spi.ItemManager;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class PluginManager {

	private final List<Class<? extends AlfredWorkflowPlugin>> workflowPluginClasses =
		new ArrayList<Class<? extends AlfredWorkflowPlugin>>();

	private final List<AlfredWorkflowPlugin> workflowPlugins = new ArrayList<AlfredWorkflowPlugin>();

	private ItemManager itemManager;

	public PluginManager(ItemManager itemManager) {
		if (itemManager == null) {
			throw new IllegalArgumentException("itemManager must not be null.");
		}
		this.itemManager = itemManager;
	}

	public void addPluginSource(File file) throws InvalidPluginException {
		try {
			URL url = file.toURI().toURL();
			URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});
			Reflections reflections = new Reflections(ConfigurationBuilder.build(urlClassLoader, url));
			workflowPluginClasses.addAll(reflections.getSubTypesOf(AlfredWorkflowPlugin.class));
			workflowPluginClasses.addAll(reflections.getSubTypesOf(AbstractWorkflowPlugin.class));
		} catch (MalformedURLException e) {
			throw new InvalidPluginException(String.format("Invalid plugin: %s.", file.getPath()), e);
		}
	}

	public void initializePlugins() throws PluginInstantiationException {
		for (Class<? extends AlfredWorkflowPlugin> workflowPluginClass : workflowPluginClasses) {
			try {
				AlfredWorkflowPlugin alfredWorkflowPlugin = workflowPluginClass.newInstance();
				alfredWorkflowPlugin.setItemManager(itemManager);
				workflowPlugins.add(alfredWorkflowPlugin);
			} catch (Exception e) {
				throw new PluginInstantiationException(
					String.format("Could not instantiate plugin: %s.", workflowPluginClass.getName()), e);
			}
		}
	}

	public void invokePlugins(String query) throws PluginExecutionException {
		for (AlfredWorkflowPlugin workflowPlugin : workflowPlugins) {
			try {
				workflowPlugin.run(query);
			} catch (Exception e) {
				throw new PluginExecutionException(
					String.format("Could not execute plugin: %s", workflowPlugin.getClass().getName()), e);
			}
		}
	}
}