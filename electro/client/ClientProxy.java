package assets.electrolysm.electro.client;

import assets.electrolysm.electro.common.CommonProxy;
import assets.electrolysm.electro.robotics.tile.TileEntitySoldering;
import assets.electrolysm.electro.robotics.tile.TileEntityWorkBench;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

	public static void registerRenderThings() {

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWorkBench.class, new RenderTileWorkBench());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySoldering.class, new RenderTileSoldering());

	}
}
