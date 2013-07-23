package eu.creationation.lukeer31;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MySQLMethods  {
	
	public static void generateTables(){
		//Generate the MySQL Tables that are needed
		java.sql.Statement st = Config.st;		
		try{		
			st.execute("CREATE TABLE IF NOT EXISTS " +
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
		}catch(SQLException ex){
			//Uh oh, somethings gone wrong
			ex.printStackTrace();			
		}		
		
	}
	
	public static void closeDatabase(){
    	//Close the database connection
        try {
        	//Close the result set
        	if(Config.rs != null){
        		Config.rs.close();
        	}
        	//Close the statement
        	if(Config.st != null){
        		Config.st.close();
        	}
        	//Close the db connection
        	if(Config.db != null){
        		Config.db.close();
        	}
		} catch (SQLException ex) {			
			ex.printStackTrace();
		}	
		
	}
	
	//RE-DO THIS SO A COMPLETE LIST OF PLAYERS IS ADDED TO A HASHMAP SO THEN ALL THAT HAS TO BE DONE TO GET
	//A USERNAME IS LOOK AT THE HASHMAP
	public static Map<String, String> loadBannedPlayers(){
		//Load all the banned players from the database and insert into a hashmap
		//Get the DB
		java.sql.Statement st = Config.st;			
		//Create the hashmap
		Map<String, String> BannedPlayers = new HashMap<String, String>();
		//Execute the database query
		try{
			//Run the query
			ResultSet result = st.executeQuery("SELECT * FROM `cn_bans` WHERE `ban_expired`=`0`");
			//Loop through the resultset and add to the hasmap
			while(result.next()){
				//Assign to variables
				String user_id = result.getString(1);
				String ban_reason = result.getString(4);
				//Get the players username
				ResultSet usersearch = st.executeQuery("`SELECT `player_username` FROM `cn_players` where `player_id`=`" + user_id + "`");
				//Declare the username string
				String username = null;
				while(usersearch.next()){
					username = usersearch.getString(1);					
				}
				//Thats it, add the info to the hashmap
				BannedPlayers.put(username, ban_reason);
			}			
		}catch(SQLException ex){
			//Print the stacktrace error
			ex.printStackTrace();
			return null;
		}
		//Return the banned players map		
		return BannedPlayers;		
	}

}
