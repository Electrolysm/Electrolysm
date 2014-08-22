package electro.sciences.robotics;

import electro.Electrolysm;
import net.minecraft.item.ItemArmor;

public class ExoPlate extends ItemArmor
{
	
	public ExoPlate()
	{
		super(ArmorMaterial.DIAMOND, 0, 1);

		this.setUnlocalizedName("exoPlate");
		this.setCreativeTab(Electrolysm.TabElectrolysm);
	}

}
