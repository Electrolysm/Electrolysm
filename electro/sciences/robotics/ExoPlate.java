package assets.electrolysm.electro.sciences.robotics;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import assets.electrolysm.electro.electrolysmCore;

public class ExoPlate extends ItemArmor
{
	
	public ExoPlate(int par1) 
	{
		super(par1, EnumArmorMaterial.DIAMOND, 0, 1);

		this.setUnlocalizedName("exoPlate");
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
	}

}
