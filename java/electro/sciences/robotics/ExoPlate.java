package electro.sciences.robotics;

import net.minecraft.item.ItemArmor;
import electro.electrolysmCore;

public class ExoPlate extends ItemArmor
{
	
	public ExoPlate()
	{
		super(ArmorMaterial.DIAMOND, 0, 1);

		this.setUnlocalizedName("exoPlate");
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
	}

}
