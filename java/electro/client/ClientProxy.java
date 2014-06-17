package electro.client;

import java.util.HashMap;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import electro.block.advMachines.te.TileEntityCharger;
import electro.block.advMachines.te.TileEntityQuantumComp;
import electro.block.machines.tile.TileEntityDesk;
import electro.block.machines.tile.TileEntityResearchDesk;
import electro.block.machines.tile.TileEntityWorkBench;
import electro.block.te.TileEntityIronFrame;
import assets.electrolysm.electro.common.CommonProxy;
import assets.electrolysm.electro.handlers.SoundHandler;
import assets.electrolysm.electro.oreProccessing.te.TileEntityElectrolisisCore;
import assets.electrolysm.electro.powerSystem.te.TileEntityWire;
import assets.electrolysm.electro.sciences.robotics.tile.TileEntitySoldering;
import electro.world.biome.EntityZombie_Scientist;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
    public static void registerRenderThings()
    {
    	MinecraftForge.EVENT_BUS.register(new SoundHandler());
    	
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWorkBench.class, new RenderTileWorkBench());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySoldering.class, new RenderTileSoldering());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDesk.class, new RenderTileDesk());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityResearchDesk.class, new RenderTileResearchDesk());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityQuantumComp.class, new RenderTileQuantumComp());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectrolisisCore.class, new RenderTileElectrolysisCore());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIronFrame.class, new RenderTileIronFrame());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCharger.class, new RenderTileCharger());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWire.class, new RenderWire());
        RenderingRegistry.registerBlockHandler(new BlockInventoryRendering());
        RenderingRegistry.registerEntityRenderingHandler(EntityZombie_Scientist.class,
        		new RenderZombie_Scientist(new ModelZombie_Scientist(), 2F));
        
		//RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new RenderPlayerLab());

    }
    
    public static HashMap<EntityPlayer, Boolean> playerCoat = new HashMap<EntityPlayer, Boolean>();
    
    public static void putData(EntityPlayer player, boolean isWearing)
    {
    	playerCoat.put(player, isWearing);
    }
}
