package electro.oreProccessing.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

import electro.common.CommonProxy;
import electro.oreProccessing.container.ContainerCrusher;
import electro.oreProccessing.container.ContainerSmeltory;
import electro.oreProccessing.te.TileEntityCrusher;
import electro.oreProccessing.te.TileEntitySmeltory;

public class GUISmeltory extends GuiContainer //implements INEIGuiHandler
{
    private TileEntitySmeltory entity;

    public GUISmeltory(TileEntitySmeltory entity, InventoryPlayer inventory)
    {
        super(new ContainerSmeltory(inventory, entity));
        this.entity = entity;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(CommonProxy.SMELTORY_GUI);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
       
        int progress = (int)((entity.time * 38) / entity.smeltTime);
        //int temp = (int)((entity.temp * 60) / entity.maxTemp);

        if(progress != 0)
        {
            this.drawTexturedModalRect(x + 69, y + 24, 176, 0, progress + 1, 38);
        }/*
        if(temp != 0)
        {
        	this.drawTexturedModalRect(x + 13, y + 12, 176, 51, 6, temp);
        }*/
        //this.drawTexturedModalRect(x + 150, y + 25, 176, 14, 24, progress);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
    	String DEGREE  = "\u00b0";
    	String tempString = ("Temperature: " + (entity.temp + 50)+ DEGREE + "C");
    	
        fontRendererObj.drawString(entity.getInventoryName(), 40, 6, 4210752);
        fontRendererObj.drawString(tempString, 13, 6 + 60 + 6, 4210752);
    }
}
