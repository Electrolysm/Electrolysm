package mods.Electrolysm.electro.basic.research;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class RNNano extends Item {

	public String nameBefore = "research." + this.getClass();
	public String name = nameBefore.replace("research.class mods.Electrolysm.electro.basic.research.", "");
	
	public RNNano(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.setUnlocalizedName(name);
	}

	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("Electrolysm:" + "research");	
	}
}
