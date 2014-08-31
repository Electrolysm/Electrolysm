package electro.powerSystem.gui;

import electrolysm.api.powerSystem.prefab.TEPowerCore;
import electro.common.CommonProxy;
import electro.handlers.helpers.ColourEnumHelper;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import org.lwjgl.opengl.GL11;

/**
 * Created by Clarky158 on 23/07/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class EnergyCoreGUI extends GuiContainer{

    private TEPowerCore entity;

    public EnergyCoreGUI(TEPowerCore entity, InventoryPlayer inventory)
    {
        super(new ContainerEnergyCore(entity, inventory));
        this.entity = entity;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        ySize = 166 + 20;

        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.mc.renderEngine.bindTexture(CommonProxy.POWER_CORE_GUI);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
        GL11.glPopMatrix();

        int barSize = 75;
        int teu = ((entity.teuData) * barSize) / entity.maxTeU;
        int amps = (int) ((entity.getAmps() * barSize) / entity.getMaxAmps());

        //System.out.println(entity.getAmps() + " : " + entity.getMaxAmps());

        this.drawTexturedModalRect(x + 49, y + 37, 176, 0, teu, 11);
        if(entity.getAmps() < entity.getMaxAmps()) {
            this.drawTexturedModalRect(x + 49, y + 65, 176, 11, amps, 11);
        } else {
            this.drawTexturedModalRect(x + 49, y + 65, 176, 22, 75, 11);
        }
    }

    @Override
    public void onGuiClosed()
    {
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j) {
        fontRendererObj.drawString("Energy Core", 55, -3, 4210752);

        fontRendererObj.drawString("TeU: " + entity.teuData, 10, 10, 4210752);

        if (entity.getAmps() < entity.getMaxAmps()) {
            fontRendererObj.drawString("Amps: " + entity.getAmps(), 10, 41, 4210752);
        } else {
            fontRendererObj.drawString("Amps: " + ColourEnumHelper.DARK_RED + "Overloading...", 10, 43, 4210752);
        }
    }
}
