package assets.electrolysm.electro.client;

import assets.electrolysm.electro.biome.EntityZombie_Scientist;
import assets.electrolysm.electro.block.advMachines.te.TileEntityQuantumComp;
import assets.electrolysm.electro.block.machines.tile.TileEntityDesk;
import assets.electrolysm.electro.block.machines.tile.TileEntityResearchDesk;
import assets.electrolysm.electro.block.machines.tile.TileEntityWorkBench;
import assets.electrolysm.electro.block.te.TileEntityIronFrame;
import assets.electrolysm.electro.common.CommonProxy;
import assets.electrolysm.electro.oreProccessing.te.TileEntityElectrolisisCore;
import assets.electrolysm.electro.powerSystem.te.TileEntityTeslaTower;
import assets.electrolysm.electro.robotics.tile.TileEntitySoldering;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	public static void registerRenderThings() {

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWorkBench.class, new RenderTileWorkBench());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySoldering.class, new RenderTileSoldering());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDesk.class, new RenderTileDesk());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityResearchDesk.class, new RenderTileResearchDesk());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityQuantumComp.class, new RenderTileQuantumComp());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectrolisisCore.class, new RenderTileElectrolysisCore());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTeslaTower.class, new RenderTileTeslaTower());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIronFrame.class, new RenderTileIronFrame());
		
		RenderingRegistry.registerBlockHandler(new BlockInventoryRendering());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityZombie_Scientist.class,
					new RenderZombie_Scientist(new ModelZombie_Scientist(), 2F));
	}
}
