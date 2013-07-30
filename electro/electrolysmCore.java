package mods.Electrolysm.electro;

import mods.Electrolysm.electro.basic.biome.diseasedBiome;
import mods.Electrolysm.electro.basic.biome.diseasedGrass;
import mods.Electrolysm.electro.basic.common.PacketHandler;
import mods.Electrolysm.electro.basic.handlers.BICrafting;
import mods.Electrolysm.electro.basic.handlers.BIRegistry;
import mods.Electrolysm.electro.basic.handlers.IDHandler;
import mods.Electrolysm.electro.basic.handlers.TickRunning;
import mods.Electrolysm.electro.basic.handlers.VersionHandler;
import mods.Electrolysm.electro.basic.machines.Crusher;
import mods.Electrolysm.electro.basic.machines.Forge;
import mods.Electrolysm.electro.basic.machines.magmaticExtractor;
import mods.Electrolysm.electro.basic.machines.matterSythisiser;
import mods.Electrolysm.electro.basic.machines.platFurnace;
import mods.Electrolysm.electro.basic.machines.solarCollector;
import mods.Electrolysm.electro.basic.machines.gui.GuiHandler;
import mods.Electrolysm.electro.basic.metals.babbitt;
import mods.Electrolysm.electro.basic.metals.hiddenDust;
import mods.Electrolysm.electro.basic.metals.hiddenIngot;
import mods.Electrolysm.electro.basic.metals.ionicElectrum;
import mods.Electrolysm.electro.basic.metals.ironisedGold;
import mods.Electrolysm.electro.basic.metals.pewter;
import mods.Electrolysm.electro.basic.metals.sydium;
import mods.Electrolysm.electro.basic.metals.sydiumLava;
import mods.Electrolysm.electro.basic.metals.tibetanSilver;
import mods.Electrolysm.electro.basic.metals.tumbaga;
import mods.Electrolysm.electro.basic.research.RNRegistry;
import mods.Electrolysm.electro.basic.research.researchNotes;
import mods.Electrolysm.electro.basic.tools.hiddenAxe;
import mods.Electrolysm.electro.basic.tools.hiddenPicaxe;
import mods.Electrolysm.electro.basic.tools.hiddenSpade;
import mods.Electrolysm.electro.basic.tools.hiddenSword;
import mods.Electrolysm.electro.basic.world.OrePlatinumRed;
import mods.Electrolysm.electro.basic.world.copperOre;
import mods.Electrolysm.electro.basic.world.dustPlatinumRed;
import mods.Electrolysm.electro.basic.world.ingotPlatinumRed;
import mods.Electrolysm.electro.basic.world.leadOre;
import mods.Electrolysm.electro.basic.world.mixedOre;
import mods.Electrolysm.electro.basic.world.silverOre;
import mods.Electrolysm.electro.basic.world.tinOre;
import mods.Electrolysm.electro.basic.world.metalOreDrops.copperDust;
import mods.Electrolysm.electro.basic.world.metalOreDrops.electrumDust;
import mods.Electrolysm.electro.basic.world.metalOreDrops.ferrousDust;
import mods.Electrolysm.electro.basic.world.metalOreDrops.leadDust;
import mods.Electrolysm.electro.basic.world.metalOreDrops.silverDust;
import mods.Electrolysm.electro.basic.world.metalOreDrops.tinDust;
import mods.Electrolysm.electro.biology.ItemAdmin;
import mods.Electrolysm.electro.biology.bacteria.Bacteria;
import mods.Electrolysm.electro.biology.bacteria.BacteriaRegistry;
import mods.Electrolysm.electro.biology.entity.EntityZombie_Scientist;
import mods.Electrolysm.electro.biology.plants.fibrePlant;
import mods.Electrolysm.electro.biology.plants.stickyString;
import mods.Electrolysm.electro.physics.atomyBook;
import mods.Electrolysm.electro.physics.platium;
import mods.Electrolysm.electro.physics.Nano.nanoBlock;
import mods.Electrolysm.electro.physics.Nano.nanoTech;
import mods.Electrolysm.electro.physics.lasers.heatVent;
import mods.Electrolysm.electro.physics.lasers.laserAmp;
import mods.Electrolysm.electro.physics.lasers.laserBoiler;
import mods.Electrolysm.electro.physics.lasers.laserCase;
import mods.Electrolysm.electro.physics.lasers.laserDiff;
import mods.Electrolysm.electro.physics.lasers.laserGen;
import mods.Electrolysm.electro.physics.lasers.laserLight;
import mods.Electrolysm.electro.physics.machines.desk;
import mods.Electrolysm.electro.physics.parts.glassLens;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

	@Mod(modid="Electrolysm", name="Electrolysm", version= "0.6.2")

	@NetworkMod(channels = { "Electrolysm" }, clientSideRequired = true, serverSideRequired = true, packetHandler = PacketHandler.class)
	    
	//EntityRegistry.registerModEntity(EntityZombie_Scientist.class, "Zombie_Scientist", 2, this, 80, 3, true))
	


	public class electrolysmCore {

		  
		//Creative Tab
		public static CreativeTabs TabElectrolysm = new TabElectrolysm(CreativeTabs.getNextID(),"Electrolysm|Basics of Science");
		public static CreativeTabs TabElectrolysmPhysics = new TabElectrolysmPhysics(CreativeTabs.getNextID(),"Electrolysm|Physics");
		public static CreativeTabs TabElectrolysmBiology = new TabElectrolysmBiology(CreativeTabs.getNextID(),"Electrolysm|Biology");
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
		public static Block OrePlatinumRed = new OrePlatinumRed(IDHandler.platiumOreID);

		//Ore Drops
		public static electrumDust electrumDust = new electrumDust(IDHandler.electrumDustID);
		public static copperDust copperDust = new copperDust(IDHandler.copperDustID);
		public static tinDust tinDust = new tinDust(IDHandler.tinDustID);
		public static ferrousDust ferrousDust = new ferrousDust(IDHandler.ferrousDustID);
		public static leadDust leadDust = new leadDust(IDHandler.leadDustID);
		public static silverDust silverDust = new silverDust(IDHandler.silverDustID);
		public static dustPlatinumRed dustPlatinumRed = new dustPlatinumRed(IDHandler.platinumDustID);
		
		public static hiddenDust hiddenDust = new hiddenDust(IDHandler.hiddenDustID);

		public static ingotPlatinumRed ingotPlatinumRed = new ingotPlatinumRed(IDHandler.platinumIngotID);

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
		
        @Instance("Electrolysm")
        public static electrolysmCore GUIinstance;
        
/*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* ===========================================================================================================
* 										Advanced Physics
* ===========================================================================================================
*/		
        //Basics
        public static atomyBook atomyBook = new atomyBook(IDHandler.atomyBookID, null);
        public static glassLens glassLens = new glassLens(IDHandler.glassLensID);
        public static Block desk = new desk(IDHandler.deskID);
        public static Block platinum = new platium(IDHandler.platinumID);
        
        //Lasers
        public static heatVent heatVent = new heatVent(IDHandler.heatVentID);
        public static laserLight laserLight = new laserLight(IDHandler.laserLightID);
        public static Block laserCase = new laserCase(IDHandler.laserCassID, null);
        public static Block laserGen = new laserGen(IDHandler.laserGenID, null);
        public static Block laserAmp = new laserAmp(IDHandler.laserAmpID, null);
        public static Block laserDiff = new laserDiff(IDHandler.laserDiffID, null);
        public static Block laserBoiler = new laserBoiler(IDHandler.laserBoilerID, null);
               
        
        
/*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* ===========================================================================================================
* 										Advanced Biology
* ===========================================================================================================
*/
        
        //Zombie Scientist
        public static Item ItemAdmin = new ItemAdmin(IDHandler.ItemAdminID);
        
        //Plants
        public static Block fibrePlant = new fibrePlant(IDHandler.fibrePlantID);
        public static stickyString stickyString = new stickyString(IDHandler.stickyStringID);
        public static final nanoTech nanoTech = new nanoTech(IDHandler.nanoTechID);
        public static final Block nanoBlock	= new nanoBlock(IDHandler.nanoBlockID);
        //Biome
        public static final Block diseasedGrass = new diseasedGrass(IDHandler.biomeIDs.grass, null);
		public static final BiomeGenBase diseasedBiomeObj = new diseasedBiome(IDHandler.biomeIDs.biomeID);
        public BiomeGenBase diseasedBiome = diseasedBiomeObj;
        /* 
 * ===============================================================================================================
 * ===============================================================================================================
 * 										Config (In game Stuff)
 * ===============================================================================================================
 * ===============================================================================================================
 */
        @PreInit
        public void preInit(FMLPreInitializationEvent event) {
        	configHandler.init(event.getSuggestedConfigurationFile());

        configHandler.init(event.getSuggestedConfigurationFile());
        }
        
		@PreInit
		public void loadConfiguration(FMLPreInitializationEvent evt) throws Exception {
			
			//Version Check	
			// Initialize the Version Check Tick Handler (Client only)
	        TickRegistry.registerTickHandler(new TickRunning(), Side.CLIENT);
	        TickRegistry.registerTickHandler(new VersionHandler(), Side.CLIENT);
	        //Registries
	        BICrafting.registerCraftingRecipes();
	        BICrafting.registerSmeltingRecipes();
	        BICrafting.registerMODCrafting();
	        BIRegistry.Registry();
	        VersionHandler.checkVersion();
	        
	        //Bacteria
	        Bacteria.loadBacteria();
	        BacteriaRegistry.registerBacteria();
	        //Research Notes
	        researchNotes.advPhy();
	        researchNotes.advBio();
	        RNRegistry.registerNotes();
	        //Zombie Scientist
	        EntityRegistry.registerModEntity(EntityZombie_Scientist.class, "Zombie_Scientist", 2, this, 80, 3, true);
	        //Biome
	        GameRegistry.addBiome(diseasedBiome);


		}
	}

 				
	