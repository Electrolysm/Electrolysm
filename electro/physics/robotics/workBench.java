package mods.Electrolysm.electro.physics.robotics;

import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class workBench extends Block {

	public workBench(int id, Material mat) {
		super(id, Material.iron);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(electrolysmCore.TabElectrolysmPhysics);
		this.setUnlocalizedName("workBench");
	}

}
