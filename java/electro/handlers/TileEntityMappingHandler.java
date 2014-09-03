package electro.handlers;

import electro.powerSystem.tesla.te.TileEntityReceiverModel;
import electrolysm.api.powerSystem.prefab.*;
import electrolysm.api.powerSystem.tesla.TERecievingCore;
import electrolysm.api.powerSystem.tesla.TETeslaTower;
import cpw.mods.fml.common.registry.GameRegistry;
import electro.machines.advMachines.te.TileEntityCharger;
import electro.machines.advMachines.te.TileEntityEnergiser;
import electro.machines.advMachines.te.TileEntityInjector;
import electro.machines.assemblySystem.crafting.TileEntityMatrix;
import electro.machines.assemblySystem.inventory.TileEntityRobotArm;
import electro.misc.block.basic.te.TileEntityBlastDoor;
import electro.misc.block.te.TileEntityIronFrame;
import electro.misc.crafting.items.te.TileEntityLumRed;
import electro.oreProccessing.te.*;
import electro.powerSystem.generators.te.*;
import electro.powerSystem.te.TileEntityWire;
import electro.powerSystem.tesla.te.TileEntityTeslaCore;
import electro.sciences.alloyFurnace.TileEntityAlloyFurnace;
import electro.world.biome.TileEntityGrass;

/**
 * Created by Clarky158 on 26/01/14.
 */
public class TileEntityMappingHandler
{
    public static void addMappings()
    {
        GameRegistry.registerTileEntity(TileEntityReceiverModel.class, "TileEntityReceiverModel");
        GameRegistry.registerTileEntity(TileEntityGrass.class, "TileEntityGrass");
        GameRegistry.registerTileEntity(TileEntityRelay.class, "TileEntityRelay");
        GameRegistry.registerTileEntity(TETeslaTower.class, "TileEntityTeslaTower");
        GameRegistry.registerTileEntity(TileEntityTeslaCore.class, "TileEntityTeslaCore");
        GameRegistry.registerTileEntity(TileEntityThermalGenerator.class, "TileEntityThermalGenerator");
        GameRegistry.registerTileEntity(TileEntityAdvGenerator.class, "TileEntityAdvGenerator");
        GameRegistry.registerTileEntity(TERecievingCore.class, "TileEntityReceivingCore");
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
