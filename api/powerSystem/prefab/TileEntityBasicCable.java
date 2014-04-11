package assets.electrolysm.api.powerSystem.prefab;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import universalelectricity.api.energy.EnergyNetworkLoader;
import universalelectricity.api.energy.EnergyStorageHandler;
import universalelectricity.api.energy.IConductor;
import universalelectricity.api.energy.IEnergyContainer;
import universalelectricity.api.energy.IEnergyInterface;
import universalelectricity.api.energy.IEnergyNetwork;
import universalelectricity.api.net.IConnector;

public class TileEntityBasicCable extends TileEntity implements IConductor/*, IEnergyContainer, IEnergyInterface, 
														IEnergyNetwork*/{

	protected IEnergyNetwork network;
    public TileEntity[] adjacentConnections = new TileEntity[6];

	@Override
	public Object[] getConnections() 
	{
		return adjacentConnections;
	}

	@Override
	public IConnector<IEnergyNetwork> getInstance(ForgeDirection dir) 
	{
		return this;
	}

	@Override
	public IEnergyNetwork getNetwork() 
	{
	    if (this.network == null)
	    {
	      setNetwork(EnergyNetworkLoader.getNewNetwork(new IConductor[] { this }));
	    }
	    
		return network;
	}

	@Override
	public void setNetwork(IEnergyNetwork networkPre) 
	{
		network = networkPre;
	}

	@Override
	public boolean canConnect(ForgeDirection from, Object source) 
	{
		return false;
	}

	@Override
	public long onReceiveEnergy(ForgeDirection from, long receive, boolean doReceive) 
	{
	    return this.getNetwork().produce(this, from.getOpposite(), receive, doReceive);
	}

	@Override
	public long onExtractEnergy(ForgeDirection from, long extract, boolean doExtract) 
	{
	    return 0L;
	}

	@Override
	public float getResistance() 
	{
		return (float) 1.25;
	}

	@Override
	public long getCurrentCapacity() 
	{
		return 10000;
	}
}
