package net.coffeedriven.alfred.spi;

public interface AlfredWorkflowPlugin {

	void setItemManager(ItemManager itemManager);

	void run(String arg) throws PluginException;

}
