package com.CMDbox.Commands;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.CMDbox.CMDbox;

public class CommandUnban implements CommandExecutor {
	public CommandUnban(CMDbox cmDbox) {
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player player = (Player) sender;
		
		if (args.length <1){
			sender.sendMessage("Missing playerName!");
		}else if(args.length >1){
			sender.sendMessage("Too many arguments!");
			
		}else{
			OfflinePlayer target = player.getServer().getOfflinePlayer(args[0]);
			if (sender.hasPermission("CMDbox.unban")) {
				if (cmd.getName().equalsIgnoreCase("unban") && args.length == 1) {
						target.setBanned(false);
						player.sendMessage(args[0] + " is now unbanned!");
						return true;
					}
			}else {
				player.sendMessage(ChatColor.RED
						+ "You don't have permissions to do that!");
				return true;
			}
		}
			
		return false;
	}
}
