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
        int progress = (int)((entity.time * 46) / entity.crushTime);
        int heat;

        if (progress != 0)
        {
            this.drawTexturedModalRect(x + 64, y + 20, 176, 0, progress + 1, 46);
        }

        //this.drawTexturedModalRect(x + 150, y + 25, 176, 14, 24, progress);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
    	String rotationString = "Rotations: " + entity.rotations  + "RPM";
        fontRenderer.drawString(entity.getInvName(), 40, 6, 4210752);
        fontRenderer.drawString(rotationString, 13, 6 + 60 + 6, 4210752);
        
    }

    
    //NEI
    /*
	@Override
	public VisiblityData modifyVisiblity(GuiContainer gui,
			VisiblityData currentVisibility) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getItemSpawnSlot(GuiContainer gui, ItemStack item) 
	{
		if(gui instanceof GUICrusher)
		{
			ItemStack grindStone = new ItemStack(electrolysmCore.grindStone);
			if(item.isItemEqual(grindStone))
			{
				return 2;
			}
			else
			{
				return 0;
			}
		}
		return -1;
	}

	@Override
	public List<TaggedInventoryArea> getInventoryAreas(GuiContainer gui) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean handleDragNDrop(GuiContainer gui, int mousex, int mousey,
			ItemStack draggedStack, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hideItemPanelSlot(GuiContainer gui, int x, int y, int w,
			int h) {
		// TODO Auto-generated method stub
		return false;
	}
    */
}
