package assets.electrolysm.electro.research.pointsSystem;

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

	public Point divideByProducedSize(ItemStack stack) 
	{
		if(stack != null)
		{
			int stackSize = stack.stackSize;
			System.out.println(stackSize);
			
			if(stackSize > 0)
			{
				int engValue = this.getEngPoint().getValue();
				int sciValue = this.getSciPoint().getValue();
				
				int engDivide = (int)(engValue / stackSize);
				int sciDivide = (int)(sciValue / stackSize);
				
				EngPoint engPoint1 = new EngPoint(engDivide);
				SciPoint sciPoint1 = (new SciPoint(sciDivide));
				
				this.setEngPoint(engPoint1);
				this.setSciPoint(sciPoint1);
		
				return new Point(engPoint1, sciPoint1);
			}
			else
			{
				String message = "Cannot divide point by stackSize Specified";
				LoggerHandler.severe(message);
				return this;
			}
		}
		return this;
	}
}
