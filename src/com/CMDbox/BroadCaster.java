package com.CMDbox;

import org.bukkit.Bukkit;

import com.CMDbox.Config.MessagesTextFile;

public class BroadCaster {
	public CMDbox pluginNS;
	public BroadCaster(CMDbox CMDbox){
		pluginNS = CMDbox;
	}
	
	public void messages(){
		int interval = MessagesTextFile.MessagesConfig.getInt("BroadCaster.interval");
		if (MessagesTextFile.MessagesConfig.getBoolean("BroadCaster.Enable") == true){
			pluginNS.getServer().getScheduler().scheduleAsyncRepeatingTask(pluginNS, new Runnable() {
				int line = MessagesTextFile.MessagesConfig.getInt("Messages.How many lines");
				int x = 0;
				   public void run() {
					   if (x == line){
						   x = 0;
					   }
				       x++;
				       String message = MessagesTextFile.MessagesConfig.getString("Messages." + x);
				       Bukkit.broadcastMessage(message);
				   }
			}, 60L, interval);
		}
	}
}
