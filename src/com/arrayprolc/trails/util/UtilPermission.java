package com.arrayprolc.trails.util;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.arrayprolc.trails.effects.EffectManager.EffectType;

public class UtilPermission {
	
	private static String prefix = "trails.";
	public static String trail = "trail.";
	
	public static boolean hasPermission(CommandSender sender, String permission){
		if(!(sender instanceof Player)){
			return true;
		}
		return hasPermission((Player)sender, permission);
		
	}
	
	public static boolean hasPermission(Player p, String permission){
		if(p.isOp()) return true;
		if(p.hasPermission("trails.*")) return true;
		return p.hasPermission(prefix + permission.toLowerCase());
	}
	
	public static boolean hasPermission(Player p, EffectType t){
		
		return hasPermission(p, trail + t.toString().toLowerCase());
	}

}
