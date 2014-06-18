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
}
