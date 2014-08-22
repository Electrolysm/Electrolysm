package electrolysm.electro.client;

import electrolysm.api.powerSystem.prefab.TEPowerCore;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import electrolysm.electro.Electrolysm;
import electrolysm.electro.client.itemRenderers.ItemRenderCharger;
import electrolysm.electro.client.itemRenderers.ItemRenderElectrolysis;
import electrolysm.electro.client.itemRenderers.ItemRenderIronFrame;
import electrolysm.electro.client.itemRenderers.ItemRenderPowerCore;
import electrolysm.electro.common.CommonProxy;
import electrolysm.electro.handlers.SoundHandler;
import electrolysm.electro.machines.advMachines.te.TileEntityCharger;
import electrolysm.electro.machines.advMachines.te.TileEntityQuantumComp;
import electrolysm.electro.machines.assemblySystem.crafting.TileEntityMatrix;
import electrolysm.electro.machines.assemblySystem.inventory.TileEntityRobotArm;
import electrolysm.electro.misc.block.te.TileEntityIronFrame;
import electrolysm.electro.oreProccessing.te.TileEntityElectrolisisCore;
import electrolysm.electro.powerSystem.te.TileEntityWire;
import electrolysm.electro.sciences.robotics.tile.TileEntitySoldering;
import electrolysm.electro.world.biome.EntityZombie_Scientist;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import java.util.HashMap;

public class ClientProxy extends CommonProxy
{
    public static void registerRenderThings()
    {
    	MinecraftForge.EVENT_BUS.register(new SoundHandler());
    	
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySoldering.class, new RenderTileSoldering());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityQuantumComp.class, new RenderTileQuantumComp());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectrolisisCore.class, new RenderTileElectrolysisCore());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIronFrame.class, new RenderTileIronFrame());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCharger.class, new RenderTileCharger());
        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCollector.class, new RenderTileCollector());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRobotArm.class, new RenderTileRobotArm());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMatrix.class, new RenderTileMatrixConstruction());
        ClientRegistry.bindTileEntitySpecialRenderer(TEPowerCore.class, new RenderTileEnergyCube());

       // MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Electrolysm.robotArm), new ItemRenderRoboticArm());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Electrolysm.charger), new ItemRenderCharger());
        //MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Electrolysm.dataRecorder), new ItemRenderCollector());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Electrolysm.electrolisisCore), new ItemRenderElectrolysis());
        //MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Electrolysm.matrix), new ItemRenderMatrix());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Electrolysm.ironFrames), new ItemRenderIronFrame());

        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Electrolysm.basicEnergyStorage), new ItemRenderPowerCore());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Electrolysm.advEnergyStorage), new ItemRenderPowerCore());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Electrolysm.creativeEnergyStorage), new ItemRenderPowerCore());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWire.class, new RenderWire());
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
