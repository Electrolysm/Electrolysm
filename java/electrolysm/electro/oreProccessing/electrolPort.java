package electrolysm.electro.oreProccessing;

import electrolysm.electro.Electrolysm;
import electrolysm.electro.oreProccessing.te.TileEntityPort;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class electrolPort extends BlockContainer
{
    public electrolPort()
    {
        super(Material.iron);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(4F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return new TileEntityPort();
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (player.isSneaking())
        {
            return false;
        }
        else if (!player.isSneaking())
        {
            player.openGui(Electrolysm.GUIInstance, 0, world, x, y, z);
            return true;
        }
        else
        {
            return false;
        }
    }
}
