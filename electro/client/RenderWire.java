package assets.electrolysm.electro.client;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import assets.electrolysm.electro.common.CommonProxy;
import assets.electrolysm.electro.powerSystem.te.TileEntityWire;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderWire extends TileEntitySpecialRenderer
{
    private static final ModelWire model = new ModelWire();
    
    public void renderAModelAt(TileEntity t, double x, double y, double z, float f)
    {
        int blockID = t.worldObj.getBlockId(t.xCoord, t.yCoord, t.zCoord);
        int metadata = t.worldObj.getBlockMetadata(t.xCoord, t.yCoord, t.zCoord);
        
        TileEntityWire tileEntity = (TileEntityWire) t;
        boolean[] connectedSides = tileEntity.getVisualConnections();
        
        this.bindTexture(new ResourceLocation(CommonProxy.MOD_ID_LOWER, "textures/models/ModelWire.png"));
        
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glScalef(1.0F, -1F, -1F);
        
        if (connectedSides[0])
        {
            model.renderBottom();
        }
        if (connectedSides[1])
        {
            model.renderTop();
        }
        if (connectedSides[2])
        {
            model.renderBack();
        }
        if (connectedSides[3])
        {
            model.renderFront();
        }
        if (connectedSides[4])
        {
            model.renderLeft();
        }
        if (connectedSides[5])
        {
            model.renderRight();
        }
        
        model.renderMiddle();
        GL11.glPopMatrix();
        
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glScalef(1.0F, -1F, -1F);
        
        if (connectedSides[0])
        {
            model.renderBottom();
        }
        if (connectedSides[1])
        {
            model.renderTop();
        }
        if (connectedSides[2])
        {
            model.renderBack();
        }
        if (connectedSides[3])
        {
            model.renderFront();
        }
        if (connectedSides[4])
        {
            model.renderLeft();
        }
        if (connectedSides[5])
        {
            model.renderRight();
        }
        
        model.renderMiddle();
        GL11.glPopMatrix();
        
    }
    
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double var2, double var4, double var6, float var8)
    {
        this.renderAModelAt(tileEntity, var2, var4, var6, var8);
    }
}