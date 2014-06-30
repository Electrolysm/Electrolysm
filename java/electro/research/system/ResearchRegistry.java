package electro.research.system;

import java.io.File;
import java.util.*;

import api.LoggerHandler;
import electro.Electrolysm;
import electro.research.common.SavePlayerScanData;
import net.minecraft.block.Block;
import electro.research.pointsSystem.Point;
import net.minecraft.init.Blocks;

public class ResearchRegistry
{
	public ResearchRegistry(boolean doRegister)
	{
		if(doRegister)
		{/*
            researchMap.clear();
            requireMap.clear();
            requireMapRev.clear();*/

			LoggerHandler.info("Registering research.");
			this.doRegister();
		}
	}

	EnumResearchType POWER = new EnumResearchType("power");
	EnumResearchType METALS_AND_ELEMENTS = new EnumResearchType("metals_and_elements");
	EnumResearchType RESEARCH = new EnumResearchType("research");
	EnumResearchType ROBOTICS = new EnumResearchType("robotics");
	EnumResearchType MACHINES = new EnumResearchType("machines");
    EnumResearchType HIDDEN = new EnumResearchType("hidden");//needs better name

	public void doRegister()
	{
		long time = System.currentTimeMillis();
		File folder = new File("config/Electrolysm/");

		//Power
        this.registerResearch(new Research("basic_storage", this.POWER, new Point(10,7 ), 1));
        this.registerResearch(new Research("advanced_storage", this.POWER, new Point (25,18), 2));
        this.registerResearch(new Research("experimental_stoage", this.POWER, new Point (40, 32), 3));
        this.registerResearch(new Research("tesla_tower", this.POWER, new Point(60,52 ), 4));
        this.registerResearch(new Research("battery", this.POWER, new Point(15,11), 2));
        this.registerResearch(new Research("advanced_battery", this.POWER, new Point(27, 20), 3));
        this.registerResearch(new Research("improved_coal", this.POWER, new Point(16,24), 2));
        this.registerResearch(new Research("improved_coal_generator", this.POWER, new Point(20, 11), 2));
        this.registerResearch(new Research("experimental_coal_generator", this.POWER, new Point(32, 20), 3));
       // this.registerResearch(new Research("antimatter_generator", this.POWER, new Point(82, 74), 4));
        this.registerResearch(new Research("thermal_generator", this.POWER, new Point(34, 24), 3));
		this.registerResearch(new Research("improved_thermal_generator", this.POWER, new Point(45, 34), 4));
		this.registerResearch(new Research("bio_generator", this.POWER, new Point (32, 26), 3));
		this.registerResearch(new Research("improved_bio_generator", this.POWER, new Point (42, 37), 3));
		this.registerResearch(new Research("solar_panel", this.POWER, new Point(34, 37), 3));
		this.registerResearch(new Research("improved_solar_panel", this.POWER, new Point(47, 53), 4));
		this.registerResearch(new Research("turbine", this.POWER, new Point(38,30), 3));
		this.registerResearch(new Research("improved_turbine", this.POWER, new Point(54, 45), 4));
		this.registerResearch(new Research("advanced_cable", this.POWER, new Point(28, 19), 2));
		this.registerResearch(new Research("experimental_cable", this.POWER, new Point(42,37), 3));
		
		//Metals And Elements
		this.registerResearch(new Research("fractional_distillation", this.METALS_AND_ELEMENTS, new Point(10, 15), 1));
		this.registerResearch(new Research("plastic", this.METALS_AND_ELEMENTS, new Point(19,15), 2));
		this.registerResearch(new Research("bio_fuel", this.METALS_AND_ELEMENTS, new Point(25,32), 2));
		this.registerResearch(new Research("improved_coal", this.METALS_AND_ELEMENTS, new Point(16,24), 1));
		this.registerResearch(new Research("carbon_fibre", this.METALS_AND_ELEMENTS, new Point(37,28), 2));
		this.registerResearch(new Research("carbon_nano_tubes", this.METALS_AND_ELEMENTS, new Point(59,41), 3));
		this.registerResearch(new Research("photomining", this.METALS_AND_ELEMENTS, new Point(29, 38), 2));
		this.registerResearch(new Research("electrolysis", this.METALS_AND_ELEMENTS, new Point(32, 26), 2));
		this.registerResearch(new Research("pure_copper", this.METALS_AND_ELEMENTS, new Point(33, 19), 3));
		this.registerResearch(new Research("aluminium", this.METALS_AND_ELEMENTS, new Point(33, 19), 3));
		this.registerResearch(new Research("alloys", this.METALS_AND_ELEMENTS, new Point(32, 22), 2));
		this.registerResearch(new Research("solder", this.METALS_AND_ELEMENTS, new Point(23, 14), 3));
		this.registerResearch(new Research("bronze", this.METALS_AND_ELEMENTS, new Point(23, 14), 3));
		this.registerResearch(new Research("steel", this.METALS_AND_ELEMENTS, new Point(23, 14), 3));
		this.registerResearch(new Research("silicon", this.METALS_AND_ELEMENTS, new Point(25, 30), 2));
		//this.registerResearch(new Research("large_hadron_colider", this.METALS_AND_ELEMENTS, new Point(67, 56), 2));
		
		
		//Research
        this.registerResearch(new Research("the_basics", this.RESEARCH, new Point(0, 0), 1, true));
		this.registerResearch(new Research("improved_analyser", this.RESEARCH, new Point(32, 25), 2));
		this.registerResearch(new Research("chromotography", this.RESEARCH, new Point(29, 37), 1));
		this.registerResearch(new Research("mass_spectrometry", this.RESEARCH, new Point(38, 47), 2));
		this.registerResearch(new Research("basic_data_recorder", this.RESEARCH, new Point(19, 12), 1));
		this.registerResearch(new Research("advanced_data_recorder", this.RESEARCH, new Point(32, 25), 2));
		this.registerResearch(new Research("experimental_data_recorder", this.RESEARCH, new Point(47, 39), 3));
		
		//Robotics
		this.registerResearch(new Research("basic_microchip", this.ROBOTICS, new Point(11, 5), 1));
		this.registerResearch(new Research("advanced_microchip", this.ROBOTICS, new Point(31, 24), 2));
		this.registerResearch(new Research("experimental_microchip", this.ROBOTICS, new Point(48, 39), 3));
		
		//Machines
		this.registerResearch(new Research("crusher", this.MACHINES, new Point(19, 14), 2));
		this.registerResearch(new Research("advanced_crusher", this.MACHINES, new Point(39, 28), 3));
		this.registerResearch(new Research("improved_furnace", this.MACHINES, new Point(23, 15), 1));
		this.registerResearch(new Research("smeltery", this.MACHINES, new Point(31, 22), 2));
		this.registerResearch(new Research("advanced_smeltery", this.MACHINES, new Point(51, 43), 3));
		this.registerResearch(new Research("molder", this.MACHINES, new Point(28, 21), 1));
		this.registerResearch(new Research("injection_molder", this.MACHINES, new Point(41, 33), 2));
		this.registerResearch(new Research("advanced_crusher", this.MACHINES, new Point(39, 28), 3));
		this.registerResearch(new Research("liquidiser", this.MACHINES, new Point(31, 24), 1));
		this.registerResearch(new Research("assembly_machine", this.MACHINES, new Point(33, 24), 1));
		this.registerResearch(new Research("advanced_assembly_machine", this.MACHINES, new Point(49, 38), 2));
		
		
		//Power Research requirements
/*
	      this.linkResearch(this.getResearch("advanced_storage"), Arrays.asList(this.getResearch("basic_storage"), this.getResearch("advanced_cable")));
	      this.linkResearch(this.getResearch("experimental_storage"), Arrays.asList(this.getResearch("advanced_storage"), this.getResearch("experimental_cable")));
	      this.linkResearch(this.getResearch("tesla_tower"), Arrays.asList(this.getResearch("steel"), this.getResearch("pure_copper"), this.getResearch("experimental_storage")));
	      this.linkResearch(this.getResearch("battery"), Arrays.asList(this.getResearch("basic_storage"), this.getResearch("steel"), this.getResearch("advanced_cable")));
	      this.linkResearch(this.getResearch("advanced_battery"), Arrays.asList(this.getResearch("battery"), this.getResearch("experimental_cable"), this.getResearch("advanced_storage")));
	      */
	      
     
		
		
        //Elliott DON'T remove this, trust me...
        //this.registerResearch(new Research("cold_fusion", this.HIDDEN, new Point(26, 93), 3));
        //this.registerResearch(new Research("wrong_cold_fusion", this.HIDDEN, new Point(0, 0), 3, this.getResearch("cold_fusion")));
		
		
		//Binding of text and research still has to be done!

        try {
            //this.bindRequirementToResearch(new Requirement(new Block[]{Blocks.stone}), this.getResearch("plastic"));
            this.bindRequirementToResearch(new Requirement(new Block[]{Blocks.iron_ore, Electrolysm.copperOre}),
                    this.getResearch("basic_storage"));
            this.bindRequirementToResearch(new Requirement("device"), this.getResearch("the_basics"));
            /*this.bindRequirementToResearch(new Requirement(new Block[]{electrolysmCore.blastProof}),
                    this.getResearch("advanced_storage"));*/

        }
        catch (Exception e) { e.printStackTrace(); }


		long duration = (System.currentTimeMillis() - time);
        LoggerHandler.info("Research registry completed in " + duration + "ms");
//        System.out.println(requireMap.get((this.getResearch("mass_spec")).toAdvString()));
        //System.exit(0);
	}

