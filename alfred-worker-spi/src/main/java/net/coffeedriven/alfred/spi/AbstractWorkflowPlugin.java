package net.coffeedriven.alfred.spi;

public abstract class AbstractWorkflowPlugin implements AlfredWorkflowPlugin {

	private ItemManager itemManager;

	protected final ItemManager getItemManager() {
		return itemManager;
	}

	@Override
	public final void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

}