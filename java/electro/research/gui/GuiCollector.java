package electro.research.gui;

import electro.common.CommonProxy;
import electro.handlers.helpers.CollectorHelper;
import electro.handlers.helpers.ColourEnumHelper;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import org.lwjgl.opengl.GL11;

/**
 * Created by Clarky158 on 29/07/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class GuiCollector extends GuiContainer
{
    TileEntityCollector entityCollector;

    public GuiCollector(TileEntityCollector te, InventoryPlayer inventory) {
        super(new ContainerCollector(te, inventory));
        entityCollector = te;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(CommonProxy.COLLECTOR_GUI);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        Object[] objects = CollectorHelper.getEnvironmentalData(entityCollector.getWorldObj(), entityCollector.xCoord,
                entityCollector.yCoord, entityCollector.zCoord);
        String rain = ColourEnumHelper.PURPLE + "Rainfall: " + ColourEnumHelper.BLACK + Float.valueOf(objects[1].toString());
        String temp = ColourEnumHelper.PURPLE + "Temperature: " + ColourEnumHelper.BLACK + Float.valueOf(objects[2].toString());
        String humidity = ColourEnumHelper.PURPLE + "Has High Humidity: " + ColourEnumHelper.BLACK + Boolean.valueOf(objects[3].toString());

        fontRendererObj.drawString(ColourEnumHelper.BLACK + entityCollector.getInventoryName(), 15, 16, 4210752);
        if(entityCollector.hasReel) {
            fontRendererObj.drawString(rain, 10, 40, 4210752);
            fontRendererObj.drawString(temp, 10, 50, 4210752);
            fontRendererObj.drawString(humidity, 10, 60, 4210752);
        }
    }
}
