package electro.handlers;

import electro.block.advMachines.te.TileEntityEnergiser;
import electro.block.advMachines.te.TileEntityInjector;
import electro.block.basic.te.TileEntityBlastDoor;
import electro.block.machines.tile.TileEntityDesk;
import electro.block.machines.tile.TileEntityResearchDesk;
import electro.block.machines.tile.TileEntityWorkBench;
import electro.block.te.TileEntityIronFrame;
import assets.electrolysm.electro.oreProccessing.te.TileEntityCrusher;
import assets.electrolysm.electro.oreProccessing.te.TileEntityElectrolisisCore;
import assets.electrolysm.electro.oreProccessing.te.TileEntityLiquidiser;
import assets.electrolysm.electro.oreProccessing.te.TileEntitySmeltory;
import assets.electrolysm.electro.powerSystem.generators.te.TileEntityGeneratorAntimatter;
import assets.electrolysm.electro.powerSystem.generators.te.TileEntityGeneratorCoal;
import assets.electrolysm.electro.powerSystem.te.TileEntityWire;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Clarky158 on 26/01/14.
 */
public class TileEntityMappingHandler
{
    public static void addMappings()
    {
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
    }
}
