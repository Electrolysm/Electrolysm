package mods.Electrolysm.electro;

import java.io.File;

import mods.Electrolysm.electro.basic.handlers.IDHandler;
import net.minecraftforge.common.Configuration;

public class configHandler {

	public static void init(File file){
    	Configuration config = new Configuration(file);   
		IDHandler id = new IDHandler();

        config.load();
        
        //Ore spawning
        electrolysmCore.spawnCopperOre = config.get(Configuration.CATEGORY_GENERAL, "spawnCopperOre", true).getBoolean(true);
        electrolysmCore.spawnTinOre = config.get(Configuration.CATEGORY_GENERAL, "spawnTinOre", true).getBoolean(true);
        electrolysmCore.spawnLeadOre = config.get(Configuration.CATEGORY_GENERAL, "spawnLeadOre", true).getBoolean(true);
        electrolysmCore.spawnSilverOre = config.get(Configuration.CATEGORY_GENERAL, "spawnSilverOre", true).getBoolean(true);
        
        //Block IDs
        id.mixedOreID = config.get(config.CATEGORY_BLOCK, "Mixed ore ID", id.mixedOreID).getInt();
		id.copperOreID = config.get(config.CATEGORY_BLOCK, "Copper ore ID", id.copperOreID).getInt();
		id.tinOreID = config.get(config.CATEGORY_BLOCK, "Tin ore ID", id.tinOreID).getInt();
		id.leadOreID = config.get(config.CATEGORY_BLOCK, "Lead ore ID", id.leadOreID).getInt();
		id.silverOreID = config.get(config.CATEGORY_BLOCK, "silver ore ID", id.silverOreID).getInt();
		id.platiumOreID = config.get(config.CATEGORY_BLOCK, "platinum ore ID", id.platiumOreID).getInt();
		id.magmaticExtractorID = config.get(config.CATEGORY_BLOCK, "magmatic extractor ID", id.magmaticExtractorID).getInt();
		id.matterSynthisiserID = config.get(config.CATEGORY_BLOCK, "matter synthisiser ID", id.matterSynthisiserID).getInt();
		id.solarCollectorID = config.get(config.CATEGORY_BLOCK, "solar collector ID", id.solarCollectorID).getInt();
		id.forgeID = config.get(config.CATEGORY_BLOCK, "forge ID", id.forgeID).getInt();
		id.platinumFurnaceID = config.get(config.CATEGORY_BLOCK, "platinum Furnace ID", id.platinumFurnaceID).getInt();
		id.nanoBlockID = config.get(config.CATEGORY_BLOCK, "nano block ID", id.nanoBlockID).getInt();
		id.deskID = config.get(config.CATEGORY_BLOCK, "desk ID", id.deskID).getInt();
		id.fibrePlantID = config.get(config.CATEGORY_BLOCK, "fibre plant ID", id.fibrePlantID).getInt();
		id.platinumID = config.get(config.CATEGORY_BLOCK, "platinum block ID", id.platinumID).getInt();
		id.CrusherID = config.get(config.CATEGORY_BLOCK, "crusher ID", id.CrusherID).getInt();      
        
		//Item IDs
		
	config.save();
	}
}
