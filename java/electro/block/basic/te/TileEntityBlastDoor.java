package electro.block.basic.te;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityBlastDoor extends TileEntity
{
    public boolean clicked;
    public String username;
    /**
    * Reads a tile entity from NBT.
    */
    public void readFromNBT(NBTTagCompound nbt)
    {
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound nbt)
    {
    }

    public void tpThrough(EntityPlayer player, int x, int y, int z)
    {
        if (player.getHeldItem() == null)
        {
            int i1 = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
            byte xBlock = 0;
            byte zBlock = 0;

            if (i1 == 0)
            {
                zBlock = 1;
            }

            if (i1 == 1)
            {
                xBlock = -1;
            }

            if (i1 == 2)
            {
                zBlock = -1;
            }

            if (i1 == 3)
            {
                xBlock = 1;
            }

            player.setPosition(x + xBlock, y + 1, z + zBlock);
        }
    }
}
