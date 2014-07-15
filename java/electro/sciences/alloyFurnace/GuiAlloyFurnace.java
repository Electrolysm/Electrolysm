package electro.sciences.alloyFurnace;

import electro.common.CommonProxy;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import org.lwjgl.opengl.GL11;

/**
 * Created by Ben on 15/07/2014.
 */
public class GuiAlloyFurnace extends GuiContainer
{
        private TileEntityAlloyFurnace entity;

    public GuiAlloyFurnace(TileEntityAlloyFurnace entity, InventoryPlayer inventory)
    {
        super(new ContainerAlloyFurnace(inventory, entity));
        this.entity = entity;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(CommonProxy.ALLOY_FURNACE_GUI);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);

        int progress0 = ((int)((entity.timer * 13) / (entity.maxTimer - 20)));
        int progress1 = (int)((entity.timer * 32) / (entity.maxTimer - 20));

        if (progress0 > 0) { this.drawTexturedModalRect(x + 46, y + 35, 176, 14 , progress0, 20); }
        if(progress1 > 0) { this.drawTexturedModalRect(x + 82, y + 35, 176 + 36, 14, progress1, 20); }

        if(entity.maxBurnTime > 0) {
            int burnProgress = ((entity.burnTime * 14) / entity.maxBurnTime);
            if (burnProgress > 0) {
                this.drawTexturedModalRect(x + 26, y + 28 + 12 - burnProgress, 176, 12 - burnProgress, 19, burnProgress + 1);
            }
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        //String RotationString = "Rotations: " + entity.rotations  + "RPM";

        fontRendererObj.drawString(entity.getInventoryName(), 40, 6, 4210752);
        //fontRenderer.drawString(EnergyString, 13, 6 + 60 + 6 + 10, 4210752);
        //fontRenderer.drawString(RotationString, 13, 6 + 60 + 6, 4210752);

    }
}
