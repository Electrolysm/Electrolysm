package mods.electrolysm.electro.world.metalOreDrops;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.electrolysm.electro.electrolysmCore;
import mods.electrolysm.electro.metals.hiddenIngot;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class copperDust extends Item {

	private static final String itemIDName = "copperDust";

	public copperDust(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	
	this.setUnlocalizedName(itemIDName);
	this.setCreativeTab(electrolysmCore.TabElectrolysm);

	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("electrolysm:" + itemIDName);	
	}

}