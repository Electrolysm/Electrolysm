package mods.Electrolysm.electro.basic.research;

import mods.Electrolysm.electro.basic.handlers.IDHandler;
import net.minecraft.item.Item;

public class researchNotes {

	//advPhysics
	public static Item RNNano;
	//advBiology
	
	public static void advPhy(){
		RNNano = new RNNano(IDHandler.researchNotes.RNNanoID);
	}
	
	public static void advBio(){
		
	}
}
