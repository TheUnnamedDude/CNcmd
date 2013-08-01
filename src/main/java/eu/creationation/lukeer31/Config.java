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

	// The main plugin
	private static CNcmd plugin = CNcmd.plugin;
	private static FileConfiguration cfg = null;

	// All the config items
	// Database
	public static String Host;
	public static String Pass;
	public static String User;

	// General Messages
	public static String MessagePrefix;
	public static String PlayerNotOnline;

	// Bans Stuff
	public static String BanMessage;
	public static String BanDisconnectMessage;

	public static String TempBanMessage;
	public static String TempBanMessageDisconnect;

	public static String MuteMessage;
	public static String MuteOnTalkMessage;

	public static String TempMuteMessage;
	public static String TempMuteOnTalkMessage;

	// Database
	public static Connection db;
	public static java.sql.Statement st;
	public static ResultSet rs;

	// Stored Player info
	public static Map<Integer, String> StoredPlayers;

	public static void loadConfig(CNcmd master) {
		// Reload the config first, just incase the server was reloaded
		plugin.reloadConfig();
		// Get the config
		cfg = plugin.getConfig();
		// Get all of the configuration items and assign them to properties
		Host = cfg.getString("Database.Host");
		Pass = cfg.getString("Database.Pass");
		User = cfg.getString("Database.User");

		// Get all the messages we need from the config
		MessagePrefix = GlobalMethods.replaceColorCodes(cfg
				.getString("Messages.MessagePrefix"));

		// Connect to the database
		try {
			// Assign it to the public properties so the MySQL classes can get
			// them
			db = DriverManager.getConnection(Host, User, Pass);
			st = db.createStatement();
		} catch (SQLException ex) {
			// Database connection failed :(
			plugin.getLogger().log(null,
					"Database connection failed. Disabling plugin");
			// Close the database connection
			MySQLMethods.closeDatabase();
			// Disable the plugin to prevent problemos
			plugin.getServer().getPluginManager().disablePlugin(master);
		}
		// Config loaded. Job done
	}

}
