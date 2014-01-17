package net.coffeedriven;

import net.coffeedriven.alfred.item.DefaultItemManager;
import net.coffeedriven.alfred.item.FeedbackGenerator;
import net.coffeedriven.alfred.plugin.PluginManager;
import net.coffeedriven.alfred.spi.ItemManager;
import org.apache.commons.cli.*;

import java.io.File;

public class AlfredWorker {

	public static void main(String[] args) {
		new AlfredWorker().run(args);
	}

	private void run(String[] args) {
		CommandLineParser parser = new GnuParser();
		try {
			Options options = createOptions();
			CommandLine line = parser.parse(options, args);
			dispatch(line, options);
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
	}

	private void dispatch(CommandLine line, Options options) {
		if (!line.hasOption("pluginPath") || !line.hasOption("query")) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("alfred-worker", options);
		} else {
			try {
				ItemManager itemManager = new DefaultItemManager();
				PluginManager pluginManager = new PluginManager(itemManager);
				pluginManager.addPluginSource(new File(line.getOptionValue("pluginPath")));
				pluginManager.initializePlugins();
				pluginManager.invokePlugins(line.getOptionValue("query"));
				FeedbackGenerator feedbackGenerator = new FeedbackGenerator();
				System.out.println(feedbackGenerator.generate(itemManager.getItems()));
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	@SuppressWarnings("AccessStaticViaInstance")
	public Options createOptions() {
		Option pluginDirOption = OptionBuilder
			.withArgName("path")
			.hasArg()
			.withDescription("Path to the plugin directory.")
			.create("pluginPath");

		Option queryOption = OptionBuilder
			.withArgName("query")
			.hasArg()
			.withDescription("Alfred's query.")
			.create("query");

		Options options = new Options();
		options.addOption(pluginDirOption);
		options.addOption(queryOption);
		return options;
	}
}
