package assets.electrolysm.electro.research.client;

import org.lwjgl.opengl.GL11;

import assets.electrolysm.electro.common.CommonProxy;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.InventoryPlayer;

public class GUIIDCardInfo extends GuiScreen
{
	public GUIIDCardInfo(InventoryPlayer inventory)
	{
		//super();
	}
	
	int xSize = 176;
    int ySize = 167;
	
	@Override
    public void drawScreen(int par1, int par2, float par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(CommonProxy.ENERGISER_GUI);
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }
}
