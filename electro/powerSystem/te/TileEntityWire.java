package assets.electrolysm.electro.powerSystem.te;

import net.minecraft.nbt.NBTTagCompound;
import assets.electrolysm.api.power.PowerConductor;

public class TileEntityWire extends PowerConductor{

	private String unitIDLong = "Tesselating Electrical Unit";
	private String unitIDShort = "Tesla Unit";
	
	public float heldTEU = 10;
	public int maxHeldTEU = 10;
	public boolean[] connections = new boolean[6];
	
	public void requestTEUFromSource()
	{
		
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
