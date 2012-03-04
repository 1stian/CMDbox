package com.CMDbox.Commands.Resources;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.CMDbox.CMDbox;

public class WarpConfig {
	public static CMDbox plugin;
	
	private static FileConfiguration WarpConfig = null;
	private static File WarpFile = null;
	
	public static void reloadWarp() {
	    if (WarpFile == null) {
	    	WarpFile = new File(plugin.getDataFolder(), "/data/Warps.yml");
	    }
	    WarpConfig = YamlConfiguration.loadConfiguration(WarpFile);
	 
	    InputStream defConfigStream = plugin.getResource("/data/Warps.yml");
	    if (defConfigStream != null) {
	        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        WarpConfig.setDefaults(defConfig);
	    }
	}
	
	public static FileConfiguration getWarps() {
	    if (WarpConfig == null) {
	        reloadWarp();
	    }
	    return WarpConfig;
	}
	
	public static void saveWarp() {
	    if (WarpConfig == null || WarpFile == null) {
	    return;
	    }
	    try {
	    	WarpConfig.save(WarpFile);
	    } catch (IOException ex) {
	        Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE, "Could not save config to " + WarpFile, ex);
	    }
	}
}
