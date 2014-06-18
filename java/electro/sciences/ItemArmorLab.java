package electro.sciences;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import electro.electrolysmCore;

public class ItemArmorLab extends ItemArmor {

	public ItemArmorLab(int piece, String unlocalName) {
		super(ArmorMaterial.CLOTH, 0, piece);
		
		this.setMaxStackSize(1);
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName(unlocalName);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		return ("electrolysm:" + "textures/models/armor/labCoat.png");
	}
}
