package assets.electrolysm.electro.research.client;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import mekanism.api.EnumColor;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.InventoryPlayer;
import assets.electrolysm.electro.common.CommonProxy;
import assets.electrolysm.electro.handlers.ResearchHandler;

public class GUIIDCardInfo extends GuiScreen
{
	public GUIIDCardInfo(InventoryPlayer inventory)
	{
		super();
	}
    
	
	int xSize = 741;
    int ySize = 646;
	public boolean isBookAdv;
    
	@Override
    public void drawScreen(int par1, int par2, float par3)
    {
		this.drawDefaultBackground();

		this.renderTechTree();
		this.renderNotWorkingText();
		this.renderBlankBookPage();
		
		if(isBookAdv)
		{
			//this.renderWithCircuit();
		}
		
    }

	private void renderBlankBookPage() 
	{
		
	}

	private void renderNotWorkingText() 
	{
        int xStart = (width) / 2;
        int yStart = (height) / 2;
        fontRenderer.drawString(EnumColor.WHITE + "This is currently unavailable!", xStart - 80 + 10 - 5, yStart - 20, 4210752);
        fontRenderer.drawString(EnumColor.WHITE + "Sorry!", xStart - 20 + 5, yStart + 10, 4210752);
	}

	private void renderTechTree() 
	{
        xSize = (741 / 2) - 100 - 20 + 5;
        ySize = (646 / 2) - 100 + 50 - 20;
        
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(CommonProxy.IMAGE_TECH_TREE);
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
	}
}
