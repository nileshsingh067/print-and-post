package print.and.post.camel.bridge.util;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

/**
 * This class interacts with config server and gets the required values
 *
 * 
 * @since 0.0.1
 *
 */
public class BridgeUtil {

	private static JsonObject bridgeConfiguration = null;

	private BridgeUtil() {

	}

	/**
	 * This method gets all values from config server as a JsonObject and stores it
	 * locally
	 */
	public static void getConfiguration() {
		String url = PropertyFileUtil.getProperty(BridgeUtil.class, "bootstrap.properties", "url");
		CompletableFuture<JsonObject> configuration = new CompletableFuture<>();

		ConfigStoreOptions configStoreOptions = new ConfigStoreOptions().setType("spring-config-server")
				.setConfig(new JsonObject().put("url", url).put("timeout", 70000));

		ConfigRetriever configRetriever = ConfigRetriever.create(Vertx.vertx(),
				new ConfigRetrieverOptions().addStore(configStoreOptions));

		configRetriever.getConfig(config -> {
			if (config.succeeded()) {
				configuration.complete(config.result());
			} else {
			//	throw new ConfigurationServerFailureException(
					//	PlatformErrorMessages.RPR_CMB_CONFIGURATION_SERVER_FAILURE_EXCEPTION.getMessage());
				//throw new Exception("CMB_CONFIGURATION_SERVER_FAILURE_EXCEPTION");
				System.out.println("	throw new Exception(\"CMB_CONFIGURATION_SERVER_FAILURE_EXCEPTION\"); ");
			}
		});

		try {
			BridgeUtil.bridgeConfiguration = configuration.get();
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
			//throw new ConfigurationServerFailureException(
				//	PlatformErrorMessages.RPR_CMB_CONFIGURATION_SERVER_FAILURE_EXCEPTION.getMessage(), e);
			System.out.println("	throw new Exception(\"CMB_CONFIGURATION_SERVER_FAILURE_EXCEPTION\"); "+e);
		}

	}

	/**
	 * This method returns the camel endpoint along with component
	 *
	 * @param messageBusAddress
	 *            The address to be used for endpoint
	 * @return The address as per the configured camel component
	 */
	public static String getPropertyFromConfigServer(String key) {
		if (BridgeUtil.bridgeConfiguration == null) {
			getConfiguration();
		}
		return BridgeUtil.bridgeConfiguration.getString(key);
	}
}
