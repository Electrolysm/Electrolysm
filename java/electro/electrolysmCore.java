/**
 *
 * @author Ben
 *
 */
package electro;

import java.io.File;

import electro.research.common.SavePlayerScanData;
import electro.research.common.ScanData;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.potion.Potion;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import electro.block.ironFrames;
import electro.block.advMachines.charger;
import electro.block.advMachines.energiser;
import electro.block.advMachines.energisingRod;
import electro.block.advMachines.injectionArm;
import electro.block.advMachines.injector;
import electro.block.basic.blastBrick;
import electro.block.basic.blastDoor;
import electro.block.basic.blastGlass;
import electro.block.basic.blastProof;
import electro.block.basic.glassModifier;
import electro.block.basic.hammer;
import electro.block.basic.lightSource;
import electro.block.basic.modBlastGlass;
import electro.block.basic.stoneObsidian;
import electro.block.liquids.fluidStorage;
import electro.block.liquids.oil;
import electro.block.liquids.plasma;
import electro.block.machines.desk;
import electro.block.machines.researchDesk;
import electro.block.machines.workBench;
import electro.client.ClientProxy;
import electro.common.CommandStardate;
import electro.crafting.acidBurns;
import electro.crafting.items.BasicMicrochip;
import electro.crafting.items.BlockLumRed;
import electro.crafting.items.CPU;
import electro.crafting.items.ItemCrafting;
import electro.crafting.items.advancedCPU;
import electro.crafting.items.advancedMicrochip;
import electro.crafting.items.antiMatterCasing;
import electro.crafting.items.ballOfPlastic;
import electro.crafting.items.crystalBase;
import electro.crafting.items.diamondShard;
import electro.crafting.items.endoInsulator;
import electro.crafting.items.experimentalMicrochip;
import electro.crafting.items.graphiteRod;
import electro.crafting.items.grindStone;
import electro.crafting.items.inkAndQuill;
import electro.crafting.items.luminousRedstone;
import electro.crafting.items.magnet;
import electro.crafting.items.microchipBoard;
import electro.crafting.items.transistor;
import electro.handlers.BetaHandler;
import electro.handlers.Crafting;
//import assets.electrolysm.electro.handlers.CraftingHandler;
import electro.handlers.ElectroEventHandler;
import electro.handlers.ElectrolysmLootHandler;
import electro.handlers.GUIHandler;
import electro.handlers.MultipartHandler;
import electro.handlers.Names;
import electro.handlers.NewsCheck;
import electro.handlers.Referance;
import electro.handlers.Register;
import electro.handlers.RegisterBlock;
import electro.handlers.TileEntityMappingHandler;
import electro.handlers.VersionCheck;
import electro.item.basic.drillCasing;
import electro.item.basic.plasmaDrill;
import electro.item.fuels.electroContain;
import electro.oreProccessing.crusher;
import electro.oreProccessing.crystalOre;
import electro.oreProccessing.dusts;
import electro.oreProccessing.electrolChamber;
import electro.oreProccessing.electrolisisCore;
import electro.oreProccessing.impureDusts;
import electro.oreProccessing.ingots;
import electro.oreProccessing.liquidiser;
import electro.oreProccessing.net;
import electro.oreProccessing.nettedBlock;
import electro.oreProccessing.node;
import electro.oreProccessing.seporator;
import electro.oreProccessing.smeltory;
import electro.oreProccessing.sulphuricAcid;
import electro.powerSystem.ItemWire;
import electro.powerSystem.battery1;
import electro.powerSystem.battery2;
import electro.powerSystem.battery3;
import electro.powerSystem.battery4;
import electro.powerSystem.endoCable;
import electro.powerSystem.energyMeter;
import electro.powerSystem.generators.generator;
import electro.powerSystem.generators.matterGen;
import electro.research.card;
import electro.research.idifier;
import electro.research.knowledge;
import electro.research.researchPaper;
import electro.research.system.ResearchRegistry;
import electro.sciences.ItemArmorLab;
import electro.world.Scandium;
import electro.world.Yttrium;
import electro.world.chunkGraphite;
import electro.world.copperIngot;
import electro.world.copperOre;
import electro.world.graphite;
import electro.world.sulpherOre;
import electro.world.sulphur;
import electro.world.biome.EntityZombie_Scientist;
import electro.world.biome.diseasedBiome;
import electro.world.biome.diseasedGrass;
import electro.world.biome.spawnZS;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = Referance.MOD_REF.MOD_ID, name = Referance.MOD_REF.MOD_ID, version = Referance.MOD_REF.VERSION)

@NetworkMod(channels = { Referance.MOD_REF.CHANNEL }, clientSideRequired = true, serverSideRequired = true, packetHandler = packetHandler.class)

