package assets.electrolysm.api.powerSystem;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ben on 27/01/14.
 */
public class basicPowerAPI
{
    /**
     * This is the map that the Earthers and Tesla Towers uses to verify if the block used can be used as a
     * earthing block - It is advised that this block is of metalic origins.
     * 2 params must be used : block ID : the persentage (int) conductivity
     * For Example:
     * this.blockConductivityMap.put(exampleMod.blockMetal, 56)
     */
    public static Map blockConductivityMap = new HashMap();

    static
    {
        blockConductivityMap.put(electrolysmCore.BlockLumRed.blockID, 10);
        blockConductivityMap.put(electrolysmCore.largeCopperCoil.blockID, 25);
        blockConductivityMap.put(electrolysmCore.plasma.blockID, 50);
        blockConductivityMap.put(Block.blockDiamond.blockID, 0);
        blockConductivityMap.put(Block.blockGold.blockID, 83);
        blockConductivityMap.put(Block.waterStill.blockID, 43);
        blockConductivityMap.put(electrolysmCore.graphite.blockID, 95);
        blockConductivityMap.put(Block.blockIron.blockID, 76);
    }
}
