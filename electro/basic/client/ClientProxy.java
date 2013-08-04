package mods.Electrolysm.electro.basic.client;

import mods.Electrolysm.electro.physics.power.ingame.entity.wireTileEntity;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy {
	
	public void registerRenderThings() {
        ClientRegistry.bindTileEntitySpecialRenderer(wireTileEntity.class, new RenderWire());
}
}
