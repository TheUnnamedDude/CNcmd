package eu.creationation.lukeer31;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

//Runs in a separate thread to prevent any server lag down to 
@SuppressWarnings("unused")
public class MySQLOperations {

	
	//Gona rebuild this entire class, keeping this here because i really cannoy be bothered to have to re-write all this SQL syntax
 
/*	st.execute("CREATE TABLE IF NOT EXISTS " +
			"`cn_players` ( " +
			"`player_id` int(11) NOT NULL AUTO_INCREMENT, " +
				"`player_username` int(11) NOT NULL,  " +
				"`player_playtime` int(11) NOT NULL,  " +
				"PRIMARY KEY (`player_id`)) " +
				"ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;");
		//Bans Table
		st.execute("CREATE TABLE IF NOT EXISTS " +
				"`cn_bans` (" +
				"`ban_id` int(11) NOT NULL AUTO_INCREMENT,  " +
				"`player_id` int(11) NOT NULL,  " +
				"`banner_id` int(11) NOT NULL,  " +
				"`ban_reason` varchar(128) NOT NULL,  " +
				"`ban_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,  " +
				"`ban_expires` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',  " +
				"`ban_expired` tinyint(1) NOT NULL,  " +
				"PRIMARY KEY (`ban_id`)) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;");
		//Homes table
		st.execute("CREATE TABLE IF NOT EXISTS " +
				"`cn_homes` (  " +
				"`home_id` int(11) NOT NULL AUTO_INCREMENT,  " +
				"`home_name` varchar(16) NOT NULL,  " +
				"`player_id` int(11) NOT NULL,  " +
				"`x` int(11) NOT NULL,  " +
				"`y` int(11) NOT NULL,  " +
				"`z` int(11) NOT NULL,  " +
				"PRIMARY KEY (`home_id`)) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;");
		//ip-bans table
		st.execute("CREATE TABLE IF NOT EXISTS `cn_ip_bans` (  " +
				"`ip_ban_id` int(11) NOT NULL AUTO_INCREMENT,  " +
				"`ban_id` int(11) NOT NULL,  " +
				"`ip_banned` varchar(15) NOT NULL,  " +
				"`ip_unbanned` tinyint(1) NOT NULL,  " +
				"PRIMARY KEY (`ip_ban_id`)) " +
				"ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;");
		//Kicks table
		st.execute("CREATE TABLE IF NOT EXISTS `cn_kicks` (  " +
				"`kick_id` int(11) NOT NULL AUTO_INCREMENT,  " +
				"`player_id` int(11) NOT NULL,  " +
				"`kicker_id` int(11) NOT NULL,  " +
				"`kick_reason` varchar(128) NOT NULL,  " +
				"`kick_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,  " +
				"PRIMARY KEY (`kick_id`)) " +
				"ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;");
		//Mutes table
		st.execute("CREATE TABLE IF NOT EXISTS `cn_mutes` (  " +
				"`mute_id` int(11) NOT NULL AUTO_INCREMENT,  " +
				"`player_id` int(11) NOT NULL,  " +
				"`muter_id` int(11) NOT NULL,  " +
				"`mute_reason` varchar(128) NOT NULL,  " +
				"`mute_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,  " +
				"`mute_expires` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',  " +
				"`mute_expired` tinyint(1) NOT NULL,  " +
				"PRIMARY KEY (`mute_id`)) " +
				"ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;");
		//Warps table
		st.execute("CREATE TABLE IF NOT EXISTS `cn_warps` (  " +
				"`warp_id` int(11) NOT NULL,  " +
				"`warp_name` varchar(32) NOT NULL,  " +
				"`player_id` int(11) NOT NULL,  " +
				"`x` int(11) NOT NULL,  " +
				"`y` int(11) NOT NULL,  " +
				"`z` int(11) NOT NULL,  " +
				"PRIMARY KEY (`warp_id`)) " +
				"ENGINE=InnoDB DEFAULT CHARSET=latin1;");
		//Thats it, all the tables are made!!!
*/		

	
}
