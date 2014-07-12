package electro.sciences;

import electro.Electrolysm;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArmorLab extends ItemArmor {

	public ItemArmorLab(int piece, String unlocalName) {
		super(ArmorMaterial.CLOTH, 0, piece);
		
		this.setMaxStackSize(1);
		this.setCreativeTab(Electrolysm.TabElectrolysm);
		this.setUnlocalizedName(unlocalName);
	}

    @Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return ("electrolysm:" + "textures/models/armor/labCoat.png");
	}
}
