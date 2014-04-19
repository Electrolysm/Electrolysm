/**
 *
 * @author Ben
 *
 */
package assets.electrolysm.electro;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.world.biome.BiomeGenBase;
import assets.electrolysm.api.LoggerHandler;
import assets.electrolysm.electro.advAtomics.liquids.fluidStorage;
import assets.electrolysm.electro.advAtomics.liquids.oil;
import assets.electrolysm.electro.advAtomics.liquids.plasma;
import assets.electrolysm.electro.biome.EntityZombie_Scientist;
import assets.electrolysm.electro.biome.diseasedBiome;
import assets.electrolysm.electro.biome.diseasedGrass;
import assets.electrolysm.electro.biome.spawnZS;
import assets.electrolysm.electro.block.ironFrames;
import assets.electrolysm.electro.block.advMachines.charger;
import assets.electrolysm.electro.block.advMachines.energiser;
import assets.electrolysm.electro.block.advMachines.energisingRod;
import assets.electrolysm.electro.block.advMachines.injectionArm;
import assets.electrolysm.electro.block.advMachines.injector;
import assets.electrolysm.electro.block.basic.blastBrick;
import assets.electrolysm.electro.block.basic.blastDoor;
import assets.electrolysm.electro.block.basic.blastGlass;
import assets.electrolysm.electro.block.basic.blastProof;
import assets.electrolysm.electro.block.basic.glassModifier;
import assets.electrolysm.electro.block.basic.hammer;
import assets.electrolysm.electro.block.basic.lightSource;
import assets.electrolysm.electro.block.basic.modBlastGlass;
import assets.electrolysm.electro.block.basic.stoneObsidian;
import assets.electrolysm.electro.block.machines.desk;
import assets.electrolysm.electro.block.machines.researchDesk;
import assets.electrolysm.electro.block.machines.workBench;
import assets.electrolysm.electro.client.ClientProxy;
import assets.electrolysm.electro.common.CommandStardate;
import assets.electrolysm.electro.common.ServerTickHandler;
import assets.electrolysm.electro.crafting.acidBurns;
import assets.electrolysm.electro.crafting.items.BasicMicrochip;
import assets.electrolysm.electro.crafting.items.BlockLumRed;
import assets.electrolysm.electro.crafting.items.CPU;
import assets.electrolysm.electro.crafting.items.ItemCrafting;
import assets.electrolysm.electro.crafting.items.advancedCPU;
import assets.electrolysm.electro.crafting.items.advancedMicrochip;
import assets.electrolysm.electro.crafting.items.antiMatterCasing;
import assets.electrolysm.electro.crafting.items.ballOfPlastic;
import assets.electrolysm.electro.crafting.items.crystalBase;
import assets.electrolysm.electro.crafting.items.diamondShard;
import assets.electrolysm.electro.crafting.items.endoInsulator;
import assets.electrolysm.electro.crafting.items.experimentalMicrochip;
import assets.electrolysm.electro.crafting.items.graphiteRod;
import assets.electrolysm.electro.crafting.items.grindStone;
import assets.electrolysm.electro.crafting.items.inkAndQuill;
import assets.electrolysm.electro.crafting.items.luminousRedstone;
import assets.electrolysm.electro.crafting.items.magnet;
import assets.electrolysm.electro.crafting.items.microchipBoard;
import assets.electrolysm.electro.crafting.items.transistor;
import assets.electrolysm.electro.handlers.BetaHandler;
import assets.electrolysm.electro.handlers.Crafting;
import assets.electrolysm.electro.handlers.ElectroylsmLoot;
import assets.electrolysm.electro.handlers.GUIHandler;
import assets.electrolysm.electro.handlers.IDHandler;
import assets.electrolysm.electro.handlers.MultipartHandler;
import assets.electrolysm.electro.handlers.Names;
import assets.electrolysm.electro.handlers.NewsCheck;
import assets.electrolysm.electro.handlers.PlayerHandler;
import assets.electrolysm.electro.handlers.Referance;
import assets.electrolysm.electro.handlers.Register;
import assets.electrolysm.electro.handlers.RegisterBlock;
import assets.electrolysm.electro.handlers.ResearchHandler;
import assets.electrolysm.electro.handlers.TickHandler;
import assets.electrolysm.electro.handlers.TileEntityMappingHandler;
import assets.electrolysm.electro.handlers.VersionCheck;
import assets.electrolysm.electro.item.basic.drillCasing;
import assets.electrolysm.electro.item.basic.plasmaDrill;
import assets.electrolysm.electro.oreProccessing.crusher;
import assets.electrolysm.electro.oreProccessing.crystalOre;
import assets.electrolysm.electro.oreProccessing.dusts;
import assets.electrolysm.electro.oreProccessing.electrolChamber;
import assets.electrolysm.electro.oreProccessing.electrolisisCore;
import assets.electrolysm.electro.oreProccessing.impureDusts;
import assets.electrolysm.electro.oreProccessing.ingots;
import assets.electrolysm.electro.oreProccessing.liquidiser;
import assets.electrolysm.electro.oreProccessing.net;
import assets.electrolysm.electro.oreProccessing.nettedBlock;
import assets.electrolysm.electro.oreProccessing.node;
import assets.electrolysm.electro.oreProccessing.seporator;
import assets.electrolysm.electro.oreProccessing.smeltory;
import assets.electrolysm.electro.oreProccessing.sulphuricAcid;
import assets.electrolysm.electro.powerSystem.ItemWire;
import assets.electrolysm.electro.powerSystem.endoCable;
import assets.electrolysm.electro.powerSystem.energyMeter;
import assets.electrolysm.electro.powerSystem.generators.generator;
import assets.electrolysm.electro.powerSystem.generators.matterGen;
import assets.electrolysm.electro.powerSystem.generators.extra.coolerProccesser;
import assets.electrolysm.electro.research.card;
import assets.electrolysm.electro.research.idifier;
import assets.electrolysm.electro.research.knowledge;
import assets.electrolysm.electro.research.researchPaper;
import assets.electrolysm.electro.robotics.ExoPlate;
import assets.electrolysm.electro.robotics.artMuscle;
import assets.electrolysm.electro.robotics.bionicArm;
import assets.electrolysm.electro.robotics.bionicChest;
import assets.electrolysm.electro.robotics.bionicHead;
import assets.electrolysm.electro.robotics.bionicLeg;
import assets.electrolysm.electro.robotics.carbonBone;
import assets.electrolysm.electro.robotics.chipDup;
import assets.electrolysm.electro.robotics.metalSheet;
import assets.electrolysm.electro.robotics.microCont;
import assets.electrolysm.electro.robotics.partAssemb;
import assets.electrolysm.electro.robotics.servo;
import assets.electrolysm.electro.robotics.silChip;
import assets.electrolysm.electro.robotics.soldering;
import assets.electrolysm.electro.robotics.upgrade;
import assets.electrolysm.electro.robotics.wire;
import assets.electrolysm.electro.world.Scandium;
import assets.electrolysm.electro.world.Yttrium;
import assets.electrolysm.electro.world.chunkGraphite;
import assets.electrolysm.electro.world.copperIngot;
import assets.electrolysm.electro.world.copperOre;
import assets.electrolysm.electro.world.graphite;
import assets.electrolysm.electro.world.sulpherOre;
import assets.electrolysm.electro.world.sulphur;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
    public static Item ItemWire = new ItemWire(configHandler.ItemWireID);
    
    /*
    public static Block teslaTowerCore = new teslaTowerCore(configHandler.teslaCoreID, null);
    public static Block largeCopperCoil = new largeCopperCoil(configHandler.largeCopperCoilID, null,
            false, ContectedTexture);
    public static Item copperCoil = new copperCoil(IDHandler.powerGrid.copperCoilID);
    public static Block plug = new plug(configHandler.plugID, null);
    */public static Block generator = new generator(configHandler.generatorID, null, 0);
    public static Block matterGen = new matterGen(configHandler.matterGenID, null, 3);
    public static Block coolerProccesser = new coolerProccesser(configHandler.coolerProccesserID, null);
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
    public static BlockContainer smeltery = (BlockContainer) new smeltory(configHandler.smelteryID, null, false).setCreativeTab(TabElectrolysm);
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
    public static Block BlockLumRed = new BlockLumRed(configHandler.lumRedBlockID, null);
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
    	
        File configFile = new File("config/Electrolysm/Electrolysm.cfg");
        configHandler.init(configFile);
        VersionCheck.check();
        NewsCheck.check();
        BetaHandler.beta();
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
        new PlayerHandler();
        new ElectroylsmLoot();
        Names.addName();
        Register.addOreDictionary();
        TileEntityMappingHandler.addMappings();
        GameRegistry.addBiome(diseasedBiome);
        EntityRegistry.registerModEntity(EntityZombie_Scientist.class, "Zombie Scientist", 2, this, 80, 3, true);
        TickRegistry.registerTickHandler(new TickHandler(), Side.CLIENT);
        TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);

        NetworkRegistry.instance().registerGuiHandler(this, new GUIHandler());
        
        long duration = (System.currentTimeMillis() - startTime);
        float secs = ((duration / 1000) * 100);
        LoggerHandler.info("Electrolysm Started in " + duration + "ms" + " (" + (secs / 100) + " secs)");

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
        ResearchHandler.downloadOnlineData();
        ResearchHandler.getStoredResearch();
    }
}
