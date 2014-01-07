package assets.electrolysm.electro.client;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import assets.electrolysm.electro.common.CommonProxy;
import assets.electrolysm.electro.powerSystem.te.TileEntityTeslaTower;

public class RenderTileTeslaTower extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y,
			double z, float f) 
	{
		this.renderTileEntityTeslaBeam((TileEntityTeslaTower)te, x, y, z, f);
	}
	
	public void renderTileEntityTeslaBeam(TileEntityTeslaTower te, double x, double y, double z,
			float par8)
    {
        float f1 = te.func_82125_v_();

        if (f1 > 0.0F && te.canDistribute(te.worldObj, (int)x, (int)y, (int)z))
        {
            Tessellator tessellator = Tessellator.instance;
            this.bindTexture(CommonProxy.BEAM_MODEL);
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, 10497.0F);
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, 10497.0F);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_CULL_FACE);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glDepthMask(true);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
            float f2 = (float)te.getWorldObj().getTotalWorldTime() + par8;
            float f3 = -f2 * 0.2F - (float)MathHelper.floor_float(-f2 * 0.1F);
            byte b0 = 1;
            double d3 = (double)f2 * 0.025D * (1.0D - (double)(b0 & 1) * 2.5D);
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA(255, 255, 255, 32);
            double d4 = (double)b0 * 0.2D;
            double d5 = 0.5D + Math.cos(d3 + 2.356194490192345D) * d4;
            double d6 = 0.5D + Math.sin(d3 + 2.356194490192345D) * d4;
            double d7 = 0.5D + Math.cos(d3 + (Math.PI / 4D)) * d4;
            double d8 = 0.5D + Math.sin(d3 + (Math.PI / 4D)) * d4;
            double d9 = 0.5D + Math.cos(d3 + 3.9269908169872414D) * d4;
            double d10 = 0.5D + Math.sin(d3 + 3.9269908169872414D) * d4;
            double d11 = 0.5D + Math.cos(d3 + 5.497787143782138D) * d4;
            double d12 = 0.5D + Math.sin(d3 + 5.497787143782138D) * d4;
            double d13 = (double)(256.0F * f1);
            double d14 = 0.0D;
            double d15 = 1.0D;
            double d16 = (double)(-1.0F + f3);
            double d17 = (double)(256.0F * f1) * (0.5D / d4) + d16;
            tessellator.addVertexWithUV(x + d5, y + d13, z + d6, d15, d17);
            tessellator.addVertexWithUV(x + d5, y, z + d6, d15, d16);
            tessellator.addVertexWithUV(x + d7, y, z + d8, d14, d16);
            tessellator.addVertexWithUV(x + d7, y + d13, z + d8, d14, d17);
            tessellator.addVertexWithUV(x + d11, y + d13, z + d12, d15, d17);
            tessellator.addVertexWithUV(x + d11, y, z + d12, d15, d16);
            tessellator.addVertexWithUV(x + d9, y, z + d10, d14, d16);
            tessellator.addVertexWithUV(x + d9, y + d13, z + d10, d14, d17);
            tessellator.addVertexWithUV(x + d7, y + d13, z + d8, d15, d17);
            tessellator.addVertexWithUV(x + d7, y, z + d8, d15, d16);
            tessellator.addVertexWithUV(x + d11, y, z + d12, d14, d16);
            tessellator.addVertexWithUV(x + d11, y + d13, z + d12, d14, d17);
            tessellator.addVertexWithUV(x + d9, y + d13, z + d10, d15, d17);
            tessellator.addVertexWithUV(x + d9, y, z + d10, d15, d16);
            tessellator.addVertexWithUV(x + d5, y, z + d6, d14, d16);
            tessellator.addVertexWithUV(x + d5, y + d13, z + d6, d14, d17);
            tessellator.draw();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glDepthMask(false);
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA(255, 255, 255, 32);
            double d18 = 0.2D;
            double d19 = 0.2D;
            double d20 = 0.8D;
            double d21 = 0.2D;
            double d22 = 0.2D;
            double d23 = 0.8D;
            double d24 = 0.8D;
            double d25 = 0.8D;
            double d26 = (double)(256.0F * f1);
            double d27 = 0.0D;
            double d28 = 1.0D;
            double d29 = (double)(-1.0F + f3);
            double d30 = (double)(256.0F * f1) + d29;
            tessellator.addVertexWithUV(x + d18, y + d26, z + d19, d28, d30);
            tessellator.addVertexWithUV(x + d18, y, z + d19, d28, d29);
            tessellator.addVertexWithUV(x + d20, y, z + d21, d27, d29);
            tessellator.addVertexWithUV(x + d20, y + d26, z + d21, d27, d30);
            tessellator.addVertexWithUV(x + d24, y + d26, z + d25, d28, d30);
            tessellator.addVertexWithUV(x + d24, y, z + d25, d28, d29);
            tessellator.addVertexWithUV(x + d22, y, z + d23, d27, d29);
            tessellator.addVertexWithUV(x + d22, y + d26, z + d23, d27, d30);
            tessellator.addVertexWithUV(x + d20, y + d26, z + d21, d28, d30);
            tessellator.addVertexWithUV(x + d20, y, z + d21, d28, d29);
            tessellator.addVertexWithUV(x + d24, y, z + d25, d27, d29);
            tessellator.addVertexWithUV(x + d24, y + d26, z + d25, d27, d30);
            tessellator.addVertexWithUV(x + d22, y + d26, z + d23, d28, d30);
            tessellator.addVertexWithUV(x + d22, y, z + d23, d28, d29);
            tessellator.addVertexWithUV(x + d18, y, z + d19, d27, d29);
            tessellator.addVertexWithUV(x + d18, y + d26, z + d19, d27, d30);
            tessellator.draw();
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glDepthMask(true);
        }
    }

}
