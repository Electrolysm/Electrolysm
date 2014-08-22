/**
 * @author Ben
 * TODO Finish Crafting recipes
 * TODO Fix bugs
 */
package electrolysm.electro;

import electrolysm.api.LoggerHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electrolysm.electro.client.ClientProxy;
import electrolysm.electro.common.CommandStardate;
import electrolysm.electro.handlers.*;
import electrolysm.electro.handlers.network.PacketHandler;
import electrolysm.electro.handlers.version.ElectrolysmVersion;
import electrolysm.electro.machines.advMachines.*;
import electrolysm.electro.misc.block.basic.*;
import electrolysm.electro.misc.block.ironFrames;
import electrolysm.electro.misc.block.liquids.fluidStorage;
import electrolysm.electro.misc.block.liquids.plasma;
import electrolysm.electro.misc.crafting.acidBurns;
import electrolysm.electro.misc.crafting.items.*;
import electrolysm.electro.misc.item.basic.drillCasing;
import electrolysm.electro.misc.item.basic.plasmaDrill;
import electrolysm.electro.misc.item.fuels.electroContain;
import electrolysm.electro.misc.item.tools.ItemInsulatedScrewdriver;
import electrolysm.electro.oreProccessing.*;
import electrolysm.electro.powerSystem.*;
import electrolysm.electro.powerSystem.generators.*;
import electrolysm.electro.sciences.ItemArmorLab;
import electrolysm.electro.sciences.alloyFurnace.BlockAlloyFurnace;
import electrolysm.electro.world.*;
import electrolysm.electro.world.biome.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.potion.Potion;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

import java.io.File;

//import assets.electrolysm.electrolysm.electro.handlers.CraftingHandler;

@Mod(modid = Referance.MOD_REF.MOD_ID, name = Referance.MOD_REF.MOD_ID, version = Referance.MOD_REF.VERSION)

