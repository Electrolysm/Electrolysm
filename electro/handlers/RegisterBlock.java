package assets.electrolysm.electro.handlers;

import net.minecraft.block.Block;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.world.Scandium;
import assets.electrolysm.electro.world.WorldGenOres;
import assets.electrolysm.electro.world.WorldGenStructures;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterBlock
{
    public static void register()
    {
        GameRegistry.registerBlock(electrolysmCore.workBench);
        GameRegistry.registerBlock(electrolysmCore.desk);
        GameRegistry.registerBlock(electrolysmCore.researchDesk);
        GameRegistry.registerBlock(electrolysmCore.diseaseGrass);
        GameRegistry.registerBlock(electrolysmCore.blastProof);
        GameRegistry.registerBlock(electrolysmCore.blastDoor);
        GameRegistry.registerBlock(electrolysmCore.blastGlass);
        GameRegistry.registerBlock(electrolysmCore.plasma);
        GameRegistry.registerBlock(electrolysmCore.energiser);
        GameRegistry.registerBlock(electrolysmCore.injector);
        //GameRegistry.registerBlock(electrolysmCore.quantumComp);
        GameRegistry.registerBlock(electrolysmCore.graphite);
        GameRegistry.registerBlock(electrolysmCore.modBlastGlass);
        GameRegistry.registerBlock(electrolysmCore.sulphurOre);
        GameRegistry.registerBlock(electrolysmCore.electrolChamber);
        GameRegistry.registerBlock(electrolysmCore.electrolisisCore);
        GameRegistry.registerBlock(electrolysmCore.crusher);
        GameRegistry.registerBlock(electrolysmCore.liquidiser);
        //GameRegistry.registerBlock(electrolysmCore.seperator);
        GameRegistry.registerBlock(electrolysmCore.smeltery);
        //GameRegistry.registerBlock(electrolysmCore.electrolPort);
        GameRegistry.registerBlock(electrolysmCore.sulpuricAcid);
        GameRegistry.registerBlock(electrolysmCore.ironFrames);
        GameRegistry.registerBlock(electrolysmCore.copperOre);
        GameRegistry.registerBlock(electrolysmCore.charger);
        GameRegistry.registerBlock(electrolysmCore.idifier);
        GameRegistry.registerBlock(electrolysmCore.blastBrick);
        GameRegistry.registerBlock(electrolysmCore.lightSource);
        GameRegistry.registerWorldGenerator(new WorldGenStructures());
        GameRegistry.registerWorldGenerator(new WorldGenOres());
        GameRegistry.registerBlock(electrolysmCore.nettedBlock);
        GameRegistry.registerBlock(electrolysmCore.crusherActive);
        GameRegistry.registerBlock(electrolysmCore.smeltoryActive);
        GameRegistry.registerBlock(electrolysmCore.endoCable);
        GameRegistry.registerBlock(electrolysmCore.generator);
        GameRegistry.registerBlock(electrolysmCore.antiMatterCasing);
        GameRegistry.registerBlock(electrolysmCore.magnet);
        GameRegistry.registerBlock(electrolysmCore.Yttrium);
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
