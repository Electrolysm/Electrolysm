package mods.Electrolysm.electro.machines.gui;

import org.lwjgl.opengl.GL11;

import mods.Electrolysm.electro.machines.container.ContainerMatterMachine;
import mods.Electrolysm.electro.machines.entities.tile.TileEntityMatterMachine;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.StatCollector;

public class GuiMatterMachine extends GuiContainer
{
	private TileEntityMatterMachine entity;

	public GuiMatterMachine(TileEntityMatterMachine entity2,	InventoryPlayer inventory)
	{
		super(new ContainerMatterMachine(entity2, inventory));
		
		this.entity = entity2;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture("/mods/electrolysm/textures/gui/MatterGUI.png");
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
		
		int progress = entity.furnaceBurnTime;
		int heat = entity.heat;
		
		if(progress != 0)
		{
			progress = progress / 4;
		}
		if(heat != 0)
		{
			heat = heat / 12;
			if(entity.active)
			{
				
				//Is heat Provided
				this.drawTexturedModalRect(x + 81, y + 46 + 12 - heat, 176, 4 - heat, 28, heat + 10);
			}
		}
		//Arrow (Progress)
		this.drawTexturedModalRect(x + 80, y + 21, 176, 14, progress - 1, 16);
	}
	
	@Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		fontRenderer.drawString(entity.getInvName(), 40, 6, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}

}
