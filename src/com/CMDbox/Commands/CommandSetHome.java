package com.CMDbox.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.CMDbox.CMDbox;
import com.CMDbox.Config.DefaultConfig;
import com.CMDbox.Config.HomesFile;

public class CommandSetHome implements CommandExecutor {
	public CommandSetHome(CMDbox cmDbox) {
		// TODO Auto-generated constructor stub
	}

	public boolean onCommand(CommandSender cs, Command cmd, String commandLabel, String[] args){
		if(cs.hasPermission("CMDbox.sethome")){
			if(cmd.getName().equalsIgnoreCase("sethome")){
				String name = cs.getName();
				if(DefaultConfig.DefaultConfig.getBoolean("players.Homes.Allow multiple homes")== true){
					if(cs instanceof Player){
						if (args.length < 1){
							cs.sendMessage("Name your home!");
							cs.sendMessage("Usage: /sethome homeName");
							return true;
						}else if(args.length > 1){
							cs.sendMessage("Too many arguments!");
							cs.sendMessage("Usage: /sethome homeName");
							return true;
						}else{
							Player player = (Player)cs;
					    	String cw = player.getWorld().getName();
					    	int x = player.getLocation().getBlockX();
					    	int y = player.getLocation().getBlockY();
					    	int z = player.getLocation().getBlockZ();
					    		
					    	HomesFile.HomesConfig.addDefault(name + "."+ args[0] + ".world", cw);
					    	HomesFile.HomesConfig.addDefault(name + "."+ args[0] + ".x", x);
					    	HomesFile.HomesConfig.addDefault(name + "."+ args[0] + ".y", y);
					    	HomesFile.HomesConfig.addDefault(name + "."+ args[0] + ".z", z);
					    	HomesFile.saveHomes();
					    	cs.sendMessage("Your home is set!");
					    	return true;
						}
					}
				}else{
					if(cs instanceof Player){
					    	if (HomesFile.HomesConfig.contains(name + ".home")){
					    		cs.sendMessage("You already got a home!");
					    		return true;
					    	}else{
					    		if(args.length > 0){
									cs.sendMessage("Too many arguments!");
									return true;
								}else{
									Player player = (Player)cs;
							    	String cw = player.getWorld().getName();
							    	int x = player.getLocation().getBlockX();
							    	int y = player.getLocation().getBlockY();
							    	int z = player.getLocation().getBlockZ();
							    		
							    	HomesFile.HomesConfig.addDefault(name + ".home.world", cw);
							    	HomesFile.HomesConfig.addDefault(name + ".home.x", x);
							    	HomesFile.HomesConfig.addDefault(name + ".home.y", y);
							    	HomesFile.HomesConfig.addDefault(name + ".home.z", z);
							    	HomesFile.saveHomes();
							    	cs.sendMessage("Your home is set!");
							    	return true;
								}
					    	}
					    }
				}
			}
		}
		return false;
		
	}
}
