package assets.electrolysm.electro.handlers.nei;

import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.block.advMachines.gui.GUIInjector;
import assets.electrolysm.electro.handlers.Referance;
import assets.electrolysm.electro.oreProccessing.gui.GUICrusher;
import assets.electrolysm.electro.oreProccessing.gui.GUILiquidiser;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIElectrolysmConfig implements IConfigureNEI{

	@Override
	public void loadConfig() 
	{
		//Item Hiding
		API.hideItem(electrolysmCore.crusherActive.blockID);
		API.hideItem(electrolysmCore.smeltoryActive.blockID);
		
		//Crusher
		API.registerRecipeHandler(new CrusherRecipeHandler());
		API.registerUsageHandler(new CrusherRecipeHandler());
		API.setGuiOffset(GUICrusher.class, 0, 0);
		
		//Liquidiser
		API.registerRecipeHandler(new LiquidiserRecipeHandler());
		API.registerRecipeHandler(new LiquidiserRecipeHandler());
		API.setGuiOffset(GUILiquidiser.class, 0, 0);
		
		//Injector
		/*
		API.registerRecipeHandler(new InjectorRecipeHandler());
		API.registerUsageHandler(new InjectorRecipeHandler());
		API.setGuiOffset(GUIInjector.class, 0, 0);*/
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
