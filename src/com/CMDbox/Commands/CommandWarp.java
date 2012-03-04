package com.CMDbox.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandWarp {
	
	public void loadC (){
		
	}
	
	public boolean onCommand(CommandSender cs, Command cmd, String commandLabel, String[] args){
		if (cs.hasPermission("CMDbox.warp")){
			if (cs.getName().equalsIgnoreCase("warp")){
				
			}
		}
		return false;
	}
}
