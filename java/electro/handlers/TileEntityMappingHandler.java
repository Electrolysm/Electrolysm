package electro.handlers;

import api.powerSystem.prefab.TEPowerCore;
import api.powerSystem.prefab.TileEntityBasicCable;
import api.powerSystem.prefab.TileEntityGenerator;
import api.powerSystem.prefab.TileEntityMachine;
import electro.machines.assemblySystem.crafting.TileEntityMatrix;
import electro.machines.assemblySystem.inventory.TileEntityRobotArm;
import electro.machines.advMachines.te.TileEntityCharger;
import electro.machines.advMachines.te.TileEntityEnergiser;
import electro.machines.advMachines.te.TileEntityInjector;
import electro.misc.block.basic.te.TileEntityBlastDoor;
import electro.misc.crafting.items.te.TileEntityLumRed;
import electro.powerSystem.generators.te.*;
import electro.powerSystem.te.TileEntityAdvCore;
import electro.powerSystem.te.TileEntityCore;
import electro.powerSystem.te.TileEntityCreativeCore;
import electro.research.machines.tile.TileEntityDesk;
import electro.research.machines.tile.TileEntityResearchDesk;
import electro.research.machines.tile.TileEntityWorkBench;
import electro.misc.block.te.TileEntityIronFrame;
import cpw.mods.fml.common.registry.GameRegistry;
import electro.oreProccessing.te.TileEntityCrusher;
import electro.oreProccessing.te.TileEntityElectrolisisCore;
import electro.oreProccessing.te.TileEntityLiquidiser;
import electro.oreProccessing.te.TileEntitySmeltory;
import electro.powerSystem.te.TileEntityWire;
import electro.research.te.TileEntityCollector;
import electro.sciences.alloyFurnace.TileEntityAlloyFurnace;
import electro.world.biome.TileEntityGrass;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Clarky158 on 26/01/14.
 */
public class TileEntityMappingHandler
{
    public static void addMappings()
    {
        GameRegistry.registerTileEntity(TileEntityGrass.class, "TileEntityGrass");
        GameRegistry.registerTileEntity(TileEntityThermalGenerator.class, "TileEntityThermalGenerator");
        GameRegistry.registerTileEntity(TileEntityAdvGenerator.class, "TileEntityAdvGenerator");
        GameRegistry.registerTileEntity(TileEntityLumRed.class, "TileEntityLumRed");
        GameRegistry.registerTileEntity(TileEntityAlloyFurnace.class, "TileEntityAlloyFurnace");
        GameRegistry.registerTileEntity(TileEntitySolarPanel.class, "TileEntitySolarPanel");
        GameRegistry.registerTileEntity(TileEntityBlastDoor.class, "TileEntityBlastDoor");
        GameRegistry.registerTileEntity(TileEntityCrusher.class, "TileEntityCrusher");
        GameRegistry.registerTileEntity(TileEntityElectrolisisCore.class, "TileEntityElectrolysisCore");
        GameRegistry.registerTileEntity(TileEntityEnergiser.class, "TileEntityEnergiser");
        GameRegistry.registerTileEntity(TileEntityInjector.class, "TileEntityInjector");
        GameRegistry.registerTileEntity(TileEntityIronFrame.class, "TileEntityIronFrame");
        GameRegistry.registerTileEntity(TileEntityResearchDesk.class, "TileEntityResearchDesk");
        GameRegistry.registerTileEntity(TileEntityWorkBench.class, "TileEntityWorkBench");
        GameRegistry.registerTileEntity(TileEntityLiquidiser.class, "TileEntityLiquidiser");
        GameRegistry.registerTileEntity(TileEntitySmeltory.class, "TileEntitySmeltory");
        GameRegistry.registerTileEntity(TileEntityWire.class, "TileEntityWire");
        GameRegistry.registerTileEntity(TileEntityGeneratorCoal.class, "TileEntityGeneratorCoal");
        GameRegistry.registerTileEntity(TileEntityGeneratorAntimatter.class, "TileEntityGeneratorAntimatter");
        GameRegistry.registerTileEntity(TileEntityDesk.class, "TileEntityDesk");
        GameRegistry.registerTileEntity(TileEntityCharger.class, "TileEntityCharge");
        GameRegistry.registerTileEntity(TileEntityCollector.class, "TileEntityCollector");
        GameRegistry.registerTileEntity(TileEntityMatrix.class, "TileEntityMatrix");
//        /GameRegistry.registerTileEntity(TileEntityMatrixMachine.class, "TileEntityMatrixMachine");
        GameRegistry.registerTileEntity(TileEntityRobotArm.class, "TileEntityRoboticArm");
        GameRegistry.registerTileEntity(TileEntityBasicCable.class, "TileEntityBasicCable");
        GameRegistry.registerTileEntity(TileEntityGenerator.class, "TileEntityGenerator");
        GameRegistry.registerTileEntity(TileEntityMachine.class, "TileEntityMachine");
        GameRegistry.registerTileEntity(TEPowerCore.class, "TEPowerCore");

        GameRegistry.registerTileEntity(TileEntityCore.class, "TileEntityCore");
        GameRegistry.registerTileEntity(TileEntityAdvCore.class, "TileEntityAdvCore");
        GameRegistry.registerTileEntity(TileEntityCreativeCore.class, "TileEntityCreativeCore");


    }
}
