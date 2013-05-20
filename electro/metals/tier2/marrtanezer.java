package mods.electrolysm.electro.metals.tier2;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.electrolysm.electro.electrolysmCore;
import mods.electrolysm.electro.metals.hiddenIngot;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class marrtanezer extends hiddenIngot {

	private static final String itemIDName = "marrtanezer";

	public marrtanezer(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	
	this.setUnlocalizedName(itemIDName);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("electrolysm:" + itemIDName);	
	}
	
	@SideOnly(Side.CLIENT)

    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) 
    {
		Object whatIngot = "An unstable, posionous and heavy metal";
		par3List.add(whatIngot );
    }
}
