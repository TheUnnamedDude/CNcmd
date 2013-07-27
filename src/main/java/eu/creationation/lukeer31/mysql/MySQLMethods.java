package eu.creationation.lukeer31.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;

import eu.creationation.lukeer31.Config;

public class MySQLMethods  {	
	
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
	
	//Gets all of the stored players in the database
	public static Map<Integer, String> getStoredPlayers(){
		//Get the statement
		java.sql.Statement st = Config.st;
		//Create the hashmap
		Map<Integer, String> StoredPlayers = new HashMap<Integer, String>();
		//Execute the query and get the results
		try{
			ResultSet rs = st.executeQuery("SELECT * FROM `cn_players`");
			//Go through the results
			while(rs.next()){
				//File the players into the hashmap
				StoredPlayers.put(rs.getInt("player_id"), rs.getString("player_username"));
			}		
		}catch(SQLException ex){
			ex.printStackTrace();
			return null;
		}
		//Return the hashmap
		return StoredPlayers;		
	}	
	
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
				//Push into the hashmap
				BannedPlayers.put(Config.getPlayerUsername(result.getInt(1)), result.getString(4));
			}			
		}catch(SQLException ex){
			//Print the stacktrace error
			ex.printStackTrace();
			return null;
		}
		//Return the banned players map		
		return BannedPlayers;		
	}
	
	//Load all the muted players from the database
	public static Map<String, String> loadMutedPlayers(){
		//Load all the banned players from the database and insert into a hashmap
		//Get the DB
		java.sql.Statement st = Config.st;			
		//Create the hashmap
		Map<String, String> MutedPlayers = new HashMap<String, String>();
		//Execute the database query
		try{
			//Run the query
			ResultSet result = st.executeQuery("SELECT * FROM `cn_mutes` WHERE `mute_expired`=`0`");
			//Loop through the resultset and add to the hasmap
			while(result.next()){
				//Push into the hashmap
				MutedPlayers.put(Config.getPlayerUsername(result.getInt(1)), result.getString(4));
			}			
		}catch(SQLException ex){
			//Print the stacktrace error
			ex.printStackTrace();
			return null;
		}
		//Return the banned players map		
		return MutedPlayers;			
	}
	//Local all of the player homes
	public static Map<Integer, Map<String, Location>> loadPlayerHomes(){
		java.sql.Statement st = Config.st;
		Map<Integer, Map<String, Location>> PlayerHomes = new HashMap<Integer, Map<String, Location>>();

		//Think up some way to do this efficiently
		
		
		
		return PlayerHomes;
	}
}
