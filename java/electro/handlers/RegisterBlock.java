package electro.handlers;

import electro.Electrolysm;
import electro.world.WorldGenOres;
import electro.world.WorldGenStructures;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterBlock
{
    public static void register()
    {
        GameRegistry.registerBlock(Electrolysm.workBench, "workBench");
        GameRegistry.registerBlock(Electrolysm.desk, "desk");
        GameRegistry.registerBlock(Electrolysm.researchDesk, "researchDesk");
        GameRegistry.registerBlock(Electrolysm.diseaseGrass, "diseasedGrass");
        GameRegistry.registerBlock(Electrolysm.blastProof, "blastProof");
        GameRegistry.registerBlock(Electrolysm.blastDoor, "blastDoor");
        GameRegistry.registerBlock(Electrolysm.blastGlass, "blastGlass");
        GameRegistry.registerBlock(Electrolysm.solarPanel, "solarPanel");
        GameRegistry.registerBlock(Electrolysm.plasma, "plasma");
        GameRegistry.registerBlock(Electrolysm.creativeEnergyStorage, "creativeEnergyCore");
        GameRegistry.registerBlock(Electrolysm.nitrocelluloseBlock, "nitrocelluloseBlock");
        GameRegistry.registerBlock(Electrolysm.energiser, "energiser");
        GameRegistry.registerBlock(Electrolysm.injector, "injector");
        //GameRegistry.registerBlock(electrolysmCore.quantumComp, "quantumComp");
        GameRegistry.registerBlock(Electrolysm.graphite, "graphite");
        GameRegistry.registerBlock(Electrolysm.modBlastGlass, "modBlastGlass");
        GameRegistry.registerBlock(Electrolysm.sulphurOre, "sulphurOre");
        GameRegistry.registerBlock(Electrolysm.electrolChamber, "electrolChamber");
        GameRegistry.registerBlock(Electrolysm.electrolisisCore, "electrolCore");
        GameRegistry.registerBlock(Electrolysm.crusher, "crusher");
        GameRegistry.registerBlock(Electrolysm.liquidiser, "liquidiser");
        //GameRegistry.registerBlock(electrolysmCore.seperator);
        GameRegistry.registerBlock(Electrolysm.smeltory, "smeltory");
        //GameRegistry.registerBlock(electrolysmCore.electrolPort);
        GameRegistry.registerBlock(Electrolysm.sulpuricAcid, "sulphuricAcid");
        GameRegistry.registerBlock(Electrolysm.ironFrames, "ironFrame");
        GameRegistry.registerBlock(Electrolysm.copperOre, "copperOre");
        GameRegistry.registerBlock(Electrolysm.charger, "charger");
        GameRegistry.registerBlock(Electrolysm.idifier, "id-ifier");
        GameRegistry.registerBlock(Electrolysm.blastBrick, "blastBrick");
        GameRegistry.registerWorldGenerator(new WorldGenStructures(), 20);
        GameRegistry.registerWorldGenerator(new WorldGenOres(), 20);
        GameRegistry.registerBlock(Electrolysm.nettedBlock, "nettedBlock");
        GameRegistry.registerBlock(Electrolysm.crusherActive, "crusherActive");
        GameRegistry.registerBlock(Electrolysm.smeltoryActive, "smeltoryActive");
        GameRegistry.registerBlock(Electrolysm.experimentalCable, "experimentalCable");
        GameRegistry.registerBlock(Electrolysm.basicCable, "basicCable");
        GameRegistry.registerBlock(Electrolysm.advancedCable, "advancedCable");
        GameRegistry.registerBlock(Electrolysm.generator, "generator");
        GameRegistry.registerBlock(Electrolysm.antiMatterCasing, "antiCasing");
        GameRegistry.registerBlock(Electrolysm.magnet, "magnet");
        GameRegistry.registerBlock(Electrolysm.Yttrium, "yttrium");
        //GameRegistry.registerBlock(electrolysmCore.coolerProccesser);
        GameRegistry.registerFuelHandler(new FuelHandler());
        GameRegistry.registerBlock(Electrolysm.steelBlock, "steelBlock");
        GameRegistry.registerBlock(Electrolysm.stoneObsidian, "stoneObsidian");
        GameRegistry.registerBlock(Electrolysm.diseasedSapling, "diseasedSapling");
        GameRegistry.registerBlock(Electrolysm.BlockLumRed, "blockLumeRed");
        GameRegistry.registerBlock(Electrolysm.diseasedLeaves, "diseasedLeaves");
        GameRegistry.registerBlock(Electrolysm.diseasedLog, "diseasedLog");
        GameRegistry.registerBlock(Electrolysm.matterGen, "antiMatterGen");
        GameRegistry.registerBlock(Electrolysm.dataRecorder, "dataRecorder");
        GameRegistry.registerBlock(Electrolysm.robotArm, "roboticArm");
        GameRegistry.registerBlock(Electrolysm.roboticBase, "robotBase");
        GameRegistry.registerBlock(Electrolysm.advancedCrafting, "advCrafting");
        GameRegistry.registerBlock(Electrolysm.matrix, "BlockMatrix");
        GameRegistry.registerBlock(Electrolysm.basicEnergyStorage, "BasicEnergyStorage");
        GameRegistry.registerBlock(Electrolysm.advancedGenerator, "advancedGenerator");
        GameRegistry.registerBlock(Electrolysm.thermalGenerator, "thermalGenerator");
        GameRegistry.registerBlock(Electrolysm.alloyFurnace, "alloyFurnace");
        GameRegistry.registerBlock(Electrolysm.aluminiumOre, "aluminiumOre");
        GameRegistry.registerBlock(Electrolysm.improvedFurnace, "improvedFurnace");


        //Fluids
        /*
        FluidContainerRegistry.registerFluidContainer(
        		new FluidContainerData(
        			FluidRegistry.getFluidStack( electrolysmCore.plasma.getName(), FluidContainerRegistry.BUCKET_VOLUME ),
        			new ItemStack( electrolysmCore.bucketPlasma),
        			new ItemStack( Item.bucketEmpty )
        		)
        	);*/
        //Adding knowledge to dungeon chests
       
        //End
    }

    public static void registerItems()
    {
        Electrolysm elec = new Electrolysm();
        GameRegistry.registerItem(elec.injectionArm, "injectionArm");
        GameRegistry.registerItem(elec.researchPaper, "researchPaper");
        GameRegistry.registerItem(elec.knowledge, "knowledge");
        GameRegistry.registerItem(elec.chunkGraphite, "graphiteChunk");
        GameRegistry.registerItem(elec.copperIngot, "copperIngot");
        GameRegistry.registerItem(elec.pureCopperIngot, "pureCopperIngot");
        GameRegistry.registerItem(elec.sulphur, "sulphur");
        GameRegistry.registerItem(elec.ingots, "ingot");
        GameRegistry.registerItem(elec.Scandium, "scandium");
        GameRegistry.registerItem(elec.spawnZS, "spawnZS");
        GameRegistry.registerItem(elec.glassModifire, "glassModifier");
        GameRegistry.registerItem(elec.fluidStorage, "fluidStorage");
        //GameRegistry.registerItem(elec.fluidRegistry, "fluidRegistry");
        GameRegistry.registerItem(elec.energisingRod, "energisingRod");
        GameRegistry.registerItem(elec.plasmaDrill, "plasmaDrill");
        GameRegistry.registerItem(elec.drillCasing, "drillCasing");
        GameRegistry.registerItem(elec.ItemWire, "itemWire");
        GameRegistry.registerItem(elec.basicBattery, "basicBattery");
        GameRegistry.registerItem(elec.advancedBattery, "advancedBattery");
        GameRegistry.registerItem(elec.experimentalBattery, "experimentalBattery");
        GameRegistry.registerItem(elec.energyMeter, "energyMeter");
        GameRegistry.registerItem(elec.impureDusts, "impureDusts");
        GameRegistry.registerItem(elec.dusts, "dusts");
        GameRegistry.registerItem(elec.node, "electrode");
        GameRegistry.registerItem(elec.net, "net");
        GameRegistry.registerItem(elec.crystal, "crystals");
        GameRegistry.registerItem(elec.diamondShard, "diamondShard");
        GameRegistry.registerItem(elec.luminousRedstone, "luminousRedstoneDust");
        GameRegistry.registerItem(elec.crystalBase, "crystalBase");
        GameRegistry.registerItem(elec.ballOfPlastic, "ballOfPlastic");
        GameRegistry.registerItem(elec.endoInsulator, "endoInsulator");
        GameRegistry.registerItem(elec.microchipBoard, "microchipBoard");
        GameRegistry.registerItem(elec.transistor, "transistor");
        GameRegistry.registerItem(elec.CPU, "CPU");
        GameRegistry.registerItem(elec.BasicMicrochip, "basicMicrochip");
        GameRegistry.registerItem(elec.advancedMicrochip, "advMicrochip");
        GameRegistry.registerItem(elec.grindStone, "grindStone");
        GameRegistry.registerItem(elec.inkAndQuill, "inkAndQuill");
        GameRegistry.registerItem(elec.experimentalMicrochip, "experimentalMicrochip");
        GameRegistry.registerItem(elec.advancedCPU, "advCPU");
        GameRegistry.registerItem(elec.graphiteRod, "graphiteRod");
        GameRegistry.registerItem(elec.electroMagnet, "electroMagnet");
        GameRegistry.registerItem(elec.electroContain, "electroContain");
        GameRegistry.registerItem(elec.itemScanner, "itemScanner");
        GameRegistry.registerItem(elec.labCoat, "labCoat");
        GameRegistry.registerItem(elec.labGoggles, "labGoggles");
        GameRegistry.registerItem(elec.researchDevice, "researchDevice");
        GameRegistry.registerItem(elec.reel, "itemReel");
        GameRegistry.registerItem(elec.hammer, "hammer");
        GameRegistry.registerItem(elec.improvedCoal, "improvedCoal");
        GameRegistry.registerItem(elec.neutraliser, "neutraliser");
        GameRegistry.registerItem(elec.nitrocellulose, "nitrocellulose");
        GameRegistry.registerItem(elec.camphor, "camphor");
        GameRegistry.registerItem(elec.steel, "steel");
        GameRegistry.registerItem(elec.aluminiumIngot, "aluminiumIngot");
        GameRegistry.registerItem(elec.silicon, "silicon");


    }
}
