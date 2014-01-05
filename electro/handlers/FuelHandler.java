package assets.electrolysm.electro.handlers;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel)
	{
		int id = fuel.itemID;
		if(id == electrolysmCore.sulphur.itemID)
		{
			return 200;
		}
		else
		{
			return 0;
		}
	}

}
