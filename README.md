# Run the example

> mvn package
> ALFRED_WORKER=alfred-worker/target/alfred-worker-1.0-SNAPSHOT.jar
> PLUGIN_PATH=alfred-worker-example/target/alfred-worker-example-1.0-SNAPSHOT.jar
> java -jar $ALFRED_WORKER -pluginPath $PLUGIN_PATH -query "Hello, world\!"