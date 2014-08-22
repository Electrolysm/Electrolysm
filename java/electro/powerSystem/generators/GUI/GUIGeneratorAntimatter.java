package electro.powerSystem.generators.GUI;

import electro.handlers.helpers.ColourEnumHelper;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import electro.common.CommonProxy;
import electro.powerSystem.generators.container.ContainerGeneratorAntimatter;
import electro.powerSystem.generators.te.TileEntityGeneratorAntimatter;

public class GUIGeneratorAntimatter extends GuiContainer
{
    private TileEntityGeneratorAntimatter entity;

    public GUIGeneratorAntimatter(TileEntityGeneratorAntimatter entity,	InventoryPlayer inventory)
    {
        super(new ContainerGeneratorAntimatter(entity, inventory));
        this.entity = entity;
    }
//Geothermal Matter-Antimatter Dilithium
    public ResourceLocation getGUI(boolean isBuilt)
    {
    	if(isBuilt)
    	{
           return CommonProxy.GENERATOR_MATTER_GUI;
    	}
    	else
    	{
            return CommonProxy.GENERATOR_MATTER_INC_GUI;
    	}
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(this.getGUI(entity.isBuilt(3, entity.getWorldObj(), entity.xCoord, 
        		entity.yCoord, entity.zCoord)));
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);

        if (entity.burnTime != 0)
        {
            int burnTime = ((entity.time * 14) / entity.burnTime); 
        	//System.out.println(entity.time + " : " + entity.burnTime + " : " + burnTime);
            //gen ids		 0   1   2    3
            int[] xCoords = {80, 0 , 0 , 81};
            int[] yCoords = {33, 0 , 0 , 61};

            this.drawTexturedModalRect(x + xCoords[3], y + yCoords[3] + 14 - burnTime, 176, 14 - burnTime, 
            		14, burnTime + 2);
        }
        

    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
    	boolean requireBuild = entity.doesRequireBuild(3);
    	boolean isComplete = entity.isBuilt(3, entity.getWorldObj(), entity.xCoord, entity.yCoord, entity.zCoord);
    	
    	if(requireBuild)
    	{
    		if(isComplete)
    		{
    	        fontRendererObj.drawString(ColourEnumHelper.BRIGHT_GREEN + "Reactor is Comlete", 42, 20, 0x404040);
    		}
    		else
    		{
    	        fontRendererObj.drawString(ColourEnumHelper.DARK_RED + "Reactor Structure is Incomplete", 9, 20, 0x404040);
    		}
    	}
    	
        fontRendererObj.drawString(ColourEnumHelper.WHITE + entity.getInventoryName(), 25, 6, 0x404040);
    }
}
