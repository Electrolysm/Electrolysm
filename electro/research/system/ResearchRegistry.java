package assets.electrolysm.electro.research.system;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.material.Material;
import assets.electrolysm.api.LoggerHandler;
import assets.electrolysm.electro.research.pointsSystem.Point;

public class ResearchRegistry 
{
	public ResearchRegistry(boolean doRegister)
	{
		if(doRegister)
		{
			LoggerHandler.info("Registering research.");
			this.doRegister();
		}
	}
	
	public void doRegister()
	{
		long time = System.currentTimeMillis();
		File folder = new File("config/Electrolysm/");
		
		//OTHER
		this.registerResearch(new Research("electrolysis", EnumResearchType.OTHER, new Point(13, 43), 4));
		this.registerResearch(new Research("smeltery", EnumResearchType.OTHER, new Point(7, 23), 2));
		this.registerResearch(new Research("crusher", EnumResearchType.OTHER, new Point(7, 12), 2));
		//ROBOTICS
		this.registerResearch(new Research("bionics", EnumResearchType.ROBOTICS, new Point(38, 90), 4));
		this.registerResearch(new Research("robotic_arm", EnumResearchType.ROBOTICS, new Point(38, 56), 3));
		this.registerResearch(new Research("hydrolics", EnumResearchType.ROBOTICS, new Point(35, 50), 3));
		this.registerResearch(new Research("AIs", EnumResearchType.ROBOTICS, new Point(13, 43), 4));
		this.registerResearch(new Research("upgrade", EnumResearchType.ROBOTICS, new Point(26, 34), 2));
		//UPGRADE - SUB - START
		this.registerResearch(new Research("upgrade_speed", EnumResearchType.ROBOTICS, new Point(12, 12), 2, this.getResearchWithName("upgrade")));
		this.registerResearch(new Research("upgrade_AI", EnumResearchType.ROBOTICS, new Point(24, 24), 3, this.getResearchWithName("upgrade")));
		this.registerResearch(new Research("upgrade_stack", EnumResearchType.ROBOTICS, new Point(12, 12), 2, this.getResearchWithName("upgrade")));
		//UPGRADE - SUB - END
		this.registerResearch(new Research("computing", EnumResearchType.ROBOTICS, new Point(13, 63), 2));
		//RESEARCH
		this.registerResearch(new Research("mass_spec", EnumResearchType.RESEARCH, new Point(6, 49), 3));
		this.registerResearch(new Research("chromography", EnumResearchType.RESEARCH, new Point(2, 13), 1));
		this.registerResearch(new Research("point_gen", EnumResearchType.RESEARCH, new Point(39, 63), 4));
		//SCIENCE
		this.registerResearch(new Research("holograms", EnumResearchType.SCIENCE, new Point(13, 63), 3));
		this.registerResearch(new Research("genetics", EnumResearchType.SCIENCE, new Point(13, 86), 3));
		this.registerResearch(new Research("LHC", EnumResearchType.SCIENCE, new Point(86, 142), 4));
		this.registerResearch(new Research("elements", EnumResearchType.SCIENCE, new Point(3, 13), 2));
		//ELEMENT - SUB - START
		this.registerResearch(new Research("elements_carbon_comp", EnumResearchType.SCIENCE, new Point(63, 113), 4, this.getResearchWithName("elements")));
		this.registerResearch(new Research("elements_bonds", EnumResearchType.SCIENCE, new Point(6, 23), 2, this.getResearchWithName("elements")));
		this.registerResearch(new Research("elements_alloys", EnumResearchType.SCIENCE, new Point(12, 25), 2, this.getResearchWithName("elements")));
		//ELEMENT - SUB - END
		this.registerResearch(new Research("phytomining", EnumResearchType.SCIENCE, new Point(3, 16), 2));
		//POWER
		this.registerResearch(new Research("starage", EnumResearchType.POWER, new Point(23, 24), 2));
		this.registerResearch(new Research("tesla_tower", EnumResearchType.POWER, new Point(36, 65), 3));
		this.registerResearch(new Research("antimatter_gen", EnumResearchType.POWER, new Point(93, 149), 4));

		/*
		for(int i = 0; i < this.getResearchMap().size(); i++)
		{
			if(this.getResearchMap().get(i) != null)
			{
				this.bindResearchToText(this.getResearchMap().get(i), folder);
			}
		}*/
		
		this.linkScanRequirementToResearch(new Requirement(new Material[]{Material.iron}), this.getResearchWithName("mass_spec"));
		
		long duration = (System.currentTimeMillis() - time);
        LoggerHandler.info("Research registry completed in " + duration + "ms");
	}
	
	private static Research[] researchMap = new Research[100];
	private static HashMap<Requirement, Research> requireMap = new HashMap<Requirement, Research>();
	private static HashMap<Research, Requirement> requireMapRev = new HashMap<Research, Requirement>();

	public static void registerResearch(Research research)
	{
		researchMap[researchMap.length] = research;
	}
	
	public static void linkScanRequirementToResearch(Requirement require, Research research)
	{
		requireMap.put(require, research);
		requireMapRev.put(research, require);
	}
	
	public static Research getResearchWithName(String name)
	{/*
		Research research = null;
		
		for(int i = 0; i < getResearchMap().size(); i++)
		{
			if(getResearchMap().get(i).getName() == name)
			{
				research = getResearchMap().get(10);
			}
		}*/
		
		return getResearchMap()[10];
	}
	
	public static Research[] getResearchMap()
	{
		return (Research[]) researchMap;
	}
	
	public static void bindResearchToText(Research research, File folder)
	{
		ResearchTextRegistry.addResearchTextFromFolder(research, folder);
	}
}
