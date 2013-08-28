package assets.electrolysm.electro.handlers;

import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterBlock {

	public static void register() {
		
		GameRegistry.registerBlock(electrolysmCore.workBench);
		GameRegistry.registerBlock(electrolysmCore.soldering);
	}

}
