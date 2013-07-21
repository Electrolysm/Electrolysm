package mods.Electrolysm.electro.basic.tools;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraftforge.common.MinecraftForge;

public class hiddenAxe extends ItemAxe
{
  String name;

  public hiddenAxe(int par1)
  {
    super(par1, EnumToolMaterial.EMERALD);
    
    this.setCreativeTab(electrolysmCore.TabElectrolysm);
    this.setUnlocalizedName("hiddenAxe");
    MinecraftForge.setToolClass(this, "axe", EnumToolMaterial.EMERALD.getMaxUses());
  }

  @Override
  @SideOnly(Side.CLIENT)
  public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("Electrolysm:" + "hiddenAxe");	
	}

  public String func_77667_c(ItemStack par1ItemStack)
  {
    return this.name;
  }


}