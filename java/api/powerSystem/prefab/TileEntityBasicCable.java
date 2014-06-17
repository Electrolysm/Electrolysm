package api.powerSystem.prefab;

import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.tileentity.TileEntity;


public class TileEntityBasicCable extends TileEntity /*implements IConductor/*, IEnergyContainer, IEnergyInterface,
														IEnergyNetwork*/{

	/*protected IEnergyNetwork network;
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
	    return 0L;//this.getNetwork().extract(this, from.getOpposite(), extract, doExtract);
	}

	@Override
	public float getResistance() 
	{
		return (float) 0;
	}

	@Override
	public long getCurrentCapacity() 
	{
		return (long)Integer.MAX_VALUE;
	}*/
}
