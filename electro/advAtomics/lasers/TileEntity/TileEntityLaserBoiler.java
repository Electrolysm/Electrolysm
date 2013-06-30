package mods.Electrolysm.electro.advAtomics.lasers.TileEntity;

import ic2.api.Direction;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergySource;
import cpw.mods.fml.client.FMLClientHandler;
import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class TileEntityLaserBoiler extends TileEntity implements IEnergySource{

	public static boolean canProduce;
	public static int ticksOn;
	public static int powerOutput;
	public static int secsOn;
	public static int minsOn;
	
	public void updateEntity() {
		canProduce = worldObj.getBlockId(xCoord + 1, yCoord, zCoord) == electrolysmCore.laserAmp.blockID;
	
		  MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));

	}
	



	@Override
	public boolean emitsEnergyTo(TileEntity receiver, Direction direction) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAddedToEnergyNet() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getMaxEnergyOutput() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}
}
