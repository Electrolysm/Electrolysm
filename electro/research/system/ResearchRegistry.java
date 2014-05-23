package assets.electrolysm.electro.research.system;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import assets.electrolysm.electro.research.pointsSystem.Point;

public class ResearchRegistry 
{
	public ResearchRegistry()
	{
		this.doRegister();
	}
	
	public void doRegister()
	{
		File folder = new File("mods/Electrolysm/");
		
		this.registerResearch(new Research("electrolysis", EnumResearchType.CHEMISTRY, new Point(13, 43), 4));
	}
	
	private static List<Research> researchMap = new ArrayList<Research>();
	
	public static void registerResearch(Research research)
	{
		researchMap.add(research);
	}
	
	public static List<Research> getResearchMap()
	{
		return researchMap;
	}
	
	public static Research[] getResearchMapAsArray()
	{
		return (Research[]) researchMap.toArray();
	}
	
	public static void bindResearchToText(Research research, File folder)
	{
		ResearchTextRegistry.addResearchTextFromFolder(research, folder);
	}
}
