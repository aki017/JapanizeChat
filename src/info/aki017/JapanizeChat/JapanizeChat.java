package info.aki017.JapanizeChat;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class JapanizeChat extends JavaPlugin {
	public static final Logger log = Logger.getLogger("Minecraft");
	private ConfigHandler configHandler;
	public void onDisable() {
		log.info("JapanizeChat Disabled");

	}

	public void onEnable() {
		new JapanizeChatPlayerListener(this);

		loadConfig();

		//Register commands
		getCommand("japanize").setExecutor(new JapanizeChatCommand(this));

		//Print that the plugin has been enabled!
		log.info("JapanizeChat version " + getDescription().getVersion() + " is enabled!");

	}

	public void loadConfig(){
		File configFile = new File(getDataFolder(), "config.yml");

		try {
			configFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		configHandler = new ConfigHandler(configFile);
	}

	public ConfigHandler getConfigHandler(){
		return configHandler;
	}
}