package electrolysm.electro.machines.advMachines.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import electrolysm.electro.machines.advMachines.container.ContainerInjector;
import electrolysm.electro.machines.advMachines.te.TileEntityInjector;
import electrolysm.electro.common.CommonProxy;
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
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        String containerName = inventoryFurnace.hasCustomInventoryName() ? inventoryFurnace.getInventoryName() : StatCollector.translateToLocal(inventoryFurnace.getInventoryName());
        fontRendererObj.drawString(containerName, xSize / 2 - fontRendererObj.getStringWidth(containerName) / 2, 5, 4210752);
        fontRendererObj.drawString("Inventory", 8, ySize - 93, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(CommonProxy.INJECTOR_GUI);
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
        int i1;
        i1 = this.inventoryFurnace.getCookProgressScaled(48);
        this.drawTexturedModalRect(xStart + 54, yStart + 34, 176, 14, i1 + 1, 41);
    }
}