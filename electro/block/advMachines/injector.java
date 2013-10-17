package assets.electrolysm.electro.block.advMachines;

import net.minecraft.block.material.Material;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.api.MachineBaseClass;
import assets.electrolysm.electro.block.advMachines.te.TileEntityInjector;

public class injector extends MachineBaseClass {

	public injector(int id, Material mat) {
		super(id, Material.iron);

		this.unlocalName = "injector";
		this.displayName = "Injector";
		this.te = new TileEntityInjector();
	}

}
