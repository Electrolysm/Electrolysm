package mods.Electrolysm.api.elements;

import mods.Electrolysm.electro.basic.handlers.IDHandler;
import net.minecraft.item.ItemStack;

public class Elements {
	
	public static String message;
	public static String blockElements;
	
	public static String getElementsVanilla(ItemStack inHand){
		String unlocalName = inHand.getItemName();
		blockElements = "";
		message = "UNDIFFINED";
		
			for(int idR = 0; idR < 10; idR++)
			{
				if(unlocalName.contains(blocksSpawnName[idR])){
					blockElements = blocksSpawn[idR];
					message = "ELEMENT";
				}
			}
		return blockElements;
		}

	
	
	public static String[] blocksSpawnName = {"stone", "dirt", "oreIron", "oreGold", "oreCoal", "oreLapis", "oreRedstone", "hellrock", "hellsand", "lightgem"};
	public static String[] blocksSpawn = {"stone", "dirt", "oreIron", "oreGold", "oreCoal", "oreLapis", "oreRedstone", "hellrock", "hellsand", "lightgem"};
	
}
