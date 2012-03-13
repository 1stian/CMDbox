package com.CMDbox.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.CMDbox.Config.SpawnConfig;

public class CommandSetSpawn {
	public boolean onCommand(CommandSender cs, Command cmd, String commandLabel, String[] args){
		if (cs.hasPermission("CMDbox.setspawn")){
			if (cmd.getName().equalsIgnoreCase("setspawn")){
				if (cs instanceof Player){
					Player player = (Player)cs;
					String cWorld = player.getWorld().getName();
					int x = player.getLocation().getBlockX();
					int y = player.getLocation().getBlockY();
					int z = player.getLocation().getBlockZ();
					
					SpawnConfig.SpawnConfig.addDefault("spawn.", cWorld);
					SpawnConfig.SpawnConfig.addDefault("spawn." + cWorld + ".", x);
					SpawnConfig.SpawnConfig.addDefault("spawn." + cWorld + ".", y);
					SpawnConfig.SpawnConfig.addDefault("spawn." + cWorld + ".", z);
					SpawnConfig.saveSpawn();
					cs.sendMessage("Spawn is set to your location!");
					return true;
				}
			}
		}
		return false;
		
	}
}
