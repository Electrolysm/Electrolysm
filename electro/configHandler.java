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
	public static int graphiteID;
	public static int copperOreID;
	public static int sulphurOreID;
	public static int diseaseGrassID;
	public static int blastProofID;
	public static int blastDoorID;
	public static int blastGlassID;
	public static int modBlastGlassID;
	public static int stoneObsidianID;
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
        graphiteID = config.get(BLOCK_CAT, "graphiteID", IDHandler.worldGenOres.graphiteID).getInt();
        copperOreID = config.get(BLOCK_CAT, "coppweOreID", IDHandler.worldGenOres.copperOreID).getInt();
        sulphurOreID = config.get(BLOCK_CAT, "sulphurOreID", IDHandler.worldGenOres.sulphurOreID).getInt();
        diseaseGrassID = config.get(BLOCK_CAT, "diseaseGrassID", IDHandler.basic.diseasedGrassID).getInt();
        blastProofID = config.get(BLOCK_CAT, "blastProofID", IDHandler.basic.blastProofID).getInt();
        blastDoorID = config.get(BLOCK_CAT, "balstDoorID", IDHandler.basic.blastDoorID).getInt();
        blastGlassID = config.get(BLOCK_CAT, "blastGlassID", IDHandler.basic.blastGlassID).getInt();
        modBlastGlassID = config.get(BLOCK_CAT, "modBlastGlassID", IDHandler.basic.modBlastGlassID).getInt();
        stoneObsidianID = config.get(BLOCK_CAT, "stoneObsidianID", IDHandler.basic.stoneObsidianID).getInt();
        config.save();
	}
}
