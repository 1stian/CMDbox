package com.CMDbox;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CMDbox extends JavaPlugin {
	public CMDbox plugin;
	
	public void onDisable(){
		
	}
	
	public void onEnable(){
		PluginManager pm = getServer().getPluginManager();
		
		getCommands(this);
		PluginConfig(this);
	}
	
	public void getCommands(CMDbox CMDbox){
		
	}
	
	public void PluginConfig(CMDbox CMDbox){
		this.getConfig().addDefault("blah", "blah");
		this.saveConfig();
	}
}
