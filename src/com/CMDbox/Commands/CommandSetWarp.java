package com.CMDbox.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.CMDbox.CMDbox;
import com.CMDbox.Commands.Resources.WarpConfig;

public class CommandSetWarp implements CommandExecutor {
	public CommandSetWarp(CMDbox cmDbox) {
		
	}

	public boolean onCommand(CommandSender cs, Command cmd, String commandLabel, String[] args){
		Player player = (Player) cs;
		if (cs.hasPermission("CMDbox.setwarp")){
			if (cmd.getName().equalsIgnoreCase("setwarp")){
				if (args.length < 1){
					cs.sendMessage("Mising warp name!");
					cs.sendMessage("Usage: /setwarp warpName");
					return true;
				}else if (args.length > 1){
					cs.sendMessage("Too many arguments!");
					cs.sendMessage("Usage: /setwarp warpName");
					return true;
				}else{
					String WarpEx = args[0];
					if (!WarpConfig.WarpConfig.contains(WarpEx)){
						String Path = args[0] + ".";
						String curworld = player.getWorld().getName();
						int x = player.getLocation().getBlockX();
						int y = player.getLocation().getBlockY();
						int z = player.getLocation().getBlockZ();
						WarpConfig.WarpConfig.addDefault(Path + "world", curworld);
						WarpConfig.WarpConfig.addDefault(Path + "x", x);
						WarpConfig.WarpConfig.addDefault(Path + "y", y);
						WarpConfig.WarpConfig.addDefault(Path + "z", z);
						WarpConfig.saveWarps();
						cs.sendMessage("Warp " + args[0] + " is set!");
						return true;
					}else{
						cs.sendMessage("Warp does already exsist!");
						return true;
					}
				}
			}
		}else{
			cs.sendMessage("you got no permissions for that!");
			return true;
		}
		return false;
	}
}
