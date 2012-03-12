package com.CMDbox.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.CMDbox.CMDbox;
import com.CMDbox.Commands.Resources.WarpMap;
import com.CMDbox.Config.WarpConfig;

public class CommandWarp implements CommandExecutor {
	
	public CommandWarp(CMDbox cmDbox) {
		// TODO Auto-generated constructor stub
	}

	public void loadC (){
		String cworld = WarpMap.ChunkLocWorld.get("world");
		int x = WarpMap.ChunkLoc.get("x");
		int z = WarpMap.ChunkLoc.get("z");
	   
		if (!Bukkit.getServer().getWorld(cworld).isChunkLoaded(x, z)){
	    	Bukkit.getServer().getWorld(cworld).loadChunk(x, z);
	    }
	}
	
	public boolean onCommand(final CommandSender cs, Command cmd, String commandLabel, final String[] args){
		if (cs.hasPermission("CMDbox.warp")){
			if (cmd.getName().equalsIgnoreCase("warp")){
				if (args.length < 1){
					cs.sendMessage("Mising warp name!");
					cs.sendMessage("Usage: /warp warpName");
					return true;
				}else if (args.length > 1){
					cs.sendMessage("Too many arguments!");
					cs.sendMessage("Usage: /warp warpName");
					return true;
				}else{
					final String WarpEx = args[0];
					if (WarpConfig.WarpConfig.contains(WarpEx)){
						String cworld = WarpConfig.WarpConfig.getString(WarpEx + ".world");
						int x = WarpConfig.WarpConfig.getInt(WarpEx + ".x");
						int z = WarpConfig.WarpConfig.getInt(WarpEx + ".z");
						WarpMap.ChunkLocWorld.put("world", cworld);
						WarpMap.ChunkLoc.put("x", x);
						WarpMap.ChunkLoc.put("z", z);
						loadC();
						cs.sendMessage("warping!");
						
						CMDbox.plugin.getServer().getScheduler().scheduleSyncDelayedTask(CMDbox.plugin, new Runnable() {
							@Override
							public void run() {
								String cworld = WarpConfig.WarpConfig.getString(WarpEx + ".world");
								int x = WarpConfig.WarpConfig.getInt(WarpEx + ".x");
								int y = WarpConfig.WarpConfig.getInt(WarpEx + ".y");
								int z = WarpConfig.WarpConfig.getInt(WarpEx + ".z");
								Player player = (Player) cs;
								
								Location warpto = new Location(Bukkit.getWorld(cworld), x, y, z);
								player.teleport(warpto);
								
							}
						}, 40L);
						return true;
					}else{
						cs.sendMessage("Warp does not exsist!");
						return true;
					}
				}
			}
		}else{
			cs.sendMessage(ChatColor.RED + "You don't have permission for this command.");
		}
		return false;
	}
}
