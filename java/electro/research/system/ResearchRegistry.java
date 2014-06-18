package electro.research.system;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import electro.research.pointsSystem.Point;
import net.minecraft.init.Blocks;

public class ResearchRegistry
{
	public ResearchRegistry(boolean doRegister)
	{
		if(doRegister)
		{
			//LoggerHandler.info("Registering research.");
			this.doRegister();
		}
	}

	EnumResearchType POWER = new EnumResearchType("power");
	EnumResearchType SCIENCE = new EnumResearchType("science");
	EnumResearchType RESEARCH = new EnumResearchType("research");
	EnumResearchType ROBOTICS = new EnumResearchType("robotics");
	EnumResearchType OTHER = new EnumResearchType("other");

	public void doRegister()
	{
		long time = System.currentTimeMillis();
		File folder = new File("config/Electrolysm/");

        //OTHER
        this.registerResearch(new Research("electrolysis", this.OTHER, new Point(13, 43), 4));
        this.registerResearch(new Research("smeltery", this.OTHER, new Point(7, 23), 2));
        this.registerResearch(new Research("crusher", this.OTHER, new Point(7, 12), 2));
        //ROBOTICS
        this.registerResearch(new Research("bionics", this.ROBOTICS, new Point(38, 90), 4));
        this.registerResearch(new Research("robotic_arm", this.ROBOTICS, new Point(38, 56), 3));
        this.registerResearch(new Research("hydrolics", this.ROBOTICS, new Point(35, 50), 3));
        this.registerResearch(new Research("AIs", this.ROBOTICS, new Point(13, 43), 4));
        this.registerResearch(new Research("upgrade", this.ROBOTICS, new Point(26, 34), 2));
        //UPGRADE - SUB - START
        this.registerResearch(new Research("upgrade_speed", this.ROBOTICS, new Point(12, 12), 2, this.getResearch("upgrade")));
        this.registerResearch(new Research("upgrade_AI", this.ROBOTICS, new Point(24, 24), 3, this.getResearch("upgrade")));
        this.registerResearch(new Research("upgrade_stack", this.ROBOTICS, new Point(12, 12), 2, this.getResearch("upgrade")));
        //UPGRADE - SUB - END
        this.registerResearch(new Research("computing", this.ROBOTICS, new Point(13, 63), 2));
        //RESEARCH
        this.registerResearch(new Research("mass_spec", this.RESEARCH, new Point(6, 49), 3));
        this.registerResearch(new Research("chromography", this.RESEARCH, new Point(2, 13), 1));
        this.registerResearch(new Research("point_gen", this.RESEARCH, new Point(39, 63), 4));
        //SCIENCE
        this.registerResearch(new Research("holograms", this.SCIENCE, new Point(13, 63), 3));
        this.registerResearch(new Research("genetics", this.SCIENCE, new Point(13, 86), 3));
        this.registerResearch(new Research("LHC", this.SCIENCE, new Point(86, 142), 4));
        this.registerResearch(new Research("elements", this.SCIENCE, new Point(3, 13), 2));
        //ELEMENT - SUB - START
        this.registerResearch(new Research("elements_carbon_comp", this.SCIENCE, new Point(63, 113), 4, this.getResearch("elements")));
        this.registerResearch(new Research("elements_bonds", this.SCIENCE, new Point(6, 23), 2, this.getResearch("elements")));
        this.registerResearch(new Research("elements_alloys", this.SCIENCE, new Point(12, 25), 2, this.getResearch("elements")));
        //ELEMENT - SUB - END
        this.registerResearch(new Research("phytomining", this.SCIENCE, new Point(3, 16), 2));
        //POWER
        this.registerResearch("storage", new Research("storage", this.POWER, new Point(23, 24), 2));
        this.registerResearch(new Research("tesla_tower", this.POWER, new Point(36, 65), 3));
        this.registerResearch("antimatter_gen", new Research("antimatter_gen", this.POWER, new Point(93, 149), 4));

		//Binding of text and research still has to be done!

		this.bindRequirementToResearch(new Requirement(new Block[]{Blocks.dirt}), this.getResearch("mass_spec"));

		long duration = (System.currentTimeMillis() - time);
        //LoggerHandler.info("Research registry completed in " + duration + "ms");
        System.out.println(requireMap.get((this.getResearch("mass_spec")).toAdvString()));
        //System.exit(0);
	}

	private HashMap<String, String> researchMap = new HashMap<String, String>();
	private HashMap<String, String> requireMap = new HashMap<String, String>();
    private HashMap<String, String> requireMapRev = new HashMap<String, String>();

    public void bindRequirementToResearch(Requirement req, Research research)
    {
        this.requireMap.put(research.toAdvString(), req.toString());
        this.requireMapRev.put(req.toString(), research.toAdvString());
    }

	public void registerResearch(Research research)
	{
		researchMap.put(research.getName(), research.toAdvString());
	}

    private void registerResearch(String string, Research research)
    {
		researchMap.put(string, research.toAdvString());
	}

	public Research getResearch(String name)
	{
		Research research  = this.getResearchFromString(researchMap.get(name));
		return research;
	}

	private Research getResearchFromString(String string)
	{
		if(string == null)
		{
			return null;
		}
		String[] details = string.split(":");
		if(details.length != 5)
		{
			return null;
		}

		String name = details[0];
		String type = details[1];
		int engPoint = Integer.parseInt(String.valueOf(details[2].split("--")[0]));
		int sciPoint = Integer.parseInt(String.valueOf(details[2].split("--")[1]));
		int tier = Integer.parseInt(String.valueOf(details[3]));
		String reliant = String.valueOf(details[4]);
		Research reliantR;
		EnumResearchType typeE = this.getEnumFromString(type);

		if(details[4].contains(":null") || details[4] == null)
		{
			return new Research(name, typeE, new Point(engPoint, sciPoint), tier);
		}
		else
		{
			reliantR = this.getResearchFromString(reliant);
			return new Research(name, typeE, new Point(engPoint, sciPoint), tier, reliantR);
		}
	}

	private EnumResearchType getEnumFromString(String type)
	{
		HashMap<String, EnumResearchType> hashMap = EnumResearchType.getHashMap();

		for(int i = 0; i < hashMap.size(); i++)
		{
			if(hashMap.get(type) != null)
			{
				return hashMap.get(type);
			}
		}
		return null;
	}

	public boolean doesNameSubResearch(String name)
	{
		Research research = this.getResearch(name);
		
		if(research.getReliant() != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Research getSubResearchForName(String name)
	{
		if(doesNameSubResearch(name))
		{
			Research research = this.getResearch(name);
			
			if(research.getReliant() != null)
			{
				return research.getReliant();
			}
			else
			{
				return null;
			}
		}
		
		return null;
	}
	
	
	public HashMap<String, String> getResearchMap()
	{
		return this.researchMap;
	}
	
	public void bindResearchToText(String name, File folder)
	{
		if(this.getResearch(name) != null)
		{
			ResearchTextRegistry.addResearchTextFromFolder(this.getResearch(name), folder);
			System.out.println("binded");
		}
		else
		{
			
		}
	}
}
