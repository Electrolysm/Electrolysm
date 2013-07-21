package mods.Electrolysm.electro.basic.machines.gui;

import mods.Electrolysm.electro.basic.machines.container.ContainerForge;
import mods.Electrolysm.electro.basic.machines.entities.tile.TileEntityForge;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiForge extends GuiContainer
{
	private TileEntityForge inventoryFurnace;

	public GuiForge(InventoryPlayer inventoryPlayer, TileEntityForge tileFurnace)
	{
		super(new ContainerForge(inventoryPlayer, tileFurnace));
		this.inventoryFurnace = tileFurnace;
		xSize = 176;
		ySize = 167;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		String containerName = inventoryFurnace.isInvNameLocalized() ? inventoryFurnace.getInvName() : StatCollector.translateToLocal(inventoryFurnace.getInvName());
		fontRenderer.drawString(containerName, xSize / 2 - fontRenderer.getStringWidth(containerName) / 2, 5, 4210752);
		fontRenderer.drawString("Inventory", 8, ySize - 93, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture("/mods/Electrolysm/textures/gui/ForgeGUI.png");
		int xStart = (width - xSize) / 2;
		int yStart = (height - ySize) / 2;
		this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
		int i1;

        
        i1 = this.inventoryFurnace.getCookProgressScaled(48);
        this.drawTexturedModalRect(xStart + 54, yStart + 34, 176, 14, i1 + 1, 41);
	}

}