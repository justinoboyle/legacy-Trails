package com.arrayprolc.trails.event.command;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.arrayprolc.trails.event.custom.PlayerCommandEvent;
import com.arrayprolc.trails.menu.TrailsMenu;
import com.arrayprolc.trails.util.UtilTrail;

public class CommandTrail implements Listener {

	@EventHandler
	public void onCommand(PlayerCommandEvent e) {
		if(!(e.getCommandLabel().equalsIgnoreCase("p") || e.getCommandLabel().equalsIgnoreCase("particles"))) {
			return;
		}

		Player p = null;

		if(e.getSender() instanceof Player) {
			p = (Player) e.getSender();
		}else {
			if(e.getArgs().length == 0) {
				e.getSender().sendMessage("Usage: particles player");
				e.setDone(); return;
			}else {
				p = Bukkit.getPlayer(e.getArgs()[0]);
			}
		}
		TrailsMenu.openMenu(p);
		e.setDone(); return;
	}

}
