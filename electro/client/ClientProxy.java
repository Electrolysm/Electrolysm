package mods.Electrolysm.electro.client;

import mods.Electrolysm.electro.biology.bacteria.TileEntityPetriDish;
import mods.Electrolysm.electro.biology.entity.TileEntityMicroscope;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy {
	
	public static void registerRenderThings() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPetriDish.class, new RenderTilePetriDish());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMicroscope.class, new RenderTileMicroscope());

	}
}
