package electro.powerSystem.generators;

import electro.Electrolysm;
import electro.powerSystem.generators.te.TileEntitySolarPanel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Ben on 19/07/2014.
 */
public class BlockSolarPanel extends BlockContainer
{
    public BlockSolarPanel()
    {
        super(Material.iron);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(3.14159F);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntitySolarPanel();
    }
}
