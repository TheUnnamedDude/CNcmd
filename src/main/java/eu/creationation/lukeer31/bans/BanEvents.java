package eu.creationation.lukeer31.bans;

import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import eu.creationation.lukeer31.Config;

public class BanEvents implements Listener {

	// When the player joins. Higest priority so nothing else interferes
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerLogin(PlayerLoginEvent event) {
		// Get the player who is logging in
		Player player = event.getPlayer();
		String username = player.getName();
		// Get the map full of banned players
		Map<String, String> BannedPlayers = BansStorage.BannedPlayers;
		// If they are in the map, then uh oh they are banned
		if (BannedPlayers.containsKey(username)) {
			String reason = BannedPlayers.get(username);
			String message = Config.BanDisconnectMessage.replace("%REASON%",
					reason);
			player.kickPlayer(Config.MessagePrefix + message);
		}
	}

	// If the player chats and is muted
	public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String username = player.getName();
		Map<String, String> MutedPlayers = BansStorage.MutedPlayers;
		if (MutedPlayers.containsKey(username)) {
			String reason = MutedPlayers.get(username);
			String message = Config.MuteOnTalkMessage.replace("%REASON%",
					reason);
			// Tell the player why they are muted
			player.sendMessage(Config.MessagePrefix + message);
			// Cancel their chat
			event.setCancelled(true);
		}
	}

}
