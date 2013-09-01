package assets.electrolysm.electro.client;

import net.minecraftforge.client.MinecraftForgeClient;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.block.machines.tile.TileEntityDesk;
import assets.electrolysm.electro.block.machines.tile.TileEntityResearchDesk;
import assets.electrolysm.electro.block.machines.tile.TileEntityWorkBench;
import assets.electrolysm.electro.common.CommonProxy;
import assets.electrolysm.electro.robotics.tile.TileEntitySoldering;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

	public static void registerRenderThings() {

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWorkBench.class, new RenderTileWorkBench());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySoldering.class, new RenderTileSoldering());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDesk.class, new RenderTileDesk());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityResearchDesk.class, new RenderTileResearchDesk());

		MinecraftForgeClient.registerItemRenderer(electrolysmCore.researchDesk.blockID, new ItemRenderResearchDesk());

	}
}
