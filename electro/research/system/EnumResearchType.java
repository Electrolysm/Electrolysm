package assets.electrolysm.electro.research.system;

public enum EnumResearchType 
{
	CHEMISTRY("chemistry"),
	PHYSICS("physics"),
	BIOLOGY("biology"),
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
