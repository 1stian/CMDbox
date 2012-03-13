package com.CMDbox.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.CMDbox.Config.SpawnConfig;

public class CommandSpawn {
	public boolean onCommand(CommandSender cs, Command cmd, String commandLabel, String[] args){
		if(cs.hasPermission("CMDbox.spawn")){
			if(cmd.getName().equalsIgnoreCase("spawn")){
				if (cs instanceof Player){
					Player player = (Player)cs;
					String cWorld = player.getWorld().getName();
					
					int x = SpawnConfig.SpawnConfig.getInt("spawn." + cWorld + ".x");
					int y = SpawnConfig.SpawnConfig.getInt("spawn." + cWorld + ".y");
					int z = SpawnConfig.SpawnConfig.getInt("spawn." + cWorld + ".z");
					
					Location spawnloc = new Location(Bukkit.getWorld(cWorld), x,y,z);
					player.teleport(spawnloc);
					return true;
				}
			}
		}
		return false;
		
	}
}
