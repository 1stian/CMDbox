package com.CMDbox.Commands;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.CMDbox.CMDbox;
import com.CMDbox.Commands.Resources.GodMap;

public class CommandGod implements CommandExecutor{

	public CommandGod(CMDbox cmDbox) {
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs.hasPermission("CMDbox.god")){
			if (cmd.getName().equalsIgnoreCase("god")){
				if (args.length == 1){
					if (cs.hasPermission("CMDbox.god.others")){
						Player target = cs.getServer().getPlayer(args[0]);
						if (!GodMap.GodM.containsKey(target)){
							GodMap.GodM.put(target, true);
							cs.sendMessage(ChatColor.AQUA + "God mode enabled for " + ChatColor.GREEN + args[0]);
						}else{
							GodMap.GodM.put(target, false);
							cs.sendMessage(ChatColor.AQUA + "God mode disabled for " + ChatColor.GREEN + args[0]);
						}
					}
				}else if(args.length == 0){
					String pname = cs.getName();
					Player player = cs.getServer().getPlayer(pname);
					if (!GodMap.GodM.containsKey(player)){
						GodMap.GodM.put(player, true);
						cs.sendMessage(ChatColor.AQUA + "God mode enabled");
					}else{
						GodMap.GodM.put(player, false);
						cs.sendMessage(ChatColor.AQUA + "God mode disabled");
					}
				}
			}
		}
		
		return false;
     }	
}
