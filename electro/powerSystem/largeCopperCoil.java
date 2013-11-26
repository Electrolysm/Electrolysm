package assets.electrolysm.electro.powerSystem;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class largeCopperCoil extends Block {

	public largeCopperCoil(int id, Material mat) {
		super(id, Material.iron);
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("largeCopperCoil");
		this.setHardness(3F);
	}

}
