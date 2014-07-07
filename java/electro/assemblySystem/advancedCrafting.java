package electro.assemblySystem;

import electro.Electrolysm;
import electro.assemblySystem.tileEntity.TileEntityAdvCrafting;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Ben on 07/07/2014.
 */
public class advancedCrafting extends BlockContainer
{
    public advancedCrafting()
    {
        super(Material.iron);
        this.setBlockName("advancedCrafting");
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(7F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return new TileEntityAdvCrafting();
    }
}
