package com.CMDbox.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.CMDbox.CMDbox;

public class CommandBan implements CommandExecutor {

	public CommandBan(CMDbox cmDbox) {
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String [] args){
		Player player = (Player) sender;
		Player target = player.getServer().getPlayer(args[0]);
		
		if (cmd.getName().equalsIgnoreCase("Ban")&& args.length == 1){
		if (sender.hasPermission("CMDbox.ban")) {
			if (target == null){
				player.sendMessage(ChatColor.RED + "The player you're trying to ban is currently offline");
				return true;
				 
			}else{

                 target.setBanned(true);
                 player.sendMessage(target + "has been banned.");
                 target.kickPlayer("You've been banned by a server operator or an Administrator.");
                 return true;
                 
			}
                 
			}else{
				
				player.sendMessage(ChatColor.RED + "You don't have permission for this command.");
                 return true;
                 
                 
               
			}
		    }
		
		return false;
		
	}
}
	


