package mods.Electrolysm.electro.physics.parts;

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

public class glassLens extends Item {

	private static final String itemIDName = "glassLens";

	public glassLens(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	
	this.setUnlocalizedName(itemIDName);
	this.setCreativeTab(electrolysmCore.TabElectrolysmPhysics);
	this.setMaxStackSize(16);

	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("Electrolysm:" + itemIDName);	
	}
}