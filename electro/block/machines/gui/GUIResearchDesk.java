package assets.electrolysm.electro.block.machines.gui;

import java.util.Random;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

import assets.electrolysm.electro.block.machines.container.ContainerResearchDesk;
import assets.electrolysm.electro.block.machines.tile.TileEntityResearchDesk;
import assets.electrolysm.electro.common.CommonProxy;

public class GUIResearchDesk extends GuiContainer
{
    private TileEntityResearchDesk entity;

    public GUIResearchDesk(TileEntityResearchDesk entity,	InventoryPlayer inventory)
    {
        super(new ContainerResearchDesk(entity, inventory));
        this.entity = entity;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(CommonProxy.RESEARCH_DESK_GUI);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
        int progress = 0;
        int heat;

        if (progress != 0)
        {
        }

        this.drawTexturedModalRect(x + 150, y + 25, 176, 14, 24, progress);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        fontRenderer.drawString(entity.getInvName(), 40, 6, 4210752);
        /*
        fontRenderer.drawString(matrix(), 10, 40, 4210752);
        fontRenderer.drawString(matrix(), 10, 48, 4210752);
        fontRenderer.drawString(matrix(), 10, 56, 4210752);
        fontRenderer.drawString(matrix(), 10, 62, 4210752);
        fontRenderer.drawString(matrix(), 10, 70, 4210752);
        fontRenderer.drawString(matrix(), 10, 78, 4210752);
        fontRenderer.drawString(matrix(), 10, 86, 4210752);
        fontRenderer.drawString(matrix(), 10, 94, 4210752);
        fontRenderer.drawString(matrix(), 10, 102, 4210752);
        fontRenderer.drawString(matrix(), 10, 110, 4210752);
        */
    }
    public String matrix()
    {
        String[] matrix = { "0010101001000011010101" ,
                            "1011010101011101010010",
                            "0100101010100110101101",
                            "1011101001011100101000"
                          };
        Random rand = new Random();
        int randNo = rand.nextInt(3);
        return matrix[randNo];
    }
}
