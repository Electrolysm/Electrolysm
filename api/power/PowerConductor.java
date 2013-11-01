package assets.electrolysm.api.power;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import assets.electrolysm.electro.powerSystem.te.TileEntityWire;

public class PowerConductor extends TileEntity{
	
    private final ForgeDirection[] dirs = ForgeDirection.values();
    public int heldTEU;
    public String cableType;
	
    @Override
    public void updateEntity()
    {
    	this.sendTEULine(worldObj, xCoord, yCoord, zCoord);
    }
    
    
	public void sendTEULine(World world, int x, int y, int z)
	{
		for(int i = 0; i < 6; i++)
		{
			ForgeDirection dir = dirs[i];
			int dx = x + dir.offsetX;
			int dy = y + dir.offsetY;
			int dz = z + dir.offsetZ;
			
			PowerConductor te = (PowerConductor)world.getBlockTileEntity(dx, dy, dz);
			if(te instanceof PowerConductor)
			{
				
				/*if((teP.getHeldTEU(teP) + this.getHeldTEU(teP)) <= teP.getMaxHeldTEU(teP))
				{*/
					te.setTEU(this.getHeldTEU(te));
				//}
			}
			
		}
	}
	
	public void removeTEULine(World world, int x, int y, int z)
	{
		for(int i = 0; i < 6; i++)
		{
			ForgeDirection dir = dirs[i];
			int dx = x + dir.offsetX;
			int dy = y + dir.offsetY;
			int dz = z + dir.offsetZ;
			
			PowerConductor te = (PowerConductor)world.getBlockTileEntity(dx, dy, dz);
			if(te.equals(this))
			{
				te.zeroTEU();
			}
		}
	}
	
	public void setTEU(int setTo) 
	{
		this.heldTEU = setTo;
	}
	
	public void zeroTEU()
	{
		this.heldTEU = 0;
	}
	
	public int getHeldTEU(PowerConductor wire)
	{
		return wire.heldTEU;
		
	}
	/*
	public int getMaxHeldTEU(PowerConductor wire)
	{
		for(int i = 0; i < PowerHandler.cableTypes.length; i++)
		{
			if(wire.getCableType(wire) == PowerHandler.cableTypes[i])
			{
				return (Integer) PowerHandler.wireMap.get(this.getCableType(wire));
			}
		}
		return 0;
	}

	public String getCableType(PowerConductor wire)
	{
		return wire.cableType;
	}
	*/
	
	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		this.heldTEU = tag.getInteger("heldTEU");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag)
	{
		tag.setInteger("heldTEU", this.heldTEU);
	}
	
}
