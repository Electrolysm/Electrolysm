package mods.Electrolysm.electro.physics.power.ingame;

import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class electWire extends Block {

	public electWire(int id, Material mat) {
		super(id, Material.cloth);
		// TODO Auto-generated constructor stub
	this.setCreativeTab(electrolysmCore.TabElectrolysmPhysics);
	}

}
