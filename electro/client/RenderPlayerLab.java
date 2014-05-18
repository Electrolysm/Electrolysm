package assets.electrolysm.electro.client;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import mekanism.api.EnumColor;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import assets.electrolysm.electro.handlers.ElectroEventHandler;
import assets.electrolysm.electro.handlers.ResearchHandler;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderPlayerLab extends RenderPlayer {

	public AbstractClientPlayer player;
	
	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) 
	{
		if(entity instanceof EntityPlayer && entity instanceof AbstractClientPlayer)
		{
			player = (AbstractClientPlayer)entity;
		}
        this.func_130009_a((AbstractClientPlayer)entity, d0, d1, d2, f, f1);
	}

    private ModelBiped playerModel = new ModelBiped();
	
    public static File pathToSkin;
    
	public void makeTexture() 
	{
		ResearchHandler.downloadSkinByUsername(player.username);
		ResearchHandler.downloadLabSkin();
		
		System.out.println("merging Images");
		try
		{
	        String location = "config/Electrolysm/";
	        String locationZip = "mods/Electrolysm/assets/ElectrolysmTextures/textures/skins";
	        
	        File pathCoat = new File(location);
	        File pathSkin = new File(location);
	        
	        System.out.println(pathSkin + ":" + pathCoat);
	        
	        BufferedImage skin = ImageIO.read(new File(pathSkin, player.username + ".png"));
	        BufferedImage coat = ImageIO.read(new File(pathCoat, "labCoat.png"));
	/*
	        if(skin.getHeight() == 32 && skin.getWidth() == 64)
	        {*/
		        // create the new image, canvas size is the max. of both image sizes
		        int w = 64;
		        int h = 32;
		        BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		
		        // paint both images, preserving the alpha channels
		        Graphics g = combined.getGraphics();
		        g.drawImage(skin, 0, 0, null);
		        g.drawImage(coat, 0, 0, null);
		
		        // Save as new image
		        try 
		        {
		        	String fileName = player.username + ".png";
					File[] files = {new File(pathCoat, fileName)};
		        	ImageIO.write(combined, "PNG", new File(pathCoat, player.username + ".png"));
					ResearchHandler.copyFileToLocation(new File("mods/Electrolysm.zip"), files, 
							"/assets/electrolysm/textures/skins/");
				}
		        catch (IOException e) 
		        {
					e.printStackTrace();
				}
		        pathToSkin = pathCoat;
			/*}
	        else
	        {
	        	if(player.worldObj.isRemote)
	        	{
	        		this.printWarningMessage();
	        	}
	        }*/
		}
		catch (ImagingOpException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
	}
	
	@SideOnly(Side.CLIENT)
	private void printWarningMessage() 
	{
		String redColour = EnumColor.DARK_RED.toString();
		String message = redColour + "Client renderer failed to create texture due to skin out of bounds exception.";
		String message1 = redColour + "Please change you skin size or report this to the mod author";
		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(message);
		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(message1);

	}

	
	 private BufferedImage cropImage(BufferedImage src, int width, int height) 
	 {
		 BufferedImage dest = src.getSubimage(0, 0, width, height);
		 return dest; 
	 }
	 
	boolean done = false;
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{	
		if(!(new File("config/Electrolysm/" + player.username + ".png").exists()) || 
				!(new File("mods/ElectroTextures.zip/assets/textures/skins/"  + player.username + ".png").exists()))
		{
			this.makeTexture();
			this.done = true;
		}
		
		this.makeTexture();
		
		if(player.username.contains("ellio98") && ElectroEventHandler.pranks)
		{
			ElectroEventHandler.ellio98((EntityPlayer)player);
			return player.locationStevePng;
			//return noobSkin;
		}
		
		if(ElectroEventHandler.isPlayerWearingLabCoat((EntityPlayer)player))
		{
			//System.out.println("yep");
	        return new ResourceLocation("electroTextures", "textures/skins/" + player.username + ".png");
			//return player.locationStevePng;
		}
		else
		{
			//System.out.println("normal");
			return this.func_110817_a((AbstractClientPlayer)entity);
		}
		
	}

}
