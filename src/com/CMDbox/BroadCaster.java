package com.CMDbox;

import org.bukkit.Bukkit;

import com.CMDbox.Config.MessagesTextFile;

public class BroadCaster {
	public static int line = MessagesTextFile.MessagesConfig.getInt("Messages.How many lines");
	public static int x = 0;
	public static int interval = MessagesTextFile.MessagesConfig.getInt("BroadCaster.interval");
	public static int inter = interval * 20;
	public static String prefix = MessagesTextFile.MessagesConfig.getString("BroadCaster.prefix");
	public static void messages(){
		if (MessagesTextFile.MessagesConfig.getBoolean("BroadCaster.Enable") == true){
			CMDbox.plugin.getServer().getScheduler().scheduleAsyncRepeatingTask(CMDbox.plugin, new Runnable() {
				   public void run() {
					   if (x == line){
						   x = 0;
					   }
					   x++;
				       String message = MessagesTextFile.MessagesConfig.getString("Messages." + x);
				       Bukkit.broadcastMessage(prefix + " " + message);
				   }
			}, 60L, inter);
		}
	}
}
