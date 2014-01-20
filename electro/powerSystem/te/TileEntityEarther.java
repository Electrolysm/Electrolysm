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
			return true;
		}
		else
		{
			return false;
		}
	}

	private boolean checkForMetal(World world, int x, int y, int z) 
	{
		int id = world.getBlockId(x, y - 3, z);
		
		if(world.getBlockTileEntity(x, y - 3, z) instanceof IConductiveMetal)
		{
			IConductiveMetal metal = (IConductiveMetal)world.getBlockTileEntity(x, y - 3, z);
			
			if(metal.isMetalConductive())
			{
				return true;
			}
		}
		else if( this.isIdOnList(id) || this.isOreDictionary(id))
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

	private boolean isIdOnList(int id) 
	{
		if(id == Block.blockGold.blockID)
		{
			return true;
		}
		else if(id == Block.blockIron.blockID)
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
