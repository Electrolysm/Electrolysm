package mods.Electrolysm.electro.biology.bacteria;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BacteriaRegistry {

	public static void registerBacteria() {
		String active = "Active Bacteria";
		String Nactive = "Non-Active Bacteria";
		String classs = "Bacteria.bacteriaFusoR";
		
		//Tier 1
		LanguageRegistry.addName(Bacteria.bacteriaFusoR, active);
		LanguageRegistry.addName(Bacteria.nitrospiraeR, active);
		
		LanguageRegistry.addName(Bacteria.bacteriaFusoNR, Nactive);
		LanguageRegistry.addName(Bacteria.nitrospiraeNR, Nactive);
		
		

	}

}
