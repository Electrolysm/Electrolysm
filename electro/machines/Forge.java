package mods.Electrolysm.electro.machines;

import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class Forge extends Block {

	public Forge(int par1, Material par2Material) {
		super(par1, Material.iron);
		// TODO Auto-generated constructor stub
	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.setUnlocalizedName("Forge");
	}
	
	
	
	@Override
	public void registerIcons(IconRegister reg)
	{
			this.blockIcon = reg.registerIcon("Electrolysm:Forge");
	}	

}