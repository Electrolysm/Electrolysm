package assets.electrolysm.electro;

import assets.electrolysm.api.specialFuel.FuelData;
import assets.electrolysm.api.specialFuel.IFuelStorage;
import assets.electrolysm.api.specialFuel.ISpecialFuel;
import assets.electrolysm.api.specialFuel.ItemFuel;
import assets.electrolysm.api.specialFuel.SpecialFuelHandler;

public class antiMatter extends ItemFuel implements IFuelStorage, ISpecialFuel {

	public antiMatter(int id) {
		super(id);
		
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setFuelData(SpecialFuelHandler.antiMatter);
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
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
