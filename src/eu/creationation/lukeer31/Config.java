package eu.creationation.lukeer31;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
	
	//The main plugin
	private static CNcmd plugin;
	private static FileConfiguration cfg = null;
	//All the config items
	public static String host;
	public static String pass;
	public static String user;
	
	public static String messagePrefix;
	//public static String 
	
	public static void load(CNcmd master){
		plugin = master;
		//Reload the config first, just incase the server was reloaded
		plugin.reloadConfig();
		//Get the config
		cfg = plugin.getConfig();
		//Get all of the configuration items and assign them to properties
		host = cfg.getString("Database.Host");
		pass = cfg.getString("Database.Pass");
		user = cfg.getString("Database.User");
		
		messagePrefix = cfg.getString("Messages.MessagePrefix");
		//More too add as i need them
		
		//Config loaded. Job done
	}

}
