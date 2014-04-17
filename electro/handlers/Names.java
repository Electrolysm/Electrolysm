package assets.electrolysm.electro.handlers;

import net.minecraft.item.ItemStack;
import assets.electrolysm.api.specialFuel.SpecialFuelHandler;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.advAtomics.liquids.Fluids;
import assets.electrolysm.electro.advAtomics.liquids.fluidStorage;
import assets.electrolysm.electro.advAtomics.liquids.plasma;
import assets.electrolysm.electro.block.advMachines.energiser;
import assets.electrolysm.electro.block.advMachines.injector;
import assets.electrolysm.electro.block.advMachines.quantumComp;
import assets.electrolysm.electro.common.CommonProxy;
import assets.electrolysm.electro.research.Research;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Names
{
    public static void addName()
    {
        LanguageRegistry.addName(electrolysmCore.workBench, "Work Bench");
        LanguageRegistry.addName(electrolysmCore.desk, "Scientist's Desk");
        LanguageRegistry.addName(electrolysmCore.researchDesk, "Research Desk");
        LanguageRegistry.addName(electrolysmCore.blastProof, "Blast Proof Iron Block");
        LanguageRegistry.addName(electrolysmCore.blastDoor, "Blast Proof Iron Door");
        LanguageRegistry.addName(electrolysmCore.energiser, "Fluid Energiser");
        LanguageRegistry.addName(electrolysmCore.injector, "Injector");
        LanguageRegistry.addName(electrolysmCore.plasma, "Liquid Plasma");
        //LanguageRegistry.addName(electrolysmCore.quantumComp, "Quantum Computer");
        LanguageRegistry.addName(electrolysmCore.blastGlass, "Blast Proof Iron Glass");
        LanguageRegistry.addName(electrolysmCore.modBlastGlass, "Modified Blast Proof Iron Glass");
        LanguageRegistry.addName(electrolysmCore.plasmaDrill, "Plasma Drill");
        LanguageRegistry.addName(electrolysmCore.diseaseGrass, "Diseased Grass");
        LanguageRegistry.addName(electrolysmCore.spawnZS, "Spawn Zombie-Scientist");
        LanguageRegistry.addName(electrolysmCore.knowledge, "Knowledge Strip");
        LanguageRegistry.addName(electrolysmCore.drillCasing, "Plasma Drill Casing");
        LanguageRegistry.addName(electrolysmCore.graphite, "Graphite");
        LanguageRegistry.addName(electrolysmCore.chunkGraphite, "Graphite Chunk");
        LanguageRegistry.addName(electrolysmCore.injectionArm, "Injection Arm");
        LanguageRegistry.addName(electrolysmCore.energisingRod, "Energising Filament");
        LanguageRegistry.addName(electrolysmCore.glassModifire, "Glass Modifier");
        LanguageRegistry.addName(electrolysmCore.sulphurOre, "Sulphur Ore");
        LanguageRegistry.addName(electrolysmCore.sulphur, "Sulphur Crystals");
        LanguageRegistry.addName(electrolysmCore.energyMeter, "Energy Meter");
        LanguageRegistry.addName(electrolysmCore.sulpuricAcid, "Sulphuric Acid");
        LanguageRegistry.addName(electrolysmCore.copperOre, "Copper Ore");
        LanguageRegistry.addName(electrolysmCore.ironFrames, "Iron Frame");
        LanguageRegistry.addName(electrolysmCore.hammer, "Hammer");
        LanguageRegistry.addName(electrolysmCore.copperIngot, "Copper Ingot");
        LanguageRegistry.addName(electrolysmCore.node, "Graphite Electrode");
        LanguageRegistry.addName(electrolysmCore.luminousRedstone, "Luminous Redstone Dust");
        LanguageRegistry.addName(electrolysmCore.diamondShard, "Diamond Shard");
        LanguageRegistry.addName(electrolysmCore.crystalBase, "Crystal Base");
        LanguageRegistry.addName(electrolysmCore.blastBrick, "Blast Proof Iron Brick");
        LanguageRegistry.addName(new ItemStack(electrolysmCore.nettedBlock, 1), "Netted Ore");
        LanguageRegistry.addName(electrolysmCore.card, "ID Card");
        LanguageRegistry.addName(new ItemStack(electrolysmCore.ingots, 1, 0), "Tin Ingot");
        LanguageRegistry.addName(new ItemStack(electrolysmCore.ingots, 1, 1), "Silver Ingot");
        LanguageRegistry.addName(new ItemStack(electrolysmCore.ingots, 1, 2), "Lead Ingot");
        LanguageRegistry.addName(electrolysmCore.liquidiser, "Displacement Chamber");
        LanguageRegistry.addName(electrolysmCore.crusher, "Crusher");
        LanguageRegistry.addName(electrolysmCore.electrolisisCore, "Electrolysis Chamber");
        LanguageRegistry.addName(electrolysmCore.electrolChamber, "Electrolysis Wall");
        LanguageRegistry.addName(electrolysmCore.smeltery, "Smeltery");
        LanguageRegistry.addName(electrolysmCore.smeltoryActive, "Smeltory");
        LanguageRegistry.addName(electrolysmCore.crusherActive, "Crusher");
        LanguageRegistry.addName(electrolysmCore.net, "Ore Net");
        LanguageRegistry.addName(electrolysmCore.endoInsulator, "Endothermite Insulator");
        LanguageRegistry.addName(electrolysmCore.microchipBoard, "Chip Board");
        LanguageRegistry.addName(electrolysmCore.CPU, "CPU");
        LanguageRegistry.addName(electrolysmCore.advancedCPU, "Advanced CPU");
        LanguageRegistry.addName(new ItemStack(electrolysmCore.advancedMicrochip, 1, 0), "Advanced Microchip");
        LanguageRegistry.addName(new ItemStack(electrolysmCore.advancedMicrochip, 1, 1), "Creepified Microchip");
        LanguageRegistry.addName(electrolysmCore.experimentalMicrochip, "Experimental Microchip");
        LanguageRegistry.addName(electrolysmCore.transistor, "Transistor");
        LanguageRegistry.addName(electrolysmCore.graphiteRod, "Graphite Rod");
        LanguageRegistry.addName(electrolysmCore.idifier, "Identifier");
        LanguageRegistry.addName(electrolysmCore.charger, "Electrostatic Energetic Charger");
        LanguageRegistry.addName(electrolysmCore.Yttrium, "Yttrium Block");
        LanguageRegistry.addName(electrolysmCore.magnet, "Rare Earth Magnet");
        LanguageRegistry.addName(electrolysmCore.antiMatterCasing, "Antimatter Proof Glass");
        LanguageRegistry.addName(electrolysmCore.BasicMicrochip, "Basic Microchip");
        LanguageRegistry.addName(electrolysmCore.inkAndQuill, "Ink and Quill");
        LanguageRegistry.addName(electrolysmCore.electroMagnet, "ElectroMagnetic Suspension Unit");
        LanguageRegistry.addName(new ItemStack(electrolysmCore.Scandium, 1, 0), "Scandium Dust");
        LanguageRegistry.addName(new ItemStack(electrolysmCore.Scandium, 1, 1), "Scandium Ingot");
        LanguageRegistry.addName(electrolysmCore.ballOfPlastic, "Ball of Plastic");
        LanguageRegistry.addName(electrolysmCore.ItemWire, "Endothermite Cable");

        
        
        for(int i = 0; i < (SpecialFuelHandler.getFuelList().size() + 1); i++)
        {
            LanguageRegistry.addName(new ItemStack(electrolysmCore.electroContain, 1, i), "Electromagenetic Containment Unit");
        }
        
        //Items
        for (int i = 0; i < ResearchHandler.getAmountOfStoredNames(); i++)
        {
            LanguageRegistry.addName(new ItemStack(electrolysmCore.researchPaper, 1, i), "Research Paper");
        }
        for(int i = 0; i < 3; i++)
        {
        	String[] tier = {"Stone", "Iron", "Diamond"};
        	LanguageRegistry.addName(new ItemStack(electrolysmCore.grindStone, 1, i), tier[i] + " Grind Stone"); 
        }
        for (int i = 0; i < CommonProxy.FLUIDS.length; i++)
        {
            LanguageRegistry.addName(new ItemStack(electrolysmCore.fluidStorage, 1, i),
                                     "Strengthened Fluid Storage Capsule");
        }
        for (int i = 0; i < CommonProxy.DUSTS.length; i++)
        {
            LanguageRegistry.addName(new ItemStack(electrolysmCore.dusts, 1, i), CommonProxy.DUSTS[i] + " Dust");
            LanguageRegistry.addName(new ItemStack(electrolysmCore.impureDusts, 1, i), "Impure " +
                                     CommonProxy.DUSTS[i] + " Dust");
            LanguageRegistry.addName(new ItemStack(electrolysmCore.crystal, 1, i), CommonProxy.DUSTS[i] + " Sulphate Crystal");
        }
        
        /*for(int i = 0; i < ElementHandler.elements.length; i++)
        {
        	LanguageRegistry.addName(new ItemStack(electrolysmCore.elementProof, 1, i), ElementHandler.elements[i]);
        }*/
    }
}