public class Electrolysm
{
    private static String[] ContectedTexture = { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    public static CreativeTabs TabElectrolysm = new TabElectrolysm(CreativeTabs.getNextID(), "electrolysm.core");
    //public static CreativeTabs TabElements = new TabElements(CreativeTabs.getNextID(), "Electrolysm|Elements & Wizardy");
    
    public static GUIHandler guiHandler = new GUIHandler();

    @Instance("Electrolysm")
    public static Electrolysm GUIInstance;
    //Advanced Machines
    public static Block injector = new injector().setBlockName("injector");
    public static Item injectionArm = new injectionArm();

    public static Item labCoat = new ItemArmorLab(2, "labCoat");
    public static Item labGoggles = new ItemArmorLab(0, "labGoggles");

    //World Generation
    public static Block graphite = new graphite().setBlockName("graphite");
    public static Item chunkGraphite = new chunkGraphite();
    public static Item copperIngot = new copperIngot();
    public static Block copperOre = new copperOre().setBlockName("copperOre");
    public static Block tinOre = new tinOre().setBlockName("tinOre");
    public static Block sulphurOre = new sulpherOre().setBlockName("sulfurOre");
    public static Item sulphur = new sulphur();
    public static Item ingots = new ingots();
    public static Item Scandium = new Scandium();
    public static Block Yttrium = new Yttrium().setBlockName("yttrium");
    public static Block aluminiumOre = new aluminiumOre().setBlockName("aluminiumOre");
    public static Item aluminiumIngot = new aluminiumIngot();

    //Biome
    public static Item spawnZS = new spawnZS();
    public static Block diseaseGrass = new diseasedGrass().setBlockName("diseasedGrass");
    public static BiomeGenBase diseasedBiome = new diseasedBiome(configHandler.biomeID);
    public static Block diseasedSapling = WorldGenDiseasedTree.initialiseTree("sapling");
    public static Block diseasedLog = WorldGenDiseasedTree.initialiseTree("log");
    public static Block diseasedLeaves = WorldGenDiseasedTree.initialiseTree("leaves");
    //See WorldGenDiseasedTree.java for tree blocks
    
    //Security
    public static Block blastProof = new blastProof().setBlockName("blastProof");
    public static Block blastBrick = new blastBrick().setBlockName("blastBrick");
    public static Block blastDoor = new blastDoor().setBlockName("blastDoor");
    public static Block blastGlass = new blastGlass(null, false, ContectedTexture).setBlockName("blastGlass");
    public static Block modBlastGlass = new modBlastGlass(null, false, ContectedTexture).setBlockName("blastGlassMod");
    public static Item glassModifire = new glassModifier();
    public static Block stoneObsidian = new stoneObsidian().setBlockName("stoneObsidian");
    //Tools
    public static Item hammer = new hammer();
    public static Item insulatedScrewdriver = new ItemInsulatedScrewdriver();
    
    public static ItemArmor.ArmorMaterial PLASTIC = EnumHelper.addArmorMaterial("PLASTIC", 10, new int[]{1, 3, 2, 1}, 5);

    //Liquids
    public static Block plasma = new plasma().setBlockName("plasma");
    public static Item fluidStorage = new fluidStorage();
    public static Item fluidRegistry/* = new fluidRegistry(IDHandler.advAtomics.fluid.fluidRegistryID)*/;

    //Machines
    public static Block energiser = new energiser().setBlockName("energiser");
    public static Item energisingRod = new energisingRod();
    public static Block charger = new charger().setBlockName("charger");
    //Items
    //Tools
    public static Item plasmaDrill = new plasmaDrill();
    public static Item drillCasing = new drillCasing();
    public static Block alloyFurnace = new BlockAlloyFurnace();

    //Power System
    public static Block basicCable = new basicCable().setBlockName("basicCable");
    //public static Item basicBattery = new basicBattery(1000, 0).setUnlocalizedName("basicBattery");
    //public static Item advancedBattery = new advancedBattery(8000, 1).setUnlocalizedName("advancedBattery");
    //public static Item experimentalBattery = new experimentalBattery(64000, 2).setUnlocalizedName("experimentalBattery");
    public static Block advancedGenerator = new advancedGenerator().setBlockName("advancedGenerator")
            .setCreativeTab(TabElectrolysm);
    public static Block thermalGenerator = new thermalGenerator().setBlockName("thermalGenerator");
    public static Block solarPanel = new BlockSolarPanel().setBlockName("solarPanel");
    public static Block advGenActive = new BlockAdvGenAcive().setBlockName("advGenActive");
    public static Block genActive = new BlockGenActive().setBlockName("genActive");

    public static Block energyRelay = new BlockEnergyRelay().setBlockName("energyRelay");
    public static Block basicEnergyStorage = new basicEnergyStorage().setBlockName("basicEnergyStorage");
    public static Block advEnergyStorage = new BlockAdvEnergyStorage().setBlockName("advEnergyStorage");
    public static Block creativeEnergyStorage = new BlockCreativeEnergyCore().setBlockName("creativeEnergyCore");
    public static Block generator = new generator().setBlockName("coalGen")
            .setCreativeTab(TabElectrolysm);
    public static Item crystal1 = new ItemCrafting().setUnlocalizedName("crystalTier1");
    public static Item crystal2 = new ItemCrafting().setUnlocalizedName("crystalTier2");
    public static Item energyMeter = new energyMeter();
    public static Block matterGen = new matterGen().setBlockName("matterGen");
    public static Block ironFrames = new ironFrames().setBlockName("ironFrames");

    //Ore Proccessing
    public static BlockContainer crusher = (BlockContainer) new crusher(false)
    				.setCreativeTab(TabElectrolysm).setBlockName("crusher");
    public static Block liquidiser = new liquidiser(false).setBlockName("liquidiser");
    public static Block electrolisisCore = new electrolisisCore().setBlockName("electrolysisCore");
    public static Block electrolChamber = new electrolChamber(null, false, ContectedTexture).setBlockName("electrolChamber");
    public static Block seperator = new seporator(false).setBlockName("seperator");
    public static Block improvedFurnace = new improvedFurnace().setBlockName("improvedFurnace")
            .setCreativeTab(TabElectrolysm);
    public static BlockContainer smeltory = (BlockContainer) new smeltory(false).setCreativeTab(TabElectrolysm)
            .setBlockName("smeltory");
    public static Item impureDusts = new impureDusts();
    public static Item dusts = new dusts();
    public static Item node = new node();
    public static Block sulpuricAcid = new sulphuricAcid().setBlockName("sulphuricAcid");
    public static Item neutraliser = new ItemNeutraliser();
    public static Block nettedBlock = new nettedBlock().setBlockName("nettedBlock");
    public static Item net = new net();
    public static Item crystal = new crystalOre();
    
    public static Block crusherActive = new crusher(true).setBlockName("crusherActive");
    public static Block smeltoryActive = new smeltory(true).setBlockName("smeltoryActive");
    public static Block improvedFurnaceActive = new improvedFurnace(true).setBlockName("improvedFurnaceActive");

    // items for crafting
    public static Item diamondShard = new diamondShard();
    public static Item luminousRedstone = new luminousRedstone();
    public static Block BlockLumRed = new BlockLumRed().setBlockName("blockLumeRed");
    public static Item crystalBase = new crystalBase();
    public static Item ballOfPlastic = new ballOfPlastic();
    public static Item endoInsulator = new endoInsulator();
    public static Item microchipBoard = new microchipBoard();
    public static Item transistor = new transistor();
    public static Item CPU = new CPU();
    public static Item BasicMicrochip = new BasicMicrochip();
    public static Item advancedMicrochip = new advancedMicrochip();
    public static Item grindStone = new grindStone();
    public static Item inkAndQuill = new inkAndQuill();
    public static Item experimentalMicrochip = new experimentalMicrochip();
    public static Item advancedCPU = new advancedCPU();
    public static Item graphiteRod = new graphiteRod();
    public static Item electroMagnet = new ItemCrafting().setUnlocalizedName("electMag");
    public static Potion acidBurns = new acidBurns(configHandler.acidBurnsID, true, 0);
    public static Item steel = new ItemCrafting().setUnlocalizedName("steel");
    public static Block steelBlock = new BlockCrafting(6.23F, "steelBlock", Material.iron);
    public static Item pureCopperIngot = new pureCopperIngot();
    public static Item silicon = new silicon();
    public static Block antiMatterCasing = new antiMatterCasing().setBlockName("antiMatterCasing");
    public static Block magnet = new magnet().setBlockName("magnet");
    public static Item bronze = new ItemCrafting().setUnlocalizedName("ingotBronze");

    //Fuels
    public static Item electroContain = new electroContain();
    public static Item improvedCoal = new ItemCrafting("improvedCoal");

    //Assembly Systems
    public static Block roboticBase = new BlockCrafting(5F, "roboticBase", Material.iron).setBlockName("roboticBase");

    /*
     * ===============================================================================================================
     * ===============================================================================================================
     * 										Config (In game Stuff)
     * ===============================================================================================================
     * ===============================================================================================================
     */
    
    long startTime;
    //private BiomeDictionary.Type DISEASED = new diseasedWorldType();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	startTime = System.currentTimeMillis();

    	//ResearchHandler.downloadLabSkin();
        File configFile = new File("config/Electrolysm/Electrolysm.cfg");
        new ElectrolysmVersion(Referance.MOD_ID_LOWER, Referance.MOD_REF.VERSION, MinecraftForge.MC_VERSION).register();
        PacketHandler.init();
        configHandler.init(configFile);
        NewsCheck.check();
        BetaHandler.beta();
        DownloadHandler.downloadAndExtractResearchData();
        RegisterBlock.register();
        RegisterBlock.registerItems();
        //new MultipartHandler();
        new ElectrolysmLootHandler();
        Names.addName();
        Register.addOreDictionary();
        TileEntityMappingHandler.addMappings();

        this.addBiome();

        EntityRegistry.registerModEntity(EntityZombie_Scientist.class, "Zombie Scientist", 2, this, 80, 3, true);

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());
        MinecraftForge.EVENT_BUS.register(new ElectroEventHandler());

        FMLCommonHandler.instance().bus().register(new TickHandler());

        long duration = (System.currentTimeMillis() - startTime);
        LoggerHandler.info("Electrolysm Started in " + duration + "ms");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        Crafting.addCrafting();
        Crafting.addFurnaceRecipes();
        this.addBiome();
    }

    @SideOnly(Side.CLIENT)
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
    	ClientProxy ClientProxy = new ClientProxy();
        ClientProxy.registerRenderThings();
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new CommandStardate());
    }

    public void addBiome()
    {
        BiomeManager.BiomeEntry biome = new BiomeManager.BiomeEntry(diseasedBiome, 2);
        //BiomeManager.desertBiomes.add(biome);
        BiomeManager.warmBiomes.add(biome);
        BiomeDictionary.registerBiomeType(biome.biome, new BiomeDictionary.Type[]{BiomeDictionary.Type.PLAINS,
                BiomeDictionary.Type.DEAD, BiomeDictionary.Type.DRY});
        BiomeManager.addSpawnBiome(diseasedBiome);
    }
}
