package mods.Electrolysm.electro;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DungeonHooks;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;


import mods.Electrolysm.electro.advAtomics.atomyBook;
import mods.Electrolysm.electro.advAtomics.platium;
import mods.Electrolysm.electro.advAtomics.Nano.nanoBlock;
import mods.Electrolysm.electro.advAtomics.Nano.nanoTech;
import mods.Electrolysm.electro.advAtomics.machines.desk;
import mods.Electrolysm.electro.advAtomics.machines.microScope;
import mods.Electrolysm.electro.advAtomics.machines.subFreezer;
import mods.Electrolysm.electro.advAtomics.parts.glassLens;
import mods.Electrolysm.electro.advAtomics.plants.fibrePlant;
import mods.Electrolysm.electro.advAtomics.plants.stickyString;
import mods.Electrolysm.electro.common.PacketHandler;
import mods.Electrolysm.electro.data.TickRunning;
import mods.Electrolysm.electro.data.data;
import mods.Electrolysm.electro.machines.entities.tile.TileEntityMagmaticExtractor;
import mods.Electrolysm.electro.machines.entities.tile.TileEntityMatterMachine;
import mods.Electrolysm.electro.machines.gui.GuiHandler;
import mods.Electrolysm.electro.metals.hiddenDust;
import mods.Electrolysm.electro.metals.hiddenIngot;
import mods.Electrolysm.electro.metals.sydiumLava;
import mods.Electrolysm.electro.metals.tier1.babbitt;
import mods.Electrolysm.electro.metals.tier1.ionicElectrum;
import mods.Electrolysm.electro.metals.tier1.ironisedGold;
import mods.Electrolysm.electro.metals.tier1.pewter;
import mods.Electrolysm.electro.metals.tier1.sydium;
import mods.Electrolysm.electro.metals.tier1.tibetanSilver;
import mods.Electrolysm.electro.metals.tier1.tumbaga;
import mods.Electrolysm.electro.tools.hiddenSword;
import mods.Electrolysm.electro.world.OrePlatinum;
import mods.Electrolysm.electro.world.OrePlatinum;
import mods.Electrolysm.electro.world.WorldGenOres;
import mods.Electrolysm.electro.world.WorldGenStructures;
import mods.Electrolysm.electro.world.copperOre;
import mods.Electrolysm.electro.world.ingotPlatinum;
import mods.Electrolysm.electro.world.leadOre;
import mods.Electrolysm.electro.world.mixedOre;
import mods.Electrolysm.electro.world.silverOre;
import mods.Electrolysm.electro.world.tinOre;
import mods.Electrolysm.electro.world.metalOreDrops.copperDust;
import mods.Electrolysm.electro.world.metalOreDrops.electrumDust;
import mods.Electrolysm.electro.world.metalOreDrops.ferrousDust;
import mods.Electrolysm.electro.world.metalOreDrops.ironDust;
import mods.Electrolysm.electro.world.metalOreDrops.leadDust;
import mods.Electrolysm.electro.world.metalOreDrops.silverDust;
import mods.Electrolysm.electro.world.metalOreDrops.tinDust;
import mods.Electrolysm.electro.machines.Forge;
import mods.Electrolysm.electro.machines.magmaticExtractor;
import mods.Electrolysm.electro.machines.matterSythisiser;
import mods.Electrolysm.electro.machines.solarCollector;
import mods.Electrolysm.electro.tools.hiddenSword;


	@Mod(modid="Electrolysm", name="Electrolysm", version= "0.4.9")

	@NetworkMod(channels = { "Electrolysm" }, clientSideRequired = true, serverSideRequired = true, packetHandler = PacketHandler.class)
	

	public class electrolysmCore {
	
		  
		//Creative Tab
		public static CreativeTabs TabElectrolysm = new TabElectrolysm(CreativeTabs.getNextID(),"Electrolysm");
		//End
		
		//ore Spawning
		public static boolean spawnCopperOre;
		public static boolean spawnTinOre;
		public static boolean spawnLeadOre;
		public static boolean spawnSilverOre;
		
	
		
/*
 * ===============================================================================================================
 * 										World Generation + Ores
 * ===============================================================================================================
 */
		
		public static int mixedOreID = 508;
		
		public static Block mixedOre = new mixedOre(mixedOreID);
		public static Block copperOre = new copperOre(509);
		public static Block tinOre = new tinOre(510);
		public static Block leadOre = new leadOre(511);
		public static Block silverOre = new silverOre(512);
		public static Block OrePlatinum = new OrePlatinum(513);

		//Ore Drops
		public static electrumDust electrumDust = new electrumDust(514);
		public static copperDust copperDust = new copperDust(515);
		public static tinDust tinDust = new tinDust(516);
		public static ferrousDust ferrousDust = new ferrousDust(517);
		public static leadDust leadDust = new leadDust(518);
		public static silverDust silverDust = new silverDust(519);
		
		public static hiddenDust hiddenDust = new hiddenDust(520);

		public static ingotPlatinum ingotPlatinum = new ingotPlatinum(521);

/*
* ===========================================================================================================
* 										Machines
* ===========================================================================================================
*/
		public static Block magmaticExtractor = new magmaticExtractor(501, null);
		public static Block matterSythisiser = new matterSythisiser(502, null);
		public static Block solarCollector = new solarCollector(503);
		public static Block Forge = new Forge(504, null);
		//Parts(Products)
		public static sydiumLava sydiumLava = new sydiumLava(620);

/*
* ===========================================================================================================
* 										Tools
* ===========================================================================================================
*/	
		public static hiddenSword hiddenSword = new hiddenSword(560, null);
	
		
/*
 * ===============================================================================================================
 * 											All Ingots
 * ===============================================================================================================		
 */	
	        
		//Hidden Ingot
		public static final hiddenIngot hiddenIngot = new hiddenIngot(599);
/*
* ============================================================================
* 									Tier 1
* ============================================================================		
*/	
		//Electrum + Iron (Strongish, light in colour)
		public static final ionicElectrum ionicElectrum = new ionicElectrum(600);
		
		//Iron + Gold (Brittle, Conductor of heat + electricity)
		public static final ironisedGold ironisedGold = new ironisedGold(601);
		
		//Gold + Copper (Strong, Conductor of heat + electricity)
		public static final tumbaga tumbaga = new tumbaga(602);
		
		//Copper + Tin (Flexible, Light in Colour)
		public static final babbitt babbitt = new babbitt(603);
		
		//Tin + ferrous (Flexible, Heavy) TextureDone
		public static final pewter pewter = new pewter(604);
		
		//Ferrous + Lead (Poisonous, Flammable, unstable(Deteriates into Syanic Acid(Liquid, like lava))) TextureDone
		public static final sydium sydium = new sydium(605);
		//public static syanicAcid syanicAcid = new syanicAcid(null);
				
		//Lead + Silver (Conductor of heat + electricity, Dark and shinny in colour) TextureDone
		public static final tibetanSilver tibetanSilver = new tibetanSilver(607);
		

/*
* ===========================================================================================================
* 										GUIs
* ===========================================================================================================
*/		
		public static GuiHandler guihandler = new GuiHandler();
		
        @Instance
        public static electrolysmCore GUIinstance;
        
/*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* ===========================================================================================================
* 										Advanced Atomics
* ===========================================================================================================
*/
        public static atomyBook atomyBook = new atomyBook(650);
        
        //machine Parts
        public static glassLens glassLens = new glassLens(651);
        
        //high end constructions
        public static final nanoTech nanoTech = new nanoTech(655);
        public static final Block nanoBlock	= new nanoBlock(656);
        
        //Machines
        //public static Block microScope = new microScope(660);
        public static Block desk = new desk(661);
        //public static Block subFreezer = new subFreezer(662, null);
        
        //Plants
        public static Block fibrePlant = new fibrePlant(680);
        public static stickyString stickyString = new stickyString(681);
        
        //Pressurised Furnace
        public static Block platinum = new platium(682);
        
        /* 
 * ===============================================================================================================
 * ===============================================================================================================
 * 										Config (In game Stuff)
 * ===============================================================================================================
 * ===============================================================================================================
 */
        @PreInit
        public void preInit(FMLPreInitializationEvent event) {
                Configuration config = new Configuration(event.getSuggestedConfigurationFile());
                config.load();
                
                spawnCopperOre = config.get(Configuration.CATEGORY_GENERAL, "spawnCopperOre", true).getBoolean(true);
                spawnTinOre = config.get(Configuration.CATEGORY_GENERAL, "spawnTinOre", true).getBoolean(true);
                spawnLeadOre = config.get(Configuration.CATEGORY_GENERAL, "spawnLeadOre", true).getBoolean(true);
                spawnSilverOre = config.get(Configuration.CATEGORY_GENERAL, "spawnSilverOre", true).getBoolean(true);

                config.save();
        }
        
		@PreInit
		public void loadConfiguration(FMLPreInitializationEvent evt) {
			
			//Version Check	
			// Initialize the Version Check Tick Handler (Client only)
	        TickRegistry.registerTickHandler(new TickRunning(), Side.CLIENT);


/*
 * ===============================================================================================================
 * 										World Generation + Ores
 * ===============================================================================================================
 */{
		
	 			GameRegistry.registerWorldGenerator(new WorldGenOres());
	 			GameRegistry.registerWorldGenerator(new WorldGenStructures());
	 			GameRegistry.registerBlock(mixedOre);
	 			GameRegistry.registerBlock(copperOre);
	 			GameRegistry.registerBlock(tinOre);
	 			GameRegistry.registerBlock(leadOre);
	 			GameRegistry.registerBlock(silverOre);
	 			GameRegistry.registerBlock(OrePlatinum);


	 			LanguageRegistry.addName(mixedOre, "Einsteinium Ore");
	 			LanguageRegistry.addName(copperOre, "Copper Ore");
	 			LanguageRegistry.addName(tinOre, "Tin Ore");
	 			LanguageRegistry.addName(leadOre, "Lead Ore");
	 			LanguageRegistry.addName(silverOre, "silver Ore");
	 			LanguageRegistry.addName(OrePlatinum, "Platinum Ore");

	 				 				 			
                OreDictionary.registerOre("dustLead", new ItemStack(leadDust));
                OreDictionary.registerOre("dustCopper", new ItemStack(copperDust));
                OreDictionary.registerOre("dustSilver", new ItemStack(silverDust));
                OreDictionary.registerOre("dustTin", new ItemStack(tinDust));
                OreDictionary.registerOre("dustElectrum", new ItemStack(electrumDust));
                OreDictionary.registerOre("dustFerrous", new ItemStack(ferrousDust));
                OreDictionary.registerOre("orePlatinum", new ItemStack(OrePlatinum));
                OreDictionary.registerOre("ingotPlatinum", new ItemStack(ingotPlatinum));


                
                LanguageRegistry.addName(electrumDust, "Electrum Dust");
	 			LanguageRegistry.addName(copperDust, "Copper Dust");
	 			LanguageRegistry.addName(tinDust, "Tin Dust");
	 			LanguageRegistry.addName(ferrousDust, "Ferrous Dust");
	 			LanguageRegistry.addName(leadDust, "Lead Dust");
	 			LanguageRegistry.addName(silverDust, "Silver Dust");
	 			LanguageRegistry.addName(ingotPlatinum, "Platinum Ingot");
	 			

	 			LanguageRegistry.addName(hiddenDust, "Hidden Matter Dust");
	 			LanguageRegistry.addName(hiddenIngot, "Hidden Matter Ingot");
	 			GameRegistry.addSmelting(hiddenDust.itemID, new ItemStack(hiddenIngot), 10F);
	 			GameRegistry.addSmelting(OrePlatinum.blockID, new ItemStack(OrePlatinum), 10F);


	 			//Crafting
	 			GameRegistry.addRecipe(new ItemStack(electrumDust, 3),
	 					"XY ",
	 					Character.valueOf('X'), mixedOre,
	 					Character.valueOf('Y'), Block.cobblestone);
	 			
	 			GameRegistry.addRecipe(new ItemStack(ferrousDust, 5),
	 					"XYY",
	 					Character.valueOf('X'), mixedOre,
	 					Character.valueOf('Y'), Block.cobblestone);
	 			
	 			
 /*
  * ===============================================================================================================
 * 											All Ingots
  * ===============================================================================================================		
  */	
 				
 				//Tier 1 Ingots
 				LanguageRegistry.addName(ionicElectrum, "Ionic Electrum Ingot");
 				LanguageRegistry.addName(ironisedGold, "Iroised Gold Ingot");
 				LanguageRegistry.addName(tumbaga, "Tumbaga Ingot");
 				LanguageRegistry.addName(babbitt, "Babbitt Ingot");
 				LanguageRegistry.addName(pewter, "Pewter Ingot");
 				LanguageRegistry.addName(sydium, "Sydium Ingot");
 				LanguageRegistry.addName(tibetanSilver, "Tibetan Silver Ingot");
 				
 				//Crafting
 				//Tier 1
 				GameRegistry.addRecipe(new ItemStack(ionicElectrum, 2),
 						"XYZ",
 						Character.valueOf('X'), electrumDust,
 						Character.valueOf('Y'), net.minecraft.item.Item.ingotIron,
 						Character.valueOf('Z'), net.minecraft.item.Item.coal);
 				
 				GameRegistry.addRecipe(new ItemStack(ironisedGold, 2),
 						"XYZ",
 						Character.valueOf('X'), net.minecraft.item.Item.ingotIron,
 						Character.valueOf('Y'), net.minecraft.item.Item.ingotGold,
 						Character.valueOf('Z'), net.minecraft.item.Item.coal);
 				
 				GameRegistry.addRecipe(new ItemStack(tumbaga, 2),
 						"XYZ",
 						Character.valueOf('X'), net.minecraft.item.Item.ingotGold,
 						Character.valueOf('Y'), copperDust,
						Character.valueOf('Z'), net.minecraft.item.Item.coal);
 				
 				GameRegistry.addRecipe(new ItemStack(babbitt, 2),
 						"XYZ",
 						Character.valueOf('X'), copperDust,
 						Character.valueOf('Y'), tinDust,
 						Character.valueOf('Z'), net.minecraft.item.Item.coal);
 				
 				GameRegistry.addRecipe(new ItemStack(pewter, 2),
 						"XYZ",
 						Character.valueOf('X'), tinDust,
 						Character.valueOf('Y'), ferrousDust,
					    Character.valueOf('Z'), net.minecraft.item.Item.coal);
 				
 				GameRegistry.addRecipe(new ItemStack(sydium, 2),
 						"XYZ",
 						Character.valueOf('X'), ferrousDust,
 						Character.valueOf('Y'), leadDust,
						Character.valueOf('Z'), net.minecraft.item.Item.coal);
 				
 				GameRegistry.addRecipe(new ItemStack(tibetanSilver, 2),
 						"XYZ",
 						Character.valueOf('X'), leadDust,
 						Character.valueOf('Y'), silverDust,
						Character.valueOf('Z'), net.minecraft.item.Item.coal);
/*
* ===========================================================================================================
* 										GUIs
* ===========================================================================================================
*/
 		        NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
                GameRegistry.registerTileEntity(TileEntityMagmaticExtractor.class, "containerMagmaticExtractor");
                GameRegistry.registerTileEntity(TileEntityMatterMachine.class, "containerMatterMachine");

/*
* ===========================================================================================================
* 										Machines
* ===========================================================================================================
*/

  		       GameRegistry.registerBlock(matterSythisiser);
 		       GameRegistry.registerBlock(magmaticExtractor);
 		       GameRegistry.registerBlock(solarCollector);
 		       GameRegistry.registerBlock(Forge); 		    
 		       
 		       LanguageRegistry.addName(magmaticExtractor, "Magmatic Extractor");
 		       LanguageRegistry.addName(matterSythisiser, "Matter Synthisiser");
 		       LanguageRegistry.addName(solarCollector, "Solar Collector");
 		       LanguageRegistry.addName(Forge, "Forge");
 		       
 		       
 		       LanguageRegistry.addName(sydiumLava, "Lava Contained by Sydium");
 		       
 		       //Crafting
 		       //Machines
 		       GameRegistry.addRecipe(new ItemStack(magmaticExtractor),
 		    		   "XYX", "ZMZ", "XNX",
 		    		   Character.valueOf('X'), net.minecraft.item.Item.ingotIron,
 		    		   Character.valueOf('Y'), net.minecraft.item.Item.redstone,
 		    		   Character.valueOf('Z'), net.minecraft.item.Item.ingotGold,
 		    		   Character.valueOf('M'), net.minecraft.item.Item.bucketEmpty,
 		    		   Character.valueOf('N'), tumbaga);
 		       
 		       GameRegistry.addRecipe(new ItemStack(solarCollector),
 		    		   "XXX", "YZY", "AAA",
 		    		   Character.valueOf('X'), Block.glass,
 		    		   Character.valueOf('Y'), net.minecraft.item.Item.redstone,
 		    		   Character.valueOf('Z'), tibetanSilver,
 		    		   Character.valueOf('A'), net.minecraft.item.Item.ingotIron);
 		       
 		       GameRegistry.addRecipe(new ItemStack(matterSythisiser),
 		    		   "XZX", "XMX", "XYX",
 		    		   Character.valueOf('X'), ionicElectrum,
 		    		   Character.valueOf('Y'), ironisedGold,
 		    		   Character.valueOf('Z'), babbitt,
 		    		   Character.valueOf('M'), Block.furnaceIdle);


// 		       
 		       
/*        
* ===========================================================================================================
* 										Tools
* ===========================================================================================================
*/
 		       	LanguageRegistry.addName(hiddenSword, "Hidden Sword");
 		       	
 		       	GameRegistry.addRecipe(new ItemStack(hiddenSword),
 		       			"  X", " X ", "Y  ",
 		       			Character.valueOf('X'), hiddenIngot,
 		       			Character.valueOf('Y'), net.minecraft.item.Item.diamond);
 		   
		
/*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* ===========================================================================================================
* 										Advanced Atomics
* ===========================================================================================================
*/
 		       	
 		       	LanguageRegistry.addName(atomyBook, "Atomic's Book");
 		       	
 		       GameRegistry.addShapelessRecipe(new ItemStack(atomyBook), 
 		    		   net.minecraft.item.Item.book,
 		    		   electrolysmCore.pewter);
 		       
 		       //Machine Parts
 		       LanguageRegistry.addName(glassLens, "Glass Lens");
 		       
 		       
 		       //Machines
 		       //GameRegistry.registerBlock(microScope);
 		       //GameRegistry.registerBlock(subFreezer);
 		       
 		       GameRegistry.registerBlock(desk);
 		       GameRegistry.registerBlock(nanoBlock);
 		       GameRegistry.registerBlock(platinum);
 		       
 		       //LanguageRegistry.addName(subFreezer, "Sub-Atomic Freezer");
 		       //LanguageRegistry.addName(microScope, "Advanced Microscope");
 		       
 		       LanguageRegistry.addName(desk, "Scientist's Desk");    
 		       LanguageRegistry.addName(nanoBlock, "Nano-Fibre Block");
 		       LanguageRegistry.addName(nanoTech, "Nano-Fibre Sheeting");
 		       LanguageRegistry.addName(platinum, "Platinum Block");
 		       
 		       //Recipes
 		       GameRegistry.addRecipe(new ItemStack(glassLens),
 		    		   "XXX",
 		    		   Character.valueOf('X'), Block.glass);
 		        
 
 		       //Plants
 		       GameRegistry.registerBlock(fibrePlant);
 		       LanguageRegistry.addName(stickyString, "Sticky String");
 		       LanguageRegistry.addName(fibrePlant, "Fibre Plant Seeds");
 		       
 		       GameRegistry.addRecipe(new ItemStack(nanoTech),
 		    		   "XX", "XX",
 		    		   Character.valueOf('X'), stickyString);
 		       
 		       GameRegistry.addRecipe(new ItemStack(net.minecraft.item.Item.silk),
 		    		   "X",
 		    		   Character.valueOf('X'), stickyString);
 				}
			}
		}

 				
	