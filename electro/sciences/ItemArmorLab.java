package assets.electrolysm.electro.sciences;

import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import assets.electrolysm.electro.electrolysmCore;

public class ItemArmorLab extends ItemArmor {

	public ItemArmorLab(int par1, int piece, String unlocalName) {
		super(par1, EnumArmorMaterial.CLOTH, 0, piece);
		
		this.setMaxStackSize(1);
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName(unlocalName);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		return ("electrolysm:" + "textures/models/armor/labCoat.png");
	}
}
