package mods.Electrolysm.electro.advAtomics;

import java.util.List;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.electro.electrolysmCore;
import mods.Electrolysm.electro.metals.hiddenIngot;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class atomyBook extends Item {

	private static final String itemIDName = "atomyBook";

	public atomyBook(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	
	this.setUnlocalizedName(itemIDName);
	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.setMaxStackSize(1);

	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("electrolysm:" + itemIDName);	
	}

	
	//Do Stuff
		public boolean onItemUse(ItemStack is, EntityPlayer player, World w, int x, int y, int z, int l, float f, float f1, float f3){

	   
	        FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage("You haven't unlocked the periodic table yet. You have to unlock the periodic table first!");
	        
	    	
			return bFull3D;
		}
}