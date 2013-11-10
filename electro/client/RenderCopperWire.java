package assets.electrolysm.electro.client;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;

import assets.electrolysm.electro.common.CommonProxy;
import assets.electrolysm.electro.handlers.vector.Vector3;
import assets.electrolysm.electro.handlers.vector.VectorHelper;
import assets.electrolysm.electro.powerSystem.te.TileEntityWire;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCopperWire extends TileEntitySpecialRenderer
{

	public static final ModelCopperWire model = new ModelCopperWire();

	public void renderModelAt(TileEntityWire tileEntity, double d, double d1, double d2, float f)
	{
		// Texture file
		FMLClientHandler.instance().getClient().renderEngine.func_110577_a(CommonProxy.GRAPHITE_WIRE_MODEL);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
		GL11.glScalef(1.0F, -1F, -1F);

		TileEntity[] adjecentConnections = new TileEntity[6];

		for (byte i = 0; i < 6; i++)
		{
			ForgeDirection side = ForgeDirection.getOrientation(i);
			TileEntity adjacentTile = VectorHelper.getTileEntityFromSide(tileEntity.worldObj, new Vector3(tileEntity), side);

			if (adjacentTile instanceof TileEntityWire)
			{
				if (((TileEntityWire) adjacentTile).canConnect(side.getOpposite()))
				{
					adjecentConnections[i] = adjacentTile;
				}
				else
				{
					adjecentConnections[i] = null;
				}
			}
		}

		if (adjecentConnections[0] != null)
		{
			model.renderBottom();
		}

		if (adjecentConnections[1] != null)
		{
			model.renderTop();
		}

		if (adjecentConnections[2] != null)
		{
			model.renderBack();
		}

		if (adjecentConnections[3] != null)
		{
			model.renderFront();
		}

		if (adjecentConnections[4] != null)
		{
			model.renderLeft();
		}

		if (adjecentConnections[5] != null)
		{
			model.renderRight();
		}

		model.renderMiddle();
		GL11.glPopMatrix();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double var2, double var4, double var6, float var8)
	{
		this.renderModelAt((TileEntityWire) tileEntity, var2, var4, var6, var8);
	}
}