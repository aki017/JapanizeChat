package info.aki017.JapanizeChat;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigHandler {
	private File configFile;
	
	private YamlConfiguration config;
	
	public ConfigHandler(File configFile){
		this.configFile = configFile;
		
		this.config = YamlConfiguration.loadConfiguration(configFile);
		
		load();
	}
	
	public void load(){
		
		//Converting of old configs by removing the options from JapanizeChat subsection and moving them to the main node
		ConfigurationSection JapanizeChatSection = config.getConfigurationSection("JapanizeChat");
		
		if (JapanizeChatSection != null){
			for (String key : JapanizeChatSection.getKeys(false)){
				config.set(key, JapanizeChatSection.get(key));
			}
		}
		try {
			config.save(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public String getJapanizeMode(String Name){
		String tmp = (String) config.get("user."+Name);
		if (tmp == null){
			config.set("user."+Name,"On");
			tmp = "On";
			try {
				config.save(configFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return tmp;
	}
	
	public void setJapanizeMode(String Name,String Value){
		config.set("user."+Name,Value);
		
		try {
			config.save(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return;
	}
}