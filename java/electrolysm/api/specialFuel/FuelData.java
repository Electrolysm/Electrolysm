package electrolysm.api.specialFuel;

public class FuelData implements Comparable<FuelData>
{
	private String name;
	private int burnTime;
	private int pollution;
	private int flamability;
	private int tier;
	private boolean explosive;
	private int explosiveRadius;

	public FuelData(String name1, int burnTime1, int pollution1, int flamabilty1, int tier1, boolean explosive1)
	{
		this.name = name1;
		this.burnTime = burnTime1;
		this.pollution = pollution1;
		this.flamability = flamabilty1;
		this.tier = tier1;
		this.explosive = explosive1;
		this.explosiveRadius = ((flamability * (burnTime / 100)) * tier);
	}
	
	public FuelData(String name1, int burnTime1, int pollution1, int flamabilty1, int tier1, boolean explosive1, int radius)
	{
		this.name = name1;
		this.burnTime = burnTime1;
		this.pollution = pollution1;
		this.flamability = flamabilty1;
		this.tier = tier1;
		this.explosive = explosive1;
		this.explosiveRadius = radius;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getBurnTime()
	{
		return this.burnTime;
	}
	
	public int getPollution()
	{
		return this.pollution;
	}
	
	public int getFlamability()
	{
		return this.flamability;
	}
	
	public int getTier()
	{
		return this.tier;
	}
	
	public boolean getExplosive()
	{
		return this.explosive;
	}
	
	public int getExplosiveRadius()
	{
		if(this.explosive)
		{
			return this.explosiveRadius;
		}
		else
		{
			return 0;
		}
	}
	
	public void setName(String name1)
	{
		this.name = name1;
	}
	
	public void setBurnTime(int time)
	{
		this.burnTime = time;
	}
	
	public void setPollution(int pol)
	{
		this.pollution = pol;
	}
	
	public void setFlamability(int flam)
	{
		this.flamability = flam;
	}
	
	public void setTier(int tier)
	{
		this.tier = tier;
	}
	
	public void setExplosive(boolean exp)
	{
		this.explosive = exp;
	}
	
	public void setExplosiveRadius(int radius)
	{
		this.explosiveRadius = radius;
	}
	
	/**
	 *  @param data to compare to
	 *  @return will return 0 if the 2 fuels are the same else will return -1
	 */
	@Override
	public int compareTo(FuelData data) 
	{
		if(data != null)
		{
			if(this.burnTime == data.burnTime && this.pollution == data.pollution && this.flamability == data.flamability
					&& this.tier == data.tier && this.explosive == data.explosive)
			{
				return 0;
			}
				
		}
		return -1;
	}
	
	@Override
	public String toString()
	{
		return "Fuel Data Report:" + "Name - " + this.name + ": Burn Time - " + this.burnTime + ": Pollution - " + this.pollution 
				+ ": Flamability - " + this.flamability + ": Tier - " + this.tier 
				+ ": Explosive - " + this.explosive;
	}

}
