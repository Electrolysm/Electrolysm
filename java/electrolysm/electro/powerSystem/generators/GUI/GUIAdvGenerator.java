package electrolysm.electro.powerSystem.generators.GUI;

import electrolysm.electro.handlers.helpers.ColourEnumHelper;
import electrolysm.electro.powerSystem.generators.container.ContainerAdvGenerator;
import electrolysm.electro.powerSystem.generators.te.TileEntityAdvGenerator;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import electrolysm.electro.common.CommonProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GUIAdvGenerator extends GuiContainer
{
    private TileEntityAdvGenerator entity;

    public GUIAdvGenerator(TileEntityAdvGenerator entity,	InventoryPlayer inventory)
    {
        super(new ContainerAdvGenerator(entity, inventory));
        this.entity = entity;
    }
    //Geothermal Matter-Antimatter Dilithium
    public ResourceLocation getGUI()
    {
        return CommonProxy.GENERATOR_BASIC_GUI;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(this.getGUI());
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);

        if (entity.burnTime != 0)
        {
            int burnTime = ((entity.time * 14) / entity.burnTime);
            //System.out.println(entity.time + " : " + entity.burnTime + " : " + burnTime);
            //gen ids		 0   1   2    3
            int[] xCoords = {80 + 1, 0 , 0 , 81};
            int[] yCoords = {33 - 2, 0 , 0 , 61};

            this.drawTexturedModalRect(x + xCoords[0], y + yCoords[0] + 14 - burnTime, 176, 14 - burnTime,
                    14, burnTime + 2);
        }


    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        fontRendererObj.drawString(ColourEnumHelper.WHITE + entity.getInventoryName(), 25, 6, 0x404040);
    }
}
