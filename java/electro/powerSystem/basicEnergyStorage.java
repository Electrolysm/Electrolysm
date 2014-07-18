package electro.powerSystem;

import api.powerSystem.prefab.TEPowerCore;
import cpw.mods.fml.common.registry.LanguageRegistry;
import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


public class basicEnergyStorage extends BlockContainer
{
    public basicEnergyStorage()
    {
        super(Material.iron);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(2F);
        setHarvestLevel("pickaxe",1);
        setStepSound(soundTypeMetal);
    }


    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TEPowerCore();
    }
}