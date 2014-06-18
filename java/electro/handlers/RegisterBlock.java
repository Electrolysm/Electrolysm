package electro.handlers;

import net.minecraft.block.Block;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import electro.electrolysmCore;
import electro.world.Scandium;
import electro.world.WorldGenOres;
import electro.world.WorldGenStructures;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterBlock
{
    public static void register()
    {
        GameRegistry.registerBlock(electrolysmCore.workBench, "workBench");
        GameRegistry.registerBlock(electrolysmCore.desk, "desk");
        GameRegistry.registerBlock(electrolysmCore.researchDesk, "researchDesk");
        GameRegistry.registerBlock(electrolysmCore.diseaseGrass, "diseasedGrass");
        GameRegistry.registerBlock(electrolysmCore.blastProof, "blastProof");
        GameRegistry.registerBlock(electrolysmCore.blastDoor, "blastDoor");
        GameRegistry.registerBlock(electrolysmCore.blastGlass, "blastGlass");
        GameRegistry.registerBlock(electrolysmCore.plasma, "plasma");
        GameRegistry.registerBlock(electrolysmCore.energiser, "energiser");
        GameRegistry.registerBlock(electrolysmCore.injector, "injector");
        //GameRegistry.registerBlock(electrolysmCore.quantumComp, "quantumComp");
        GameRegistry.registerBlock(electrolysmCore.graphite, "graphite");
        GameRegistry.registerBlock(electrolysmCore.modBlastGlass, "modBlastGlass");
        GameRegistry.registerBlock(electrolysmCore.sulphurOre, "sulphurOre");
        GameRegistry.registerBlock(electrolysmCore.electrolChamber, "electrolChamber");
        GameRegistry.registerBlock(electrolysmCore.electrolisisCore, "electrolCore");
        GameRegistry.registerBlock(electrolysmCore.crusher, "crusher");
        GameRegistry.registerBlock(electrolysmCore.liquidiser, "liquidiser");
        //GameRegistry.registerBlock(electrolysmCore.seperator);
        GameRegistry.registerBlock(electrolysmCore.smeltory, "smeltory");
        //GameRegistry.registerBlock(electrolysmCore.electrolPort);
        GameRegistry.registerBlock(electrolysmCore.sulpuricAcid, "sulphuricAcid");
        GameRegistry.registerBlock(electrolysmCore.ironFrames, "ironFrame");
        GameRegistry.registerBlock(electrolysmCore.copperOre, "copperOre");
        GameRegistry.registerBlock(electrolysmCore.charger, "charger");
        GameRegistry.registerBlock(electrolysmCore.idifier, "id-ifier");
        GameRegistry.registerBlock(electrolysmCore.blastBrick, "blastBrick");
        GameRegistry.registerBlock(electrolysmCore.lightSource, "lightSource");
        GameRegistry.registerWorldGenerator(new WorldGenStructures(), 20);
        GameRegistry.registerWorldGenerator(new WorldGenOres(), 20);
        GameRegistry.registerBlock(electrolysmCore.nettedBlock, "nettedBlock");
        GameRegistry.registerBlock(electrolysmCore.crusherActive, "crusherActive");
        GameRegistry.registerBlock(electrolysmCore.smeltoryActive, "smeltoryActive");
        GameRegistry.registerBlock(electrolysmCore.endoCable, "endoCable");
        GameRegistry.registerBlock(electrolysmCore.generator, "generator");
        GameRegistry.registerBlock(electrolysmCore.antiMatterCasing, "antiCasing");
        GameRegistry.registerBlock(electrolysmCore.magnet, "magnet");
        GameRegistry.registerBlock(electrolysmCore.Yttrium, "yttrium");
        //GameRegistry.registerBlock(electrolysmCore.coolerProccesser);
        GameRegistry.registerFuelHandler(new FuelHandler());
        GameRegistry.registerBlock(electrolysmCore.stoneObsidian, "stoneObsidian");
        GameRegistry.registerBlock(electrolysmCore.diseasedSapling, "diseasedSapling");
        GameRegistry.registerBlock(electrolysmCore.BlockLumRed, "blockLumeRed");
        GameRegistry.registerBlock(electrolysmCore.diseasedLeaves, "diseasedLeaves");
        GameRegistry.registerBlock(electrolysmCore.diseasedLog, "diseasedLog");
        GameRegistry.registerBlock(electrolysmCore.matterGen, "antiMatterGen");


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
        electrolysmCore elec = new electrolysmCore();
        GameRegistry.registerItem(elec.injectionArm, "injectionArm");
        GameRegistry.registerItem(elec.card, "IDcard");
        GameRegistry.registerItem(elec.researchPaper, "researchPaper");
        GameRegistry.registerItem(elec.knowledge, "knowledge");
        GameRegistry.registerItem(elec.chunkGraphite, "graphiteChunk");
        GameRegistry.registerItem(elec.copperIngot, "copperIngot");
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
        GameRegistry.registerItem(elec.battery1, "battery1");
        GameRegistry.registerItem(elec.battery2, "battery2");
        GameRegistry.registerItem(elec.battery3, "battery3");
        GameRegistry.registerItem(elec.battery4, "battery4");
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
    }
}
