package com.CMDbox;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.CMDbox.Commands.CommandMute;
import com.CMDbox.Commands.CommandTp;

public class CMDbox extends JavaPlugin {
	public CMDbox plugin;
	
	public void onDisable(){
		this.saveConfig();
	}
	
	public void onEnable(){
		PluginManager pm = getServer().getPluginManager();
			pm.registerEvents(new Chat(), this);
		
		getCommands(this);
		PluginConfig(this);
	}
	
	public void getCommands(CMDbox CMDbox){
		this.getCommand("mute").setExecutor(new CommandMute(this));
		this.getCommand("tp").setExecutor(new CommandTp(this));
	}
	
	public void PluginConfig(CMDbox CMDbox){
		this.getConfig().options().header("CMDbox Config file!");
		this.getConfig().set("blah boolean test", true);
		this.saveConfig();
	}
}
