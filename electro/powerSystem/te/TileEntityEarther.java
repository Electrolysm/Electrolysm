package assets.electrolysm.electro.powerSystem.te;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.oredict.OreDictionary;

public class TileEntityEarther extends TileEntity 
{
	public void updateEntity()
	{
	}
	
	public boolean isSetUp(World world, int x, int y, int z)
	{
		if(this.checkForMetal(world, x, y, z))
		{
			if(this.isFormed(world, x, y, z))
			{
				return true;
			}
		}
		return false;
	}

	public boolean isFormed(World world, int x, int y, int z) 
	{
		int id1 = world.getBlockId(x, y -1, z);
		int id2 = world.getBlockId(x, y - 2, z);
		
		if(id1 == electrolysmCore.advWire.blockID)
		{
			if(id2 == electrolysmCore.advWire.blockID)
			{
				return true;
			}
		}
		return false;
	}

	private boolean checkForMetal(World world, int x, int y, int z) 
	{
		int id = world.getBlockId(x, y - 3, z);
		
		if(id == electrolysmCore.BlockLumRed.blockID)
		{
			return true;
		}
		return false;
	}

	private boolean isOreDictionary(int id) 
	{
		String name = OreDictionary.getOreName(id);
		if(name != "Unknown" && name.contains("block"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	public boolean canConnect(ForgeDirection side, int id) 
	{
		if(id == electrolysmCore.wire.blockID)
		{
			if(side == side.EAST)
			{
				return true;
			}
			else if(side == side.NORTH)
			{
				return true;
			}
			else if(side == side.SOUTH)
			{
				return true;
			}
			else if(side == side.WEST)
			{
				return true;
			}
			else if(side == side.UP)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(id == electrolysmCore.advWire.blockID)
		{
			if(side == side.UP)
			{
				return true;
			}
			else if(side == side.DOWN)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
}
