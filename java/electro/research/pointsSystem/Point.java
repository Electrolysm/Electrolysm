package electro.research.pointsSystem;

import net.minecraft.item.ItemStack;
import assets.electrolysm.api.LoggerHandler;

public class Point 
{
	private static EngPoint engPoint;
	private static SciPoint sciPoint;
	
	public Point(EngPoint engPoint1, SciPoint sciPoint1)
	{
		this.engPoint = engPoint1;
		this.sciPoint = sciPoint1;
	}
	
	public Point(int engPoint1, int sciPoint1)
	{
		this.engPoint = new EngPoint(engPoint1);
		this.sciPoint = new SciPoint(sciPoint1);
	}
	
	public static EngPoint getEngPoint()
	{
		return engPoint;
	}
	
	public static void setEngPoint(EngPoint engPoint1)
	{
		engPoint = engPoint1;
	}
	
	public static void setSciPoint(SciPoint sciPoint1)
	{
		sciPoint = sciPoint1;
	}
	
	public static SciPoint getSciPoint()
	{
		return sciPoint;
	}
	
	@Override
	public String toString()
	{
		return this.engPoint.getValue() + "--" + this.engPoint.getValue();
	}
}
