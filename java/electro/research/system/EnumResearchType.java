package electro.research.system;

import java.util.HashMap;

public class EnumResearchType 
{
	private String name;
	private static HashMap<String, EnumResearchType> hashMap = new HashMap<String, EnumResearchType>(); 
	
	public EnumResearchType(String type1)
	{
		name = type1;
		hashMap.put(type1, this);
	}

	public static HashMap<String, EnumResearchType> getHashMap()
	{
		return hashMap;
	}
	
	public String getName()
	{	
		return this.name;
	}
}
