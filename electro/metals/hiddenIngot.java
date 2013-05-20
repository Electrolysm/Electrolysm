package mods.electrolysm.electro.metals;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.electrolysm.electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class hiddenIngot extends Item {

	private static final String itemIDName = "hiddenIngot";

	public hiddenIngot(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	
	this.setMaxStackSize(64);
	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("electrolysm:" + itemIDName);	
	}
	
	@SideOnly(Side.CLIENT)

    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) 
    {
		Object whatUnlock = "What is this witch-craft?";
		par3List.add(whatUnlock );
    }
}
