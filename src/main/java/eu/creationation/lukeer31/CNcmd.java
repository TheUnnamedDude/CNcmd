package eu.creationation.lukeer31;

import org.bukkit.plugin.java.JavaPlugin;

import eu.creationation.lukeer31.mysql.MySQLMethods;

public class CNcmd extends JavaPlugin {

	public static CNcmd plugin;

    String[] train = {
            "                      (+++++++++++)",
            "                  (++++)",
            "               (+++)",
            "             (+++)",
            "            (++)",
            "            [~]",
            "            | | (~)  (~)  (~)    /~~~~~~~~~~~~",
            "         /~~~~~~~~~~~~~~~~~~~~~~~  [~_~_] |",
            "       [|  %___________________           |",
            "         \\[___] ___   ___   ___\\  No. 4   |",
            "      /// [___+/-+-\\-/-+-\\-/-+ \\\\_________|=",
            "    //// @-=-@ \\___/ \\___/ \\___/  @-==-@    ",
            " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~",
    };

	public CNcmd() {
		plugin = this;
	}

	public void onDisable() {
        // Print train

        for (String str : train) {
            getLogger().info(str);
        }

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
