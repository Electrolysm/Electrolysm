package assets.electrolysm.electro.common;

import assets.electrolysm.electro.handlers.Referance;
import net.minecraft.util.ResourceLocation;

public class CommonProxy {

	private static String MOD_ID_LOWER = (Referance.MOD_REF.MOD_ID.toLowerCase());
	
	public static ResourceLocation MODELWORKBENCH = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelWorkBench.png");
	public static ResourceLocation MODEL_SOLDERING = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelSoldering.png");
	public static ResourceLocation MODEL_DESK = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelDesk.png");
	public static ResourceLocation MODEL_RESEARCH_DESK = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelResearchTable.png");

	//GUIs
	public static ResourceLocation RESEARCH_DESK_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/researchDeskGUI.png");
	public static ResourceLocation ENERGISER_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/energiserGUI.png");
	public static ResourceLocation INJECTOR_GUI = new ResourceLocation(MOD_ID_LOWER, "textures/gui/injectorGUI.png");
	
	//Items (With Subtypes)
	public static String[] RESEARCH_NOTES = {"researchNote", "researchNote_Complete"};

	public static String[] HOLDABLE_FLUIDS = {"Empty", "Plasma"};
	
	//MOBs
	public static final ResourceLocation ZOMBIE_SCIENTIST_TEXTURE = new ResourceLocation(MOD_ID_LOWER, "textures/mobs/ModelZombieScientist.png");

	public static final ResourceLocation MODEL_QUANTUM_COMPUTER = new ResourceLocation(MOD_ID_LOWER, "textures/models/ModelQuantumComp.png");

}
