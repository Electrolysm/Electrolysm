package mods.Electrolysm.electro.physics;

import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class reConcrete extends Block {

	public reConcrete(int id, Material mat) {
		super(id, Material.iron);
		this.setHardness(12);
		this.setResistance(30);
		this.setCreativeTab(electrolysmCore.TabElectrolysmPhysics);
		this.setUnlocalizedName("reConcrete");
	}
	
	@Override
	public void registerIcons(IconRegister reg)
	{
			this.blockIcon = reg.registerIcon("Electrolysm:" + this.getUnlocalizedName().replace("tile.", ""));
	}

}
