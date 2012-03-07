package com.CMDbox;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
		
		//colors
        bname = bname.replaceAll("&0", ChatColor.BLACK + "");
        bname = bname.replaceAll("&1", ChatColor.DARK_BLUE + "");
        bname = bname.replaceAll("&2", ChatColor.DARK_GREEN + "");
        bname = bname.replaceAll("&3", ChatColor.DARK_AQUA + "");
        bname = bname.replaceAll("&4", ChatColor.DARK_RED + "");
        bname = bname.replaceAll("&5", ChatColor.DARK_PURPLE + "");
        bname = bname.replaceAll("&6", ChatColor.GOLD + "");
        bname = bname.replaceAll("&7", ChatColor.GRAY + "");
        bname = bname.replaceAll("&8", ChatColor.DARK_GRAY+ "");
        bname = bname.replaceAll("&9", ChatColor.BLUE + "");
        bname = bname.replaceAll("&a", ChatColor.GREEN + "");
        bname = bname.replaceAll("&b", ChatColor.AQUA + "");
        bname = bname.replaceAll("&c", ChatColor.RED + "");
        bname = bname.replaceAll("&d", ChatColor.LIGHT_PURPLE + "");
        bname = bname.replaceAll("&e", ChatColor.YELLOW + "");
        bname = bname.replaceAll("&f", ChatColor.WHITE + "");
        bname = bname.replaceAll("&g", ChatColor.MAGIC + "");
        
        aname = aname.replaceAll("&0", ChatColor.BLACK + "");
        aname = aname.replaceAll("&1", ChatColor.DARK_BLUE + "");
        aname = aname.replaceAll("&2", ChatColor.DARK_GREEN + "");
        aname = aname.replaceAll("&3", ChatColor.DARK_AQUA + "");
        aname = aname.replaceAll("&4", ChatColor.DARK_RED + "");
        aname = aname.replaceAll("&5", ChatColor.DARK_PURPLE + "");
        aname = aname.replaceAll("&6", ChatColor.GOLD + "");
        aname = aname.replaceAll("&7", ChatColor.GRAY + "");
        aname = aname.replaceAll("&8", ChatColor.DARK_GRAY+ "");
        aname = aname.replaceAll("&9", ChatColor.BLUE + "");
        aname = aname.replaceAll("&a", ChatColor.GREEN + "");
        aname = aname.replaceAll("&b", ChatColor.AQUA + "");
        aname = aname.replaceAll("&c", ChatColor.RED + "");
        aname = aname.replaceAll("&d", ChatColor.LIGHT_PURPLE + "");
        aname = aname.replaceAll("&e", ChatColor.YELLOW + "");
        aname = aname.replaceAll("&f", ChatColor.WHITE + "");
        aname = aname.replaceAll("&g", ChatColor.MAGIC + "");
		
        welcomeText = welcomeText.replaceAll("&0", ChatColor.BLACK + "");
        welcomeText = welcomeText.replaceAll("&1", ChatColor.DARK_BLUE + "");
        welcomeText = welcomeText.replaceAll("&2", ChatColor.DARK_GREEN + "");
        welcomeText = welcomeText.replaceAll("&3", ChatColor.DARK_AQUA + "");
        welcomeText = welcomeText.replaceAll("&4", ChatColor.DARK_RED + "");
        welcomeText = welcomeText.replaceAll("&5", ChatColor.DARK_PURPLE + "");
        welcomeText = welcomeText.replaceAll("&6", ChatColor.GOLD + "");
        welcomeText = welcomeText.replaceAll("&7", ChatColor.GRAY + "");
        welcomeText = welcomeText.replaceAll("&8", ChatColor.DARK_GRAY+ "");
        welcomeText = welcomeText.replaceAll("&9", ChatColor.BLUE + "");
        welcomeText = welcomeText.replaceAll("&a", ChatColor.GREEN + "");
        welcomeText = welcomeText.replaceAll("&b", ChatColor.AQUA + "");
        welcomeText = welcomeText.replaceAll("&c", ChatColor.RED + "");
        welcomeText = welcomeText.replaceAll("&d", ChatColor.LIGHT_PURPLE + "");
        welcomeText = welcomeText.replaceAll("&e", ChatColor.YELLOW + "");
        welcomeText = welcomeText.replaceAll("&f", ChatColor.WHITE + "");
        welcomeText = welcomeText.replaceAll("&g", ChatColor.MAGIC + "");
		
        if (!playerfile.exists()){
			playerfile.createNewFile();
			Bukkit.broadcastMessage(bname + " " + player.getName() + " " + aname);
		}else{
			player.sendMessage(welcomeText);
		}
	}
}
