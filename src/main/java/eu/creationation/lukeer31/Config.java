package eu.creationation.lukeer31;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import eu.creationation.lukeer31.mysql.MySQLMethods;

@SuppressWarnings("unused")
public class Config {
	
	//The main plugin
	private static CNcmd plugin;
	private static FileConfiguration cfg = null;
	
	//All the config items
		//Database
		public static String Host;
		public static String Pass;
		public static String User;
		
		//General Messages	
		public static String MessagePrefix;
		public static String PlayerNotOnline;
	
		//Bans Stuff
		public static String BanMessage;		
		public static String BanDisconnectMessage;
		
		public static String TempBanMessage;
		public static String TempBanMessageDisconnect;
		
		public static String MuteMessage;
		public static String MuteOnTalkMessage;
		
		public static String TempMuteMessage;
		public static String TempMuteOnTalkMessage;
		
		
	
	
	//Database
	public static Connection db;
	public static java.sql.Statement st;
	public static ResultSet rs;
	
	//Stored Player info
	public static Map<Integer, String> StoredPlayers;
	
	
	public static void loadConfig(CNcmd master){
		plugin = master;
		//Reload the config first, just incase the server was reloaded
		plugin.reloadConfig();
		//Get the config
		cfg = plugin.getConfig();
		//Get all of the configuration items and assign them to properties
		Host = cfg.getString("Database.Host");
		Pass = cfg.getString("Database.Pass");
		User = cfg.getString("Database.User");
		
		//Get all the messages we need from the config		
		MessagePrefix = Config.replaceColorCodes(cfg.getString("Messages.MessagePrefix"));
		
		
		
		
		
		
		//Connect to the database
		try{
			//Assign it to the public properties so the MySQL classes can get them
			db = DriverManager.getConnection(Host, User, Pass);
			st = db.createStatement();			
		}catch(SQLException ex){
			//Database connection failed :(
			plugin.getLogger().log(null, "Database connection failed. Disabling plugin");
			//Close the database connection
			MySQLMethods.closeDatabase();
			//Disable the plugin to prevent problemos
			plugin.getServer().getPluginManager().disablePlugin(master);						
		}		
		//Config loaded. Job done
	}	

	
	//Function to save me time getting the username from the ID
	public static String getPlayerUsername(Integer player_id){
		String username = StoredPlayers.get(player_id);		
		return username;		
	}
	public static String replaceColorCodes(String in){
		//Replace color codes inside the config
		in.replace("&0", "§0");
		in.replace("&1", "§1");
		in.replace("&2", "§2");
		in.replace("&3", "§3");
		in.replace("&4", "§4");
		in.replace("&5", "§5");
		in.replace("&6", "§6");
		in.replace("&7", "§7");
		in.replace("&8", "§8");
		in.replace("&9", "§9");
		in.replace("&a", "§a");
		in.replace("&b", "§b");
		in.replace("&c", "§c");
		in.replace("&d", "§d");
		in.replace("&e", "§e");
		in.replace("&f", "§f");
		in.replace("&k", "§k");
		in.replace("&l", "§l");
		in.replace("&m", "§m");
		in.replace("&n", "§n");
		in.replace("&o", "§o");
		in.replace("&r", "§r");
		return in;
	}
	
	//The command system will allow for multple players to be used in any command (That it is possible) by splitting the names with a ,
	//Thus every command will send the playerlist to here to be processed, and this will return a list of the online players
	public static Player[] getPlayerCSV(String players){
		//Split the CSV
		String[] playerlist = players.split(",");
		int length = playerlist.length;
		Player[] playerlistout = null;
		
		
		
		
		return null;
	}

}
