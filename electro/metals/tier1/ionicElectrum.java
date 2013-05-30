package mods.Electrolysm.electro.metals.tier1;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ionicElectrum extends Item {

	private static final String itemIDName = "ionicElectrum";

	public ionicElectrum(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	
	this.setMaxStackSize(64);
	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.setUnlocalizedName(itemIDName);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("Electrolysm:" + itemIDName);	
	}
	
	@SideOnly(Side.CLIENT)

    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) 
    {
		Object whatIngot = "A strong metal, brilliant for armour!";
		par3List.add(whatIngot );
    }
}
