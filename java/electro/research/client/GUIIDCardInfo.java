package electro.research.client;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import electro.handlers.helpers.ColourEnumHelper;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.InventoryPlayer;
import electro.common.CommonProxy;
import electro.handlers.ResearchHandler;

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
	  	GL11.glPushMatrix();

		this.drawDefaultBackground();
		
		//this.renderTechTree();
		this.renderBlankBookPageBorder();
		//this.renderBlankBookPageBackground();
		
		if(isBookAdv)
		{
			//this.renderWithCircuit();
		}
		
		this.renderNotWorkingText();
		
    }

	private void renderBlankBookPageBackground() 
	{
		int xSize1 = 670 / 2 + 100 - 50 - 100 - 30;//670
		int ySize1 = 450 / 2 + 50 - 20;//450
		
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glScalef(1.35F, 1.0F, 1.0F);

        this.mc.renderEngine.bindTexture(CommonProxy.RESEARCH_BACKGROUND);
        int xStart = (width - xSize1) / 2;
        int yStart = (height - ySize1) / 2;
        this.drawTexturedModalRect(xStart - 100 + 10 + 5, yStart, 0, 0, xSize1, ySize1);
	}

	private void renderBlankBookPageBorder() 
	{
		xSize = 512 / 2;
		ySize = 512 / 2;
		
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef(1.0F, -10.0F, 1.0F);
        GL11.glScalef(1.0F, 1.0F, 1.0F);

        this.mc.renderEngine.bindTexture(CommonProxy.RESEARCH_BACKING);
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart/* - 100 - 50 - 50 + 60*/, yStart, 0, 0, xSize, ySize);
	}

	private void renderNotWorkingText() 
	{
        int xStart = (width) / 2;
        int yStart = (height) / 2;
        fontRendererObj.drawString(ColourEnumHelper.WHITE + "This is currently unavailable!", xStart - 80 + 10 - 5, yStart - 20, 4210752);
        fontRendererObj.drawString(ColourEnumHelper.WHITE + "Sorry!", xStart - 20 + 5, yStart + 10, 4210752);
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
