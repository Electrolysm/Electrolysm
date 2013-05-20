package mods.electrolysm.electro.learning;

import java.util.List;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.electrolysm.electro.electrolysmCore;
import mods.electrolysm.electro.data.VersionData;
import mods.electrolysm.electro.data.data;
import mods.electrolysm.electro.metals.hiddenIngot;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class matterResearch extends Item {

	private static final String itemIDName = "matterResearch";

	public matterResearch(int par1) {
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
	
	//Name Changer
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
    	if(data.hiddenMatterFound < 1){
    		data.hiddenMatterFound = data.hiddenMatterFound + 1;
			FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage("ResearchText" + data.hiddenMatterFound);
    	}
    	return par1ItemStack;

    }
}