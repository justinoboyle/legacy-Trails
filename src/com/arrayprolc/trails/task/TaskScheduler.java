package com.arrayprolc.trails.task;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.arrayprolc.trails.main.TrailsCore;

public class TaskScheduler {

	public static int maxTickTime = 0;
	private static int ticks = 0;
	
	public static void scheduleTask(){
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(TrailsCore.getInstance(), new Runnable(){
			public void run(){
				for(Player p : Bukkit.getOnlinePlayers()){
					
				}
			}
		}, 0, 1);
	}
	
}
