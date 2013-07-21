package mods.Electrolysm.electro.research;

import mods.Electrolysm.electro.handlers.IDHandler;
import net.minecraft.item.Item;

public class researchNotes {

	public static Item RNNano;
	
	public static void advPhy(){
		RNNano = new RNNano(IDHandler.researchNotes.RNNanoID);
	}
	
	public static void advBio(){
		
	}
}
