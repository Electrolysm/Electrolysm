package assets.electrolysm.electro;

import java.io.File;

import net.minecraftforge.common.Configuration;
import assets.electrolysm.electro.handlers.BetaHandler;

public class configHandler {
	
	public static String modID;
	public static int modIDInt;
	public static boolean idSet;
	public static boolean idSetD;
	
	public static void init(File file){
    	Configuration config = new Configuration(file);   

        config.load();
        
		modID = (config.get("debuging", "Mod_ID", "Gamer").toString());
		modIDInt = (config.get("debuging", "modID as int", BetaHandler.setID(), "ModID").getInt());
		idSet = (config.get("debuging", "IDSet", idSetD).getBoolean(false));
        
        config.save();
	}
}
