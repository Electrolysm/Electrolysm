package mods.Electrolysm.electro.machines.gui;



import mods.Electrolysm.electro.machines.container.ContainerForge;
import mods.Electrolysm.electro.machines.container.ContainerMatterMachine;
import mods.Electrolysm.electro.machines.container.ContainerMagmaticExtractor;
import mods.Electrolysm.electro.machines.entities.tile.TileEntityForge;
import mods.Electrolysm.electro.machines.entities.tile.TileEntityMatterMachine;
import mods.Electrolysm.electro.machines.entities.tile.TileEntityMagmaticExtractor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		
		if (entity instanceof TileEntityMatterMachine)
		{
			return new ContainerMatterMachine((TileEntityMatterMachine)entity, player.inventory);
		}
		
		if (entity instanceof TileEntityMagmaticExtractor)
		{
			return new ContainerMagmaticExtractor((TileEntityMagmaticExtractor)entity, player.inventory);
		}
		if (entity instanceof TileEntityForge)
		{
			return new ContainerForge(player.inventory, (TileEntityForge)entity);
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		if (entity instanceof TileEntityMatterMachine)
		{
			return new GuiMatterMachine((TileEntityMatterMachine)entity, player.inventory);
		}
		
		if (entity instanceof TileEntityMagmaticExtractor)
		{
			return new GuiMagmaticExtractor((TileEntityMagmaticExtractor)entity, player.inventory);
		}
		
		if (entity instanceof TileEntityForge)
		{
			return new GuiForge(player.inventory, (TileEntityForge)entity);
		}
		
		
		return null;
	}
}
