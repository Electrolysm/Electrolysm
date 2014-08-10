package electro.handlers.nei;

import electro.Electrolysm;
import electro.machines.advMachines.gui.GUIEnergiser;
import electro.machines.advMachines.gui.GUIInjector;
import electro.handlers.Referance;
import electro.oreProccessing.gui.GUICrusher;
import electro.oreProccessing.gui.GUIElectrolysisCore;
import electro.oreProccessing.gui.GUILiquidiser;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import electro.sciences.alloyFurnace.GuiAlloyFurnace;
import net.minecraft.item.ItemStack;

public class NEIElectrolysmConfig implements IConfigureNEI{

	@Override
	public void loadConfig()
	{
		//Item Hiding
		API.hideItem(new ItemStack(Electrolysm.crusherActive));
		API.hideItem(new ItemStack(Electrolysm.smeltoryActive));
		API.hideItem(new ItemStack(Electrolysm.experimentalCable));

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
