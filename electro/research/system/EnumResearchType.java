package assets.electrolysm.electro.research.system;

public enum EnumResearchType 
{
	POWER("power"),
	SCIENCE("science"),
	RESEARCH("research"),
	ROBOTICS("robotics"),
	OTHER("other");

	private String name;
	
	private EnumResearchType(String type1)
	{
		name = type1;
	}
	
	public String getName()
	{	
		return this.name;
	}
}
