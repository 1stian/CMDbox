package com.CMDbox.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;

import com.CMDbox.CMDbox;

public class CommandCMDbox implements CommandExecutor {
	
	
	public CommandCMDbox(CMDbox cmDbox) {
		// TODO Auto-generated constructor stub
	}

	public boolean onCommand(CommandSender cs, Command cmd, String commandLabel, String[] args){
		PluginDescriptionFile pdfFile = CMDbox.plugin.getDescription();
		if (cmd.getName().equalsIgnoreCase("cmdbox")){
			cs.sendMessage("Name: " + pdfFile.getName());
			//cs.sendMessage(pdfFile.getAuthors());
			cs.sendMessage("Description: " + pdfFile.getDescription());
			cs.sendMessage("Version: " + pdfFile.getVersion());
		}
		return false;
	}
}
