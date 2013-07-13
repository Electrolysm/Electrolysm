package mods.Electrolysm.electro.biology.bacteria;

import net.minecraft.item.Item;
import mods.Electrolysm.api.bacteria.BacteriaBaseClass;
import mods.Electrolysm.electro.biology.bacteria.tier1.bacteriaFuso1;

public class Bacteria {
	
	public static Item bacteriaFuso1;
	
	
	public static void loadBacteria(){
		
		//Tier 1
		//Fusobacteria
		bacteriaFuso1 = new bacteriaFuso1(BacIDHandler.bacteriaFuso);
		//Item bacteriaFuso2 = new bacteriaFuso2((BacIDHandler.bacteriaFuso) + 1);
		//Nitrospirae
		
		//
		//Tier 2
		
		//Tier 3
		
		//Tier 4
		
		//Tier 5
		
		//Tier 6
	}
}
