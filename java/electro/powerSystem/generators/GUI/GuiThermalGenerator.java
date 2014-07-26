package electro.powerSystem.generators.GUI;

import electro.common.CommonProxy;
import electro.oreProccessing.container.ContainerCrusher;
import electro.powerSystem.generators.container.ContainerThermalGenerator;
import electro.powerSystem.generators.te.TileEntityThermalGenerator;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Ben on 19/07/2014.
 */
public class GuiThermalGenerator extends GuiContainer {

    TileEntityThermalGenerator thermalGenerator;

    public GuiThermalGenerator(TileEntityThermalGenerator te, InventoryPlayer inventory)
    {
        super(new ContainerThermalGenerator(inventory, te));
        thermalGenerator = te;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        ySize = 166 + 20;

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(CommonProxy.THERMAL_GEN_GUI);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);

        if (thermalGenerator.amountFluid != 0) {
            int amount = thermalGenerator.amountFluid;
            int capacity = 100000;
            int scale = (amount * 58) / capacity;
            //System.out.println(thermalGenerator.amountFluid + " : " + (scale));

            this.drawTexturedModalRect(x + 75, y + 78 - scale, 176, 58 - scale, 16, scale + 1);
            //this.drawTexturedModalRect(x + 26, y + 28 + 12 - burnProgress, 176, 12 - burnProgress, 19, burnProgress + 1);

        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        //String RotationString = "Rotations: " + entity.rotations  + "RPM";

        fontRendererObj.drawString(thermalGenerator.getInventoryName(), 35, -6, 4210752);
        //fontRenderer.drawString(EnergyString, 13, 6 + 60 + 6 + 10, 4210752);
        //fontRenderer.drawString(RotationString, 13, 6 + 60 + 6, 4210752);

    }
}
