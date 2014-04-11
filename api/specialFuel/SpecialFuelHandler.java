package assets.electrolysm.api.specialFuel;

import assets.electrolysm.api.items.Fetcher;
import net.minecraft.item.ItemStack;

public class SpecialFuelHandler {

	public static FuelData antiMatter = new FuelData(2400, 0, 0, 4, true, 500);
	
	
	public static FuelData getFuelData(ItemStack itemStack) 
	{
		if(itemStack != null && itemStack.getItem() instanceof ItemFuel)
		{
			return ((ItemFuel)itemStack.getItem()).getFuelData();
		}
		else if(itemStack != null && itemStack.getItem() instanceof IFuelStorage)
		{
			if(((IFuelStorage)itemStack.getItem()).isFull())
			{
				return ((IFuelStorage)itemStack.getItem()).getFuelData();
			}
		}
			
		return null;
	}

}
