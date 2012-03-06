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

public class MessagesTextFile {
	public static CMDbox plugin;
	public CommandSetWarp csw;
	
	public static FileConfiguration MessagesConfig = null;
	public static File MessagesFile = null;

	public static void loadMessages() {
		getMessages().options().copyDefaults(true);
		saveMessages();
		}
	
	public static void reloadMessages() {
	    if (MessagesFile == null) {
	    	MessagesFile = new File("plugins/CMDbox/messages.yml");
	    }
	    MessagesConfig = YamlConfiguration.loadConfiguration(MessagesFile);
	}
	
	public static FileConfiguration getMessages() {
	    if (MessagesConfig == null) {
	        reloadMessages();
	    }
	    return MessagesConfig;
	}
	
	public static void saveMessages() {
	    if (MessagesConfig == null || MessagesFile == null) {
	    return;
	    }
	    try {
	    	MessagesConfig.save(MessagesFile);
	    } catch (IOException ex) {
	        Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE, "Could not save config to " + MessagesFile, ex);
	    }
	}
}
