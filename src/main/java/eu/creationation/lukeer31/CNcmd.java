package eu.creationation.lukeer31;

import org.bukkit.plugin.java.JavaPlugin;

import eu.creationation.lukeer31.mysql.MySQLMethods;

public class CNcmd extends JavaPlugin {

	public static CNcmd plugin;

	public CNcmd() {
		plugin = this;
	}

	public void onDisable() {
		// Log the message
		getLogger().log(null, "Disabling CNCmd");
		// Database
		getServer().getScheduler().runTaskAsynchronously(plugin,
				new Runnable() {
					public void run() {
						MySQLMethods.closeDatabase();
					}
				});

		getLogger().log(null, "Database Connection Closed");
	}

	public void onEnable() {
		// Load up the configuration
		Config.loadConfig(this);
		// Generate the database tables if they don't exist
		getServer().getScheduler().runTaskAsynchronously(plugin,
				new Runnable() {
					public void run() {
						// MySQLMethods.generateTables();
						// Other database stuff

					}

				});

	}
}
