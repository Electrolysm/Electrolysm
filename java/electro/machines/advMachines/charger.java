package electro.machines.advMachines;

import electro.Electrolysm;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import electro.machines.advMachines.te.TileEntityCharger;

public class charger extends BlockContainer
{
    public charger()
    {
        super(Material.iron);
        this.setHardness(4F);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(4F);
        this.setResistance(7F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return new TileEntityCharger();
    }

    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }
}
