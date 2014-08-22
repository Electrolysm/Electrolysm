package electrolysm.electro.handlers;

import electrolysm.api.powerSystem.prefab.*;
import cpw.mods.fml.common.registry.GameRegistry;
import electrolysm.electro.machines.advMachines.te.TileEntityCharger;
import electrolysm.electro.machines.advMachines.te.TileEntityEnergiser;
import electrolysm.electro.machines.advMachines.te.TileEntityInjector;
import electrolysm.electro.machines.assemblySystem.crafting.TileEntityMatrix;
import electrolysm.electro.machines.assemblySystem.inventory.TileEntityRobotArm;
import electrolysm.electro.misc.block.basic.te.TileEntityBlastDoor;
import electrolysm.electro.misc.block.te.TileEntityIronFrame;
import electrolysm.electro.misc.crafting.items.te.TileEntityLumRed;
import electrolysm.electro.oreProccessing.te.*;
import electrolysm.electro.powerSystem.generators.te.*;
import electrolysm.electro.powerSystem.te.TileEntityWire;
import electrolysm.electro.sciences.alloyFurnace.TileEntityAlloyFurnace;
import electrolysm.electro.world.biome.TileEntityGrass;

/**
 * Created by Clarky158 on 26/01/14.
 */
public class TileEntityMappingHandler
{
    public static void addMappings()
    {
        GameRegistry.registerTileEntity(TileEntityGrass.class, "TileEntityGrass");
        GameRegistry.registerTileEntity(TileEntityRelay.class, "TileEntityRelay");
        GameRegistry.registerTileEntity(TileEntityThermalGenerator.class, "TileEntityThermalGenerator");
        GameRegistry.registerTileEntity(TileEntityAdvGenerator.class, "TileEntityAdvGenerator");
        GameRegistry.registerTileEntity(TileEntityLumRed.class, "TileEntityLumRed");
        GameRegistry.registerTileEntity(TileEntityAlloyFurnace.class, "TileEntityAlloyFurnace");
        GameRegistry.registerTileEntity(TileEntitySolarPanel.class, "TileEntitySolarPanel");
        GameRegistry.registerTileEntity(TileEntityBlastDoor.class, "TileEntityBlastDoor");
        GameRegistry.registerTileEntity(TileEntityCrusher.class, "TileEntityCrusher");
        GameRegistry.registerTileEntity(TileEntityElectrolisisCore.class, "TileEntityElectrolysisCore");
        GameRegistry.registerTileEntity(TileEntityImprovedFurnace.class, "TileEntityImprovedFurnace");
        GameRegistry.registerTileEntity(TileEntityEnergiser.class, "TileEntityEnergiser");
        GameRegistry.registerTileEntity(TileEntityInjector.class, "TileEntityInjector");
        GameRegistry.registerTileEntity(TileEntityIronFrame.class, "TileEntityIronFrame");
        GameRegistry.registerTileEntity(TileEntityLiquidiser.class, "TileEntityLiquidiser");
        GameRegistry.registerTileEntity(TileEntitySmeltory.class, "TileEntitySmeltory");
        GameRegistry.registerTileEntity(TileEntityWire.class, "TileEntityWire");
        GameRegistry.registerTileEntity(TileEntityGeneratorCoal.class, "TileEntityGeneratorCoal");
        GameRegistry.registerTileEntity(TileEntityGeneratorAntimatter.class, "TileEntityGeneratorAntimatter");
        GameRegistry.registerTileEntity(TileEntityCharger.class, "TileEntityCharge");
        GameRegistry.registerTileEntity(TileEntityMatrix.class, "TileEntityMatrix");
//        /GameRegistry.registerTileEntity(TileEntityMatrixMachine.class, "TileEntityMatrixMachine");
        GameRegistry.registerTileEntity(TileEntityRobotArm.class, "TileEntityRoboticArm");
        GameRegistry.registerTileEntity(TEPowerCore.class, "TEPowerCore");
        GameRegistry.registerTileEntity(TileEntityBasicCable.class, "TileEntityBasicCable");
        GameRegistry.registerTileEntity(TileEntityGenerator.class, "TileEntityGenerator");
        GameRegistry.registerTileEntity(TileEntityMachine.class, "TileEntityMachine");

    }
}
