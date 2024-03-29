package com.CMDbox.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.CMDbox.CMDbox;
import com.CMDbox.Commands.Resources.MuteMap;

public class CommandMute implements CommandExecutor {
	public CommandMute(CMDbox cmDbox) {
		
	}

	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("mute")) {
			Player player = (Player) cs;
			if (cs.hasPermission("CMDbox.mute")) {
				if (args.length < 1){
					cs.sendMessage("Missing the player name!");
					cs.sendMessage("Usage: /mute playerName");
					return true;
				}else if (args.length > 1){
					cs.sendMessage("To many arguments!");
					cs.sendMessage("Usage: /mute playerName");
					return true;
				}else{
					Player target = player.getServer().getPlayer(args[0]);
					if (target == null){
						player.sendMessage("The Player your trying to mute is not online!");
						return true;
					}else if (MuteMap.mu.containsKey(target)){
						player.sendMessage(args[0] + " is unmuted!");
						MuteMap.mu.remove(target);
						return true;
					}else{
						player.sendMessage(args[0] + " is muted!");
						MuteMap.mu.put(target, "mute");
						return true;
					}
				}
			} else {
				player.sendMessage(ChatColor.RED
						+ "You don't have permissions to do that!");
				return true;
			}
		}
		return false;
	}
}
