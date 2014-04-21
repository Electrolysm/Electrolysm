package assets.electrolysm.electro.oreProccessing.te;

import mekanism.api.energy.IStrictEnergyAcceptor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import universalelectricity.api.UniversalClass;
import universalelectricity.api.energy.EnergyStorageHandler;
import universalelectricity.api.energy.IEnergyContainer;
import universalelectricity.api.energy.IEnergyInterface;
import universalelectricity.api.net.IConnectable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@UniversalClass
public class TileEntityElectrical extends TileEntity implements IEnergyInterface, IEnergyContainer, 
				IStrictEnergyAcceptor{

	public EnergyStorageHandler energy;
	public long currentEnergy;
	public boolean active = false;
	public long capacity = 500000;
	
	public boolean isActive()
	{
		return active;
	}

    public TileEntityElectrical(long capacity1)
    {
    	if(capacity > 0)
    	{
    		capacity = capacity1;
    		energy = new EnergyStorageHandler(capacity, Long.MAX_VALUE, 0);
    	}
    	else
    	{
    		capacity = 500000;
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
		if(source instanceof IConnectable)
		{
			IConnectable te = (IConnectable)source;
			return true;
		}
		else
		{
			return false;
		}
		
	}

	private boolean getInputDirections(ForgeDirection direction) 
	{
		return true;
	}

	@Override
    public long onReceiveEnergy(ForgeDirection from, long receive, boolean doReceive)
    {
        if (from != ForgeDirection.UNKNOWN && this.getInputDirections(from))
        {/*
        	TileEntity te = worldObj.getBlockTileEntity(xCoord + from.getOpposite().offsetX, 
        			yCoord + from.getOpposite().offsetY, zCoord + from.getOpposite().offsetZ);*/
        	
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

	@Override
	public double getEnergy() {
		// TODO Auto-generated method stub
		return this.energy.getEnergy();
	}

	@Override
	public void setEnergy(double energy) 
	{
		this.energy.setEnergy((long)energy);
	}

	@Override
	public double getMaxEnergy() 
	{
		return this.capacity;
	}

	@Override
	public double transferEnergyToAcceptor(ForgeDirection side, double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean canReceiveEnergy(ForgeDirection side) {
		// TODO Auto-generated method stub
		return true;
	}

}
