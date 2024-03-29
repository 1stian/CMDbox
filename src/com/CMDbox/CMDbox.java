package com.CMDbox;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.CMDbox.Commands.CommandBan;
import com.CMDbox.Commands.CommandCMDbox;
import com.CMDbox.Commands.CommandDelWarp;
import com.CMDbox.Commands.CommandGod;
import com.CMDbox.Commands.CommandHome;
import com.CMDbox.Commands.CommandItem;
import com.CMDbox.Commands.CommandKick;
import com.CMDbox.Commands.CommandMute;
import com.CMDbox.Commands.CommandSetHome;
import com.CMDbox.Commands.CommandSetWarp;
import com.CMDbox.Commands.CommandTp;
import com.CMDbox.Commands.CommandTphere;
import com.CMDbox.Commands.CommandUnban;
import com.CMDbox.Commands.CommandWarp;
import com.CMDbox.Config.DefaultConfig;
import com.CMDbox.Config.HomesFile;
import com.CMDbox.Config.MessagesTextFile;
import com.CMDbox.Config.WarpConfig;

public class CMDbox extends JavaPlugin {
	public static CMDbox plugin;
	public CMDbox pluginNS = this;
	public Logger log = Logger.getLogger("Minecraft");
	
	public void onDisable(){
		
	}
	
	public void onEnable(){
		PluginManager pm = getServer().getPluginManager();
			pm.registerEvents(new Chat(), this);
		
		getCommands(this);
		PluginConfig(this);
		
		plugin = this;
		
		File datadir = new File (this.getDataFolder() + "/data");
		datadir.mkdir();
		File playerdir = new File(this.getDataFolder() + "/data/players");
		playerdir.mkdir();
		WarpConfig.loadWarps();
		DefaultConfig.loadConfig();
		HomesFile.loadHomes();
		MessagesTextFile.loadMessages();
		PluginConfig(this);
		MessagesConfigFile(this);
		
		pluginNS.getServer().getScheduler().scheduleSyncDelayedTask(pluginNS, new Runnable() {
			public void run() {
		    	BroadCaster.messages();
		    }
		}, 120L);
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
		this.getCommand("delwarp").setExecutor(new CommandDelWarp(this));
		this.getCommand("god").setExecutor(new CommandGod(this));
		this.getCommand("item").setExecutor(new CommandItem(this));
		this.getCommand("cmdbox").setExecutor(new CommandCMDbox(this));
		this.getCommand("home").setExecutor(new CommandHome(this));
		this.getCommand("sethome").setExecutor(new CommandSetHome(this));
	}
	
	public void PluginConfig(CMDbox CMDbox){
		DefaultConfig.getConfig().getDefaults();
		DefaultConfig.DefaultConfig.options().header("CMDbox Config file!");
		DefaultConfig.DefaultConfig.addDefault("general.Welcome text to the player", "Welcome!");
		DefaultConfig.DefaultConfig.addDefault("general.First time join text before playerName", "Welcome");
		DefaultConfig.DefaultConfig.addDefault("general.First time join text after playerName", "to the server");
		DefaultConfig.DefaultConfig.addDefault("players.Homes.Allow multiple homes", true);
		DefaultConfig.DefaultConfig.addDefault("players.Homes.How many homes allowed - THIS IS NOT WORKING YET", 5);
		DefaultConfig.saveConfig();
	}
	
	public void MessagesConfigFile(CMDbox CMDbox){
		MessagesTextFile.MessagesConfig.options().header("CMDbox BroadCaster settings!");
		MessagesTextFile.MessagesConfig.addDefault("BroadCaster.Enable", false);
		MessagesTextFile.MessagesConfig.addDefault("BroadCaster.prefix", "&a[&fCMDbox&a]&f");
		MessagesTextFile.MessagesConfig.addDefault("BroadCaster.interval", 45);
		MessagesTextFile.MessagesConfig.addDefault("Messages.How many lines", 4);
		MessagesTextFile.MessagesConfig.addDefault("Messages.1", "&aHi &fand &bwelcome1");
		MessagesTextFile.MessagesConfig.addDefault("Messages.2", "&aHi &fand &bwelcome2");
		MessagesTextFile.MessagesConfig.addDefault("Messages.3", "&aHi &fand &bwelcome3");
		MessagesTextFile.MessagesConfig.addDefault("Messages.4", "&aHi &fand &bwelcome4");
		MessagesTextFile.saveMessages();
	}
}
