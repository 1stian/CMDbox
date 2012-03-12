package com.CMDbox.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.CMDbox.CMDbox;

public class CommandTp implements CommandExecutor {
	public CommandTp(CMDbox cmDbox) {
		
	}

	public boolean onCommand(CommandSender cs, Command cmd, String commandLabel, String[] args){
		if (cs.hasPermission("CMDbox.tp")){
			if (cmd.getName().equalsIgnoreCase("tp")){
				if (args.length < 1){
					cs.sendMessage("Missing the player name!");
					cs.sendMessage("Usage: /tp playerName");
					return true;
				}else if (args.length > 1){
					cs.sendMessage("Too many arguments!");
					cs.sendMessage("Usage: /tp playerName");
					return true;
				}else{
					Player player = (Player) cs;
					Player target = player.getServer().getPlayer(args[0]);
					if (!(target == null)){
						player.teleport(target);
						return true;
					}else{
						cs.sendMessage("Player offline or does not exsist!");
						return true;
					}
				}
			}
		}else{
			cs.sendMessage(ChatColor.RED + "You don't have permission for this command.");
		}
		return false;
		
	}
}
