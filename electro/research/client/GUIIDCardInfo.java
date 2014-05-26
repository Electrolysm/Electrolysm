package assets.electrolysm.electro.research.client;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.lwjgl.opengl.GL11;

import mekanism.api.EnumColor;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.InventoryPlayer;
import assets.electrolysm.electro.common.CommonProxy;
import assets.electrolysm.electro.handlers.ResearchHandler;

public class GUIIDCardInfo extends GuiScreen
{
	public GUIIDCardInfo(InventoryPlayer inventory)
	{
		//super();
		this.runImageLoading();
	}
    
	
	int xSize = this.getImageXSize();
    int ySize = this.getImageYSize();
	
	private int getImageXSize() 
	{
		try
		{
			this.runImageLoading();
			String location = "config/Electrolysm/";
		    
		    File path = new File(location);
		    BufferedImage image = ImageIO.read(new File(path, "techTree" + ".png"));
		    return image.getWidth();
		}
		catch(IOException e)
		{
			return 0;
		}
	}
	
	private int getImageYSize() 
	{
		try
		{
			this.runImageLoading();
			String location = "config/Electrolysm/";
		    
		    File path = new File(location);
		    BufferedImage image = ImageIO.read(new File(path, "techTree" + ".png"));
		    return image.getHeight();
		}
		catch(IOException e)
		{
			return 0;
		}
	}
    
    public void runImageLoading()
	{
		ResearchHandler.downloadTechTree();
	}
	
	@Override
    public void drawScreen(int par1, int par2, float par3)
    {/*
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(CommonProxy.IMAGE_TECH_TREE);*/
        int xStart = (width) / 2;
        int yStart = (height) / 2;/*
        xSize = 741;
        ySize = 646;
        this.drawTexturedModalRect(xStart - (xSize / 2), yStart - (ySize / 2), 0, 0, xSize, ySize);
		*/
        
        fontRenderer.drawString(EnumColor.WHITE + "This is currently unavailable!", xStart - 80 + 10 - 5, yStart - 20, 4210752);
        fontRenderer.drawString(EnumColor.WHITE + "Sorry!", xStart - 20 + 5, yStart + 10, 4210752);
    }
}
