package com.CMDbox.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.CMDbox.CMDbox;
import com.CMDbox.Commands.Resources.WarpConfig;

public class CommandDelWarp implements CommandExecutor {
	public CommandDelWarp(CMDbox cmDbox) {
		// TODO Auto-generated constructor stub
	}

	public boolean onCommand(CommandSender cs, Command cmd, String commandLabel, String[] args){
		if (cs.hasPermission("CMDbox.delwarp")){
			if (cmd.getName().equalsIgnoreCase("delwarp")){
				if (args.length < 1){
					cs.sendMessage("Missing the warp name to delete!");
					return true;
				}else if(args.length > 1){
					cs.sendMessage("Too mnay arguments!");
					cs.sendMessage("Usage: /delwarp warpName");
					return true;
				}else{
					String WarpEx = args[0];
					if (WarpConfig.WarpConfig.contains(WarpEx)){
						WarpConfig.WarpConfig.set(args[0], null);
						cs.sendMessage("Warp " + args[0] + " is now deleted!");
						return true;
					}else{
						cs.sendMessage("Warp does not exsist!");
						return true;
					}
				}
			}
		}
		return false;
	}
}
