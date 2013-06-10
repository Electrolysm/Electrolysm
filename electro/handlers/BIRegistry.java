package mods.Electrolysm.electro.handlers;

import mods.Electrolysm.electro.electrolysmCore;
import mods.Electrolysm.electro.machines.entities.tile.TileEntityMagmaticExtractor;
import mods.Electrolysm.electro.machines.entities.tile.TileEntityMatterMachine;
import mods.Electrolysm.electro.machines.gui.GuiHandler;
import mods.Electrolysm.electro.world.WorldGenOres;
import mods.Electrolysm.electro.world.WorldGenStructures;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BIRegistry {

	public static void Registry() {
	
		/*
		 * ===============================================================================================================
		 * 										World Generation + Ores
		 * ===============================================================================================================
		 */{
				
			 			GameRegistry.registerWorldGenerator(new WorldGenOres());
			 			GameRegistry.registerWorldGenerator(new WorldGenStructures());
			 			GameRegistry.registerBlock(electrolysmCore.mixedOre);
			 			GameRegistry.registerBlock(electrolysmCore.copperOre);
			 			GameRegistry.registerBlock(electrolysmCore.tinOre);
			 			GameRegistry.registerBlock(electrolysmCore.leadOre);
			 			GameRegistry.registerBlock(electrolysmCore.silverOre);
			 			GameRegistry.registerBlock(electrolysmCore.OrePlatinum);


			 			LanguageRegistry.addName(electrolysmCore.mixedOre, "Einsteinium Ore");
			 			LanguageRegistry.addName(electrolysmCore.copperOre, "Copper Ore");
			 			LanguageRegistry.addName(electrolysmCore.tinOre, "Tin Ore");
			 			LanguageRegistry.addName(electrolysmCore.leadOre, "Lead Ore");
			 			LanguageRegistry.addName(electrolysmCore.silverOre, "silver Ore");
			 			LanguageRegistry.addName(electrolysmCore.OrePlatinum, "Redstone Infused Platinum Ore");

			 				 				 			
		                OreDictionary.registerOre("dustLead", new ItemStack(electrolysmCore.leadDust));
		                OreDictionary.registerOre("dustCopper", new ItemStack(electrolysmCore.copperDust));
		                OreDictionary.registerOre("dustSilver", new ItemStack(electrolysmCore.silverDust));
		                OreDictionary.registerOre("dustTin", new ItemStack(electrolysmCore.tinDust));
		                OreDictionary.registerOre("dustElectrum", new ItemStack(electrolysmCore.electrumDust));
		                OreDictionary.registerOre("dustFerrous", new ItemStack(electrolysmCore.ferrousDust));
		                OreDictionary.registerOre("orePlatinum", new ItemStack(electrolysmCore.OrePlatinum));
		                OreDictionary.registerOre("ingotRedstoneInfusedPlatinum", new ItemStack(electrolysmCore.ingotPlatinum));
		                OreDictionary.registerOre("dustRedstoneInfusedPlatinum", new ItemStack(electrolysmCore.dustPlatinum));


		                
		                LanguageRegistry.addName(electrolysmCore.electrumDust, "Electrum Dust");
			 			LanguageRegistry.addName(electrolysmCore.copperDust, "Copper Dust");
			 			LanguageRegistry.addName(electrolysmCore.tinDust, "Tin Dust");
			 			LanguageRegistry.addName(electrolysmCore.ferrousDust, "Ferrous Dust");
			 			LanguageRegistry.addName(electrolysmCore.leadDust, "Lead Dust");
			 			LanguageRegistry.addName(electrolysmCore.silverDust, "Silver Dust");
			 			LanguageRegistry.addName(electrolysmCore.ingotPlatinum, "Redstone Infused Platinum Ingot");
			 			LanguageRegistry.addName(electrolysmCore.dustPlatinum, "Redstone Infused Platium Dust");
			 			

			 			LanguageRegistry.addName(electrolysmCore.hiddenDust, "Hidden Matter Dust");
			 			LanguageRegistry.addName(electrolysmCore.hiddenIngot, "Hidden Matter Ingot");
			 			


			 			
			 			
			 			
		 /*
		  * ===============================================================================================================
		 * 											All Ingots
		  * ===============================================================================================================		
		  */	
		 				
		 				//Tier 1 Ingots
		 				LanguageRegistry.addName(electrolysmCore.ionicElectrum, "Ionic Electrum Ingot");
		 				LanguageRegistry.addName(electrolysmCore.ironisedGold, "Iroised Gold Ingot");
		 				LanguageRegistry.addName(electrolysmCore.tumbaga, "Tumbaga Ingot");
		 				LanguageRegistry.addName(electrolysmCore.babbitt, "Babbitt Ingot");
		 				LanguageRegistry.addName(electrolysmCore.pewter, "Pewter Ingot");
		 				LanguageRegistry.addName(electrolysmCore.sydium, "Sydium Ingot");
		 				LanguageRegistry.addName(electrolysmCore.tibetanSilver, "Tibetan Silver Ingot");
		 				
		 				
		/*
		* ===========================================================================================================
		* 										GUIs
		* ===========================================================================================================
		*/
		 		        NetworkRegistry.instance().registerGuiHandler(null, new GuiHandler());
		                GameRegistry.registerTileEntity(TileEntityMagmaticExtractor.class, "containerMagmaticExtractor");
		                GameRegistry.registerTileEntity(TileEntityMatterMachine.class, "containerMatterMachine");

		/*
		* ===========================================================================================================
		* 										Machines
		* ===========================================================================================================
		*/

		  		       GameRegistry.registerBlock(electrolysmCore.matterSythisiser);
		 		       GameRegistry.registerBlock(electrolysmCore.magmaticExtractor);
		 		       GameRegistry.registerBlock(electrolysmCore.solarCollector);
		 		       GameRegistry.registerBlock(electrolysmCore.Forge); 
		 		       GameRegistry.registerBlock(electrolysmCore.platFurnace);
		 		       
		 		       LanguageRegistry.addName(electrolysmCore.magmaticExtractor, "Magmatic Extractor");
		 		       LanguageRegistry.addName(electrolysmCore.matterSythisiser, "Matter Synthisiser");
		 		       LanguageRegistry.addName(electrolysmCore.solarCollector, "Solar Collector");
		 		       LanguageRegistry.addName(electrolysmCore.Forge, "Forge");
		 		       LanguageRegistry.addName(electrolysmCore.platFurnace, "Platinum Furnace");
		 		       
		 		       
		 		       LanguageRegistry.addName(electrolysmCore.sydiumLava, "Lava Contained by Sydium");
		 		      

//		 		       
		 		       
		/*        
		* ===========================================================================================================
		* 										Tools
		* ===========================================================================================================
		*/
		 		       	LanguageRegistry.addName(electrolysmCore.hiddenSword, "Hidden Sword");
		 		       	LanguageRegistry.addName(electrolysmCore.hiddenPicaxe, "Hidden Picaxe");
		 		       	LanguageRegistry.addName(electrolysmCore.hiddenSpade, "Hidden Spade");
		 		       	LanguageRegistry.addName(electrolysmCore.hiddenAxe, "Hidden Axe");
				
		/*
		* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		* ===========================================================================================================
		* 										Advanced Atomics
		* ===========================================================================================================
		*/
		 		       	
		 		       	LanguageRegistry.addName(electrolysmCore.atomyBook, "Atomic's Book");
		 		       	

		 		       
		 		       //Machine Parts
		 		       LanguageRegistry.addName(electrolysmCore.glassLens, "Glass Lens");
		 		       
		 		       
		 		       //Machines
		 		       //GameRegistry.registerBlock(microScope);
		 		       //GameRegistry.registerBlock(subFreezer);
		 		       
		 		       GameRegistry.registerBlock(electrolysmCore.desk);
		 		       GameRegistry.registerBlock(electrolysmCore.nanoBlock);
		 		       GameRegistry.registerBlock(electrolysmCore.platinum);
		 		       
		 		       //LanguageRegistry.addName(subFreezer, "Sub-Atomic Freezer");
		 		       //LanguageRegistry.addName(microScope, "Advanced Microscope");
		 		       
		 		       LanguageRegistry.addName(electrolysmCore.desk, "Scientist's Desk");    
		 		       LanguageRegistry.addName(electrolysmCore.nanoBlock, "Nano-Fibre Block");
		 		       LanguageRegistry.addName(electrolysmCore.nanoTech, "Nano-Fibre Sheeting");
		 		       LanguageRegistry.addName(electrolysmCore.platinum, "Redstone Infused Platinum Block");
		 		       
		 		       
		 		        
		 
		 		       //Plants
		 		       GameRegistry.registerBlock(electrolysmCore.fibrePlant);
		 		       LanguageRegistry.addName(electrolysmCore.stickyString, "Sticky String");
		 		       LanguageRegistry.addName(electrolysmCore.fibrePlant, "Fibre Plant Seeds");
		 		      
		 				}
					}
	}
