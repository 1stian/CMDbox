package com.CMDbox.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.CMDbox.CMDbox;
import com.CMDbox.Config.DefaultConfig;

public class CommandHome implements CommandExecutor {
	public CommandHome(CMDbox cmDbox) {
		// TODO Auto-generated constructor stub
	}

	public boolean onCommand(CommandSender cs, Command cmd, String commandLabel, String[] args){
		if(cs.hasPermission("CMDbox.home")){
			if(cmd.getName().equalsIgnoreCase("home")){
				if(DefaultConfig.DefaultConfig.getBoolean("players.Homes.Allow multiple homes")== true){
					
				}else{
					
				}
			}
		}
		return false;
		
	}
}
