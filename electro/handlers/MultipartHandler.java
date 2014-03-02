package assets.electrolysm.electro.handlers;

import net.minecraft.block.Block;
import assets.electrolysm.electro.electrolysmCore;
import codechicken.microblock.BlockMicroMaterial;
import codechicken.multipart.MultiPartRegistry.IPartFactory;

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
		addMultiparts();
	}

	private void addMultiparts()
	{
        BlockMicroMaterial.createAndRegister(electrolysmCore.blastBrick);
        BlockMicroMaterial.createAndRegister(electrolysmCore.blastProof);
        BlockMicroMaterial.createAndRegister(electrolysmCore.blastGlass);
        BlockMicroMaterial.createAndRegister(electrolysmCore.BlockLumRed);
        BlockMicroMaterial.createAndRegister(electrolysmCore.diseaseGrass);
        BlockMicroMaterial.createAndRegister(electrolysmCore.graphite);
        BlockMicroMaterial.createAndRegister(electrolysmCore.largeCopperCoil);
        BlockMicroMaterial.createAndRegister(electrolysmCore.stoneObsidian);
        BlockMicroMaterial.createAndRegister(electrolysmCore.sulphurOre);
	}
}