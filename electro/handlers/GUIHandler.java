package assets.electrolysm.electro.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.block.advMachines.container.ContainerEnergiser;
import assets.electrolysm.electro.block.advMachines.container.ContainerInjector;
import assets.electrolysm.electro.block.advMachines.gui.GUIEnergiser;
import assets.electrolysm.electro.block.advMachines.gui.GUIInjector;
import assets.electrolysm.electro.block.advMachines.te.TileEntityEnergiser;
import assets.electrolysm.electro.block.advMachines.te.TileEntityInjector;
import assets.electrolysm.electro.block.machines.container.ContainerResearchDesk;
import assets.electrolysm.electro.block.machines.container.ContainerWorkBench;
import assets.electrolysm.electro.block.machines.gui.GUIResearchDesk;
import assets.electrolysm.electro.block.machines.gui.GUIWorkBench;
import assets.electrolysm.electro.block.machines.tile.TileEntityResearchDesk;
import assets.electrolysm.electro.oreProccessing.container.ContainerElectrolysis;
import assets.electrolysm.electro.oreProccessing.container.ContainerPort;
import assets.electrolysm.electro.oreProccessing.gui.GUIElectrolysisCore;
import assets.electrolysm.electro.oreProccessing.gui.GUIPort;
import assets.electrolysm.electro.oreProccessing.te.TileEntityElectrolisisCore;
import assets.electrolysm.electro.oreProccessing.te.TileEntityPort;
import assets.electrolysm.electro.powerSystem.container.ConatainerPlug;
import assets.electrolysm.electro.powerSystem.gui.GUIPlug;
import assets.electrolysm.electro.powerSystem.te.TileEntityPlug;
import cpw.mods.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		
		if(entity instanceof TileEntityResearchDesk)
		{
			return new ContainerResearchDesk((TileEntityResearchDesk)entity, player.inventory);
		}
		
		if(entity instanceof TileEntityEnergiser)
		{
			return new ContainerEnergiser(player.inventory, (TileEntityEnergiser)entity);
		}
		
		if(entity instanceof TileEntityInjector)
		{
			return new ContainerInjector(player.inventory, (TileEntityInjector)entity);
		}
		if(entity instanceof TileEntityElectrolisisCore)
		{
			return new ContainerElectrolysis((TileEntityElectrolisisCore)entity, player.inventory);
		}
		if(entity instanceof TileEntityPort)
		{
			return new ContainerPort((TileEntityPort)entity, player.inventory);
		}
		if(entity instanceof TileEntityPlug)
		{
			return new ConatainerPlug((TileEntityPlug)entity, player.inventory);
		}
		
		//Crafting
		
		switch(ID)
		{
		case 0: return ID == 0 && world.getBlockId(x, y, z) == electrolysmCore.workBench.blockID ? 
				new ContainerWorkBench(player.inventory, world, x, y, z) : null;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		
		if(entity instanceof TileEntityResearchDesk)
		{
			return new GUIResearchDesk((TileEntityResearchDesk)entity, player.inventory);
		}
		
		if(entity instanceof TileEntityEnergiser)
		{
			return new GUIEnergiser(player.inventory, (TileEntityEnergiser)entity);
		}
		
		if(entity instanceof TileEntityInjector)
		{
			return new GUIInjector(player.inventory, (TileEntityInjector)entity);
		}
		if(entity instanceof TileEntityElectrolisisCore)
		{
			return new GUIElectrolysisCore((TileEntityElectrolisisCore)entity, player.inventory);
		}
		if(entity instanceof TileEntityPort)
		{
			return new GUIPort((TileEntityPort)entity, player.inventory);
		}
		if(entity instanceof TileEntityPlug)
		{
			return new GUIPlug((TileEntityPlug)entity, player.inventory);
		}
		
		//Crafting
		
		switch(ID)
		{
		case 0: return ID == 0 && world.getBlockId(x, y, z) == electrolysmCore.workBench.blockID ?
				new GUIWorkBench(player.inventory, world, x, y, z) : null;
		}
		
		return null;
	}

}
