package assets.electrolysm.electro.oreProccessing.te;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import universalelectricity.api.UniversalClass;
import universalelectricity.api.energy.EnergyStorageHandler;
import universalelectricity.api.energy.IEnergyContainer;
import universalelectricity.api.energy.IEnergyInterface;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@UniversalClass
public class TileEntityElectrical extends TileEntity implements IEnergyInterface, IEnergyContainer{

	@SideOnly(Side.CLIENT)
	public EnergyStorageHandler energy;
	public long currentEnergy;
	public boolean active = false;
	
	public boolean isActive()
	{
		return active;
	}

    public TileEntityElectrical(long capacity)
    {
    	if(capacity > 0)
    	{
    		energy = new EnergyStorageHandler(capacity, Long.MAX_VALUE, 0);
    	}
    	else
    	{
    		energy = new EnergyStorageHandler(500000, Long.MAX_VALUE, 0);
    	}
    }
    
    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.energy.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        this.energy.writeToNBT(nbt);
    }

	
	@Override
	public boolean canConnect(ForgeDirection direction, Object source) 
	{
        if (direction == null || direction.equals(ForgeDirection.UNKNOWN))
        {
            return false;
        }

        return this.getInputDirections(direction);
    }

	private boolean getInputDirections(ForgeDirection direction) 
	{
		return direction != ForgeDirection.UP;
	}

	@Override
    public long onReceiveEnergy(ForgeDirection from, long receive, boolean doReceive)
    {
        if (from != ForgeDirection.UNKNOWN && this.getInputDirections(from))
        {
        	return this.energy.receiveEnergy(receive, doReceive);
        }

        return 0;
    }

	@Override
	public long onExtractEnergy(ForgeDirection from, long extract, boolean doExtract) 
	{
		return 0;
	}

	@Override
	public long getEnergy(ForgeDirection from) 
	{
		return this.energy.getEnergy();
	}

	@Override
	public long getEnergyCapacity(ForgeDirection from) 
	{	
		return this.energy.getEnergyCapacity();
	}

	@Override
	public void setEnergy(ForgeDirection from, long energyIn) 
	{
		if(this.getInputDirections(from))
		{
			this.energy.setEnergy(energyIn);
		}
	}

}
