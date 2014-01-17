package net.coffeedriven.alfred.spi;

public class Item {

	private String uid;

	private String arg;

	Type type;

	boolean isValid;

	String autocomplete;

	String title;

	String subTitle;

	String icon;

	IconType iconType;

	public Item() {
	}

	public Item(String uid, String arg, Type type, boolean valid, String autocomplete, String title, String subTitle,
		String icon) {
		this.uid = uid;
		this.arg = arg;
		this.type = type;
		isValid = valid;
		this.autocomplete = autocomplete;
		this.title = title;
		this.subTitle = subTitle;
		this.icon = icon;
	}

	public String getUid() {
		return uid;
	}

	public Item setUid(String uid) {
		this.uid = uid;
		return this;
	}

	public String getArg() {
		return arg;
	}

	public Item setArg(String arg) {
		this.arg = arg;
		return this;
	}

	public Type getType() {
		return type;
	}

	public Item setType(Type type) {
		this.type = type;
		return this;
	}

	public boolean isValid() {
		return isValid;
	}

	public Item setValid(boolean valid) {
		isValid = valid;
		return this;
	}

	public String getAutocomplete() {
		return autocomplete;
	}

	public Item setAutocomplete(String autocomplete) {
		this.autocomplete = autocomplete;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Item setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public Item setSubTitle(String subTitle) {
		this.subTitle = subTitle;
		return this;
	}

	public String getIcon() {
		return icon;
	}

	public Item setIcon(String icon) {
		this.icon = icon;
		return this;
	}

	public IconType getIconType() {
		return iconType;
	}

	public Item setIconType(IconType iconType) {
		this.iconType = iconType;
		return this;
	}
}
