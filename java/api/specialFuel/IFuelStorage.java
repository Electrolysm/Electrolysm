package api.specialFuel;

public interface IFuelStorage
{
	public boolean isFull(int meta);
	
	public boolean isUsingNegativeMeta();
}
