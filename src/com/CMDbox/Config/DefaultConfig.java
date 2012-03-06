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

public class DefaultConfig {
	public static CMDbox plugin;
	public CommandSetWarp csw;
	
	public static FileConfiguration DefaultConfig = null;
	public static File ConfigFile = null;

	public static void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		}
	
	public static void reloadConfig() {
	    if (ConfigFile == null) {
	    	ConfigFile = new File("plugins/CMDbox/config.yml");
	    }
	    DefaultConfig = YamlConfiguration.loadConfiguration(ConfigFile);
	}
	
	public static FileConfiguration getConfig() {
	    if (DefaultConfig == null) {
	        reloadConfig();
	    }
	    return DefaultConfig;
	}
	
	public static void saveConfig() {
	    if (DefaultConfig == null || ConfigFile == null) {
	    return;
	    }
	    try {
	    	DefaultConfig.save(ConfigFile);
	    } catch (IOException ex) {
	        Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE, "Could not save config to " + ConfigFile, ex);
	    }
	}
}
