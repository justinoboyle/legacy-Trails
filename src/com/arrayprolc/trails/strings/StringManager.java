package com.arrayprolc.trails.strings;

import org.apache.commons.lang.WordUtils;

public class StringManager {

	public static String getMessage(String s, MessageType m){
		return getFormatAndColor(m) + ":§7 " + s;
	}
	
	public static String capitalize(String s){
		return WordUtils.capitalize(s.toLowerCase().replace("_", " "));
	}
	
	public static String getPrefix(MessageType m){
		return getFormatAndColor(m) + ":§7 ";
	}
	
	public static String getFormatAndColor(MessageType m){
		switch(m) {
		case CONDITION: return "§9§lCondition".toUpperCase();
		case DEATH: return "§c§lDeath".toUpperCase();
		case ERROR: return "§4§lError".toUpperCase();
		case INFO: return "§e§lInfo".toUpperCase();
		case KICK: return "§c§lKick".toUpperCase();
		case PURCHASE: return "§2§lPurchase".toUpperCase();
		case STATS: return "§b§lStats".toUpperCase();
		case SUCCESS: return "§a§lSuccess".toUpperCase();
		case TRANSACTION: return "§a§lTransaction".toUpperCase();
		case GADGETS: return "§e§lGadgets".toUpperCase();
		case PARTICLES: return "§a§lParticles".toUpperCase();
		case TREASURE: return "§b§lTreasure".toUpperCase();
		default: return "§e§lInfo".toUpperCase();
		
		}
	}
	
}
