package com.arrayprolc.trails.main;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.arrayprolc.trails.manager.TrailManager;
import com.arrayprolc.trails.task.TaskScheduler;
import com.arrayprolc.trails.util.UtilPermission;

public abstract class Trail {

	String name = "";
	ItemStack icon = new ItemStack(Material.STONE);
	String[] description = { "A fancy trail." };
	int tickInterval = 5;

	@Deprecated
	public Trail(String name){
		this.name = name;
		TrailManager.trails.put(name, this);
		System.out.println("[Trails] Loaded trail " + name);
	}
	
	@Deprecated
	public abstract void activate(Location loc);
	
	@Deprecated
	public void setIcon(ItemStack i){
		icon = i;
	}
	
	@Deprecated
	public ItemStack getIcon(){
		return new ItemStack(Material.STONE);
	}
	
	@Deprecated
	public boolean hasPermission(Player p){
		return UtilPermission.hasPermission(p, "use." + name.toLowerCase());
	}
	
	@Deprecated
	public void setName(String s){
		name = s;
	}
	
	@Deprecated
	public String getName(){
		return name;
	}
	
	@Deprecated
	public void setTickInterval(int i){
		tickInterval = i;
		if(tickInterval > TaskScheduler.maxTickTime){
			TaskScheduler.maxTickTime = tickInterval;
		}
	}
	
	@Deprecated
	public int getTickInterval(){
		return tickInterval;
	}
	
	@Deprecated
	public void setDescription(String[] s){
		description = s;
	}
	
	@Deprecated
	public String[] getDescription(){
		String[] n = new String[description.length];
		int counter = 0;
		for(String s : description){
			s = "§7§o" + s;
			n[counter] = s;
			counter++;
		}
		return n;
	}
}
