package assets.electrolysm.electro.powerSystem.te;

import assets.electrolysm.electro.api.power.PowerConductor;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityWire extends PowerConductor{

	private String unitIDLong = "Tesselating Electrical Unit";
	private String unitIDShort = "Tesla Unit";
	
    public void updateEntity() 
    {
		this.maxHeldTEU = 500;
    }
}
