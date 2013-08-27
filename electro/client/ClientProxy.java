package mods.Electrolysm.electro.client;

import mods.Electrolysm.electro.biology.bacteria.TileEntityPetriDish;
import mods.Electrolysm.electro.biology.entity.TileEntityMicroscope;
import mods.Electrolysm.electro.common.CommonProxy;
import mods.Electrolysm.electro.physics.power.ingame.entity.TileEntityWire;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

	public static void registerRenderThings() {
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPetriDish.class, new RenderTilePetriDish());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMicroscope.class, new RenderTileMicroscope());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWire.class, new RenderWire());

	}
}
