package assets.electrolysm.electro.handlers;

import assets.electrolysm.electro.block.advMachines.te.TileEntityEnergiser;
import assets.electrolysm.electro.block.advMachines.te.TileEntityInjector;
import assets.electrolysm.electro.block.basic.te.TileEntityBlastDoor;
import assets.electrolysm.electro.block.machines.tile.TileEntityResearchDesk;
import assets.electrolysm.electro.block.machines.tile.TileEntityWorkBench;
import assets.electrolysm.electro.block.te.TileEntityIronFrame;
import assets.electrolysm.electro.oreProccessing.te.TileEntityCrusher;
import assets.electrolysm.electro.oreProccessing.te.TileEntityElectrolisisCore;
import assets.electrolysm.electro.oreProccessing.te.TileEntityLiquidiser;
import assets.electrolysm.electro.oreProccessing.te.TileEntitySmeltory;
import assets.electrolysm.electro.powerSystem.generators.te.TileEntityGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Ben on 26/01/14.
 */
public class TileEntityMappingHandler
{
    public static void addMappings()
    {
        GameRegistry.registerTileEntity(TileEntityGenerator.class, "TileEntityGenerator");
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
    }
}
