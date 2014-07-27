package electro.powerSystem;

import api.powerSystem.prefab.TEPowerCore;
import electro.Electrolysm;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Clarky158 on 25/07/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class BlockAdvEnergyStorage extends basicEnergyStorage
{
    public BlockAdvEnergyStorage()
    {
        super();
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(2F);
        setHarvestLevel("pickaxe",1);
        setStepSound(soundTypeMetal);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TEPowerCore(2);
    }
}
