package electro.machines.assemblySystem;

import electro.Electrolysm;
import electro.machines.assemblySystem.inventory.TileEntityRobotArm;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Ben on 07/07/2014.
 */
public class roboticArm extends BlockContainer
{
    public roboticArm()
    {
        super(Material.iron);
        this.setBlockName("roboticArm");
        this.setHardness(7F);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return new TileEntityRobotArm();
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }





}
