package mods.Electrolysm.electro.tools;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.electro.electrolysmCore;
import mods.Electrolysm.electro.data.data;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public class hiddenSword extends Item {


	
	public hiddenSword(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
		
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("hiddenSword");
	}

	//Do Stuff
	public boolean onItemUse(ItemStack is, EntityPlayer player, World w, int x, int y, int z, int l, float f, float f1, float f3){

    	player.setInvisible(true);
    	data.invisNo = 1;
		
    	if(data.randNo >= 90){
        	w.createExplosion(player, x, y, z, 10, true);
    	}
    	
		return bFull3D;
    	
	
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("electrolysm:" + "research");	
	}
}
