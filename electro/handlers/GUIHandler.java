package assets.electrolysm.electro.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.electro.block.machines.container.ContainerResearchDesk;
import assets.electrolysm.electro.block.machines.gui.GUIResearchDesk;
import assets.electrolysm.electro.block.machines.tile.TileEntityResearchDesk;
import cpw.mods.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		
		if(entity instanceof TileEntityResearchDesk)
		{
			return new ContainerResearchDesk((TileEntityResearchDesk)entity, player.inventory);
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
		return null;
	}

}
