package eu.creationation.lukeer31.bans;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BanCommands implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {

		// Kick command
		if (command.getName().equalsIgnoreCase("kick")) {
			// The first argument is always the players in any command
			String players = args[1];
			// If the second argument is to add time, then the 3 argument is the
			// time specified
			if (args[2].equals("-t")) {
				String time = args[3];
				String reason = args[4];
			}
			String time = args[2];
			String reason = args[3];

		}

		return false;
	}

}
