package mods.Electrolysm.electro.basic.machines.gui;



import mods.Electrolysm.electro.basic.machines.container.ContainerCrusher;
import mods.Electrolysm.electro.basic.machines.container.ContainerForge;
import mods.Electrolysm.electro.basic.machines.container.ContainerMagmaticExtractor;
import mods.Electrolysm.electro.basic.machines.container.ContainerMatterMachine;
import mods.Electrolysm.electro.basic.machines.container.ContainerPlatFurnace;
import mods.Electrolysm.electro.basic.machines.entities.tile.TileEntityCrusher;
import mods.Electrolysm.electro.basic.machines.entities.tile.TileEntityForge;
import mods.Electrolysm.electro.basic.machines.entities.tile.TileEntityMagmaticExtractor;
import mods.Electrolysm.electro.basic.machines.entities.tile.TileEntityMatterMachine;
import mods.Electrolysm.electro.basic.machines.entities.tile.TileEntityPlatFurnace;
import mods.Electrolysm.electro.biology.entity.TileEntityMicroscope;
import mods.Electrolysm.electro.biology.machines.container.ContainerMicroscope;
import mods.Electrolysm.electro.biology.machines.gui.GuiMicroscope;
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
		if (entity instanceof TileEntityCrusher)
		{
			return new ContainerCrusher((TileEntityCrusher)entity, player.inventory);
		}
		if (entity instanceof TileEntityPlatFurnace)
		{
			return new ContainerPlatFurnace(player.inventory, (TileEntityPlatFurnace)entity);
		}
		if (entity instanceof TileEntityMicroscope)
		{
			return new ContainerMicroscope((TileEntityMicroscope)entity, player.inventory);
		}
		return false;
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
		
		if (entity instanceof TileEntityCrusher)
		{
			return new GuiCrusher((TileEntityCrusher)entity, player.inventory);
		}
		
		if (entity instanceof TileEntityPlatFurnace)
		{
			return new GuiPlatFurnace(player.inventory, (TileEntityPlatFurnace)entity);
		}
		if (entity instanceof TileEntityMicroscope)
		{
			return new GuiMicroscope((TileEntityMicroscope)entity, player.inventory);
		}
		
		return null;
	}
}
