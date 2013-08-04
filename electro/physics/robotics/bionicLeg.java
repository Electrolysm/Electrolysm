package mods.Electrolysm.electro.physics.robotics;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class bionicLeg extends Item {

	public bionicLeg(int id) {
		super(id);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setUnlocalizedName("bionicLeg");
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("Electrolysm:" + this.getUnlocalizedName().replace("item.", ""));	
	}

}
