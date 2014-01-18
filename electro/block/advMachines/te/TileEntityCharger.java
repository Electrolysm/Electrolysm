package assets.electrolysm.electro.block.advMachines.te;

import cpw.mods.fml.common.Loader;
import assets.electrolysm.api.powerSystem.usageMachine.TileEntityEnergyMachine;

public class TileEntityCharger extends TileEntityEnergyMachine 
{
	public static boolean delay;
	
	@Override
	public void updateEntity()
	{
		if(Loader.isModLoaded("Electrolysm"))
		{
			this.canWork(worldObj, xCoord, yCoord, zCoord);
		}
		
		int active = 0;
		int nactive = 1;
		int time = 0;
		
		if(delay)
		{
			if(time == 500)
			{
				delay = false;
			}
			else
			{
				time++;
			}
		}
		
		if(delay)
		{
			if(worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == active)
			{
				worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, nactive, 0);
			}
		}
		else
		{
			if(worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == nactive)
			{
				worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, active, 0);
			}
		}
	}
	
	@Override
	public int getActivationEnergy()
	{
		return 250;
	}
}
