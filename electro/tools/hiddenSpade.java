package mods.Electrolysm.electro.tools;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraftforge.common.MinecraftForge;

public class hiddenSpade extends ItemSpade
{
  String name;

  public hiddenSpade(int par1)
  {
    super(par1, EnumToolMaterial.EMERALD);
    
    this.setCreativeTab(electrolysmCore.TabElectrolysm);
    this.setUnlocalizedName("hiddenSpade");
    MinecraftForge.setToolClass(this, "shovel", EnumToolMaterial.EMERALD.getMaxUses());
  }

  @Override
  @SideOnly(Side.CLIENT)
  public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("Electrolysm:" + "hiddenSpade");	
	}

  public String func_77667_c(ItemStack par1ItemStack)
  {
    return this.name;
  }


}