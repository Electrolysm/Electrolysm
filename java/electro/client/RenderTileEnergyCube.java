package electro.client;

import api.powerSystem.interfaces.IConnector;
import api.powerSystem.prefab.TEPowerCore;
import electro.common.CommonProxy;
import electro.machines.assemblySystem.crafting.TileEntityMatrix;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

/**
 * Created by Ben on 20/07/2014.
 */
public class RenderTileEnergyCube extends TileEntitySpecialRenderer
{
    ModelEnergyCube modelEnergyCube = new ModelEnergyCube();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale)
    {
        TEPowerCore te = (TEPowerCore)tileEntity;

        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        bindTexture(CommonProxy.MODEL_ENERGY_CUBE_CREATIVE);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glEnable(GL11.GL_LIGHTING);
        modelEnergyCube.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        TileEntity[] adj = ((TEPowerCore) tileEntity).getAdjConnections();
        for(int i = 2; i < adj.length; i++)
        {
            if(adj[i] != null && adj[i] instanceof IConnector)
            {
                modelEnergyCube.renderSide(i);
            }
        }

        GL11.glPopMatrix();

    }
}
