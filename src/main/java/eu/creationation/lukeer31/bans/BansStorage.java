package eu.creationation.lukeer31.bans;

import java.util.Map;

import eu.creationation.lukeer31.CNcmd;
import eu.creationation.lukeer31.mysql.MySQLMethods;

public class BansStorage {

	// The main plugin
	private static CNcmd plugin;

	// Bans
	public static Map<String, String> BannedPlayers;
	public static Map<String, String> MutedPlayers;

	public static void loadBannedPlayers() {
		// Load all the players into a hashmap
		// Run the task async so the queries to not lock up the entire server
		// thread
		plugin.getServer().getScheduler()
				.runTaskAsynchronously(plugin, new Runnable() {
					public void run() {
						BannedPlayers = MySQLMethods.loadBannedPlayers();
					}
				});
	}

	public static void loadMutedPlayers() {
		// Load all the players into a hashmap
		// Run the task async so the queries to not lock up the entire server
		// thread
		plugin.getServer().getScheduler()
				.runTaskAsynchronously(plugin, new Runnable() {
					public void run() {
						MutedPlayers = MySQLMethods.loadMutedPlayers();
					}
				});
	}

}
