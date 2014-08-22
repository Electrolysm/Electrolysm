package electro.client;

import electro.machines.assemblySystem.crafting.TileEntityMatrix;
import electro.common.CommonProxy;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

/**
 * Created by Ben on 10/07/2014.
 */
public class RenderTileMatrixConstruction extends TileEntitySpecialRenderer {

    ModelMatrixConstruct modelMatrixConstruct = new ModelMatrixConstruct();
    ModelMatrix modelMatrix = new ModelMatrix();


    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale)
    {
        if(!(tileEntity instanceof TileEntityMatrix)) { return; }
        TileEntityMatrix te = (TileEntityMatrix)tileEntity;

        if(te.isConstruct)
        {
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            bindTexture(CommonProxy.MODEL_MATRIX_CONSTRUCT);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            modelMatrixConstruct.renderWithHeight(te.height);
            GL11.glPopMatrix();
        }
        else
        {
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            bindTexture(CommonProxy.MODEL_MATRIX_CONSTRUCT);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glEnable(GL11.GL_LIGHTING);
            modelMatrix.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
        }

    }
}
