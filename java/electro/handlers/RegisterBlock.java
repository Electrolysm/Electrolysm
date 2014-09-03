package electro.handlers;

import electro.Electrolysm;
import electro.world.WorldGenOres;
import electro.world.WorldGenStructures;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterBlock
{
    public static void register()
    {
        //WorldGen
        GameRegistry.registerBlock(Electrolysm.diseaseGrass, "diseasedGrass");
        GameRegistry.registerBlock(Electrolysm.diseasedSapling, "diseasedSapling");
        GameRegistry.registerBlock(Electrolysm.diseasedLog, "diseasedLog");
        GameRegistry.registerBlock(Electrolysm.diseasedLeaves, "diseasedLeaves");
        GameRegistry.registerBlock(Electrolysm.copperOre, "copperOre");
        GameRegistry.registerBlock(Electrolysm.tinOre, "tinOre");
        GameRegistry.registerBlock(Electrolysm.aluminiumOre, "aluminiumOre");
        GameRegistry.registerBlock(Electrolysm.sulphurOre, "sulphurOre");
        GameRegistry.registerBlock(Electrolysm.graphite, "graphite");
        GameRegistry.registerBlock(Electrolysm.Yttrium, "yttrium");

        //Power System
        GameRegistry.registerBlock(Electrolysm.basicEnergyStorage, "BasicEnergyStorage");
        GameRegistry.registerBlock(Electrolysm.creativeEnergyStorage, "creativeEnergyCore");
        GameRegistry.registerBlock(Electrolysm.energyRelay, "energyRelay");
        GameRegistry.registerBlock(Electrolysm.basicCable, "basicCable");
        GameRegistry.registerBlock(Electrolysm.generator, "generator");
        GameRegistry.registerBlock(Electrolysm.advancedGenerator, "advancedGenerator");
        GameRegistry.registerBlock(Electrolysm.solarPanel, "solarPanel");
        GameRegistry.registerBlock(Electrolysm.thermalGenerator, "thermalGenerator");
        GameRegistry.registerBlock(Electrolysm.genActive, "genActive");
        GameRegistry.registerBlock(Electrolysm.advGenActive, "advGenActive");
        GameRegistry.registerBlock(Electrolysm.teslaCore, "blockTeslaCore");
        GameRegistry.registerBlock(Electrolysm.ironFrames, "ironFrame");
        GameRegistry.registerBlock(Electrolysm.recievingCore, "recievingCore");
        GameRegistry.registerBlock(Electrolysm.copperCoil, "copperCoil");
        GameRegistry.registerBlock(Electrolysm.receiver, "receiverModel");

        //Ore Processing
        GameRegistry.registerBlock(Electrolysm.nettedBlock, "nettedBlock");
        GameRegistry.registerBlock(Electrolysm.improvedFurnace, "improvedFurnace");
        GameRegistry.registerBlock(Electrolysm.crusher, "crusher");
        GameRegistry.registerBlock(Electrolysm.smeltory, "smeltory");
        GameRegistry.registerBlock(Electrolysm.liquidiser, "liquidiser");
        GameRegistry.registerBlock(Electrolysm.sulpuricAcid, "sulphuricAcid");
        GameRegistry.registerBlock(Electrolysm.electrolisisCore, "electrolCore");
        GameRegistry.registerBlock(Electrolysm.electrolChamber, "electrolChamber");
        GameRegistry.registerBlock(Electrolysm.improvedFurnaceActive, "activeImprovedFurnace");
        GameRegistry.registerBlock(Electrolysm.crusherActive, "crusherActive");
        GameRegistry.registerBlock(Electrolysm.smeltoryActive, "smeltoryActive");

        //Machines
        GameRegistry.registerBlock(Electrolysm.alloyFurnace, "alloyFurnace");
        GameRegistry.registerBlock(Electrolysm.energiser, "energiser");
        GameRegistry.registerBlock(Electrolysm.injector, "injector");
        GameRegistry.registerBlock(Electrolysm.charger, "charger");

        //Misc
        GameRegistry.registerBlock(Electrolysm.stoneObsidian, "stoneObsidian");
        GameRegistry.registerBlock(Electrolysm.blastProof, "blastProof");
        GameRegistry.registerBlock(Electrolysm.blastBrick, "blastBrick");
        GameRegistry.registerBlock(Electrolysm.blastDoor, "blastDoor");
        GameRegistry.registerBlock(Electrolysm.blastGlass, "blastGlass");
        GameRegistry.registerBlock(Electrolysm.modBlastGlass, "modBlastGlass");
        GameRegistry.registerBlock(Electrolysm.BlockLumRed, "blockLumeRed");
        GameRegistry.registerBlock(Electrolysm.plasma, "plasma");
        GameRegistry.registerBlock(Electrolysm.magnet, "magnet");
        GameRegistry.registerBlock(Electrolysm.steelBlock, "steelBlock");

        GameRegistry.registerWorldGenerator(new WorldGenStructures(), 20);
        GameRegistry.registerWorldGenerator(new WorldGenOres(), 20);
        GameRegistry.registerFuelHandler(new FuelHandler());
        //removed for this release only
        /*
        GameRegistry.registerBlock(Electrolysm.roboticBase, "robotBase");
        GameRegistry.registerBlock(Electrolysm.matterGen, "antiMatterGen");
        GameRegistry.registerBlock(Electrolysm.antiMatterCasing, "antiCasing");
        GameRegistry.registerBlock(Electrolysm.advEnergyStorage, "advEnergyStorage");
        */
    }

    public static void registerItems()
    {
        Electrolysm elec = new Electrolysm();
        //World Gen
        GameRegistry.registerItem(elec.ingots, "ingot");
        GameRegistry.registerItem(elec.copperIngot, "copperIngot");
        GameRegistry.registerItem(elec.steel, "steel");
        GameRegistry.registerItem(elec.aluminiumIngot, "aluminiumIngot");
        GameRegistry.registerItem(elec.sulphur, "sulphur");
        GameRegistry.registerItem(elec.chunkGraphite, "graphiteChunk");
        GameRegistry.registerItem(elec.Scandium, "scandium");

        //PowerSystem
        GameRegistry.registerItem(elec.crystalBase, "crystalBase");
        GameRegistry.registerItem(elec.crystal1, "crystalTier1");
        GameRegistry.registerItem(elec.crystal2, "crystalTier2");

        //OreProcessing
        GameRegistry.registerItem(elec.impureDusts, "impureDusts");
        GameRegistry.registerItem(elec.dusts, "dusts");
        GameRegistry.registerItem(elec.neutraliser, "neutraliser");
        GameRegistry.registerItem(elec.crystal, "crystals");
        GameRegistry.registerItem(elec.net, "net");
        GameRegistry.registerItem(elec.node, "electrode");
        GameRegistry.registerItem(elec.grindStone, "grindStone");

        //Machines
        GameRegistry.registerItem(elec.injectionArm, "injectionArm");
        GameRegistry.registerItem(elec.energisingRod, "energisingRod");

        //tech
        GameRegistry.registerItem(elec.microchipBoard, "microchipBoard");
        GameRegistry.registerItem(elec.transistor, "transistor");
        GameRegistry.registerItem(elec.BasicMicrochip, "basicMicrochip");
        GameRegistry.registerItem(elec.advancedMicrochip, "advMicrochip");
        GameRegistry.registerItem(elec.experimentalMicrochip, "experimentalMicrochip");
        GameRegistry.registerItem(elec.CPU, "CPU");
        GameRegistry.registerItem(elec.advancedCPU, "advCPU");

        //tools
        GameRegistry.registerItem(elec.hammer, "hammer");
        GameRegistry.registerItem(elec.insulatedScrewdriver, "InsulatedScrewdriver");
        GameRegistry.registerItem(elec.glassModifire, "glassModifier");
        GameRegistry.registerItem(elec.energyMeter, "energyMeter");
        GameRegistry.registerItem(elec.drillCasing, "drillCasing");
        GameRegistry.registerItem(elec.plasmaDrill, "plasmaDrill");

        //Misc
        GameRegistry.registerItem(elec.spawnZS, "spawnZS");
        GameRegistry.registerItem(elec.fluidStorage, "fluidStorage");
        GameRegistry.registerItem(elec.diamondShard, "diamondShard");
        GameRegistry.registerItem(elec.luminousRedstone, "luminousRedstoneDust");
        GameRegistry.registerItem(elec.graphiteRod, "graphiteRod");
        GameRegistry.registerItem(elec.improvedCoal, "improvedCoal");
        GameRegistry.registerItem(elec.labGoggles, "labGoggles");
        GameRegistry.registerItem(elec.labCoat, "labCoat");
        GameRegistry.registerItem(elec.diamondDust, "diamondDust");

        //Removed for this release
        /*
        GameRegistry.registerItem(elec.bronze, "bronze");
        GameRegistry.registerItem(elec.silicon, "silicon");
        GameRegistry.registerItem(elec.pureCopperIngot, "pureCopperIngot");
        GameRegistry.registerItem(elec.electroMagnet, "electroMagnet");
        GameRegistry.registerItem(elec.electroContain, "electroContain");
        GameRegistry.registerItem(elec.ballOfPlastic, "ballOfPlastic");
        GameRegistry.registerItem(elec.endoInsulator, "endoInsulator");
        GameRegistry.registerItem(elec.inkAndQuill, "inkAndQuill");*/
    }
}
