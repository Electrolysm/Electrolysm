package assets.electrolysm.api.powerSystem.usageMachine;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.powerSystem.te.TileEntityPlug;

public class TileEntityEnergyMachine extends TileEntity implements IEnergyMachine
{
	public void updateEntity()
	{
		this.canWork(worldObj, xCoord, yCoord, zCoord);
		
	}

	@Override
	public boolean canWork(World world, int x, int y, int z) 
	{
		if(this.isPowered(world, x, y, z))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isPowered(World world, int x, int y, int z)
	{
		if(world.getBlockId(x, y - 1, z) == electrolysmCore.plug.blockID)
		{
			TileEntityPlug te = (TileEntityPlug)world.getBlockTileEntity(x, y - 1, z);
			if(te.getRecievedTeUAfterResistance(world, x, y - 1, z) > 0)
			{
				return true;
			}
		}
		return false;
	}

}