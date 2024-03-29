package com.CMDbox.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.CMDbox.CMDbox;

public class CommandTphere implements CommandExecutor {
	public CommandTphere(CMDbox cmDbox) {
		
	}

	public boolean onCommand(CommandSender cs, Command cmd, String commandLabel, String[] args){
		if (cs.hasPermission("CMDbox.tphere")){
			if (cmd.getName().equalsIgnoreCase("tphere")){
				if (args.length < 1){
					cs.sendMessage("Missing player name!");
					cs.sendMessage("Usage: /tphere playerName");
					return true;
				}else if (args.length > 1){
					cs.sendMessage("To many arguments!");
					cs.sendMessage("Usage: /tphere playerName");
					return true;
				}else{
					Player player = (Player) cs;
					Player target = player.getServer().getPlayer(args[0]);
					if (target == null){
						cs.sendMessage("Player offline or does not exsist!");
						return true;
					}else{
						target.teleport(player);
						return true;
					}
				}
			}
		}else{
			cs.sendMessage(ChatColor.RED + "You don't have permission for this command.");
			return true;
		}
		return false;
		
	}
}
