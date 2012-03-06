package com.CMDbox;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.CMDbox.Commands.CommandBan;
import com.CMDbox.Commands.CommandCMDbox;
import com.CMDbox.Commands.CommandGod;
import com.CMDbox.Commands.CommandItem;
import com.CMDbox.Commands.CommandKick;
import com.CMDbox.Commands.CommandMute;
import com.CMDbox.Commands.CommandSetWarp;
import com.CMDbox.Commands.CommandTp;
import com.CMDbox.Commands.CommandTphere;
import com.CMDbox.Commands.CommandUnban;
import com.CMDbox.Commands.CommandWarp;
import com.CMDbox.Commands.Resources.WarpConfig;

public class CMDbox extends JavaPlugin {
	public static CMDbox plugin;
	public Logger log = Logger.getLogger("Minecraft");
	
	public void onDisable(){
		this.saveConfig();
	}
	
	public void onEnable(){
		PluginManager pm = getServer().getPluginManager();
			pm.registerEvents(new Chat(), this);
		
		getCommands(this);
		PluginConfig(this);
		
		File datadir = new File (this.getDataFolder() + "/data");
		datadir.mkdir();
		WarpConfig.loadWarps();
	}
	
	public void getCommands(CMDbox CMDbox){
		this.getCommand("mute").setExecutor(new CommandMute(this));
		this.getCommand("tp").setExecutor(new CommandTp(this));
		this.getCommand("tphere").setExecutor(new CommandTphere(this));
		this.getCommand("ban").setExecutor(new CommandBan(this));
		this.getCommand("unban").setExecutor(new CommandUnban(this));
		this.getCommand("kick").setExecutor(new CommandKick (this));
		this.getCommand("setwarp").setExecutor(new CommandSetWarp(this));
		this.getCommand("warp").setExecutor(new CommandWarp(this));
		this.getCommand("god").setExecutor(new CommandGod(this));
		this.getCommand("item").setExecutor(new CommandItem(this));
		this.getCommand("cmdbox").setExecutor(new CommandCMDbox(this));
	}
	
	public void PluginConfig(CMDbox CMDbox){
		this.getConfig().getDefaults();
		this.getConfig().options().header("CMDbox Config file!");
		this.getConfig().set("blah boolean test", true);
		this.saveConfig();
	}
}
