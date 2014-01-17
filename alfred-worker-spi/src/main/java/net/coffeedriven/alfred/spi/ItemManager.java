package net.coffeedriven.alfred.spi;

import java.util.List;

public interface ItemManager {

	public void addItem(Item item);

	List<Item> getItems();

}
