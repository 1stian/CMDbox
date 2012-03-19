package com.CMDbox.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGM {
	public boolean onCommand(CommandSender cs, Command cmd,
			String commandLabel, String[] args) {
		if (cs.hasPermission("CMDbox.gm")) {
			if (cmd.getName().equalsIgnoreCase("gm")) {
				if (args.length < 1) {
					if (cs instanceof Player) {
						Player player = (Player) cs;
						player.getGameMode();
						if (GameMode.CREATIVE != null) {
							player.setGameMode(GameMode.SURVIVAL);
							cs.sendMessage("Your gamemode has changed!");
						}
						player.getGameMode();
						if (GameMode.SURVIVAL != null) {
							player.setGameMode(GameMode.CREATIVE);
							cs.sendMessage("Your gamemode has changed!");
						}
					}
				} else if (args.length == 1) {
					Player player = (Player) cs;
					Player target = player.getServer().getPlayer(args[0]);

					target.getGameMode();
					if (GameMode.CREATIVE != null) {
						target.setGameMode(GameMode.SURVIVAL);
						String tname = target.getDisplayName();
						cs.sendMessage("GameMode Changed to survival for "
								+ tname);
					}
					target.getGameMode();
					if (GameMode.SURVIVAL != null) {
						target.setGameMode(GameMode.CREATIVE);
						String tname = target.getDisplayName();
						cs.sendMessage("GameMode Changed to creative for "
								+ tname);
					}
				}
			}
		}
		return false;

	}
}
