package com.CMDbox.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.CMDbox.CMDbox;
import com.CMDbox.Config.DefaultConfig;
import com.CMDbox.Config.HomesFile;

public class CommandHome implements CommandExecutor {
	public CommandHome(CMDbox cmDbox) {
		// TODO Auto-generated constructor stub
	}

	public boolean onCommand(CommandSender cs, Command cmd, String commandLabel, String[] args){
		if(cs.hasPermission("CMDbox.home")){
			if(cmd.getName().equalsIgnoreCase("home")){
				if(DefaultConfig.DefaultConfig.getBoolean("players.Homes.Allow multiple homes")== true){
					if(args.length < 1){
						
					}else if(args.length > 1){
						cs.sendMessage("Too many arguments!");
						cs.sendMessage("Usage: /home homeName");
					}else{
						String name = cs.getName();
						if(HomesFile.HomesConfig.contains(name + "." + args[0])){
							String cWorld = HomesFile.HomesConfig.getString(name + "."+ args[0] + ".world");
					    	int x = HomesFile.HomesConfig.getInt(name + "."+ args[0] + ".x");
					    	int y = HomesFile.HomesConfig.getInt(name + "."+ args[0] + ".y");
					    	int z = HomesFile.HomesConfig.getInt(name + "."+ args[0] + ".z");
					    	Player player = (Player) cs;
					    	Location homeloc = new Location(Bukkit.getWorld(cWorld), x,y,z);
					    	player.teleport(homeloc);
						}
					}
				}else{
					
				}
			}
		}
		return false;
		
	}
}
