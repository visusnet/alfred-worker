package net.coffeedriven.alfred.item;

import net.coffeedriven.alfred.spi.Item;
import net.coffeedriven.alfred.spi.Type;
import org.jdom2.Attribute;
import org.jdom2.CDATA;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.util.List;

public class FeedbackGenerator {

	public String generate(List<Item> items) {
		Element itemsElement = new Element("items");
		Document document = new Document(itemsElement);

		for (Item item : items) {
			document.getRootElement().addContent(createElement(item));
		}

		XMLOutputter xmlOutputter = new XMLOutputter();
		xmlOutputter.setFormat(Format.getPrettyFormat());
		return xmlOutputter.outputString(document);
	}

	private Element createElement(Item item) {
		Element element = new Element("item");
		if (item.getUid() != null) {
			element.setAttribute(new Attribute("uid", item.getUid()));
		}
		if (item.getArg() != null) {
			element.setAttribute(new Attribute("arg", item.getArg()));
		}
		if (item.getType() != null) {
			element.setAttribute(new Attribute("arg", item.getType().getName()));
		} else {
			element.setAttribute(new Attribute("arg", Type.FILE.getName()));
		}
		if (item.getTitle() != null) {
			element.addContent(new Element("title").setText(item.getTitle()));
		}
		if (item.getSubTitle() != null) {
			element.addContent(new Element("subtitle").setText(item.getSubTitle()));
		}
		if (item.getIcon() != null && item.getIconType() != null) {
			Element iconElement = new Element("icon");
			iconElement.setAttribute(new Attribute("type", item.getIconType().getName()));
			iconElement.setContent(new CDATA(item.getIcon()));
			element.addContent(iconElement);
		}
		return element;
	}

}