package mods.Electrolysm.electro;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.Tessellator;
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
import mods.Electrolysm.electro.handlers.BICrafting;
import mods.Electrolysm.electro.handlers.BIRegistry;
import mods.Electrolysm.electro.handlers.IDHandler;
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
import mods.Electrolysm.electro.tools.hiddenAxe;
import mods.Electrolysm.electro.tools.lighteningAltering;
import mods.Electrolysm.electro.tools.hiddenPicaxe;
import mods.Electrolysm.electro.tools.hiddenSpade;
import mods.Electrolysm.electro.tools.hiddenSword;
import mods.Electrolysm.electro.world.OrePlatinum;
import mods.Electrolysm.electro.world.OrePlatinum;
import mods.Electrolysm.electro.world.WorldGenOres;
import mods.Electrolysm.electro.world.WorldGenStructures;
import mods.Electrolysm.electro.world.copperOre;
import mods.Electrolysm.electro.world.dustPlatinum;
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
import mods.Electrolysm.electro.machines.Crusher;
import mods.Electrolysm.electro.machines.Forge;
import mods.Electrolysm.electro.machines.magmaticExtractor;
import mods.Electrolysm.electro.machines.matterSythisiser;
import mods.Electrolysm.electro.machines.platFurnace;
import mods.Electrolysm.electro.machines.solarCollector;
import mods.Electrolysm.electro.tools.hiddenSword;


	@Mod(modid="Electrolysm", name="Electrolysm", version= "0.6.1")

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
		
		public static Block mixedOre = new mixedOre(IDHandler.mixedOreID);
		public static Block copperOre = new copperOre(IDHandler.copperOreID);
		public static Block tinOre = new tinOre(IDHandler.tinOreID);
		public static Block leadOre = new leadOre(IDHandler.leadOreID);
		public static Block silverOre = new silverOre(IDHandler.silverOreID);
		public static Block OrePlatinum = new OrePlatinum(IDHandler.platiumOreID);

		//Ore Drops
		public static electrumDust electrumDust = new electrumDust(IDHandler.electrumDustID);
		public static copperDust copperDust = new copperDust(IDHandler.copperDustID);
		public static tinDust tinDust = new tinDust(IDHandler.tinDustID);
		public static ferrousDust ferrousDust = new ferrousDust(IDHandler.ferrousDustID);
		public static leadDust leadDust = new leadDust(IDHandler.leadDustID);
		public static silverDust silverDust = new silverDust(IDHandler.silverDustID);
		public static dustPlatinum dustPlatinum = new dustPlatinum(IDHandler.platinumDustID);
		
		public static hiddenDust hiddenDust = new hiddenDust(IDHandler.hiddenDustID);

		public static ingotPlatinum ingotPlatinum = new ingotPlatinum(IDHandler.platinumIngotID);

/*
* ===========================================================================================================
* 										Machines
* ===========================================================================================================
*/
		public static Block magmaticExtractor = new magmaticExtractor(IDHandler.magmaticExtractorID, null);
		public static Block matterSythisiser = new matterSythisiser(IDHandler.matterSynthisiserID, null);
		public static Block solarCollector = new solarCollector(IDHandler.solarCollectorID);
		public static Block Forge = new Forge(IDHandler.forgeID, false);
		public static Block platFurnace = new platFurnace(IDHandler.platinumFurnaceID, null);
		public static Block Crusher = new Crusher(IDHandler.CrusherID, null);

		//Parts(Products)
		public static sydiumLava sydiumLava = new sydiumLava(IDHandler.sydiumLavaID);

/*
* ===========================================================================================================
* 										Tools
* ===========================================================================================================
*/	
		public static hiddenSword hiddenSword = new hiddenSword(IDHandler.hiddenSwordID, null);
	    public static hiddenPicaxe	hiddenPicaxe = new hiddenPicaxe(IDHandler.hiddenPicaxeID);
	    public static hiddenSpade hiddenSpade = new hiddenSpade(IDHandler.hiddenSpadeID);
	    public static hiddenAxe hiddenAxe = new hiddenAxe(IDHandler.hiddenAxeID);
	    
/*
 * ===============================================================================================================
 * 											All Ingots
 * ===============================================================================================================		
 */	
	        
		//Hidden Ingot
		public static final hiddenIngot hiddenIngot = new hiddenIngot(IDHandler.hiddenIngotID);
/*
* ============================================================================
* 									Tier 1
* ============================================================================		
*/	
		//Electrum + Iron (Strongish, light in colour)
		public static final ionicElectrum ionicElectrum = new ionicElectrum(IDHandler.ionicElectrumID);
		
		//Iron + Gold (Brittle, Conductor of heat + electricity)
		public static final ironisedGold ironisedGold = new ironisedGold(IDHandler.ironisedGoldID);
		
		//Gold + Copper (Strong, Conductor of heat + electricity)
		public static final tumbaga tumbaga = new tumbaga(IDHandler.tumbagaID);
		
		//Copper + Tin (Flexible, Light in Colour)
		public static final babbitt babbitt = new babbitt(IDHandler.babbittID);
		
		//Tin + ferrous (Flexible, Heavy) TextureDone
		public static final pewter pewter = new pewter(IDHandler.pewterID);
		
		//Ferrous + Lead (Poisonous, Flammable, unstable(Deteriates into Syanic Acid(Liquid, like lava))) TextureDone
		public static final sydium sydium = new sydium(IDHandler.sydiumID);
		//public static syanicAcid syanicAcid = new syanicAcid(null);
				
		//Lead + Silver (Conductor of heat + electricity, Dark and shinny in colour) TextureDone
		public static final tibetanSilver tibetanSilver = new tibetanSilver(IDHandler.tibetanSilverID);
		

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
        public static atomyBook atomyBook = new atomyBook(IDHandler.atomyBookID);
        
        //machine Parts
        public static glassLens glassLens = new glassLens(IDHandler.glassLensID);
        
        //high end constructions
        public static final nanoTech nanoTech = new nanoTech(IDHandler.nanoTechID);
        public static final Block nanoBlock	= new nanoBlock(IDHandler.nanoBlockID);
        
        //Machines
        //public static Block microScope = new microScope(660);
        public static Block desk = new desk(IDHandler.deskID);
        //public static Block subFreezer = new subFreezer(662, null);
        
        //Plants
        public static Block fibrePlant = new fibrePlant(IDHandler.fibrePlantID);
        public static stickyString stickyString = new stickyString(IDHandler.stickyStringID);
        
        //Pressurised Furnace
        public static Block platinum = new platium(IDHandler.platinumID);
        
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
	        //Registries
	        BICrafting.registerCraftingRecipes();
	        BICrafting.registerSmeltingRecipes();
	        BICrafting.registerMODCrafting();
	        
	        BIRegistry.Registry();



		}
	}

 				
	