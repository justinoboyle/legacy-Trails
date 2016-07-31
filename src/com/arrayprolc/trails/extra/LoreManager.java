package com.arrayprolc.trails.extra;

import com.arrayprolc.trails.effects.EffectManager.EffectType;
import com.arrayprolc.trails.strings.MessageType;
import com.arrayprolc.trails.strings.StringManager;

public class LoreManager {

	private static EffectType vip[] = { EffectType.FlameRing, EffectType.GreenSpiral };
	
	private static EffectType vipplus[] = { EffectType.Cloud, EffectType.CloudSnow, EffectType.CloudStorm };
	
	private static EffectType mvp[] = { EffectType.Disco, EffectType.Tornado, EffectType.Vortex };
	
	private static EffectType mvpplus[] = { EffectType.FlameLilly, EffectType.HourGlass, EffectType.Shield };
	
	private static EffectType Elite[] = { EffectType.Fountain, EffectType.GreenRing, EffectType.EnderWave };
	
	public static String getRank(EffectType e){
		for(EffectType e2 : vip){
			if(e2 == e){
				return "§e§lVIP";
			}
		}
		for(EffectType e2 : vipplus){
			if(e2 == e){
				return "§e§lVIP§a+";
			}
		}
		for(EffectType e2 : mvp){
			if(e2 == e){
				return "§b§lMVP";
			}
		}
		for(EffectType e2 : mvpplus){
			if(e2 == e){
				return "§b§lMVP§a+";
			}
		}
		for(EffectType e2 : Elite){
			if(e2 == e){
				return "§6§lElite";
			}
		}
		return "§8Guest";
	}
	
	public static String getYouMustHave(EffectType e){
		return StringManager.getMessage("You need " + getRank(e) + "§7 to use that particle.", MessageType.ERROR);
	}
	
	public static String getExclusive(EffectType e){
		return getRank(e) + " §7exclusive";
	}
	
	
}
