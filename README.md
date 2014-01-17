# Run the example

    mvn package
    ALFRED_WORKER=alfred-worker/target/alfred-worker-1.0-SNAPSHOT.jar
    PLUGIN_PATH=alfred-worker-example/target/alfred-worker-example-1.0-SNAPSHOT.jar
    java -jar $ALFRED_WORKER -pluginPath $PLUGIN_PATH -query "Hello, world\!"

# Quickstart Example

    public class ExamplePlugin extends AbstractWorkflowPlugin {
    	@Override
    	public void run(String query) throws PluginException {
    		getItemManager().addItem(new Item().setArg(query).setAutocomplete(query).setSubTitle(query).setValid(true));
    	}
    }

