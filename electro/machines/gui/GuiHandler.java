package mods.electrolysm.electro.machines.gui;


import mods.electrolysm.electro.machines.container.ContainerElectricFurnace;
import mods.electrolysm.electro.machines.container.ContainerMagmaticExtractor;
import mods.electrolysm.electro.machines.entities.tile.TileEntityElectricFurnace;
import mods.electrolysm.electro.machines.entities.tile.TileEntityMagmaticExtractor;
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
		
		if (entity instanceof TileEntityElectricFurnace)
		{
			return new ContainerElectricFurnace((TileEntityElectricFurnace)entity, player.inventory);
		}
		if (entity instanceof TileEntityMagmaticExtractor)
		{
			return new ContainerMagmaticExtractor((TileEntityMagmaticExtractor)entity, player.inventory);
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		if (entity instanceof TileEntityElectricFurnace)
		{
			return new GuiElectricFurnace((TileEntityElectricFurnace)entity, player.inventory);
		}
		if (entity instanceof TileEntityMagmaticExtractor)
		{
			return new GuiMagmaticExtractor((TileEntityMagmaticExtractor)entity, player.inventory);
		}
		
		
		return null;
	}
}
