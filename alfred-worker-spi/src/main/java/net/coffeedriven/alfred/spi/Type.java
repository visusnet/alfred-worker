package net.coffeedriven.alfred.spi;

public enum Type {
	FILE("file");

	private final String typeName;

	Type(String typeName) {
		this.typeName = typeName;
	}

	public String getName() {
		return this.typeName;
	}
}
