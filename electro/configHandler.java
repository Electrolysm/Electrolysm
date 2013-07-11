package mods.Electrolysm.electro;

import java.io.File;

import mods.Electrolysm.electro.handlers.IDHandler;
import net.minecraftforge.common.Configuration;

public class configHandler {

	public static String BLOCK_CATEGORY = "Blocks";
	private static String ID = "ID";
	
	//IDs
	public static int MIXED_ORE_ID; 
	
	public static void init(File file){
    	Configuration config = new Configuration(file);   
		
        config.load();
        
        //Ore spawning
        electrolysmCore.spawnCopperOre = config.get(Configuration.CATEGORY_GENERAL, "spawnCopperOre", true).getBoolean(true);
        electrolysmCore.spawnTinOre = config.get(Configuration.CATEGORY_GENERAL, "spawnTinOre", true).getBoolean(true);
        electrolysmCore.spawnLeadOre = config.get(Configuration.CATEGORY_GENERAL, "spawnLeadOre", true).getBoolean(true);
        electrolysmCore.spawnSilverOre = config.get(Configuration.CATEGORY_GENERAL, "spawnSilverOre", true).getBoolean(true);
        
        //IDs
        MIXED_ORE_ID = config.get(BLOCK_CATEGORY, configHandler.MIXED_ORE_ID + ID, IDHandler.mixedOreID).getInt(); 
        
        
	config.save();
	}
}
