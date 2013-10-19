package assets.electrolysm.electro.block.advMachines.te;

import ic2.api.energy.tile.IEnergySink;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityQuantumComp extends TileEntity implements IEnergySink {

	
	public void running()
	{
	
	}

	@Override
	public boolean acceptsEnergyFrom(TileEntity emitter,
			ForgeDirection direction) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public double demandedEnergyUnits() {
		// TODO Auto-generated method stub
		return 160;
	}

	@Override
	public double injectEnergyUnits(ForgeDirection directionFrom, double amount) {
		// TODO Auto-generated method stub
		return 160;
	}

	@Override
	public int getMaxSafeInput() {
		// TODO Auto-generated method stub
		return 100000;
	}
}
