package assets.electrolysm.electro.block.advMachines.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import assets.electrolysm.electro.block.advMachines.container.ContainerInjector;
import assets.electrolysm.electro.block.advMachines.te.TileEntityInjector;
import assets.electrolysm.electro.common.CommonProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GUIInjector extends GuiContainer
{
	private TileEntityInjector inventoryFurnace;

	public GUIInjector(InventoryPlayer inventoryPlayer, TileEntityInjector tileFurnace)
	{
		super(new ContainerInjector(inventoryPlayer, tileFurnace));
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
		this.mc.renderEngine.func_110577_a(CommonProxy.INJECTOR_GUI);
		int xStart = (width - xSize) / 2;
		int yStart = (height - ySize) / 2;
		this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
		int i1;

        
        i1 = this.inventoryFurnace.getCookProgressScaled(48);
        this.drawTexturedModalRect(xStart + 54, yStart + 34, 176, 14, i1 + 1, 41);
	}

}