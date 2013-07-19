package eu.creationation.lukeer31;

import org.bukkit.plugin.java.JavaPlugin;

public class CNcmd extends JavaPlugin {
	
	public static CNcmd plugin;
	
	public CNcmd(){
		plugin = this;		
	}
	
    public void onDisable() {
    	
        
    }

    public void onEnable() {
    	//Load up the configuration
    	Config.load(this);
    	//Generate the database tables if they don't exist
    	getServer().getScheduler().runTaskAsynchronously(plugin, new Runnable(){
			public void run() {
				//Generate the database tables
				MySQLMethods.generateTables();
				//Other stuff
				
			}
    		
    	});

    	       
    }
}

