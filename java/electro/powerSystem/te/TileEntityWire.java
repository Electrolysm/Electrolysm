package electro.powerSystem.te;

import api.powerSystem.interfaces.IConnector;
import api.powerSystem.prefab.TileEntityBasicCable;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
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

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        NBTTagList tagList = new NBTTagList();

        for (int currentIndex = 0; currentIndex < adjacentConnections.length; ++currentIndex)
        {
            if (adjacentConnections[currentIndex] != null)
            {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                adjacentConnections[currentIndex].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        tag.setTag("TileEntities", tagList);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        NBTTagList tagList = pkt.func_148857_g().getTagList("TileEntities", 10);
        adjacentConnections = new TileEntity[6];
        for (int i = 0; i < tagList.tagCount(); ++i)
        {
            NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
            byte slotIndex = tagCompound.getByte("Slot");
            if (slotIndex >= 0 && slotIndex < adjacentConnections.length)
            {
                adjacentConnections[slotIndex] = TileEntity.createAndLoadEntity(tagCompound);
            }
        }
    }
}