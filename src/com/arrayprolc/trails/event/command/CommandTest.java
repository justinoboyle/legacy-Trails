package com.arrayprolc.trails.event.command;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.arrayprolc.trails.event.custom.PlayerCommandEvent;

public class CommandTest implements Listener {

	@EventHandler
	public void onCommand(PlayerCommandEvent e) {
		if(!e.getCommandLabel().equalsIgnoreCase("test")) {
			return;
		}
		
		Player p = (Player)(e.getSender());
		
	}

}
