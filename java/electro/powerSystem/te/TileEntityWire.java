package electro.powerSystem.te;

import api.powerSystem.interfaces.IConnector;
import api.powerSystem.prefab.TileEntityBasicCable;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityWire extends TileEntityBasicCable implements IConnector
{
    @Override
    public void updateEntity()
    {
        for (byte i = 0; i < 6; i++)
        {
            ForgeDirection dir = ForgeDirection.getOrientation(i);
            this.updateConnection(this.worldObj.getTileEntity(this.xCoord + dir.offsetX, this.yCoord + dir.offsetY,
                                  this.zCoord + dir.offsetZ), dir);
        }
    }

    @Override
	public boolean canConnect(ForgeDirection from, Object source) {
		return this.updateConnection(source, from);
	}
    
    public boolean updateConnection(Object obj, ForgeDirection side)
    {
        Block thisID = worldObj.getBlock(xCoord, yCoord, zCoord);

        if(obj instanceof TileEntity)
        {
        	TileEntity source = (TileEntity)obj;
        	
	        if (source instanceof TileEntityWire)
	        {
	            TileEntityWire tileEntityIns = (TileEntityWire) source;
	
	            if (((TileEntityWire) source).canConnect(side.getOpposite()))
	            {
	                this.adjacentConnections[side.ordinal()] = source;
	                this.visuallyConnected[side.ordinal()] = true;
	                return true;
	            }
	        }
	        else if (source instanceof IConnector)
	        {
                IConnector tileEntityIns = (IConnector) source;
	
	            if (((IConnector) source).canConnect(side.getOpposite(), tileEntityIns))
	            {
	                this.adjacentConnections[side.ordinal()] = source;
	                this.visuallyConnected[side.ordinal()] = true;
	                return true;
	            }
	        }
    	}
    	else
    	{
    		this.adjacentConnections[side.ordinal()] = null;
            this.visuallyConnected[side.ordinal()] = false;
    		return false;
    	}

        this.adjacentConnections[side.ordinal()] = null;
        this.visuallyConnected[side.ordinal()] = false;
        return false;
    }

    @Override
    public boolean canConnect(ForgeDirection side)
    {
        return true;
    }

    @Override
    public boolean[] getVisualConnections()
    {
        return this.visuallyConnected;
    }

    @Override
    public TileEntity[] getAdjConnections() {
        return this.adjacentConnections;
    }
    /*
    public TileEntity[] getAdjacentConnections()
    {
        return adjacentConnections;
    }

    public Block getBlockType()
    {
        return electrolysmCore.endoCable;
    }

    public int getBlockMetadata()
    {
        return 0;
    }*/
}