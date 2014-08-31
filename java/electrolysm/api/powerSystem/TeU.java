package electrolysm.api.powerSystem;

public class TeU 
{
	private static int value;
	
	public TeU(int value1)
	{
		this.value = value1;
	}
	
	public static int getValue()
	{
		return value;
	}
	
	public static int setValue(int newValue)
	{
		value = newValue;
		return (value - newValue);
	}
	
	public static int incrementValue(int increment)
	{
		value = value + increment;
		return value;
	}
	
	public static int decrementValue(int decrement)
	{
		value = value - decrement;
		return value;
	}
}
