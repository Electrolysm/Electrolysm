package mods.Electrolysm.electro.biology.bacteria.tier1;

import java.awt.List;

import mods.Electrolysm.api.bacteria.BacteriaBaseClass;
import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class bacteriaFuso1 extends BacteriaBaseClass {

	public bacteriaFuso1(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(electrolysmCore.TabElectrolysmBiology);
		this.setUnlocalizedName("bacteriaBasic");
	}

	@SideOnly(Side.CLIENT)

    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) 
    {
		String whatIngot = "A strong metal, brilliant for armour!";
		par3List.add(whatIngot );
    }
	

}
