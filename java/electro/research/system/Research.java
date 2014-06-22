package electro.research.system;

import electro.research.pointsSystem.Point;

public class Research 
{
	private static String researchName;
	private static EnumResearchType researchType;
	private static Point researchPoint;
	private static int researchTier;
    private static boolean hasImage;

    public Research(String name, EnumResearchType type, Point point, int tier)
    {
        this(name, type, point, tier, false);
    }

	public Research(String name, EnumResearchType type, Point point, int tier, boolean hasImage1)
	{
		researchName = name;
		researchPoint = point;
		researchType = type;
		researchTier = tier;
        hasImage = hasImage1;
	}

    public static boolean hasImage() { return hasImage; }

	public static String getName()
	{
		return researchName;
	}
	
	public static Point getPointValue()
	{
		return researchPoint;
	}
	
	public static EnumResearchType getType()
	{
		return researchType;
	}
	
	public static int getTier()
	{
		return researchTier;
	}
	

	@Override
	public String toString()
	{
		String string = "research_" + this.researchName;
		return string;
	}
	
	public String toAdvString()
	{
		String string = this.researchName + ":" + this.researchType.getName() + ":" + this.researchPoint.toString() + ":" + 
				this.researchTier + ":" + this.hasImage;
		return string;
	}
}