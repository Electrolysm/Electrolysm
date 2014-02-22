package assets.electrolysm.electro.oreProccessing.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import assets.electrolysm.electro.common.CommonProxy;
import assets.electrolysm.electro.oreProccessing.container.ContainerElectrolysis;
import assets.electrolysm.electro.oreProccessing.te.TileEntityElectrolisisCore;

public class GUIElectrolysisCore extends GuiContainer
{
    private TileEntityElectrolisisCore entity;

    public GUIElectrolysisCore(TileEntityElectrolisisCore entity,	InventoryPlayer inventory)
    {
        super(new ContainerElectrolysis(entity, inventory));
        this.entity = entity;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(CommonProxy.ELECTROLYSIS_CORE_GUI);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
        int progress = entity.furnaceBurnTime;
        int heat = entity.heat;

        if (progress != 0)
        {
            progress = progress / 50;
        }

        if (heat != 0)
        {
            heat = heat / 12;

            if (entity.active)
            {
                this.drawTexturedModalRect(x + 63, y + 27 + 12 - heat, 176, 4 - heat, 44, heat + 10);
            }
        }

        this.drawTexturedModalRect(x + 82, y + 23, 176, 14, 80, progress - 50);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        fontRenderer.drawString(entity.getInvName(), 40, 6, 4210752);
    }
}
