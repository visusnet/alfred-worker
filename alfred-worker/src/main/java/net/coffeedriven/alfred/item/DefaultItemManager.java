package net.coffeedriven.alfred.item;

import net.coffeedriven.alfred.spi.Item;
import net.coffeedriven.alfred.spi.ItemManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DefaultItemManager implements ItemManager {

	private final List<Item> items = new ArrayList<Item>();

	@Override
	public void addItem(Item item) {
		items.add(item);
	}

	@Override
	public List<Item> getItems() {
		return Collections.unmodifiableList(items);
	}
}