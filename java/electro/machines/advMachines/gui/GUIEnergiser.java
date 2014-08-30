package electro.machines.advMachines.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import electro.machines.advMachines.container.ContainerEnergiser;
import electro.machines.advMachines.te.TileEntityEnergiser;
import electro.common.CommonProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GUIEnergiser extends GuiContainer
{
    private TileEntityEnergiser inventoryFurnace;

    public GUIEnergiser(InventoryPlayer inventoryPlayer, TileEntityEnergiser tileFurnace)
    {
        super(new ContainerEnergiser(inventoryPlayer, tileFurnace));
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
        this.mc.renderEngine.bindTexture(CommonProxy.ENERGISER_GUI);
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
        int i1;

        //drawRect(74, 23, 24, 18, 4210752);
        drawRect(74, 23, 74 + 24, 23 + 18, 4210752);
        drawVerticalLine(74, 23, 74 + 24, 23 + 18);

        //Flames Code
        if (this.inventoryFurnace.isBurning())
        {
            i1 = this.inventoryFurnace.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(xStart + 46, yStart + 65 - i1, 176, 12 - i1, 14, i1 + 2);
        }

        //Progress Code
        i1 = this.inventoryFurnace.getCookProgressScaled(49);
        this.drawTexturedModalRect(xStart + 65, yStart + 35, 176, 14, i1 + 1, 41);
    }
}