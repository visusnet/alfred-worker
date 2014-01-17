package net.coffeedriven.alfred.spi;

public enum IconType {

	FILE_ICON("fileicon"),

	FILE_TYPE("filetype");

	private String iconTypeName;

	IconType(String iconTypeName) {
		this.iconTypeName = iconTypeName;
	}

	public String getName() {
		return iconTypeName;
	}
}
