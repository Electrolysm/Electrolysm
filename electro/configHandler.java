package assets.electrolysm.electro;

import java.io.File;

import net.minecraftforge.common.Configuration;
import assets.electrolysm.electro.handlers.BetaHandler;

public class configHandler {
	
	public static String modID;
	public static int modIDInt;
	public static boolean idSet;
	
	public static void init(File file){
    	Configuration config = new Configuration(file);   

        config.load();
        
		modID = (config.get("debuging", "Mod_ID", "Gamer").toString());
		modIDInt = (config.get("debuging", "modID as int", BetaHandler.setID(), "hey").getInt());
		idSet = (config.get("debuging", "IDSet", false).getBoolean(false));
        
        config.save();
	}
}
