package eu.creationation.lukeer31;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.configuration.file.FileConfiguration;

@SuppressWarnings("unused")
public class Config {
	
	//The main plugin
	private static CNcmd plugin;
	private static FileConfiguration cfg = null;
	//All the config items
	public static String host;
	public static String pass;
	public static String user;
	
	public static String messagePrefix;
	
	//Database
	public static Connection db;
	public static java.sql.Statement st;
	public static ResultSet rs;
		
	
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
		
		//Connect to the database
		try{
			//Assign it to the public properties so the MySQL classes can get them
			db = DriverManager.getConnection(host, user, pass);
			st = db.createStatement();			
		}catch(SQLException ex){
			//Database connection failed :(
			plugin.getLogger().log(null, "Database connection failed. Disabling plugin");
			//Disable the plugin to prevent problemos
			plugin.getServer().getPluginManager().disablePlugin(master);						
		}		
		//Config loaded. Job done
	}

}
