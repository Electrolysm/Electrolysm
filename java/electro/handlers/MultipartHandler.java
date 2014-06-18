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
        //this.addMultiparts();
	}

	private void addMultiparts()
	{
        BlockMicroMaterial.createAndRegister(electrolysmCore.blastBrick, "Blast Proof Iron Brick");
        BlockMicroMaterial.createAndRegister(electrolysmCore.blastProof, "Blast Proof Iron Block");
        BlockMicroMaterial.createAndRegister(electrolysmCore.BlockLumRed, "Luminous Redstone Block");
        BlockMicroMaterial.createAndRegister(electrolysmCore.diseaseGrass, "Diseased Grass");
        BlockMicroMaterial.createAndRegister(electrolysmCore.graphite, "Graphite");
        //BlockMicroMaterial.createAndRegister(electrolysmCore.stoneObsidian, "Stone");
        BlockMicroMaterial.createAndRegister(electrolysmCore.sulphurOre, "Sulphur Ore");
	}
}