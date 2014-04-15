package assets.electrolysm.electro.oreProccessing.gui;

import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.common.CommonProxy;
import assets.electrolysm.electro.oreProccessing.container.ContainerCrusher;
import assets.electrolysm.electro.oreProccessing.te.TileEntityCrusher;
import codechicken.nei.VisiblityData;
import codechicken.nei.api.INEIGuiHandler;
import codechicken.nei.api.TaggedInventoryArea;

public class GUICrusher extends GuiContainer //implements INEIGuiHandler
{
    private TileEntityCrusher entity;

    public GUICrusher(TileEntityCrusher entity, InventoryPlayer inventory)
    {
        super(new ContainerCrusher(inventory, entity));
        this.entity = entity;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(CommonProxy.CRUSHER_GUI);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
        
        int progress = ((int)((entity.time * 46) / entity.crushTime));
        int coord = 0;
        
        if(!entity.active)
        {
        	if(entity.getStackInSlot(2) != null)
        	{
        		int grindMeta = entity.getStackInSlot(2).getItemDamage();
        		int[] yCoord = {0, 46, 92};
        		coord = yCoord[grindMeta];
        	}
        	else
        	{
        		coord = 0;
        	}
        }
        
        if (progress > 0)
        {//grinder = 2
        	
            this.drawTexturedModalRect(x + 64, y + 20, 176, coord, progress + 1, 46);
        }

        //this.drawTexturedModalRect(x + 150, y + 25, 176, 14, 24, progress);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
    	String RotationString = "Rotations: " + entity.rotations  + "RPM";
    	String EnergyString = "Energy: " + this.getEnergyStat(entity.currentEnergy, entity);
        
    	fontRenderer.drawString(entity.getInvName(), 40, 6, 4210752);
        //fontRenderer.drawString(EnergyString, 13, 6 + 60 + 6 + 10, 4210752);
        //fontRenderer.drawString(RotationString, 13, 6 + 60 + 6, 4210752);
        
    }

    private String lastOutput;
    
	private String getEnergyStat(long currentEnergy, TileEntityCrusher te) 
	{
		String empty = "Empty";
		String part = "Part Filled";
		String full = "Full";
		
		if(currentEnergy <= (te.energy.getEnergyCapacity() * 0.1))
		{
			return empty;
		}
		else if(currentEnergy <= (te.energy.getEnergyCapacity() * 0.75))
		{
			return part;
		}
		else
		{
			return full;
		}
	}
}
