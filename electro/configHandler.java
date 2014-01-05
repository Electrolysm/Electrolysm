package assets.electrolysm.electro;

import java.io.File;

import net.minecraftforge.common.Configuration;
import assets.electrolysm.electro.handlers.BetaHandler;
import assets.electrolysm.electro.handlers.IDHandler;

public class configHandler {
	
	public static String BLOCK_CAT = "BLOCKS";
	public static String ITEM_CAT = "ITEMS";
	public static String OTHER_CAT = "OTHER";
	public static int connectedTexturesMode = 2;
	public static String modID;
	public static int modIDInt;
	public static boolean idSet;
	public static boolean idSetD;
	
	//IDs - Blocks
	public static int workBenchID;
	public static int deskID;
	public static int injectorID;
	public static int researchDeskID;
	//etc. Do them in order so you dont get confused
	
	public static void init(File file){
    	Configuration config = new Configuration(file);   

        config.load();
        
		modID = (config.get("debuging", "Mod_ID", "Gamer").toString());
		modIDInt = (config.get("debuging", "modID as int", BetaHandler.setID(), "ModID").getInt());
		idSet = (config.get("debuging", "IDSet", idSetD).getBoolean(false));
        
		//IDs - Blocks
		workBenchID = config.get(BLOCK_CAT, "workBenchID", IDHandler.machines.basic.workBenchID).getInt();
		deskID = config.get(BLOCK_CAT, "DeskID", IDHandler.machines.basic.deskID).getInt();
		injectorID = config.get(BLOCK_CAT, "injectorID", IDHandler.advMachines.injectorID).getInt();
		researchDeskID = config.get(BLOCK_CAT, "researchDeskID", IDHandler.machines.basic.researchDeskID).getInt();

        config.save();
	}
}