public class electrolysmCore
{
    private static String[] ContectedTexture = { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    public static CreativeTabs TabElectrolysm = new TabElectrolysm(CreativeTabs.getNextID(), "Electrolysm");
    //public static CreativeTabs TabElements = new TabElements(CreativeTabs.getNextID(), "Electrolysm|Elements & Wizardy");
    
    public static GUIHandler guiHandler = new GUIHandler();

    @Instance("Electrolysm")
    public static electrolysmCore GUIInstance;
    //Basic Machines
    public static Block workBench = new workBench(IDHandler.machines.basic.workBenchID, null);
    public static Block desk = new desk(configHandler.deskID, null);
    //Advanced Machines
    public static Block injector = new injector(configHandler.injectorID, null);
    public static Item injectionArm = new injectionArm(configHandler.injectionArmID);

    //Research System
    public static Block idifier = new idifier(configHandler.idifierID, null);
    public static Block researchDesk = new researchDesk(configHandler.researchDeskID, null);
    public static card card = new card(configHandler.cardID);
    public static Item researchPaper = new researchPaper(configHandler.researchPaperID);
    public static Item knowledge = new knowledge(configHandler.knowledgeID);
    public static Item labCoat = new ItemArmorLab(configHandler.labCoatID, 2, "labCoat");
    public static Item labGoggles = new ItemArmorLab(configHandler.labGogglesID, 0, "labGoggles");
    public static Item itemScanner = new itemScanner(configHandler.itemScannerID);
    //public static Block autoDesk = new autoDesk(IDHandler.research.autoDeskID, null);

    //World Generation
    public static Block graphite = new graphite(configHandler.graphiteID, null);
    public static Item chunkGraphite = new chunkGraphite(configHandler.chunkGraphiteID);
    public static Item copperIngot = new copperIngot(configHandler.copperIngotID);
    public static Block copperOre = new copperOre(configHandler.copperOreID, null);
    public static Block sulphurOre = new sulpherOre(configHandler.sulphurOreID, null);
    public static Item sulphur = new sulphur(configHandler.sulfurID);
    public static Item ingots = new ingots(configHandler.ingotsID);
    public static Item Scandium = new Scandium(configHandler.ScandiumID);
    public static Block Yttrium = new Yttrium(configHandler.YttriumID, null);

    //Biome
    public static Item spawnZS = new spawnZS(configHandler.spawnZSID);
    public static Block diseaseGrass = new diseasedGrass(configHandler.diseaseGrassID, null);
    public static final BiomeGenBase diseasedBiomeObj = new diseasedBiome(configHandler.biomeID);
    public BiomeGenBase diseasedBiome = diseasedBiomeObj;
    //See WorldGenDiseasedTree.java for tree blocks
    
    //Security
    public static Block blastProof = new blastProof(configHandler.blastProofID, null);
    public static Block blastBrick = new blastBrick(configHandler.blastBrickID, null);
    public static Block blastDoor = new blastDoor(configHandler.blastDoorID, null);
    public static Block blastGlass = new blastGlass(configHandler.blastGlassID, null, false, ContectedTexture);
    public static Block modBlastGlass = new modBlastGlass(configHandler.modBlastGlassID, null, false, ContectedTexture);
    public static Item glassModifire = new glassModifier(configHandler.glassModifierID);
    public static Block stoneObsidian = new stoneObsidian(configHandler.stoneObsidianID, null);
    //Tools
    public static Item hammer = new hammer(configHandler.hammerID);
    
    public static ItemArmor.ArmorMaterial PLASTIC = EnumHelper.addArmorMaterial("PLASTIC", 10, new int[]{1, 3, 2, 1}, 5);
    /*public static Item hazMatHat = new HazMap(configHandler.hazMat1ID, 0);
    public static Item hazMatChest = new HazMap(configHandler.hazMat2ID, 1);
    public static Item hazMatLegs = new HazMap(configHandler.hazMat3ID, 2);
    public static Item hazMatShoes = new HazMap(configHandler.hazMat4ID, 3);*/
    
    //Advanced atomics
    //Liquids
    public static Block plasma = new plasma(configHandler.plasmaID);
    public static Item fluidStorage = new fluidStorage(configHandler.fluidStorageID);
    public static Item fluidRegistry/* = new fluidRegistry(IDHandler.advAtomics.fluid.fluidRegistryID)*/;
    public static Block oil = new oil(configHandler.oilID);
    //Atomics
    //public static Item elementProof = new elementProof(IDHandler.elements.elementProofID);

    //Machines
    //public static Block quantumComp = new quantumComp(IDHandler.advMachines.quantumCompID, null);
    public static Block energiser = new energiser(configHandler.energiserID, null);
    public static Item energisingRod = new energisingRod(configHandler.energisingRodID);
    public static Block charger = new charger(configHandler.chargerID, null);
    //Items
    //Tools
    public static Item plasmaDrill = new plasmaDrill(configHandler.plasmaDrillID, 0, null, null);
    public static Item drillCasing = new drillCasing(configHandler.drillCasingID);

    //Power System
    public static Block endoCable = new endoCable(configHandler.endoCableID, null);
    public static Item ItemWire = new ItemWire();
    public static Item battery1 = new battery1(configHandler.battery1ID, 1000, 1).setUnlocalizedName("battery1");
    public static Item battery2 = new battery2(configHandler.battery2ID, 8000, 2).setUnlocalizedName("battery2");
    public static Item battery3 = new battery3(configHandler.battery3ID, 64000, 3).setUnlocalizedName("battery3");
    public static Item battery4 = new battery4(configHandler.battery4ID, 512000, 4).setUnlocalizedName("battery4");

    /*
    public static Block teslaTowerCore = new teslaTowerCore(configHandler.teslaCoreID, null);
    public static Block largeCopperCoil = new largeCopperCoil(configHandler.largeCopperCoilID, null,
            false, ContectedTexture);
    public static Item copperCoil = new copperCoil(IDHandler.powerGrid.copperCoilID);
    public static Block plug = new plug(configHandler.plugID, null);
    */public static Block generator = new generator(configHandler.generatorID, null, 0);
    public static Block matterGen = new matterGen(configHandler.matterGenID, null, 3);
    public static Block coolerProccesser ;//= new coolerProccesser(configHandler.coolerProccesserID, null);
   // public static Block coolerPort = new coolerPort(configHandler.coolerPortID, null);
   // public static Block coolerFan = new coolerFan(configHandler.coolerFanID, null);

    /*
    public static Item crystal1 = new crystal(IDHandler.powerGrid.crystalID);
    public static Block wire = new wire(IDHandler.powerGrid.wireID, null);
    public static Block advWire = new wire(IDHandler.powerGrid.advWireID, null);
    public static Block earther = new earther(IDHandler.powerGrid.eartherID, null);
    public static Block advEarther = new advEarther(IDHandler.powerGrid.advEartherID, null);
    public static Item keyTransCoppier = new keyTransCoppier(IDHandler.powerGrid.keyTransCoppierID);
    public static Item ItemWire = new ItemWire(IDHandler.powerGrid.ItemWireID);
    */
    public static Item energyMeter = new energyMeter(configHandler.energyMeterID);
    //Random Blocks
    public static Block ironFrames = new ironFrames(configHandler.ironFrameID, null);

    //Ore Proccessing
    public static BlockContainer crusher = (BlockContainer) new crusher(configHandler.crusherID, null, false)
    				.setCreativeTab(TabElectrolysm);
    public static BlockContainer liquidiser = new liquidiser(configHandler.liquidizerID, null, false);
    public static BlockContainer electrolisisCore = new electrolisisCore(configHandler.electrolysisCoreID,
            null);
    public static Block electrolChamber = new electrolChamber(configHandler.electrolChamberID,
            null, false, ContectedTexture);
    public static BlockContainer seperator = new seporator(configHandler.seperatorID, null, false);
    public static BlockContainer smeltory = (BlockContainer) new smeltory(configHandler.smelteryID, null, false).setCreativeTab(TabElectrolysm);
    public static Item impureDusts = new impureDusts(configHandler.impureDustsID);
    public static Item dusts = new dusts(configHandler.dustsID);
    public static Item node = new node(configHandler.nodeID);
    public static Block sulpuricAcid = new sulphuricAcid(configHandler.sulphuricAcidID);
    public static Block nettedBlock = new nettedBlock(configHandler.nettedBlockID, null);
    public static Item net = new net(configHandler.netID);
    public static Item crystal = new crystalOre(configHandler.oreCrystalsID);
    
    public static BlockContainer crusherActive = new crusher(configHandler.crusherActiveID, null, true);
    public static BlockContainer smeltoryActive = new smeltory(configHandler.smeltoryActiveID, null, true);

    // items for crafting
    public static Item diamondShard = new diamondShard(configHandler.diamondShardID);
    public static Item luminousRedstone = new luminousRedstone(configHandler.luminousRedID);
    public static Block BlockLumRed = new BlockLumRed();
    public static Item crystalBase = new crystalBase(configHandler.crystalBaseID);
    public static Item ballOfPlastic = new ballOfPlastic(configHandler.ballOfPlasticID);
    public static Item endoInsulator = new endoInsulator(configHandler.endoInsulatorID);
    public static Block lightSource = new lightSource(configHandler.lightSourceID, null);
    public static Item microchipBoard = new microchipBoard(configHandler.microBoardID);
    public static Item transistor = new transistor(configHandler.transistorID);
    public static Item CPU = new CPU(configHandler.CPUID);
    public static Item BasicMicrochip = new BasicMicrochip(configHandler.basicMicroChipID);
    public static Item advancedMicrochip = new advancedMicrochip(configHandler.advMicrochipID);
    public static Item grindStone = new grindStone(configHandler.grindStoneID);
    public static Item inkAndQuill = new inkAndQuill(configHandler.inkQuillID);
    public static Item experimentalMicrochip = new experimentalMicrochip(configHandler.expMicrochipID);
    public static Item advancedCPU = new advancedCPU(configHandler.advCPUID);
    public static Item graphiteRod = new graphiteRod(configHandler.graphiteRodID);
    public static Item electroMagnet = new ItemCrafting(configHandler.electroMagnetID).setUnlocalizedName("electMag");
    public static Potion acidBurns = new acidBurns(configHandler.acidBurnsID, true, 0);

    public static Block antiMatterCasing = new antiMatterCasing(configHandler.antiMatterCasingID, null);
    public static Block magnet = new magnet(configHandler.magnetID, null);
    //Fuels
    public static Item electroContain = new electroContain(configHandler.electroContainID);
    
    /*
    //Robots
    //Parts
    public static Item metalSheet = new metalSheet(IDHandler.robotics.metalSheetID);
    public static Item wire = new wire(IDHandler.robotics.wireID);
    public static Item servo = new servo(IDHandler.robotics.servoID);
    public static Item artMuscle = new artMuscle(IDHandler.robotics.artMuscleID);
    public static Item carbonBone = new carbonBone(IDHandler.robotics.carbonBoneID);
    //=====================Adv. Parts================================
    public static Item microController = new microCont(IDHandler.robotics.microContID);
    public static Item upgrade = new upgrade(IDHandler.robotics.upgradeID);
    public static Item silChip = new silChip(IDHandler.robotics.silChipID);
    public static Item ChipDup = new chipDup(IDHandler.robotics.chipDub);
    //===============================================================
    public static Item exoPlate = new ExoPlate(IDHandler.robotics.exoPlateID);
    public static Item bionicArm = new bionicArm(IDHandler.robotics.bionicArmID);
    public static Item bionicChest = new bionicChest(IDHandler.robotics.bionicChestID);
    public static Item bionicHead = new bionicHead(IDHandler.robotics.bionicHeadID);
    public static Item bionicLeg = new bionicLeg(IDHandler.robotics.bionicLegID);
    //====================Machines!==================================
    public static Block soldering = new soldering(IDHandler.robotics.machines.solderingID, null);
    public static Block partAssemb = new partAssemb(IDHandler.robotics.machines.partAssembID, null);
    */
    /*
     * ===============================================================================================================
     * ===============================================================================================================
     * 										Config (In game Stuff)
     * ===============================================================================================================
     * ===============================================================================================================
     */
    
    long startTime;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	startTime = System.currentTimeMillis();
    	
    	//ResearchHandler.downloadLabSkin();
        File configFile = new File("config/Electrolysm/Electrolysm.cfg");
        new ResearchRegistry(true);
//        ResearchTextRegistry.getTextInFile(configFile);
        configHandler.init(configFile);
        VersionCheck.check();
        NewsCheck.check();
        BetaHandler.beta();
        //new SavePlayerScanData("Clarky158", "ygcfg");
        //System.exit(0);
        //ResearchHandler.downloadOnlineData();
        //ResearchHandler.getStoredResearch();
    }

