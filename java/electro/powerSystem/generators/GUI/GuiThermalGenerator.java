package electro.powerSystem.generators.GUI;

import electro.common.CommonProxy;
import electro.oreProccessing.container.ContainerCrusher;
import electro.powerSystem.generators.container.ContainerThermalGenerator;
import electro.powerSystem.generators.te.TileEntityThermalGenerator;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
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
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(CommonProxy.CRUSHER_GUI);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);

        if(thermalGenerator.tank.getFluid() != null) {
            int amount = thermalGenerator.tank.getFluid().amount;
            int capacity = thermalGenerator.tank.getCapacity();
            int scale = (amount * 50) - capacity;

            this.drawTexturedModalRect(x, y, 0, 0, scale, 16);
        }
        System.out.println(thermalGenerator.tank.getFluidAmount());
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        //String RotationString = "Rotations: " + entity.rotations  + "RPM";

        fontRendererObj.drawString(thermalGenerator.getInventoryName(), 40, 6, 4210752);
        //fontRenderer.drawString(EnergyString, 13, 6 + 60 + 6 + 10, 4210752);
        //fontRenderer.drawString(RotationString, 13, 6 + 60 + 6, 4210752);

    }
}
