package electro.handlers;

import electro.Electrolysm;
import electro.world.biome.EntityZombie_Scientist;
import net.minecraft.item.ItemStack;
import api.specialFuel.SpecialFuelHandler;
import electro.common.CommonProxy;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.world.World;

public class Names
{
    public static void addName()
    {
        //LanguageRegistry.addName(Electrolysm.workBench, "Work Bench");
        //LanguageRegistry.addName(Electrolysm.desk, "Scientist's Desk");
        /*LanguageRegistry.addName(Electrolysm.researchDesk, "Research Desk");
        LanguageRegistry.addName(Electrolysm.blastProof, "Blast Proof Iron Block");
        LanguageRegistry.addName(Electrolysm.blastDoor, "Blast Proof Iron Door");
        LanguageRegistry.addName(Electrolysm.energiser, "Fluid Energiser");
        LanguageRegistry.addName(Electrolysm.injector, "Injector");
        LanguageRegistry.addName(Electrolysm.plasma, "Liquid Plasma");
        //LanguageRegistry.addName(electrolysmCore.quantumComp, "Quantum Computer");
        LanguageRegistry.addName(Electrolysm.blastGlass, "Blast Proof Iron Glass");
        LanguageRegistry.addName(Electrolysm.modBlastGlass, "Modified Blast Proof Iron Glass");
        LanguageRegistry.addName(Electrolysm.plasmaDrill, "Plasma Drill");
        LanguageRegistry.addName(Electrolysm.diseaseGrass, "Diseased Grass");
        LanguageRegistry.addName(Electrolysm.spawnZS, "Spawn Zombie-Scientist");
        LanguageRegistry.addName(Electrolysm.knowledge, "Knowledge Strip");
        LanguageRegistry.addName(Electrolysm.drillCasing, "Plasma Drill Casing");
        LanguageRegistry.addName(Electrolysm.graphite, "Graphite");
        LanguageRegistry.addName(Electrolysm.chunkGraphite, "Graphite Chunk");
        LanguageRegistry.addName(Electrolysm.injectionArm, "Injection Arm");
        LanguageRegistry.addName(Electrolysm.energisingRod, "Energising Filament");
        LanguageRegistry.addName(Electrolysm.glassModifire, "Glass Modifier");
        LanguageRegistry.addName(Electrolysm.sulphurOre, "Sulphur Ore");
        LanguageRegistry.addName(Electrolysm.sulphur, "Sulphur Crystals");
        LanguageRegistry.addName(Electrolysm.energyMeter, "Energy Meter");
        LanguageRegistry.addName(Electrolysm.sulpuricAcid, "Sulphuric Acid");
        LanguageRegistry.addName(Electrolysm.copperOre, "Copper Ore");
        LanguageRegistry.addName(Electrolysm.ironFrames, "Iron Frame");
        LanguageRegistry.addName(Electrolysm.hammer, "Hammer");
        LanguageRegistry.addName(Electrolysm.copperIngot, "Copper Ingot");
        LanguageRegistry.addName(Electrolysm.node, "Graphite Electrode");
        LanguageRegistry.addName(Electrolysm.luminousRedstone, "Luminous Redstone Dust");
        LanguageRegistry.addName(Electrolysm.diamondShard, "Diamond Shard");
        LanguageRegistry.addName(Electrolysm.crystalBase, "Crystal Base");
        LanguageRegistry.addName(Electrolysm.blastBrick, "Blast Proof Iron Brick");
        LanguageRegistry.addName(new ItemStack(Electrolysm.nettedBlock, 1), "Netted Ore");
        LanguageRegistry.addName(Electrolysm.card, "ID Card");
        LanguageRegistry.addName(new ItemStack(Electrolysm.ingots, 1, 0), "Tin Ingot");
        LanguageRegistry.addName(new ItemStack(Electrolysm.ingots, 1, 1), "Silver Ingot");
        LanguageRegistry.addName(new ItemStack(Electrolysm.ingots, 1, 2), "Lead Ingot");
        LanguageRegistry.addName(Electrolysm.liquidiser, "Displacement Chamber");
        LanguageRegistry.addName(Electrolysm.crusher, "Crusher");
        LanguageRegistry.addName(Electrolysm.electrolisisCore, "Electrolysis Chamber");
        LanguageRegistry.addName(Electrolysm.electrolChamber, "Electrolysis Wall");
        LanguageRegistry.addName(Electrolysm.smeltory, "Smeltery");
        LanguageRegistry.addName(Electrolysm.smeltoryActive, "Smeltory");
        LanguageRegistry.addName(Electrolysm.crusherActive, "Crusher");
        LanguageRegistry.addName(Electrolysm.net, "Ore Net");
        LanguageRegistry.addName(Electrolysm.endoInsulator, "Endothermite Insulator");
        LanguageRegistry.addName(Electrolysm.microchipBoard, "Chip Board");
        LanguageRegistry.addName(Electrolysm.CPU, "CPU");
        LanguageRegistry.addName(Electrolysm.advancedCPU, "Advanced CPU");
        LanguageRegistry.addName(new ItemStack(Electrolysm.advancedMicrochip, 1, 0), "Advanced Microchip");
        LanguageRegistry.addName(new ItemStack(Electrolysm.advancedMicrochip, 1, 1), "Creepified Microchip");
        LanguageRegistry.addName(Electrolysm.experimentalMicrochip, "Experimental Microchip");
        LanguageRegistry.addName(Electrolysm.transistor, "Transistor");
        LanguageRegistry.addName(Electrolysm.graphiteRod, "Graphite Rod");
        LanguageRegistry.addName(Electrolysm.idifier, "Identifier");
        LanguageRegistry.addName(Electrolysm.charger, "Electrostatic Energetic Charger");
        LanguageRegistry.addName(Electrolysm.Yttrium, "Yttrium Block");
        LanguageRegistry.addName(Electrolysm.magnet, "Rare Earth Magnet");
        LanguageRegistry.addName(Electrolysm.antiMatterCasing, "Antimatter Proof Glass");
        LanguageRegistry.addName(Electrolysm.BasicMicrochip, "Basic Microchip");
        LanguageRegistry.addName(Electrolysm.inkAndQuill, "Ink and Quill");
        LanguageRegistry.addName(Electrolysm.electroMagnet, "ElectroMagnetic Suspension Unit");
        LanguageRegistry.addName(new ItemStack(Electrolysm.Scandium, 1, 0), "Scandium Dust");
        LanguageRegistry.addName(new ItemStack(Electrolysm.Scandium, 1, 1), "Scandium Ingot");
        LanguageRegistry.addName(Electrolysm.ballOfPlastic, "Ball of Plastic");
        LanguageRegistry.addName(Electrolysm.ItemWire, "Endothermite Cable");
        LanguageRegistry.addName(Electrolysm.researchDevice, "Research Identification Tablet");
        LanguageRegistry.addName(Electrolysm.itemScanner, "Analyser");
        LanguageRegistry.addName(Electrolysm.neutraliser, "Neutralising Compound");
*/
        for(int i = 0; i < (SpecialFuelHandler.getFuelList().size() + 1); i++)
        {
            LanguageRegistry.addName(new ItemStack(Electrolysm.electroContain, 1, i), "Electromagenetic Containment Unit");
        }
        
        for(int i = 0; i < 3; i++)
        {
        	String[] tier = {"Stone", "Iron", "Diamond"};
        	LanguageRegistry.addName(new ItemStack(Electrolysm.grindStone, 1, i), tier[i] + " Grind Stone");
        }
        for (int i = 0; i < CommonProxy.FLUIDS.length; i++)
        {
            LanguageRegistry.addName(new ItemStack(Electrolysm.fluidStorage, 1, i),
                                     "Strengthened Fluid Storage Capsule");
        }
        for (int i = 0; i < CommonProxy.DUSTS.length; i++)
        {
            LanguageRegistry.addName(new ItemStack(Electrolysm.dusts, 1, i), CommonProxy.DUSTS[i] + " Dust");
            LanguageRegistry.addName(new ItemStack(Electrolysm.impureDusts, 1, i), "Impure " +
                                     CommonProxy.DUSTS[i] + " Dust");
            LanguageRegistry.addName(new ItemStack(Electrolysm.crystal, 1, i), CommonProxy.DUSTS[i] + " Sulphate Crystal");
        }
        
        /*for(int i = 0; i < ElementHandler.elements.length; i++)
        {
        	LanguageRegistry.addName(new ItemStack(electrolysmCore.elementProof, 1, i), ElementHandler.elements[i]);
        }*/
    }
}
