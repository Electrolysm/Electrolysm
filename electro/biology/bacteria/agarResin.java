package mods.Electrolysm.electro.biology.bacteria;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class agarResin extends Item {

	public agarResin(int id) {
		super(id);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(electrolysmCore.TabElectrolysmBiology);
		this.setUnlocalizedName("agarResin");
	}

	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("Electrolysm:" + "agarResin");	
	}
}
