package assets.electrolysm.electro.common;

import assets.electrolysm.electro.handlers.Referance;
import net.minecraft.util.ResourceLocation;

public class CommonProxy {

	private static String MOD_ID_LOWER = (Referance.MOD_REF.MOD_ID.toLowerCase());
	
	public static ResourceLocation MODELWORKBENCH = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelWorkBench.png");
	public static ResourceLocation MODEL_SOLDERING = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelSoldering.png");
	public static ResourceLocation MODEL_DESK = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelDesk.png");
	public static ResourceLocation MODEL_RESEARCH_DESK = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelResearchTable.png");
	public static ResourceLocation MODEL_TRANSFORMER_SOURCE = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelTransformerSource.png");
	public static ResourceLocation MODEL_TRANSFORMER_MACHINE = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelTransformerMachine.png");
	public static ResourceLocation MODEL_QUANTUM_COMPUTER = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelQuantumComp.png");
	public static ResourceLocation GRAPHITE_WIRE_MODEL = new ResourceLocation(MOD_ID_LOWER, "textures/models/copperWire.png");
	public static ResourceLocation MODEL_ELECTROLYSIS_CORE = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelElectrolysisCore.png");
	
	//GUIs
	public static ResourceLocation RESEARCH_DESK_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/researchDeskGUI.png");
	public static ResourceLocation ENERGISER_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/energiserGUI.png");
	public static ResourceLocation INJECTOR_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/injectorGUI.png");
	public static ResourceLocation SMELTORY_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/smelteryGUI.png");
	public static ResourceLocation ELECTROLYSIS_CORE_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/electrolysisGUI.png");
	public static ResourceLocation ELECTROLYSIS_PORT = new ResourceLocation(MOD_ID_LOWER, "texture/gui/electrolysisPort.png");
	
	//Items (With Subtypes)
	public static String[] RESEARCH_NOTES = {"researchNote", "researchNote_Complete"};
	public static String[] HOLDABLE_FLUIDS = {"Empty", "Plasma", "Sulphuric Acid", "Copper Sulphate",
	//METAs										0			1			2					3
		"Iron Sulphate", "Gold Sulphate", "Tin Sulphate", "Lead Sulphate"};
	//METAs    4				5				6				7
	public static final String[] DUSTS = {"Copper", "Tin", "Iron", "Gold", "Silver", "Lead"};
	//METAs									0		   1	  2		  3			4		5

	
	//MOBs
	public static final ResourceLocation ZOMBIE_SCIENTIST_TEXTURE = new ResourceLocation(MOD_ID_LOWER, "textures/mobs/ModelZombieScientist.png");



}
