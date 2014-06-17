package assets.electrolysm.api.specialFuel;

import net.minecraft.item.Item;

public class ItemFuel extends Item implements ISpecialFuel{

	protected FuelData fuelData = null;
	
	public ItemFuel(int id) 
	{
		super(id);
	}

	@Override
	public FuelData getFuelData() 
	{
		return this.fuelData;
	}

	@Override
	public void setFuelData(FuelData data) 
	{
		this.fuelData = data;
	}

	
	
}
