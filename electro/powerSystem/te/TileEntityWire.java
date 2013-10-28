package assets.electrolysm.electro.powerSystem.te;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityWire extends TileEntity{

	private String unitIDLong = "Tesselating Electrical Unit";
	private String unitIDShort = "Tesla Unit";
	
	public String cableType;
	public float heldTEU = 10;
	public int maxHeldTEU = 10;
	
	public float getHeldTEU()
	{
		return heldTEU;
	}
	
	public int getMaxHeldTEU()
	{
		return maxHeldTEU;
	}
	
	public void setHeldTEU(float ammountOfTEU)
	{
		this.heldTEU = ammountOfTEU;
	}
	
	public void sendTEU(World world, int x, int y, int z)
	{
		TileEntityWire te = (TileEntityWire)world.getBlockTileEntity(x, y + 1, z);
		
		if((te.getHeldTEU() + this.heldTEU) <= te.getMaxHeldTEU())
		{
			te.setHeldTEU(te.getHeldTEU() + this.heldTEU);
			this.heldTEU = 0;
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		this.heldTEU = tag.getFloat("heldTEU");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag)
	{
		tag.setFloat("heldTEU", this.heldTEU);
	}
	
}
