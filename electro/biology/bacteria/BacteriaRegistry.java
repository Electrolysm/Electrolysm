package mods.Electrolysm.electro.biology.bacteria;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BacteriaRegistry {

	public static void registerBacteria() {
		String active = "";
		String Nactive = "";
		String bacteria = " Bacteria";
		
		//Tier 1
		LanguageRegistry.addName(Bacteria.bacteriaFusoR, active + Bacteria.bacteriaFusoR.getUnlocalizedName().replace("item.", "").replace("R", "") + bacteria);
		LanguageRegistry.addName(Bacteria.nitrospiraeR, active + Bacteria.nitrospiraeR.getUnlocalizedName().replace("item.", "").replace("R", "") + bacteria);
		LanguageRegistry.addName(Bacteria.GemmigerR, active + Bacteria.GemmigerR.getUnlocalizedName().replace("item.", "").replace("R", "") + bacteria);
		
		LanguageRegistry.addName(Bacteria.bacteriaFusoNR, Nactive + Bacteria.bacteriaFusoNR.getUnlocalizedName().replace("item.", "").replace("NR", "") + bacteria);
		LanguageRegistry.addName(Bacteria.nitrospiraeNR, Nactive + Bacteria.nitrospiraeNR.getUnlocalizedName().replace("item.", "").replace("NR", "") + bacteria);
		LanguageRegistry.addName(Bacteria.GemmigerNR, Nactive + Bacteria.GemmigerNR.getUnlocalizedName().replace("item.", "").replace("NR", "") + bacteria);
		
		

	}

}
