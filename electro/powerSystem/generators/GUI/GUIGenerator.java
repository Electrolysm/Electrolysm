package assets.electrolysm.electro.powerSystem.generators.GUI;

import mekanism.api.EnumColor;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import assets.electrolysm.electro.common.CommonProxy;
import assets.electrolysm.electro.powerSystem.generators.container.ContainerGenerator;
import assets.electrolysm.electro.powerSystem.generators.te.TileEntityGenerator;

public class GUIGenerator extends GuiContainer
{
    private TileEntityGenerator entity;

    public GUIGenerator(TileEntityGenerator entity,	InventoryPlayer inventory)
    {
        super(new ContainerGenerator(entity, inventory, entity.genID));
        this.entity = entity;
    }
//Geothermal Matter-Antimatter Dilithium
    public ResourceLocation getGUI(TileEntityGenerator te)
    {
        int ID = te.genID;

        if (ID == 0)
        {
            return CommonProxy.GENERATOR_BASIC_GUI;
        }
        else if (ID == 1)
        {
            return CommonProxy.GENERATOR_GEO_GUI;
        }
        else if (ID == 2)
        {
            return CommonProxy.GENERATOR_FUSION_GUI;
        }
        else if (ID == 3)
        {
            return CommonProxy.GENERATOR_MATTER_GUI;
        }
        else
        {
            return null;
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(this.getGUI(entity));
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);

        if (entity.burnTime != 0)
        {
            int burnTime = (entity.time * 14) / entity.burnTime; 
        	//System.out.println(entity.time + " : " + entity.burnTime + " : " + burnTime);
            //gen ids		 0   1   2    3
            int[] xCoords = {80, 0 , 0 , 81};
            int[] yCoords = {33, 0 , 0 , 61};

            this.drawTexturedModalRect(x + xCoords[entity.genID], y + yCoords[entity.genID] + 14 - burnTime, 176, 14 - burnTime, 
            		14, burnTime + 2);
        }
        

    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
    	boolean requireBuild = entity.doesRequireBuild(entity.genID);
    	boolean isComplete = entity.isBuilt(entity.genID, entity.getWorldObj(), entity.xCoord, entity.yCoord, entity.zCoord);
    	
    	if(requireBuild)
    	{
    		if(isComplete)
    		{
    	        fontRenderer.drawString(EnumColor.BRIGHT_GREEN + "Reactor is Comlete", 42, 20, 0x404040);
    		}
    		else
    		{
    	        fontRenderer.drawString(EnumColor.DARK_RED + "Reactor Structure is Incomplete", 9, 20, 0x404040);
    		}
    	}
    	
        fontRenderer.drawString(EnumColor.WHITE + entity.getInvName(), 25, 6, 0x404040);
    }
}
