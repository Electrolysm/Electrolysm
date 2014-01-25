package assets.electrolysm.electro.powerSystem.te;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityCopperCoil extends TileEntity 
{

	public boolean blockIsCorner(int id) 
	{
		if(worldObj.getBlockId(xCoord + 1, yCoord, zCoord) == id)
		{
			if(worldObj.getBlockId(xCoord, yCoord, zCoord + 1) == id)
			{
				return true;
			}
		}
		else if(worldObj.getBlockId(xCoord - 1, yCoord, zCoord) == id)
		{
			if(worldObj.getBlockId(xCoord, yCoord, zCoord + 1) == id)
			{
				return true;
			}
		}
		else if(worldObj.getBlockId(xCoord + 1, yCoord, zCoord) == id)
		{
			if(worldObj.getBlockId(xCoord, yCoord, zCoord - 1) == id)
			{
				return true;
			}
		}
		else if(worldObj.getBlockId(xCoord - 1, yCoord, zCoord) == id)
		{
			if(worldObj.getBlockId(xCoord, yCoord, zCoord - 1) == id)
			{
				return true;
			}
		}
		return false;
	}
	
}
