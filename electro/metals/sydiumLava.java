package mods.Electrolysm.electro.metals;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class sydiumLava extends Item {

	private static final String itemIDName = "sydiumLava";

	public sydiumLava(int par1) {
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
	//Transmutation
    public boolean onItemUse(ItemStack is, EntityPlayer player, World w, int x, int y, int z, int l, float f, float f1, float f3){
    	if (!player.capabilities.isCreativeMode)
        {
            --is.stackSize;
        }

    	w.createExplosion(player, x, y, z, 10, true);
    	player.setFire(20);
		
    	return bFull3D;

    }


}


