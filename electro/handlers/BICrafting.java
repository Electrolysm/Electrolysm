package mods.Electrolysm.electro.handlers;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import mods.Electrolysm.electro.electrolysmCore;

public class BICrafting {

	//Creafting
	public static void registerCraftingRecipes()
	{
		//World Generation Crafting
			GameRegistry.addRecipe(new ItemStack(electrolysmCore.electrumDust, 3),
					"XY ",
					Character.valueOf('X'), electrolysmCore.mixedOre,
					Character.valueOf('Y'), Block.cobblestone);
			
			GameRegistry.addRecipe(new ItemStack(electrolysmCore.ferrousDust, 5),
					"XYY",
					Character.valueOf('X'), electrolysmCore.mixedOre,
					Character.valueOf('Y'), Block.cobblestone);
			
			//Ingot Crafting
				//Tier 1
				GameRegistry.addRecipe(new ItemStack(electrolysmCore.ionicElectrum, 2),
						"XYZ",
						Character.valueOf('X'), electrolysmCore.electrumDust,
						Character.valueOf('Y'), net.minecraft.item.Item.ingotIron,
						Character.valueOf('Z'), net.minecraft.item.Item.coal);
				
				GameRegistry.addRecipe(new ItemStack(electrolysmCore.ironisedGold, 2),
						"XYZ",
						Character.valueOf('X'), net.minecraft.item.Item.ingotIron,
						Character.valueOf('Y'), net.minecraft.item.Item.ingotGold,
						Character.valueOf('Z'), net.minecraft.item.Item.coal);
				
				GameRegistry.addRecipe(new ItemStack(electrolysmCore.tumbaga, 2),
						"XYZ",
						Character.valueOf('X'), net.minecraft.item.Item.ingotGold,
						Character.valueOf('Y'), electrolysmCore.copperDust,
					Character.valueOf('Z'), net.minecraft.item.Item.coal);
				
				GameRegistry.addRecipe(new ItemStack(electrolysmCore.babbitt, 2),
						"XYZ",
						Character.valueOf('X'), electrolysmCore.copperDust,
						Character.valueOf('Y'), electrolysmCore.tinDust,
						Character.valueOf('Z'), net.minecraft.item.Item.coal);
				
				GameRegistry.addRecipe(new ItemStack(electrolysmCore.pewter, 2),
						"XYZ",
						Character.valueOf('X'), electrolysmCore.tinDust,
						Character.valueOf('Y'), electrolysmCore.ferrousDust,
				    Character.valueOf('Z'), net.minecraft.item.Item.coal);
				
				GameRegistry.addRecipe(new ItemStack(electrolysmCore.sydium, 2),
						"XYZ",
						Character.valueOf('X'), electrolysmCore.ferrousDust,
						Character.valueOf('Y'), electrolysmCore.leadDust,
					Character.valueOf('Z'), net.minecraft.item.Item.coal);
				
				GameRegistry.addRecipe(new ItemStack(electrolysmCore.tibetanSilver, 2),
						"XYZ",
						Character.valueOf('X'), electrolysmCore.leadDust,
						Character.valueOf('Y'), electrolysmCore.silverDust,
					Character.valueOf('Z'), net.minecraft.item.Item.coal);
				
				//Crafting Machines
				
	 		       GameRegistry.addRecipe(new ItemStack(electrolysmCore.magmaticExtractor),
	 		    		   "XYX", "ZMZ", "XNX",
	 		    		   Character.valueOf('X'), net.minecraft.item.Item.ingotIron,
	 		    		   Character.valueOf('Y'), net.minecraft.item.Item.redstone,
	 		    		   Character.valueOf('Z'), net.minecraft.item.Item.ingotGold,
	 		    		   Character.valueOf('M'), net.minecraft.item.Item.bucketEmpty,
	 		    		   Character.valueOf('N'), electrolysmCore.tumbaga);
	 		       
	 		       GameRegistry.addRecipe(new ItemStack(electrolysmCore.solarCollector),
	 		    		   "XXX", "YZY", "AAA",
	 		    		   Character.valueOf('X'), Block.glass,
	 		    		   Character.valueOf('Y'), net.minecraft.item.Item.redstone,
	 		    		   Character.valueOf('Z'), electrolysmCore.tibetanSilver,
	 		    		   Character.valueOf('A'), net.minecraft.item.Item.ingotIron);
	 		       
	 		       GameRegistry.addRecipe(new ItemStack(electrolysmCore.matterSythisiser),
	 		    		   "XZX", "XMX", "XYX",
	 		    		   Character.valueOf('X'), electrolysmCore.ionicElectrum,
	 		    		   Character.valueOf('Y'), electrolysmCore.ironisedGold,
	 		    		   Character.valueOf('Z'), electrolysmCore.babbitt,
	 		    		   Character.valueOf('M'), Block.furnaceIdle);
	 		       
	 		       //Crafting Tools
	 		      GameRegistry.addRecipe(new ItemStack(electrolysmCore.hiddenSword),
	 		       			"  X", " X ", "Y  ",
	 		       			Character.valueOf('X'), electrolysmCore.hiddenIngot,
	 		       			Character.valueOf('Y'), net.minecraft.item.Item.diamond);
	 		      
	 		   //Crafting Adv. Atomics
	 		       GameRegistry.addRecipe(new ItemStack(electrolysmCore.glassLens),
	 		    		   "XXX",
	 		    		   Character.valueOf('X'), Block.glass);
		
	 		      
	 		       GameRegistry.addRecipe(new ItemStack(electrolysmCore.nanoTech),
	 		    		   "XX", "XX",
	 		    		   Character.valueOf('X'), electrolysmCore.stickyString);
	 		       
	 		       GameRegistry.addRecipe(new ItemStack(net.minecraft.item.Item.silk),
	 		    		   "X",
	 		    		   Character.valueOf('X'), electrolysmCore.stickyString);
	 		       
	 		      GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.atomyBook), 
	 		    		   net.minecraft.item.Item.book,
	 		    		   electrolysmCore.pewter);
	}

	public static void registerSmeltingRecipes() {
		
		//WorldGen Smelting
		GameRegistry.addSmelting(electrolysmCore.hiddenDust.itemID, new ItemStack(electrolysmCore.hiddenIngot), 10F);
		
		GameRegistry.addSmelting(electrolysmCore.OrePlatinum.blockID, new ItemStack(electrolysmCore.OrePlatinum), 10F);
		
	}
}
