package com.CMDbox.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.CMDbox.CMDbox;

public class CommandItem implements CommandExecutor {

	public CommandItem(CMDbox cmDbox) {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
	     
		if (args.length >1){
		    sender.sendMessage(ChatColor.RED + "Missing playername");
		  }else if (args.length < 1){
		    sender.sendMessage(ChatColor.RED + "Too many arguments");
		    
		    return true;   
		  }
		
		Player target = player.getServer().getPlayer(args[0]);
		
		  if (!player.hasPermission("CMDbox.Item")){
			sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
		
			if (cmd.getName().equalsIgnoreCase("item")&& args.length == 1){
			}
		
			
		}
		
		
		
		
		
		
		
		return false;
	}

}
