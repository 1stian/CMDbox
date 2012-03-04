package com.CMDbox.Commands.Resources;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.CMDbox.CMDbox;
import com.CMDbox.Commands.CommandSetWarp;

public class WarpConfig {
	public static CMDbox plugin;
	public CommandSetWarp csw;
	
	public static FileConfiguration WarpConfig = null;
	public static File WarpFile = null;

	public static void loadWarps() {
		getWarps().options().copyDefaults(true);
		saveWarps();
		}
	
	public static void reloadWarps() {
	    if (WarpFile == null) {
	    	WarpFile = new File("plugins/CMDbox/data/Warps.yml");
	    }
	    WarpConfig = YamlConfiguration.loadConfiguration(WarpFile);
	}
	
	public static FileConfiguration getWarps() {
	    if (WarpConfig == null) {
	        reloadWarps();
	    }
	    return WarpConfig;
	}
	
	public static void saveWarps() {
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
