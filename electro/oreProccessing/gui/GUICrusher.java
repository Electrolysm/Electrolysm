package assets.electrolysm.electro.oreProccessing.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

import assets.electrolysm.electro.common.CommonProxy;
import assets.electrolysm.electro.oreProccessing.container.ContainerCrusher;
import assets.electrolysm.electro.oreProccessing.te.TileEntityCrusher;

public class GUICrusher extends GuiContainer
{
    private TileEntityCrusher entity;

    public GUICrusher(TileEntityCrusher entity, InventoryPlayer inventory)
    {
        super(new ContainerCrusher(inventory, entity));
        this.entity = entity;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(CommonProxy.CRUSHER_GUI);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
        int progress = (int)((entity.time * 46) / entity.crushTime);
        int heat;

        if (progress != 0)
        {
            this.drawTexturedModalRect(x + 64, y + 20, 176, 0, progress + 1, 46);
        }

        //this.drawTexturedModalRect(x + 150, y + 25, 176, 14, 24, progress);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        fontRenderer.drawString(entity.getInvName(), 40, 6, 4210752);
    }
    
}
