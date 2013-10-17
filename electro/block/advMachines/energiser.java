package assets.electrolysm.electro.block.advMachines;

import net.minecraft.block.material.Material;
import assets.electrolysm.electro.api.MachineBaseClass;
import assets.electrolysm.electro.block.advMachines.te.TileEntityEnergiser;

public class energiser extends MachineBaseClass {

	public energiser(int id, Material mat) {
		super(id, mat);
		
		this.unlocalName = "fluidEnergiser";
		this.displayName = "Fluid Energiser";
		this.te = new TileEntityEnergiser();
	}

}
