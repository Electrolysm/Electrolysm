package assets.electrolysm.electro.common;

import java.util.Map;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.handlers.Referance;

public class CommonProxy
{
    public static String MOD_ID_LOWER = (Referance.MOD_REF.MOD_ID.toLowerCase());
    public static String MOD_MODEL_ELECTROL_LOCATION = "textures/models/electrolysis/";

    public static ResourceLocation MODELWORKBENCH = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelWorkBench.png");
    public static ResourceLocation MODEL_SOLDERING = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelSoldering.png");
    public static ResourceLocation MODEL_DESK = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelDesk.png");
    public static ResourceLocation MODEL_RESEARCH_DESK = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelResearchTable.png");
    public static ResourceLocation MODEL_TRANSFORMER_SOURCE = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelTransformerSource.png");
    public static ResourceLocation MODEL_TRANSFORMER_MACHINE = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelTransformerMachine.png");
    public static ResourceLocation MODEL_QUANTUM_COMPUTER = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelQuantumComp.png");
    public static ResourceLocation GRAPHITE_WIRE_MODEL = new ResourceLocation(MOD_ID_LOWER, "textures/models/copperWire.png");
    public static ResourceLocation MODEL_ELECTROLYSIS_CORE_EMPTY = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelElectrolysisCore.png");
    public static ResourceLocation BEAM_MODEL = new ResourceLocation("textures/entity/beacon_beam.png");
    public static ResourceLocation MODEL_IRON_FRAME = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelIronFrame.png");
    public static ResourceLocation MODEL_CHARGER = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelCharger.png");

    //GUIs
    public static ResourceLocation RESEARCH_DESK_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/researchDeskGUI.png");
    public static ResourceLocation ENERGISER_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/energiserGUI.png");
    public static ResourceLocation INJECTOR_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/injectorGUI.png");
    public static ResourceLocation SMELTORY_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/smelteryGUI.png");
    public static ResourceLocation ELECTROLYSIS_CORE_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/electrolysisGUI.png");
    public static ResourceLocation PORT_GUI = new ResourceLocation(MOD_ID_LOWER, "texture/gui/electrolysisPort.png");
    public static ResourceLocation GENERATOR_BASIC_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/generatorGUI.png");
    public static ResourceLocation GENERATOR_GEO_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/geoGenGUI.png");
    public static ResourceLocation GENERATOR_FUSION_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/fusionGenGUI.png");
    public static ResourceLocation GENERATOR_MATTER_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/matterGenGUI.png");
    public static ResourceLocation GENERATOR_MATTER_INC_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/matterGenIncGUI.png");
    public static ResourceLocation WORK_BENCH_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/workBenchGUI.png");
    public static ResourceLocation CRUSHER_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/crusherGUI.png");
    public static ResourceLocation LIQUIDISER_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/liquidiserGUI.png");
	public static ResourceLocation SLOT_ICON = new ResourceLocation(MOD_ID_LOWER, "textures/gui/slotIcon.png");
	public static ResourceLocation IMAGE_TECH_TREE = new ResourceLocation(MOD_ID_LOWER, "textures/gui/research/image_techTree.png");

    //NEI GUIs
    public static ResourceLocation NEI_ELECTROL_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/nei/neiElectrolysisGUI.png");
    
    //Items (With Subtypes)
    public static String[] RESEARCH_NOTES = {"researchNote", "researchNote_Complete"};
    public static String[] FLUIDS = {"Empty", "Plasma", "Sulphuric Acid", "Copper Sulphate",
                           //METAs	  	0			1			2					3
                           "Iron Sulphate", "Gold Sulphate", "Tin Sulphate", "Lead Sulphate", "Silver Sulphate", "Water"};
    //METAs   						 4				5				6				7				8				9
    
    public static int[] FLUID_IDS = {0, electrolysmCore.plasma.blockID, electrolysmCore.sulpuricAcid.blockID, 
		0, 0, 0, 0, 0, 0};
    
    public static final String[] DUSTS = {"Copper", "Tin", "Iron", "Gold", "Silver", "Lead"};
    //METAs									0		   1	  2		  3			4		5

    //MOBs
    public static final ResourceLocation ZOMBIE_SCIENTIST_TEXTURE = new ResourceLocation(MOD_ID_LOWER, "textures/mobs/ModelZombieScientist.png");
    public static int[] RANGE_TIER = {40, 80, 135};
    
    
}
