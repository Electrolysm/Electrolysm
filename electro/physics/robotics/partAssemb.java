package mods.Electrolysm.electro.physics.robotics;

import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class partAssemb extends Block {

	public partAssemb(int id, Material mat) {
		super(id, Material.iron);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(electrolysmCore.TabElectrolysmPhysics);
		this.setUnlocalizedName("partAssemb");
	}

}
