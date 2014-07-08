package electro.client;

import java.util.HashMap;

import electro.Electrolysm;
import electro.assemblySystem.tileEntity.TileEntityRobotArm;
import electro.client.itemRenderers.ItemRenderRoboticArm;
import electro.research.te.TileEntityCollector;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import electro.block.advMachines.te.TileEntityCharger;
import electro.block.advMachines.te.TileEntityQuantumComp;
import electro.block.machines.tile.TileEntityDesk;
import electro.block.machines.tile.TileEntityResearchDesk;
import electro.block.machines.tile.TileEntityWorkBench;
import electro.block.te.TileEntityIronFrame;
import electro.common.CommonProxy;
import electro.handlers.SoundHandler;
import electro.oreProccessing.te.TileEntityElectrolisisCore;
import electro.powerSystem.te.TileEntityWire;
import electro.sciences.robotics.tile.TileEntitySoldering;
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
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCollector.class, new RenderTileCollector());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRobotArm.class, new RenderTileRobotArm());

        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Electrolysm.researchDesk), new ItemResearchDeskRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Electrolysm.robotArm), new ItemRenderRoboticArm());

        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWire.class, new RenderWire());
        //RenderingRegistry.registerBlockHandler(new BlockInventoryRendering());
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
