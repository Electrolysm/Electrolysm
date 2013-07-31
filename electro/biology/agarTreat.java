package mods.Electrolysm.electro.biology;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.electro.electrolysmCore;
import mods.Electrolysm.electro.basic.handlers.data;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class agarTreat extends ItemFood {

	public agarTreat(int id, int food, float sat, boolean wolf) {
		super(id, food, sat, wolf);
		// TODO Auto-generated constructor stub
		this.setAlwaysEdible();
		this.setCreativeTab(electrolysmCore.TabElectrolysmBiology);
		this.setUnlocalizedName("agarTreat");

	}
	
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
    {
    	((EntityLiving)player).addPotionEffect(new PotionEffect(Potion.jump.getId(), 250, 5));
    	((EntityLiving)player).addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 250, 5));
    	((EntityLiving)player).addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 250, 100));

		return stack;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("Electrolysm:" + "agarTreat");	
	}

}
