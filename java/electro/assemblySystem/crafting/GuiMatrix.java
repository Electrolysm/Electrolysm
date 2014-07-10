package electro.assemblySystem.crafting;

import electro.common.CommonProxy;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import org.lwjgl.opengl.GL11;

/**
 * Created by Ben on 10/07/2014.
 */
public class GuiMatrix extends GuiContainer
{
    private TileEntityMatrix entity;

    public GuiMatrix(TileEntityMatrix entity, InventoryPlayer inventory)
    {
        super(new ContainerMatrix(inventory, entity));
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
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        fontRendererObj.drawString(entity.getInventoryName(), 40, 6, 4210752);
    }
}
