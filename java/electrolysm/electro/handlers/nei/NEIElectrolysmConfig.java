package electrolysm.electro.handlers.nei;

import electrolysm.electro.Electrolysm;
import electrolysm.electro.machines.advMachines.gui.GUIEnergiser;
import electrolysm.electro.machines.advMachines.gui.GUIInjector;
import electrolysm.electro.handlers.Referance;
import electrolysm.electro.oreProccessing.gui.GUICrusher;
import electrolysm.electro.oreProccessing.gui.GUIElectrolysisCore;
import electrolysm.electro.oreProccessing.gui.GUILiquidiser;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import electrolysm.electro.sciences.alloyFurnace.GuiAlloyFurnace;
import net.minecraft.item.ItemStack;

public class NEIElectrolysmConfig implements IConfigureNEI{

	@Override
	public void loadConfig()
	{
		//Item Hiding
		API.hideItem(new ItemStack(Electrolysm.crusherActive, 1, 3));
		API.hideItem(new ItemStack(Electrolysm.smeltoryActive, 1, 3));
		API.hideItem(new ItemStack(Electrolysm.advGenActive, 1, 3));
		API.hideItem(new ItemStack(Electrolysm.genActive, 1, 3));
		API.hideItem(new ItemStack(Electrolysm.improvedFurnaceActive, 1, 3));

        //For this release only:
        /*
        API.hideItem(new ItemStack(Electrolysm.roboticBase));
        API.hideItem(new ItemStack(Electrolysm.ironFrames));
        API.hideItem(new ItemStack(Electrolysm.antiMatterCasing));

        API.hideItem(new ItemStack(Electrolysm.crystal2));
        API.hideItem(new ItemStack(Electrolysm.electroContain));
        API.hideItem(new ItemStack(Electrolysm.electroMagnet));
        API.hideItem(new ItemStack(Electrolysm.endoInsulator));
        API.hideItem(new ItemStack(Electrolysm.silicon));
        API.hideItem(new ItemStack(Electrolysm.ballOfPlastic));
        API.hideItem(new ItemStack(Electrolysm.bronze));
*/
		//Crusher
		API.registerRecipeHandler(new CrusherRecipeHandler());
		API.registerUsageHandler(new CrusherRecipeHandler());
		API.setGuiOffset(GUICrusher.class, 0, 0);

		//Liquidiser
		API.registerRecipeHandler(new LiquidiserRecipeHandler());
		API.registerRecipeHandler(new LiquidiserRecipeHandler());
		API.setGuiOffset(GUILiquidiser.class, 0, 0);

		//Electrolysis
		API.registerRecipeHandler(new ElectrolysisRecipeHander());
		API.registerRecipeHandler(new ElectrolysisRecipeHander());
		API.setGuiOffset(GUIElectrolysisCore.class, 0, 0);

		//Injector
		API.registerRecipeHandler(new InjectorRecipeHandler());
		API.registerUsageHandler(new InjectorRecipeHandler());
		API.setGuiOffset(GUIInjector.class, 0, 0);

        //Resource
        API.registerRecipeHandler(new ResourceRecipeHandler());
        API.registerUsageHandler(new ResourceRecipeHandler());
        API.setGuiOffset(NEIResourceGUI.class, 0, 0);

        //Energiser
        API.registerRecipeHandler(new EnergiserRecipeHandler());
        API.registerUsageHandler(new EnergiserRecipeHandler());
        API.setGuiOffset(GUIEnergiser.class, 0, 0);

        //Alloy Furnace
        API.registerRecipeHandler(new AlloyFurnaceRecipeHandler());
        API.registerUsageHandler(new AlloyFurnaceRecipeHandler());
        API.setGuiOffset(GuiAlloyFurnace.class, 0, 0);

        //Research Crafting
        //API.registerRecipeHandler(new ResearchRecipeHandler());
        //API.registerUsageHandler(new ResearchRecipeHandler());
        //API.setGuiOffset(GUIWorkBench.class, 0, 0);
    }

	@Override
	public String getName()
	{
		return "Electrolysm NEI Plugin";
	}

	@Override
	public String getVersion()
	{
		return Referance.MOD_REF.VERSION;
	}

}
