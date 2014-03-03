package assets.electrolysm.electro.oreProccessing.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

import assets.electrolysm.electro.common.CommonProxy;
import assets.electrolysm.electro.oreProccessing.container.ContainerLiquidiser;
import assets.electrolysm.electro.oreProccessing.te.TileEntityLiquidiser;

public class GUILiquidiser extends GuiContainer
{
    private TileEntityLiquidiser entity;

    public GUILiquidiser(TileEntityLiquidiser entity2, InventoryPlayer inventory)
    {
        super(new ContainerLiquidiser(inventory, entity2));
        this.entity = entity2;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(CommonProxy.LIQUIDISER_GUI);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
        int progress = (int)((entity.time * 90) / entity.crushTime);
        int heat;

        if (progress != 0)
        {
            this.drawTexturedModalRect(x + 44, y + 40, 0, 166, progress + 1, 90);
        }

        //this.drawTexturedModalRect(x + 150, y + 25, 176, 14, 24, progress);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        fontRenderer.drawString(entity.getInvName(), 40, 6, 4210752);
    }
    
}
