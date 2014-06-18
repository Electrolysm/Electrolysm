package electro.handlers;

import electro.electrolysmCore;
import codechicken.microblock.BlockMicroMaterial;
import net.minecraft.item.ItemStack;

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
        this.addMultiparts();
	}

	private void addMultiparts()
	{
        BlockMicroMaterial.createAndRegister(electrolysmCore.blastBrick, new ItemStack(electrolysmCore.blastBrick).getDisplayName());
        BlockMicroMaterial.createAndRegister(electrolysmCore.blastProof, new ItemStack(electrolysmCore.blastProof).getDisplayName());
        BlockMicroMaterial.createAndRegister(electrolysmCore.BlockLumRed, new ItemStack(electrolysmCore.BlockLumRed).getDisplayName());
        BlockMicroMaterial.createAndRegister(electrolysmCore.diseaseGrass, new ItemStack(electrolysmCore.diseaseGrass).getDisplayName());
        BlockMicroMaterial.createAndRegister(electrolysmCore.graphite, new ItemStack(electrolysmCore.graphite).getDisplayName());
        BlockMicroMaterial.createAndRegister(electrolysmCore.stoneObsidian, new ItemStack(electrolysmCore.stoneObsidian).getDisplayName());
        BlockMicroMaterial.createAndRegister(electrolysmCore.sulphurOre, new ItemStack(electrolysmCore.sulphurOre).getDisplayName());
	}
}