package assets.electrolysm.electro.powerSystem.generators.GUI;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
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
		super(new ContainerGenerator(entity, inventory));

		this.entity = entity;
	}
//Geothermal Matter-Antimatter Dilithium
	public ResourceLocation getGUI(TileEntityGenerator te)
	{
		String name = te.getNameTag(entity.worldObj, entity.xCoord, entity.yCoord, entity.zCoord);
		
		if(name.contains("Coal"))
		{
			return CommonProxy.GENERATOR_BASIC_GUI;
		}
		else if(name.contains("Geothermal"))
		{
			return CommonProxy.GENERATOR_GEO_GUI;
		}
		else if(name.contains("Fusion"))
		{
			return CommonProxy.GENERATOR_FUSION_GUI;
		}
		else if(name.contains("Antimatter"))
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
		this.mc.renderEngine.func_110577_a(this.getGUI(entity));
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);

		int progress = 0;
		int heat;

		if(progress != 0)
		{

		}

    	this.drawTexturedModalRect(x + 150, y + 25, 176, 14, 24, progress);
	}

	@Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		fontRenderer.drawString(entity.getInvName(), 40, 6, 4210752);
	}
}
