package assets.electrolysm.electro.handlers;

import codechicken.microblock.BlockMicroMaterial;
import net.minecraft.block.Block;
import assets.electrolysm.electro.configHandler;
import assets.electrolysm.electro.electrolysmCore;

public class MultipartHandler
{
    private static MultipartHandler instance = null;

    public static MultipartHandler getInstance()
    {
        if (instance == null) {
            instance = new MultipartHandler();
        }
        return instance;
    }
	
	public MultipartHandler()
	{
		if(configHandler.multipart)
		{
			addMultiparts();
			LoggerHandler.info("Adding Multipart Blocks");
		}
		else
		{
			LoggerHandler.config("Multipart Blocks not added, due to configuration options!");
			LoggerHandler.config("Change config options to add Multipart Blocks");
		}
	}

	private void addMultiparts()
	{
        BlockMicroMaterial.createAndRegister(electrolysmCore.blastBrick);
        BlockMicroMaterial.createAndRegister(electrolysmCore.blastProof);
        BlockMicroMaterial.createAndRegister(electrolysmCore.blastGlass);
        BlockMicroMaterial.createAndRegister(electrolysmCore.BlockLumRed);
        BlockMicroMaterial.createAndRegister(electrolysmCore.diseaseGrass);
        BlockMicroMaterial.createAndRegister(electrolysmCore.graphite);
        BlockMicroMaterial.createAndRegister(electrolysmCore.stoneObsidian);
        BlockMicroMaterial.createAndRegister(electrolysmCore.sulphurOre);
	}
}