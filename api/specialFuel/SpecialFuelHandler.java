package assets.electrolysm.api.specialFuel;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.ItemStack;

public class SpecialFuelHandler {

	public static FuelData antiMatter = new FuelData("Antimatter", 1000, 0, 0, 4, true, 500);
	
	private static Map fuelList = new HashMap();
	private static Map fuelListRev = new HashMap();
	
	static 
	{
		registerFuelData(antiMatter);
	}
	
	public static boolean registerFuelData(FuelData data)
	{
		if(fuelList.get(fuelList.size()) == null)
		{
			fuelList.put(fuelList.size(), data);
			fuelListRev.put(data, fuelList.size());
			return true;
		}
		return false;
	}
	
	public static Map getFuelList()
	{
		return fuelList;
	}
	
	public static Map getFuelListRev()
	{
		return fuelListRev;
	}
	
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
