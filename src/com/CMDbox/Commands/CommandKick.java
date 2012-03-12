package com.CMDbox.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.CMDbox.CMDbox;

public class CommandKick implements CommandExecutor{

	public CommandKick(CMDbox cmDbox) {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String [] args){
			Player player = (Player) sender;
		      if (args.length <1){
		        sender.sendMessage(ChatColor.RED + "Missing PlayerName!");
	         }else if (args.length > 1){
	            sender.sendMessage(ChatColor.RED + "Too many arguments!");
		
	         }else{
	        	 Player target = player.getServer().getPlayer (args[0]);
	        	 if (cmd.getName().equalsIgnoreCase("kick") && args.length == 1){
	        		 if (sender.hasPermission("CMDbox.Kick")) {
	        			 if (target == null){
	        				 sender.sendMessage(ChatColor.RED + "The player you're trying to kick is currently offline.");
		        			 return true;
	        			 }else{
	        				 target.kickPlayer("You've kicked by a server operator or an Administrator");
		        			 sender.sendMessage(ChatColor.GREEN + "" + target + "has been kicked from the server!");
	        			 }
	    			
	        		 }else{
	        			 sender.sendMessage(ChatColor.RED + "You don't have permission for this command.");
	        		 }
	        	 }
	    	}
			return false;
	    	
	     }
	}
