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
		public static dustPlatinum dustPlatinum = new dustPlatinum(520);
		
		public static hiddenDust hiddenDust = new hiddenDust(521);

		public static ingotPlatinum ingotPlatinum = new ingotPlatinum(522);

/*
* ===========================================================================================================
* 										Machines
* ===========================================================================================================
*/
		public static Block magmaticExtractor = new magmaticExtractor(501, null);
		public static Block matterSythisiser = new matterSythisiser(502, null);
		public static Block solarCollector = new solarCollector(503);
		public static Block Forge = new Forge(504, null);
		public static Block platFurnace = new platFurnace(505, null);

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
	        //Registries
	        BICrafting.registerCraftingRecipes();
	        BICrafting.registerSmeltingRecipes();
	        BICrafting.registerMODCrafting();
	        
	        BIRegistry.Registry();

	        Tessellator tessellator = Tessellator.instance;


		}
	}

 				
	