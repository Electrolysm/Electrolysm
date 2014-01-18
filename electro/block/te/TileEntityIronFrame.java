package assets.electrolysm.electro.block.te;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.powerSystem.generators.te.TileEntityGenerator;
import assets.electrolysm.electro.powerSystem.te.TileEntityTeslaTower;
import assets.electrolysm.electro.powerSystem.te.TileEntityWire;

public class TileEntityIronFrame extends TileEntity 
{
	public boolean isRecieving()
	{
		World world = this.getWorldObj();
		int x = xCoord;
		int y = yCoord;
		int z = zCoord;
		int generatorID = electrolysmCore.generator.blockID;
		
		boolean[] overall = new boolean[4];
		boolean canRecieve = false;

		TileEntityTeslaTower te = (TileEntityTeslaTower)world.getBlockTileEntity(x, y + 5, z);
		
		if(te != null)
		{
			if(te.isTowerFormed(world, x, y + 5, z))
			{
				if(this.getRecievingTeU(world, x, y, z) > 0)
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
		else
		{
			return false;
		}
	}
	
	public int getRecievingTeU(World world, int x, int y, int z)
	{
		int wireID = electrolysmCore.wire.blockID;
		
		int teu1 = 0;
		
		//x + 1
		if(world.getBlockId(x, y - 1, z) == wireID)
		{
			TileEntityWire teGen = (TileEntityWire)world.getBlockTileEntity(x, y - 1, z);
			teu1 = teGen.getRecievingTeUOverall(world, x, y - 1, z);
		}
		return (teu1);
	}

	public boolean canConnect(ForgeDirection side) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean canBePowered(World world, int x, int y, int z) 
	{
		if(world.getBlockTileEntity(x, y + 5, z) instanceof TileEntityTeslaTower)
		{
			TileEntityTeslaTower te = (TileEntityTeslaTower)world.getBlockTileEntity(x, y + 5, z);
			return (te.isTowerFormed(world, x, y + 5, z));
		}
		else
		{
			return false;
		}
	}
}
