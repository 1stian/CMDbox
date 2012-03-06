package com.CMDbox;

import org.bukkit.Bukkit;

import com.CMDbox.Config.MessagesTextFile;

public class BroadCaster {
	
	public static void messages(){
		//int interval = MessagesTextFile.MessagesConfig.getInt("BroadCaster.interval");
		if (MessagesTextFile.MessagesConfig.getBoolean("BroadCaster.Enable") == true){
			CMDbox.plugin.getServer().getScheduler().scheduleAsyncRepeatingTask(CMDbox.plugin, new Runnable() {
				int line = MessagesTextFile.MessagesConfig.getInt("Messages.How many lines");
				int x = 0;
				   public void run() {
					   Bukkit.broadcastMessage("running?!?!?!");
					   if (x < line){
						   x = 0;
					   }
				       x++;
				       String message = MessagesTextFile.MessagesConfig.getString("Messages." + x);
				       Bukkit.broadcastMessage(message);
				   }
			}, 60L, 200L);
		}
	}
}
