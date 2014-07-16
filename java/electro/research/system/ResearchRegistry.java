package electro.research.system;

import java.io.File;
import java.util.*;

import api.LoggerHandler;
import electro.Electrolysm;
import electro.research.common.SavePlayerScanData;
import net.minecraft.block.Block;
import electro.research.pointsSystem.Point;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

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
        this.registerResearch(new Research("energy_storage", this.POWER, new Point(10,7 ), 1));
        // this.registerResearch(new Research("WET_energy_storage", this.POWER, new Point (25,18), 2));
        // this.registerResearch(new Research("graphene_energy_storage", this.POWER, new Point (40, 32), 3));
        //  this.registerResearch(new Research("tesla_coil", this.POWER, new Point(60,52 ), 4));
        // this.registerResearch(new Research("compact_storage", this.POWER, new Point(15,11), 2));
        // this.registerResearch(new Research("WET_batteries", this.POWER, new Point(30, 24), 3));
        // this.registerResearch(new Research("grahene_batteries", this.POWER, new Point(49, 38), 4));
        this.registerResearch(new Research("electricity", this.POWER, new Point (12, 6), 1));
        this.registerResearch(new Research("improved_conductors", this.POWER, new Point(20, 11), 2));
        // this.registerResearch(new Research("efficent_generators", this.POWER, new Point(32, 20), 3));
        // this.registerResearch(new Research("antimatter_generator", this.POWER, new Point(82, 74), 4));
        this.registerResearch(new Research("thermal_generator", this.POWER, new Point(34, 24), 3));
        //this.registerResearch(new Research("better_conduction", this.POWER, new Point(45, 34), 4));
        //this.registerResearch(new Research("bio_generator", this.POWER, new Point (32, 26), 3));
        //this.registerResearch(new Research("less-waste_gas", this.POWER, new Point (42, 37), 3));
        this.registerResearch(new Research("solar_panel", this.POWER, new Point(34, 37), 3));
        //this.registerResearch(new Research("solar_cells", this.POWER, new Point(47, 53), 4));
        //	this.registerResearch(new Research("turbine", this.POWER, new Point(38,30), 3));
        //	this.registerResearch(new Research("lighter_blades", this.POWER, new Point(54, 45), 4));
        this.registerResearch(new Research ("copper_cable", this.POWER, new Point (15, 7), 1));
        this.registerResearch(new Research("improved_conductivity", this.POWER, new Point(28, 19), 2));
        this.registerResearch(new Research("endothermic_cable", this.POWER, new Point(42,37), 3));

        //Metals And Elements
        //this.registerResearch(new Research("oil_extraction", this.METALS_AND_ELEMENTS, new Point(10, 8), 1));
        //this.registerResearch(new Research("fractional_distillation", this.METALS_AND_ELEMENTS, new Point(19, 15), 2));
        //this.registerResearch(new Research("plastic", this.METALS_AND_ELEMENTS, new Point(27,18), 3));
        //this.registerResearch(new Research("bio_fuel", this.METALS_AND_ELEMENTS, new Point(25,32), 3));
        this.registerResearch(new Research("improved_coal", this.METALS_AND_ELEMENTS, new Point(16,24), 1));
        //this.registerResearch(new Research("carbon_fibre", this.METALS_AND_ELEMENTS, new Point(37,28), 2));
        //this.registerResearch(new Research("nano_technology", this.METALS_AND_ELEMENTS, new Point(59,41), 3));
        //this.registerResearch(new Research("photomining", this.METALS_AND_ELEMENTS, new Point(29, 38), 2));
        this.registerResearch(new Research("electrolysis", this.METALS_AND_ELEMENTS, new Point(32, 26), 2));
        this.registerResearch(new Research("pure_copper", this.METALS_AND_ELEMENTS, new Point(33, 19), 3));
        this.registerResearch(new Research("aluminium", this.METALS_AND_ELEMENTS, new Point(33, 19), 3));
        this.registerResearch(new Research("alloys", this.METALS_AND_ELEMENTS, new Point(32, 22), 2));
        this.registerResearch(new Research("bronze", this.METALS_AND_ELEMENTS, new Point(23, 14), 3));
        this.registerResearch(new Research("steel", this.METALS_AND_ELEMENTS, new Point(23, 14), 3));
        this.registerResearch(new Research("silicon", this.METALS_AND_ELEMENTS, new Point(25, 30), 2));
        //this.registerResearch(new Research("large_hadron_colider", this.METALS_AND_ELEMENTS, new Point(67, 56), 2));

        //Research
        //this.registerResearch(new Research("atomc_analyser", this.RESEARCH, new Point(32, 25), 2));
        //this.registerResearch(new Research("chromotography", this.RESEARCH, new Point(29, 37), 1));
        //this.registerResearch(new Research("mass_spectrometry", this.RESEARCH, new Point(38, 47), 2));
        this.registerResearch(new Research("data_recorder", this.RESEARCH, new Point(19, 12), 1));
        //this.registerResearch(new Research("improved_equipment", this.RESEARCH, new Point(32, 25), 2));
        //this.registerResearch(new Research("sensitive_equipment", this.RESEARCH, new Point(47, 39), 3));
        //this.registerResearch(new Research("thinner_tape", this.RESEARCH, new Point(29, 22), 2));
        //this.registerResearch(new Research("conductibe_tape", this.RESEARCH, new Point(41,34), 3));

        //Robotics
        this.registerResearch(new Research("intergrated_circuit", this.ROBOTICS, new Point(11, 5), 1));
        this.registerResearch(new Research("CPU", this.ROBOTICS, new Point(31, 24), 2));
        this.registerResearch(new Research("microprocessor", this.ROBOTICS, new Point(48, 39), 3));

        //Machines
        this.registerResearch(new Research("crusher", this.MACHINES, new Point(19, 14), 2));
        //this.registerResearch(new Research("finer_filters", this.MACHINES, new Point(39, 28), 3));
        this.registerResearch(new Research("better_conduction", this.MACHINES, new Point(23, 15), 1));
        this.registerResearch(new Research("smeltery", this.MACHINES, new Point(31, 22), 2));
        //this.registerResearch(new Research("higher_tempertures", this.MACHINES, new Point(51, 43), 3));
        this.registerResearch(new Research("molder", this.MACHINES, new Point(28, 21), 1));
        this.registerResearch(new Research("injection_molder", this.MACHINES, new Point(41, 33), 2));
        this.registerResearch(new Research("liquidiser", this.MACHINES, new Point(31, 24), 1));
        //this.registerResearch(new Research("assembly_machine", this.MACHINES, new Point(33, 24), 1));
        //this.registerResearch(new Research("improved_production_speed", this.MACHINES, new Point(49, 38), 2));
        this.registerResearch(new Research("compressor", this.MACHINES, new Point(23, 15), 1));
        //this.registerResearch(new Research("higher_compression_ratio", this.MACHINES, new Point(39, 31), 1));


        //Power Research requirements
        //You keep making spelling mistakes and I cannot be bothered to change them.
        //Check your work with what you have registered, so we don't have this problem.

        this.linkResearch(this.getResearch("energy_storage"), Arrays.asList(this.getResearch("copper_cable")));
        // this.linkResearch(this.getResearch("WET_energy_storage"), Arrays.asList(this.getResearch("energy_storage"), this.getResearch("improved_conductivity"), this.getResearch("liquidiser")));
        //this.linkResearch(this.getResearch("graphene_energy_storage"), Arrays.asList(this.getResearch("WET_energy_storage"), this.getResearch("endothermic_cable")));
        // this.linkResearch(this.getResearch("tesla_coil"), Arrays.asList(this.getResearch("steel"), this.getResearch("pure_copper"), this.getResearch("experimental_storage")));
        // this.linkResearch(this.getResearch("compact_storage"), Arrays.asList(this.getResearch("energy_storage"), this.getResearch("steel"), this.getResearch("liquidiser")));
        // this.linkResearch(this.getResearch("WET_batteries"), Arrays.asList(this.getResearch("compact_storage"), this.getResearch("improved_conductivity"), this.getResearch("WET_energy_storage")));
        // this.linkResearch(this.getResearch("grahene_batteries"), Arrays.asList(this.getResearch("WET_batteries"), this.getResearch("graphene_energy_storage")));
        this.linkResearch(this.getResearch("improved_conductors"), Arrays.asList(this.getResearch("better_conduction"), this.getResearch("electricity"), this.getResearch("intergrated_circuit")));
        // this.linkResearch(this.getResearch("efficent_generators"), Arrays.asList(this.getResearch("improved_conductors"), this.getResearch("CPU")));
        this.linkResearch(this.getResearch("thermal_generator"), Arrays.asList(this.getResearch("improved_conductors")));
        // this.linkResearch(this.getResearch("better conduction"), Arrays.asList(this.getResearch("efficent_generators"), this.getResearch("thermal_generator")));
        //this.linkResearch(this.getResearch("bio_generator"), Arrays.asList(this.getResearch("improved_conductors"), this.getResearch("bio_fuel")));
        // this.linkResearch(this.getResearch("less_waste_gas"), Arrays.asList(this.getResearch("efficent_generators"), this.getResearch("bio_generator")));
        this.linkResearch(this.getResearch("solar_panel"), Arrays.asList(this.getResearch("improved_conductors")));
        // this.linkResearch(this.getResearch("solar_cells"), Arrays.asList(this.getResearch("efficent_generators"), this.getResearch("solar_pannels")));
        // this.linkResearch(this.getResearch("turbine"), Arrays.asList(this.getResearch("improved_conductors")));
        //  this.linkResearch(this.getResearch("lighter_blades"), Arrays.asList(this.getResearch("efficent_generators"), this.getResearch("turbine")));
        this.linkResearch(this.getResearch("copper_cable"), Arrays.asList(this.getResearch("electricity")));
        // this.linkResearch(this.getResearch("improved_conductivity"), Arrays.asList(this.getResearch("copper_cable"), this.getResearch("bronze"), this.getResearch("plastic")));
        //this.linkResearch(this.getResearch("endothermic_cable"), Arrays.asList(this.getResearch("improved_conductivity"), this.getResearch("pure_copper"), this.getResearch("carbon_fibre")));

        // Metals and Elements research requirements
        //this.linkResearch(this.getResearch("oil_extraction"), Arrays.asList(this.getResearch("electricity"), this.getResearch("intergrated_ciruit")));
        //this.linkResearch(this.getResearch("fractional_distillation"), Arrays.asList(this.getResearch("better_conduction"), this.getResearch("oil_extraction")));
        // this.linkResearch(this.getResearch("plastic"), Arrays.asList(this.getResearch("fractional_distillation")));
        //this.linkResearch(this.getResearch("bio_fuel"), Arrays.asList(this.getResearch("fractional;_distillation")));
        this.linkResearch(this.getResearch("improved_coal"), Arrays.asList(this.getResearch("electricity"), this.getResearch("crusher")));
        //this.linkResearch(this.getResearch("carbon_fibre"), Arrays.asList(this.getResearch("improved_coal"), this.getResearch("compressor")));
        // this.linkResearch(this.getResearch("nano_technology"), Arrays.asList(this.getResearch("carbon_fibre"), this.getResearch("higher_compression_ratio")));
        this.linkResearch(this.getResearch("pure_copper"), Arrays.asList(this.getResearch("electrolysis")));
        this.linkResearch(this.getResearch("aluminium"), Arrays.asList(this.getResearch("electrolysis")));
        this.linkResearch(this.getResearch("electrolysis"), Arrays.asList(this.getResearch("improved_conductivity"), this.getResearch("steel"), this.getResearch("bronze")));
        this.linkResearch(this.getResearch("alloys"), Arrays.asList(this.getResearch("better_conduction")));
        this.linkResearch(this.getResearch("bronze"), Arrays.asList(this.getResearch("alloys")));
        this.linkResearch(this.getResearch("steel"), Arrays.asList(this.getResearch("alloys")));

        // Research research requirements
        // this.linkResearch(this.getResearch("atomic_analyser"), Arrays.asList(this.getResearch("steel"), this.getResearch("WET_batteries")));
        //this.linkResearch(this.getResearch("chromatography"), Arrays.asList(this.getResearch("steel"), this.getResearch("CPU")));
        // this.linkResearch(this.getResearch("mass_spectrometry"), Arrays.asList(this.getResearch("chromatography"), this.getResearch("microprocessor")));
        this.linkResearch(this.getResearch("data_recorder"), Arrays.asList(this.getResearch("intergrated_circuit")));
        // this.linkResearch(this.getResearch("improved_equipment"), Arrays.asList(this.getResearch("CPU"), this.getResearch("carbon_fibre")));
        // this.linkResearch(this.getResearch("sensitive_equipment"), Arrays.asList(this.getResearch("improved_equipment"), this.getResearch("microprocessor")));
        // this.linkResearch(this.getResearch("thinner_tape"), Arrays.asList(this.getResearch("plastic"), this.getResearch("improved_equipment")));
        // this.linkResearch(this.getResearch("conductive_tape"), Arrays.asList(this.getResearch("thinner_tape"), this.getResearch("sensitive_equipment")));

        // Robotics research requirements
        this.linkResearch(this.getResearch("intergrated_circuit"), Arrays.asList(this.getResearch("copper_cable"), this.getResearch("silicon")));
        this.linkResearch(this.getResearch("CPU"), Arrays.asList(this.getResearch("intergrated_circuit"), this.getResearch("molder"), this.getResearch("solder")));
        this.linkResearch(this.getResearch("microprocessor"), Arrays.asList(this.getResearch("endothermic_cable"), this.getResearch("CPU"), this.getResearch("injection_molder")));

        // Machines Research requirements
        this.linkResearch(this.getResearch("crusher"), Arrays.asList(this.getResearch("electricity"), this.getResearch("intergrated_circuit")));
        // this.linkResearch(this.getResearch("finer_filters"), Arrays.asList(this.getResearch("crusher"), this.getResearch("CPU")));
        this.linkResearch(this.getResearch("smeltery"), Arrays.asList(this.getResearch("better_conduction"), this.getResearch("intergrated_circuit")));
        //this.linkResearch(this.getResearch("higher_tempertures"), Arrays.asList(this.getResearch("microprocessor"), this.getResearch("steel")));
        this.linkResearch(this.getResearch("molder"), Arrays.asList(this.getResearch("CPU"), this.getResearch("steel")));
        // this.linkResearch(this.getResearch("injection_molder"), Arrays.asList(this.getResearch("microprocessor"), this.getResearch("molder"),this.getResearch("carbon_fibre")));
        this.linkResearch(this.getResearch("liquidiser"), Arrays.asList(this.getResearch("CPU")));
        // this.linkResearch(this.getResearch("assembly_machine"), Arrays.asList(this.getResearch("CPU"), this.getResearch("carbon_fibre")));
        // this.linkResearch(this.getResearch("improved_production_speed"), Arrays.asList(this.getResearch("assembly_machine"), this.getResearch("microprocessor")));
        this.linkResearch(this.getResearch("compressor"), Arrays.asList(this.getResearch("intergrated_circuit"), this.getResearch("steel")));
        //this.linkResearch(this.getResearch("higher_compression_ratio"), Arrays.asList(this.getResearch("compressor"), this.getResearch("CPU")));

        // Temporary research requirements
        this.linkResearch(this.getResearch("improved_conductivity"), Arrays.asList(this.getResearch("copper_cable"), this.getResearch("bronze")));
        this.linkResearch(this.getResearch("endothermic_cable"), Arrays.asList(this.getResearch("improved_conductivity"), this.getResearch("pure_copper")));
        this.linkResearch(this.getResearch("injection_molder"), Arrays.asList(this.getResearch("microprocessor"), this.getResearch("molder")));

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

    public static LinkedHashMap<String, List<String>> getReliantMap() {
        return reliantMap;
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
        if(requireString != null) {
            String[] array = requireString.split(":");

            return array;
        } else {
            return null;
        }
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