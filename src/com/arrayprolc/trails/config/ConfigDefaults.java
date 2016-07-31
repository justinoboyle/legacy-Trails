package com.arrayprolc.trails.config;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;

import com.arrayprolc.trails.effects.EffectManager.EffectType;
import com.arrayprolc.trails.main.TrailsCore;

public class ConfigDefaults {

    public static void setupDefaults() {
        
        setupLocalization();
        
        int i = 0;
        for (EffectType e : EffectType.values()) {
            setup("trail." + i + ".name", e.toString().replace("_", " "));
            setup("trail." + i + ".permission", "trails.trail." + i);
            setup("trail." + i + ".lore", "&7A fancy trail! :D");
            if(e == EffectType.Footstep) {
                setup("trail." + i + ".guislot", 38 + "");
                setup("trail." + i + ".enablesound", Sound.CHICKEN_EGG_POP + "");
                setup("trail." + i + ".nopermitem.type", Material.STONE.toString());
                setup("trail." + i + ".nopermitem.data", ((byte) 6) + "");
                setup("trail." + i + ".disableditem.type", Material.STONE.toString());
                setup("trail." + i + ".disableditem.data", ((byte) 6) + "");
                setup("trail." + i + ".enableditem.type", Material.STONE.toString());
                setup("trail." + i + ".enableditem.data", ((byte) 2) + "");
            } else {
                setup("trail." + i + ".guislot", i + "");
                setup("trail." + i + ".enablesound", Sound.CHICKEN_EGG_POP + "");
                setup("trail." + i + ".nopermitem.type", Material.INK_SACK.toString());
                setup("trail." + i + ".nopermitem.data", ((byte) 8) + "");
                setup("trail." + i + ".disableditem.type", Material.INK_SACK.toString());
                setup("trail." + i + ".disableditem.data", ((byte) 10) + "");
                setup("trail." + i + ".enableditem.type", Material.INK_SACK.toString());
                setup("trail." + i + ".enableditem.data", ((byte) 5) + "");
            }

            i++;
        }
        
        
    }
    
    private static void setupLocalization() {
        setup("locale.prefix.ERROR",       "§4§lError > §7");
        setup("locale.prefix.INFO",        "§e§lInfo > §7");
        setup("locale.prefix.PURCHASE",    "§2§lPurchase > §7");
        setup("locale.prefix.SUCCESS",     "§a§lSuccess > §7");
        setup("locale.prefix.PARTICLES",   "§a§lParticles > §7");
        
        setup("locale.err.noperm",    "%prefix.error%You don't have permission to use %name%!");
        setup("locale.err.usage",    "%prefix.ERROR%Usage: %usage%");
        setup("locale.success.active",    "%prefix.SUCCESS%You have activated %particle%!");
        
    }

    private static void setup(String key, String value) {
        FileConfiguration c = TrailsCore.getInstance().getConfig();
        if (c.get(key) == null) {
            c.set(key, value);
        }
        TrailsCore.getInstance().saveConfig();
    }

}
