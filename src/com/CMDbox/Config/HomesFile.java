package com.CMDbox.Config;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.CMDbox.CMDbox;
import com.CMDbox.Commands.CommandSetWarp;

public class HomesFile {
	public static CMDbox plugin;
	public CommandSetWarp csw;
	
	public static FileConfiguration HomesConfig = null;
	public static File HomesFile = null;

	public static void loadHomes() {
		getHomes().options().copyDefaults(true);
		saveHomes();
		}
	
	public static void reloadHomes() {
	    if (HomesFile == null) {
	    	HomesFile = new File("plugins/CMDbox/data/homes.yml");
	    }
	    HomesConfig = YamlConfiguration.loadConfiguration(HomesFile);
	}
	
	public static FileConfiguration getHomes() {
	    if (HomesConfig == null) {
	    	reloadHomes();
	    }
	    return HomesConfig;
	}
	
	public static void saveHomes() {
	    if (HomesConfig == null || HomesFile == null) {
	    return;
	    }
	    try {
	    	HomesConfig.save(HomesFile);
	    } catch (IOException ex) {
	        Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE, "Could not save config to " + HomesFile, ex);
	    }
	}
}
