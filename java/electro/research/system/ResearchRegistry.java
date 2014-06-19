package electro.research.system;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import api.LoggerHandler;
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
			LoggerHandler.info("Registering research.");
			this.doRegister();
		}
	}

	EnumResearchType POWER = new EnumResearchType("power");
	EnumResearchType METALS_AND_ELEMENTS = new EnumResearchType("metals and elements ");
	EnumResearchType RESEARCH = new EnumResearchType("research");
	EnumResearchType ROBOTICS = new EnumResearchType("robotics");
	EnumResearchType MACHINES = new EnumResearchType("machines");

	public void doRegister()
	{
		long time = System.currentTimeMillis();
		File folder = new File("config/Electrolysm/");

		//Power
        this.registerResearch(new Research("basic_storage", this.POWER, new Point(10,7 ), 1));
        this.registerResearch(new Research("advanced_storage", this.POWER, new Point (25,18), 2, this.getResearch("basic_storage")));
        this.registerResearch(new Research("experimental_stoage", this.POWER, new Point (40, 32), 3, this.getResearch("advanced_storage")));
        this.registerResearch(new Research("tesla_tower", this.POWER, new Point(60,52 ), 4, this.getResearch("experimental_storage")));
        this.registerResearch(new Research("battery", this.POWER, new Point(15,11), 2, this.getResearch("basic_storage")));
        this.registerResearch(new Research("advanced_battery", this.POWER, new Point(27, 20), 3, this.getResearch("battery")));
        this.registerResearch(new Research("improved_coal", this.POWER, new Point(16,24), 2));
        this.registerResearch(new Research("improved_coal_generator", this.POWER, new Point(20, 11), 2));
        this.registerResearch(new Research("experimental_coal_generator", this.POWER, new Point(32, 20), 3, this.getResearch("improved_coal_generator")));
        this.registerResearch(new Research("antimatter_generator", this.POWER, new Point(90, 82), 4));
        this.registerResearch(new Research("thermal_generator", this.POWER, new Point(34, 24), 3, this.getResearch("improved_coal_generator")));
		this.registerResearch(new Research("improved_thermal_generator", this.POWER, new Point(45, 34), 4, this.getResearch("thermal_generator")));
		this.registerResearch(new Research("bio_generator", this.POWER, new Point (32, 26), 3, this.getResearch("improved_coal_generator")));
		this.registerResearch(new Research("improved_bio_generator", this.POWER, new Point (42, 37), 4, this.getResearch("bio_generator")));
		this.registerResearch(new Research("solar_panel", this.POWER, new Point(34, 37), 3, this.getResearch("improved_coal_generator")));
		this.registerResearch(new Research("improved_solar_panel", this.POWER, new Point(47, 53), 4, this.getResearch("solar_panel")));
		this.registerResearch(new Research("turbine", this.POWER, new Point(38,30), 3, this.getResearch("improved_coal_generator"))); 
		this.registerResearch(new Research("improved_turbine", this.POWER, new Point(54, 45), 4, this.getResearch("turbine")));
		this.registerResearch(new Research("advanced_cable", this.POWER, new Point(28, 19), 2));
		this.registerResearch(new Research("experimental_cable", this.POWER, new Point(42,37), 3, this.getResearch("advanced_cable")));
		//Metals And Elements
		this.registerResearch(new Research("fractional_distillation", this.METALS_AND_ELEMENTS, new Point(10, 15), 1));
		this.registerResearch(new Research("plastic", this.METALS_AND_ELEMENTS, new Point(19,15), 2, this.getResearch("fractional_distillation")));
		this.registerResearch(new Research("bio_fuel", this.METALS_AND_ELEMENTS, new Point(25,32), 2, this.getResearch("fractional_distillation")));
		this.registerResearch(new Research("improved_coal", this.METALS_AND_ELEMENTS, new Point(16,24), 2));
		
		
		//Binding of text and research still has to be done!

        try {
            this.bindRequirementToResearch(new Requirement(new Block[]{Blocks.stone}), this.getResearch("plastic"));
        }
        catch (Exception e) { e.printStackTrace(); }

		long duration = (System.currentTimeMillis() - time);
        //LoggerHandler.info("Research registry completed in " + duration + "ms");
//        System.out.println(requireMap.get((this.getResearch("mass_spec")).toAdvString()));
        //System.exit(0);
	}

	private static HashMap<String, String> researchMap = new HashMap<String, String>();
	private static HashMap<String, String> requireMap = new HashMap<String, String>();
    private static HashMap<String, String> requireMapRev = new HashMap<String, String>();

    public void bindRequirementToResearch(Requirement req, Research research) throws Exception
    {
        if(research != null && req != null) {
            this.requireMap.put(research.toAdvString(), req.toString());
            this.requireMapRev.put(req.toString(), research.toAdvString());
        }
        else
        {
            if(research == null) {
                throw new Exception("Research, when binding requirement equals 'null'...");
            }
            else
            {
                throw new Exception("Requirement, when binding requirement equals 'null'...");
            }
        }
    }

    public static HashMap<String, String> getRequireMap() { return requireMap; }

    public void registerResearch(Research research)
	{
		researchMap.put(research.getName(), research.toAdvString());
	}

    private void registerResearch(String string, Research research)
    {
		researchMap.put(string, research.toAdvString());
	}

	public static Research getResearch(String name)
	{
		Research research  = getResearchFromString(researchMap.get(name));
		return research;
	}

	private static Research getResearchFromString(String string)
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
		EnumResearchType typeE = getEnumFromString(type);

		if(details[4].contains(":null") || details[4] == null)
		{
			return new Research(name, typeE, new Point(engPoint, sciPoint), tier);
		}
		else
		{
			reliantR = getResearchFromString(reliant);
			return new Research(name, typeE, new Point(engPoint, sciPoint), tier, reliantR);
		}
	}

	private static EnumResearchType getEnumFromString(String type)
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
	
	
	public static HashMap<String, String> getResearchMap()
	{
		return researchMap;
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

    public static String[] getRequirementsFromStringAsArray(String requireString)
    {
        String[] array = requireString.split(":");

        return array;
    }

}
