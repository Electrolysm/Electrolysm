package mods.Electrolysm.electro.biology.bacteria;

import mods.Electrolysm.api.bacteria.BacteriaBaseClass;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Bacteria {
	
	public static Item agarResin;
	public static Block petriDish;
	
	public static Item bacteriaFusoR;
	public static Item bacteriaFusoNR;
	public static Item nitrospiraeR;
	public static Item nitrospiraeNR;
	public static Item GemmigerR;
	public static Item GemmigerNR;
	public static String[] posBac = {"bacteriaFuso", "nitrospirae", "Gemmiger"};
	public static String[] reBac = {"R", "RN", "N"};

	
	public static void loadBacteria(){
		
		ItemStack stack;
		int damage;
		petriDish = new petriDish(BacIDHandler.petriDishID, null);
		agarResin = new agarResin(BacIDHandler.agarResinID);
		//Tier 1
		//Fusobacteria
		bacteriaFusoR = new BacteriaBaseClass(BacIDHandler.tier1.bacteriaFuso).setUnlocalizedName("FusoR");
		bacteriaFusoNR = new BacteriaBaseClass(BacIDHandler.tier1.bacteriaFuso + 1).setUnlocalizedName("FusoNR");
		//Nitrospirae
		nitrospiraeR = new BacteriaBaseClass(BacIDHandler.tier1.nitrospirae).setUnlocalizedName("NitrospiraeR");
		nitrospiraeNR = new BacteriaBaseClass(BacIDHandler.tier1.nitrospirae + 1).setUnlocalizedName("NitrospiraeNR");
		//Gemmiger
		GemmigerR = new BacteriaBaseClass(BacIDHandler.tier1.GemmigerID).setUnlocalizedName("GemmigerR");
		GemmigerNR = new BacteriaBaseClass(BacIDHandler.tier1.GemmigerID + 1).setUnlocalizedName("GemmigerNR");
		//Tier 2
		
		//Tier 3
		
		//Tier 4
		
		//Tier 5
		
		//Tier 6

	}
}
