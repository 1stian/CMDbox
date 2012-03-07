package com.CMDbox;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class Welcome {
	public void PlayerJoin(PlayerJoinEvent event) throws IOException{
		Player player = event.getPlayer();
		File playerfile = new File(CMDbox.plugin.getDataFolder() + "/data/players/" + player.getName() + ".yml");
		
		if (!playerfile.exists()){
			playerfile.createNewFile();
			Bukkit.broadcastMessage("Welcome " + player.getName() + " To the server!");
		}else{
			player.sendMessage("Welcome!");
		}
	}
}
