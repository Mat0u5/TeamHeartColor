package net.mat0u5.teamhearts;

import net.mat0u5.teamhearts.platform.Platform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//? fabric {
import net.mat0u5.teamhearts.platform.fabric.FabricPlatform;
//?} neoforge {
/*import net.mat0u5.teamhearts.platform.neoforge.NeoforgePlatform;
 *///?} forge {
/*import net.mat0u5.teamhearts.platform.forge.ForgePlatform;
 *///?}

public class Main {

	public static final String MOD_ID = "teamhearts";
	public static final String MOD_VERSION = "1.1.0";
	public static final String MOD_FRIENDLY_NAME = "Team Heart Color";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	private static final Platform PLATFORM = createPlatformInstance();

	public static void onInitialize() {
		LOGGER.info("Initializing {}", MOD_ID);
		LOGGER.info("{}: { version: {}; friendly_name: {} }", MOD_ID, MOD_VERSION, MOD_FRIENDLY_NAME);
	}

	public static Platform platform() {
		return PLATFORM;
	}

	private static Platform createPlatformInstance() {
		//? fabric {
		return new FabricPlatform();
		//?} neoforge {
		/*return new NeoforgePlatform();
		 *///?} forge {
		/*return new ForgePlatform();
		 *///?}
	}
}
