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


	//Items (With Subtypes)
	public static String[] RESEARCH_NOTES = {"researchNote", "researchNote_Complete"};
}
