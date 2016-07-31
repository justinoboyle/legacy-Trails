package com.arrayprolc.trails.event.click;

import org.bukkit.event.Listener;

import com.arrayprolc.trails.effects.EffectManager.EffectType;

public class JoinListener implements Listener {

	/*@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		try {
			com.prismservices.dev.gtdb.mongodb.entities.User user = DatabaseAPI
					.getUserByUUID(p.getUniqueId());
			if (!EffectManager.hasEffect(p)) {
				user.activeParticle = "nothing";
				UserDAO.getInstance().save(user);
				return;
			}
			try {
				String active = EffectManager.getEffect(p).toString();
				try {
					user.activeParticle = active;
				} catch (Exception ex) {
					// It's null, that's ok.
				}
				UserDAO.getInstance().save(user);
			} catch (Exception ex) {

			}
		} catch (Exception ex) {
			// It's null, that's ok.
		}

	}*/

	public EffectType getFromString(String s) {
		for (EffectType e : EffectType.values()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}

}
