package com.arrayprolc.trails.manager;

import java.util.HashMap;

import org.bukkit.entity.Player;

import com.arrayprolc.trails.main.Trail;
import com.arrayprolc.trails.main.TrailsCore;

public class TrailManager {

	public static HashMap<String, Trail> trails = new HashMap<String, Trail>();
	
	public String getActiveTrailName(Player p){
		try{
			String s = TrailsCore.getInstance().getConfig().getString(p.getUniqueId() + ".Trail");
			if(s.equals("") || s == null || s.equals(null)){
				return "";
			}
			return s;
		}catch(Exception ex){
			return "";
		}
	}
	
	public Trail getActiveTrail(Player p){
		return trails.get("Test");
	}
	
	public boolean hasActiveTrail(Player p){
		return true;
	}
	
}