    @EventHandler
    public void loadConfiguration(FMLPreInitializationEvent evt)
    {
    	//Fluids.registerStuff();
        Crafting.addCrafting();
        Crafting.addFurnaceRecipes();
        RegisterBlock.register();
        new MultipartHandler();
        new ElectrolysmLootHandler();
        Names.addName();
        Register.addOreDictionary();
        TileEntityMappingHandler.addMappings();
        //GameRegistry.registerCraftingHandler(new CraftingHandler());
        GameRegistry.addBiome(diseasedBiome);
        EntityRegistry.registerModEntity(EntityZombie_Scientist.class, "Zombie Scientist", 2, this, 80, 3, true);
        TickRegistry.registerTickHandler(new TickHandler(), Side.CLIENT);
        TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);

        NetworkRegistry.instance().registerGuiHandler(this, new GUIHandler());
        MinecraftForge.EVENT_BUS.register(new ElectroEventHandler());

        long duration = (System.currentTimeMillis() - startTime);
        LoggerHandler.info("Electrolysm Started in " + duration + "ms");
    } 

    @SideOnly(Side.CLIENT)
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
    	ClientProxy ClientProxy = new ClientProxy();
        ClientProxy.registerRenderThings();
    }

    @ServerStarting
    public void serverLoad(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new CommandStardate());
    }
}
