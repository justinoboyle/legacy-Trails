package com.arrayprolc.trails.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.arrayprolc.trails.config.ConfigDefaults;
import com.arrayprolc.trails.effects.EffectManager;
import com.arrayprolc.trails.effects.EffectManager.EffectType;
import com.arrayprolc.trails.event.click.InventoryClickListener;
import com.arrayprolc.trails.event.click.JoinListener;
import com.arrayprolc.trails.event.command.CommandTest;
import com.arrayprolc.trails.event.command.CommandTrail;
import com.arrayprolc.trails.event.custom.PlayerCommandEvent;
import com.arrayprolc.trails.extra.ExtraManager;
import com.arrayprolc.trails.util.CircleParticle;
import com.arrayprolc.trails.util.ParticleManager;


@SuppressWarnings("deprecation")
public class TrailsCore extends JavaPlugin {

	private static TrailsCore instance;

	@Override
	public void onEnable(){
		instance = this;
		ConfigDefaults.setupDefaults();
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Updater(this), 1L, 1L);
		
		try {
			System.out.println("[Trails] Setting up listeners");
			setupListeners();
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	private void setupListeners(){
		ParticleManager.registerEvents();
		ExtraManager.registerEvents(this);
		EffectManager.registerEvents(this);
		getServer().getPluginManager().registerEvents(new CommandTest(), this);
		getServer().getPluginManager().registerEvents(new CommandTrail(), this);
		getServer().getPluginManager().registerEvents(new JoinListener(), this);
		getServer().getPluginManager().registerEvents(new CircleParticle(), this);
		getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
	}

	
	private EffectType getFromString(String s){
		for(EffectType e : EffectType.values()) {
			if(e.toString().equalsIgnoreCase(s)){
				return e;
			}
		}
		return null;
	}

	public static TrailsCore getInstance(){
		if(instance == null){
			instance = new TrailsCore();
		}
		return instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		PlayerCommandEvent e = new PlayerCommandEvent(sender, command, label, args);
		getServer().getPluginManager().callEvent(e);
		return e.getDone();
	}

}
