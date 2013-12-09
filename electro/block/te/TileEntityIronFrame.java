package assets.electrolysm.electro.block.te;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.world.World;

public class TileEntityIronFrame extends TileEntity 
{
	public boolean isRecieving()
	{ /*
		World world = worldObj;
		Direction dir = null;
		int generatorID = 1;
		
		boolean[] overall = new boolean[4];
		boolean canRecieve = false;
		
		for(int i = 0; i < dir.offsetX.length; i++)
		{
			if(world.getBlockId(xCoord + dir.offsetX[i], yCoord, zCoord + dir.offsetZ[i]) == generatorID)
			{
				overall[i] = true;
			}
			else
			{
				overall[i] = false;
			}
			
		}
		for(int i = 0; i < overall.length; i++)
		{
			if(overall[i])
			{
				canRecieve = true;
			}
		}
		return canRecieve;*/
		return true;
	}
	
	public int getRecievingTeU(World world, int x, int y, int z)
	{
		return 100;
	}
}
