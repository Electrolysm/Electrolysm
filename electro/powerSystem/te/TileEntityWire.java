package assets.electrolysm.electro.powerSystem.te;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.block.te.TileEntityIronFrame;
import assets.electrolysm.electro.crafting.items.te.TileEntityLumRed;

public class TileEntityWire extends TileEntity
{
    protected boolean[] visuallyConnected = new boolean[6];
    protected TileEntity[] adjacentConnections = new TileEntity[6];
    
    @Override
    public void updateEntity()
    {
        for (byte i = 0; i < 6; i++)
        {
            ForgeDirection dir = ForgeDirection.getOrientation(i);
            this.updateConnection(this.worldObj.getBlockTileEntity(this.xCoord + dir.offsetX, this.yCoord + dir.offsetY,
            		this.zCoord + dir.offsetZ), dir, this.worldObj.getBlockId(this.xCoord + dir.offsetX,
            				this.yCoord + dir.offsetY, this.zCoord + dir.offsetZ));
        }
    }
    
    public void updateConnection(TileEntity that, ForgeDirection side, int id)
    {
        int thisID = worldObj.getBlockId(xCoord, yCoord, zCoord);

        if (!this.worldObj.isRemote && that != null && this.canConnect(side))
        {
        }
        else if (that instanceof TileEntityWire)
        {
          	TileEntityWire tileEntityIns = (TileEntityWire) that;
               
            if (((TileEntityWire) that).canConnect(side.getOpposite()))
            {
                  this.adjacentConnections[side.ordinal()] = that;
                  this.visuallyConnected[side.ordinal()] = true;
                      
                  return;
            }
        }
        
        else if (that instanceof TileEntityIronFrame)
        {
        	TileEntityIronFrame tileEntityIns = (TileEntityIronFrame) that;
	           
	        if (((TileEntityIronFrame) that).canConnect(side.getOpposite()))
	        {
	             this.adjacentConnections[side.ordinal()] = that;
	             this.visuallyConnected[side.ordinal()] = true;
	                
	             return;
	        }
	    }
        
        else if (that instanceof TileEntityEarther)
	    {
        	TileEntityEarther tileEntityIns = (TileEntityEarther) that;
        	
	        if (((TileEntityEarther) that).canConnect(side.getOpposite(), thisID))
	        {
	            this.adjacentConnections[side.ordinal()] = that;
	            this.visuallyConnected[side.ordinal()] = true;
	                
	            return;
	        }
	    }
        else if (that instanceof TileEntityLumRed)
	    {
        	TileEntityLumRed tileEntityIns = (TileEntityLumRed) that;
        	
	        if (((TileEntityLumRed) that).canConnect(side.getOpposite(), thisID))
	        {
	            this.adjacentConnections[side.ordinal()] = that;
	            this.visuallyConnected[side.ordinal()] = true;
	                
	            return;
	        }
	    }
	    
        
        this.adjacentConnections[side.ordinal()] = null;
        this.visuallyConnected[side.ordinal()] = false;
    }

	public boolean canConnect(ForgeDirection side) 
	{
		return true;
	}	
	
    public boolean[] getVisualConnections()
    {
        return this.visuallyConnected;
    }

	public TileEntity[] getAdjacentConnections() 
	{
		return adjacentConnections;
	}
	
	public Block getBlockType()
    {
		return electrolysmCore.wire;
    }
	
	public int getBlockMetadata()
    {
		return 0;
    }
	
}
