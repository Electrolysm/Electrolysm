package mods.Electrolysm.electro.basic.research;

import mods.Electrolysm.electro.basic.handlers.IDHandler;
import net.minecraft.item.Item;

public class researchNotes {

	//advPhysics
	public static Item RNNano;
	public static Item RNLaser;
	//advBiology
	public static Item RNMicroS;
	public static Item RNFibre;
	
	public static void advPhy(){
		RNNano = new RNNano(IDHandler.researchNotes.RNNanoID);
		RNLaser = new RNLaser(IDHandler.researchNotes.RNLaser);
	}
	
	public static void advBio(){
		RNMicroS = new RNMicroS(IDHandler.researchNotes.RNMicroS);
		RNFibre = new RNFibre(IDHandler.researchNotes.RNFibre);
	}
}
