package eu.creationation.lukeer31;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class GlobalMethods {

	// The main plugin
	private static CNcmd plugin = CNcmd.plugin;

	// Function to save me time getting the username from the ID
	public static String getPlayerUsername(Integer player_id) {
		String username = Config.StoredPlayers.get(player_id);
		return username;
	}

	public static String replaceColorCodes(String in) {
		// Replace color codes inside the config
		in.replace("&0", "$0");
		in.replace("&1", "$1");
		in.replace("&2", "$2");
		in.replace("&3", "$3");
		in.replace("&4", "$4");
		in.replace("&5", "$5");
		in.replace("&6", "$6");
		in.replace("&7", "$7");
		in.replace("&8", "$8");
		in.replace("&9", "$9");
		in.replace("&a", "$a");
		in.replace("&b", "$b");
		in.replace("&c", "$c");
		in.replace("&d", "$d");
		in.replace("&e", "$e");
		in.replace("&f", "$f");
		in.replace("&k", "$k");
		in.replace("&l", "$l");
		in.replace("&m", "$m");
		in.replace("&n", "$n");
		in.replace("&o", "$o");
		in.replace("&r", "$r");
		return in;
	}

	// The command system will allow for multple players to be used in any
	// command (That it is possible) by splitting the names with a ,
	// Thus every command will send the playerlist to here to be processed, and
	// this will return a list of the online players#
	public static ArrayList<Player> getPlayerCSV(String players,
			boolean onlineonly) {
		// Split the CSV
		String[] playerlist = players.split(",");
		ArrayList<Player> playerlistout = new ArrayList<Player>();
		if (playerlist.length == 0) {
			// There is only one player specified. Just get that one and return
			// it
			// If the command requires online only players
			if (onlineonly == true) {
				Player player = plugin.getServer().getPlayer(players);
				if (player == null) {
					return null;
				} else {
					playerlistout.add(player);
					return playerlistout;
				}
			} else {
				// Ofline players are allowed
				Player player = plugin.getServer().getPlayer(players);
				if (player == null) {
					// If the player is not online, then get the offline player
					player = (Player) plugin.getServer().getOfflinePlayer(
							players);
				}
				playerlistout.add(player);
				return playerlistout;
			}
		}
		// If there is more than one player listed
		// Iterate over the playerlist array
		for (int i = 0; i < playerlist.length; i++) {
			// Get the username
			// If offline players are not allowed
			if (onlineonly == true) {
				String username = playerlist[i];
				// Now get the player
				if (!username.equals("")
						& plugin.getServer().getPlayer(username) != null) {
					// If the username is exact, add it to the arraylist
					playerlistout.add(plugin.getServer().getPlayer(username));
				}
			} else {
				// Offline players are allowed
				String username = playerlist[i];
				if (!username.equals("")
						& plugin.getServer().getPlayer(username) != null) {
					// If the username is exact, add it to the arraylist
					playerlistout.add(plugin.getServer().getPlayer(username));
				} else if (!username.equals("")) {
					// The player is offline, get em and add them to the
					// arraylist
					playerlistout.add((Player) plugin.getServer()
							.getOfflinePlayer(username));
				}
			}
		}
		// Return the arraylist to the command executor
		return playerlistout;
	}

	// Method to get a player from a username, so i can easily edit this when
	// mojang breaks
	// everything when username changes are allowed
	public static Player processPlayer(String username, boolean onlineonly) {
		Player player = plugin.getServer().getPlayer(username);
		if (onlineonly == true) {
			if (player == null) {
				return null;
			}
			return player;
		}
		if (player == null) {
			player = (Player) plugin.getServer().getOfflinePlayer(username);
		}
		return player;
	}

}
