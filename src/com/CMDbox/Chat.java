package com.CMDbox;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import com.CMDbox.Commands.Resources.MuteMap;

public class Chat implements Listener {
	@EventHandler
	public void muteplayer(PlayerChatEvent event) {
		Player target = event.getPlayer();
		if (MuteMap.mu.containsKey(target)) {
			if (MuteMap.mu.containsValue("mute")) {
				event.setCancelled(true);
				target.sendMessage("You are muted!");
			}
		}
	}
}
