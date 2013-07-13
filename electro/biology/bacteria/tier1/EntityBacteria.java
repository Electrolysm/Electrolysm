package mods.Electrolysm.electro.biology.bacteria.tier1;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityBacteria extends Entity{

	public static String trate1;
	
	public EntityBacteria(World par1World) {
		super(par1World);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbt) {
		// TODO Auto-generated method stub
		this.trate1 = nbt.getString("Trate_1");
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbt) {
		// TODO Auto-generated method stub
		nbt.setString("Trate_1", bacteriaFuso1.trate1);
		
	}

}
