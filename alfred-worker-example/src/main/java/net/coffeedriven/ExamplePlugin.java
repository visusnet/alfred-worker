package net.coffeedriven;

import net.coffeedriven.alfred.spi.AbstractWorkflowPlugin;
import net.coffeedriven.alfred.spi.Item;
import net.coffeedriven.alfred.spi.ItemManager;
import net.coffeedriven.alfred.spi.PluginException;

public class ExamplePlugin extends AbstractWorkflowPlugin {

	@Override
	public void run(String query) throws PluginException {
		getItemManager().addItem(new Item().setArg(query).setAutocomplete(query).setSubTitle(query).setValid(true));
	}
}