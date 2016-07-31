package com.arrayprolc.trails.event.click;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.arrayprolc.trails.effects.EffectManager;
import com.arrayprolc.trails.effects.EffectManager.EffectType;
import com.arrayprolc.trails.extra.LoreManager;
import com.arrayprolc.trails.menu.TrailsMenu;
import com.arrayprolc.trails.util.UtilPermission;

public class InventoryClickListener implements Listener {

	@SuppressWarnings("unchecked")
	public HashMap<String, Integer> footstep = new HashMap();

	@EventHandler
	public void click(InventoryClickEvent e) {
		try {
			if (!e.getInventory().getTitle().contains("Particles")) {
				return;
			}
			if (e.getInventory().getTitle().contains("Particles")) {
				e.setCancelled(true);
				ItemStack i = e.getCurrentItem();
				if (!i.hasItemMeta())
					return;
				if (!i.getItemMeta().hasDisplayName())
					return;
				String s = i.getItemMeta().getDisplayName();
				if (ChatColor.stripColor(s).contains("Footstep")) {
					if (EffectManager.getEffect((Player) e.getWhoClicked()) == EffectType.Footstep) {
						EffectManager.removeEffect((Player) e.getWhoClicked(),
								false);
						Inventory ii = TrailsMenu.openMenu(
								(Player) e.getWhoClicked(), false);
						int i2 = 0;
						for (ItemStack it : ii.getContents()) {
							if (it != null) {
								e.getWhoClicked().getOpenInventory()
								.setItem(i2, it);
							}
							i2++;
						}
					} else {
						EffectManager.addEffect((Player) e.getWhoClicked(),
								EffectType.Footstep);
						// //updateDB((Player) e.getWhoClicked());
						// e.getWhoClicked().closeInventory();
						Inventory ii = TrailsMenu.openMenu(
								(Player) e.getWhoClicked(), false);
						int i2 = 0;
						for (ItemStack it : ii.getContents()) {
							if (it != null) {
								e.getWhoClicked().getOpenInventory()
								.setItem(i2, it);
							}
							i2++;
						}
					}
					//updateDB((Player) e.getWhoClicked());
					return;
				}
				if (ChatColor.stripColor(s).contains("Disable")) {
					EffectManager.removeEffect((Player) e.getWhoClicked(),
							false);
					Inventory ii = TrailsMenu.openMenu(
							(Player) e.getWhoClicked(), false);
					int i2 = 0;
					for (ItemStack it : ii.getContents()) {
						if (it != null) {
							e.getWhoClicked().getOpenInventory()
							.setItem(i2, it);
						}
						i2++;
					}
					//updateDB((Player) e.getWhoClicked());
					return;
				}
				if (s.contains(" §7Trail")) {
					s = s.split(" §7Trail")[0];
					s = ChatColor.stripColor(s);
					if (UtilPermission.hasPermission(
							(Player) e.getWhoClicked(), getFromString(s))) {
						EffectManager.addEffect((Player) e.getWhoClicked(),
								getFromString(s));
					} else {
						((Player) e.getWhoClicked()).sendMessage(LoreManager
								.getYouMustHave(getFromString(s)));
					}
				}
				Inventory ii = TrailsMenu.openMenu((Player) e.getWhoClicked(),
						false);
				int i2 = 0;
				for (ItemStack it : ii.getContents()) {
					if (it != null) {
						e.getWhoClicked().getOpenInventory().setItem(i2, it);
					}
					i2++;
				}

			}

			Inventory ii = TrailsMenu.openMenu((Player) e.getWhoClicked(),
					false);
			int i2 = 0;
			for (ItemStack it : ii.getContents()) {
				if (it != null) {
					e.getWhoClicked().getOpenInventory().setItem(i2, it);
				}
				i2++;
			}
		} catch (Exception ex) {

		}
		//updateDB((Player) e.getWhoClicked());
	}

	public EffectType getFromString(String s) {
		for (EffectType e : EffectType.values()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}


}
