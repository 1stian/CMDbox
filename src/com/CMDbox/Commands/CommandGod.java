package com.CMDbox.Commands;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.CMDbox.CMDbox;

public class CommandGod implements CommandExecutor{

	public CommandGod(CMDbox cmDbox) {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if (args.length > 1){
			sender.sendMessage("You're doing it wrong!");
		}else if 
		   (args.length < 1){
			sender.sendMessage("Too many arguments!");
		return true;
		}
		   Player target = player.getServer().getPlayer(args[0]);
		if (cmd.getName().equalsIgnoreCase("god")&& args.length == 1);
		if (!player.hasPermission("CMDbox.God")){
			sender.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
		}else if (player.hasPermission("CMDbox.God"));
		   player.setNoDamageTicks(999999999);
		   sender.sendMessage(ChatColor.GREEN + "Godmode activated!");
		   target.setNoDamageTicks(999999999);
		   target.sendMessage(ChatColor.GREEN + "Godmode activated!");
		   
		return false;
     }	
}