	private static LinkedHashMap<String, String> researchMap = new LinkedHashMap<String, String>();
	private static LinkedHashMap<String, String> requireMap = new LinkedHashMap<String, String>();
    private static LinkedHashMap<String, String> requireMapRev = new LinkedHashMap<String, String>();
    private static LinkedHashMap<String, List<String>> reliantMap = new LinkedHashMap<String, List<String>>();

    public void linkResearch(Research research, List<Research> reliants)
    {
        List<String> stringList = new ArrayList<String>();
        for(int i = 0; i < reliants.size(); i++)
        {
            stringList.add(reliants.get(i).toAdvString());
        }

        reliantMap.put(research.toAdvString(), stringList);
    }

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

    public static LinkedHashMap<String, String> getRequireMap() { return requireMap; }

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

	public static Research getResearchFromString(String string)
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
        String hasImage = details[4];
		EnumResearchType typeE = getEnumFromString(type);

        if(hasImage.contains("false")) {
            return new Research(name, typeE, new Point(engPoint, sciPoint), tier);
        }
        else
        {
            return new Research(name, typeE, new Point(engPoint, sciPoint), tier, true);
        }
	}

	public static EnumResearchType getEnumFromString(String type)
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
		
		if(this.reliantMap.get(research.toAdvString()) != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public List<Research> getSubResearchForName(String name)
	{
		if(doesNameSubResearch(name))
		{
			Research research = this.getResearch(name);
			
			if(this.reliantMap.get(research.toAdvString()) != null)
			{
                List<Research> researchList = new ArrayList<Research>();
                for(int i =0; i < this.reliantMap.get(research.toAdvString()).size(); i++)
                {
                    researchList.add(i, this.getResearchFromString(this.reliantMap.get(research.toAdvString()).get(i)));
                }

                return researchList;

            }
			else
			{
				return null;
			}
		}
		
		return null;
	}
	
	
	public static LinkedHashMap<String, String> getResearchMap()
	{
		return researchMap;
	}

    public static String[] getRequirementsFromStringAsArray(String requireString)
    {
        String[] array = requireString.split(":");

        return array;
    }

    public static boolean unlockedReliants(String username, Research research)
    {
        List<String> reliants = reliantMap.get(research.toAdvString());

        if(reliants == null)
        {
            return true;
        }

        Research[] array = new Research[reliants.size()];
        boolean[] booleanArray = new boolean[reliants.size()];
        for(int i = 0; i < reliants.size(); i++)
        {
            booleanArray[i] = SavePlayerScanData.ResearchData.hasPlayerUnlocked(username,
                    getResearchFromString(reliants.get(i)).getName());
        }
        String check= "";
        for(int i = 0; i < booleanArray.length; i++)
        {
            check = check + String.valueOf(booleanArray[i]);
        }

        if(check.contains("false"))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

}
