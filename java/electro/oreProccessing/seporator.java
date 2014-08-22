package electro.oreProccessing;

import electro.Electrolysm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class seporator extends oreProcessMachineBase
{
    public String className = "" + this.getClass();
    public String unlocalName = className.replace("assets.electrolysm.electro", "");
    public String textureName = unlocalName.replace(".", "/");

    public seporator(boolean isActive)
    {
        super(isActive);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(6.0F);
        this.active = isActive;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return null;
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (player.isSneaking())
        {
            return false;
        }
        else
        {
            player.openGui(Electrolysm.GUIInstance, 0, world, x, y, z);
            return true;
        }
    }
}
