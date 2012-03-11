package com.CMDbox;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

import com.CMDbox.Commands.Resources.GodMap;

public class Damage {
	public void PlayerDamage(EntityDamageEvent event){
		Entity ent = event.getEntity();
		
		if(ent instanceof Player){
		    Player player = (Player)ent;
		    if (GodMap.GodM.containsKey(player)){
		    	event.setCancelled(true);
		    }
		}
	}
}
