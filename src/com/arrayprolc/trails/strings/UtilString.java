package com.arrayprolc.trails.strings;

public class UtilString {

	static String chatPattern = "[a-zA-Z,a-zA-Z\\\\d\\\\p{Blank}?!.,:()+-/*{}\\[\\]'\";<>\\d]";
	
	public static String enumToString(String input){
		return WordUtils.capitalize(input.toLowerCase().replace("_", " "));
	}
	
}
