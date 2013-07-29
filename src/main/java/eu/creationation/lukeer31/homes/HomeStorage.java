package eu.creationation.lukeer31.homes;

import java.util.Map;

import org.bukkit.Location;

import eu.creationation.lukeer31.CNcmd;

public class HomeStorage {
	
	
	//The main plugin
	private static CNcmd plugin;	
	
	//Homes
	// Player_ID -> Map<HomeName, Location of home>
	public static Map<Integer, Map<String, Location>> Homes;
	
	
	public static void loadHomes(){
		//Load all the homes for each player into a hashmap... inside a hashmap. Hashmapception
		
	}	

}
