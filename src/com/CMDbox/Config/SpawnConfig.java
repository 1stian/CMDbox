package com.CMDbox.Config;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnConfig {
	public static FileConfiguration SpawnConfig = null;
	public static File SpawnFile = null;

	public static void loadSpawn() {
		getSpawn().options().copyDefaults(true);
		saveSpawn();
		}
	
	public static void reloadSpawn() {
	    if (SpawnFile == null) {
	    	SpawnFile = new File("plugins/CMDbox/data/spawn.yml");
	    }
	    SpawnConfig = YamlConfiguration.loadConfiguration(SpawnFile);
	}
	
	public static FileConfiguration getSpawn() {
	    if (SpawnConfig == null) {
	        reloadSpawn();
	    }
	    return SpawnConfig;
	}
	
	public static void saveSpawn() {
	    if (SpawnConfig == null || SpawnFile == null) {
	    return;
	    }
	    try {
	    	SpawnConfig.save(SpawnFile);
	    } catch (IOException ex) {
	        Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE, "Could not save config to " + SpawnFile, ex);
	    }
	}
}
