package com.CMDbox;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

import com.CMDbox.Config.DefaultConfig;

public class Welcome {
	public void PlayerJoin(PlayerJoinEvent event) throws IOException{
		Player player = event.getPlayer();
		File playerfile = new File(CMDbox.plugin.getDataFolder() + "/data/players/" + player.getName() + ".yml");
		String welcomeText = DefaultConfig.DefaultConfig.getString("general.Welcome text to the player");
		String bname = DefaultConfig.DefaultConfig.getString("general.First time join text before playerName");
		String aname = DefaultConfig.DefaultConfig.getString("general.First time join text after playerName");
		
		if (!playerfile.exists()){
			playerfile.createNewFile();
			Bukkit.broadcastMessage(bname + " " + player.getName() + " " + aname);
		}else{
			player.sendMessage(welcomeText);
		}
	}
}
