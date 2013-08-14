package mods.Electrolysm.electro.biology.machines.gui;

import mods.Electrolysm.electro.biology.entity.TileEntityMicroscope;
import mods.Electrolysm.electro.biology.machines.container.ContainerMicroscope;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

public class GuiMicroscope extends GuiContainer
{
	private TileEntityMicroscope entity;

	public GuiMicroscope(TileEntityMicroscope entity,	InventoryPlayer inventory)
	{
		super(new ContainerMicroscope(entity, inventory));
		
		this.entity = entity;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture("/mods/Electrolysm/textures/gui/MicroscopeGUI.png");
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
		
		int progress = entity.furnaceBurnTime;
		int heat = entity.heat;
		
		if(progress != 0)
		{

		}

    	this.drawTexturedModalRect(x + 150, y + 25, 176, 14, 24, progress);
	}
	
	@Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		fontRenderer.drawString(entity.getInvName(), 40, 6, 4210752);
	}

}


