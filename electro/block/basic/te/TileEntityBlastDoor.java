package assets.electrolysm.electro.block.basic.te;

import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.block.basic.blastDoor;
import assets.electrolysm.electro.client.ClientProxy;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class TileEntityBlastDoor extends TileEntity {

	public boolean clicked;
	public String username;
	blastDoor block = new blastDoor(electrolysmCore.blastDoor.blockID, null);
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
	
	public void tpThrough(World world, EntityPlayer player, int x, int y, int z, int blockID)
	{
		if(player.getHeldItem() == null)
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
            String accessAllowed = "Access Granted";
            ClientProxy.printChatMessage(accessAllowed);
    	}
	}
}

