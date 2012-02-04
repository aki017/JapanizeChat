package info.aki017.JapanizeChat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import info.aki017.JapanizeChat.JapanizeChat;

public class JapanizeChatCommand implements CommandExecutor {
	private final JapanizeChat plugin;
	
	public JapanizeChatCommand(JapanizeChat plugin){
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){

		if (args.length < 1){
			sender.sendMessage(ChatColor.GOLD + "JapanizeChat is "+ plugin.getConfigHandler().getJapanizeMode(sender.getName()));
			return true;
		}

		if (args[0].equalsIgnoreCase("on")){
			plugin.getConfigHandler().setJapanizeMode(sender.getName(),"On");
		}
		if (args[0].equalsIgnoreCase("off")){
			plugin.getConfigHandler().setJapanizeMode(sender.getName(),"Off");
		}
		sender.sendMessage(ChatColor.GOLD + "JapanizeChat is "+ plugin.getConfigHandler().getJapanizeMode(sender.getName()));
		return true;
	}
}