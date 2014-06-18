package electro.powerSystem.te;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import api.powerSystem.prefab.TileEntityBasicCable;
import electro.electrolysmCore;
import electro.block.te.TileEntityIronFrame;
import electro.crafting.items.te.TileEntityLumRed;

public class TileEntityWire extends TileEntityBasicCable
{
    protected boolean[] visuallyConnected = new boolean[6];
/*
    @Override
    public void updateEntity()
    {
        for (byte i = 0; i < 6; i++)
        {
            //ForgeDirection dir = ForgeDirection.getOrientation(i);
            this.updateConnection(this.worldObj.getTileEntity(this.xCoord + dir.offsetX, this.yCoord + dir.offsetY,
                                  this.zCoord + dir.offsetZ), dir);
        }
    }


	@Override
	public boolean canConnect(ForgeDirection from, Object source) {
		// TODO Auto-generated method stub
		return this.updateConnection(source, from);
	}
    
    public boolean updateConnection(Object obj, ForgeDirection side)
    {
        int thisID = worldObj.getBlockId(xCoord, yCoord, zCoord);

        if(obj instanceof TileEntity)
        {
        	TileEntity source = (TileEntity)obj;
        	
	        if (!this.worldObj.isRemote && source != null && this.canConnect(side))
	        {
	        }
	        else if (source instanceof TileEntityWire)
	        {
	            TileEntityWire tileEntityIns = (TileEntityWire) source;
	
	            if (((TileEntityWire) source).canConnect(side.getOpposite()))
	            {
	                this.adjacentConnections[side.ordinal()] = source;
	                this.visuallyConnected[side.ordinal()] = true;
	                return true;
	            }
	        }
	        else if (source instanceof IConnectable)
	        {
	        	IConnectable tileEntityIns = (IConnectable) source;
	
	            if (((IConnectable) source).canConnect(side.getOpposite(), tileEntityIns))
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

    public boolean canConnect(ForgeDirection side)
    {
        return true;
    }
*/
    public boolean[] getVisualConnections()
    {
        return this.visuallyConnected;
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