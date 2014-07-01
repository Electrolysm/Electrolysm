package electro.client;

import electro.Electrolysm;
import electro.block.machines.tile.TileEntityResearchDesk;
import electro.research.researchDevice;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import electro.common.CommonProxy;

public class RenderTileResearchDesk extends TileEntitySpecialRenderer
{
    //The model of your block
    private final ModelResearchDesk model;
    private final ModelHologram modelHol;

    public RenderTileResearchDesk()
    {
        this.model = new ModelResearchDesk();
        this.modelHol = new ModelHologram();
    }

    private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
    {
        int meta = world.getBlockMetadata(x, y, z);
        GL11.glPushMatrix();
        GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
        GL11.glPopMatrix();
    }

    ItemStack lastStack;

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
    {
        //The PushMatrix tells the renderer to "start" doing something.
        GL11.glPushMatrix();
        //This is setting the initial location.
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        //This is the texture of your block. It's pathed to be the same place as your other blocks here.
        bindTexture(CommonProxy.MODEL_RESEARCH_DESK);
        //This rotation part is very important! Without it, your model will render upside-down! And for some reason you DO need PushMatrix again!
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        //A reference to your Model file. Again, very important.
        this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        //Tell it to stop rendering for both the PushMatrix's
        GL11.glPopMatrix();
        GL11.glPopMatrix();

        boolean hasDevice = false;
        boolean flicker = false;
        if(te instanceof TileEntityResearchDesk) {
            TileEntityResearchDesk teDesk = (TileEntityResearchDesk) te;
            if(teDesk.getStackInSlot(2) != null && teDesk.getStackInSlot(2).getItem() instanceof researchDevice){
                hasDevice = true;
                if(lastStack != null && !lastStack.isItemEqual(teDesk.getStackInSlot(2))) {
                    lastStack = teDesk.getStackInSlot(2);
                    //hasDevice = true;
                    flicker = true;
                } else {
                    if(lastStack == null)
                    {
                        lastStack = new ItemStack(Electrolysm.net);
                    }
                    // = new ItemStack(Electrolysm.net);
                }
            }
            else if(teDesk.getStackInSlot(2) == null) {
                if(lastStack != null) {
                    flicker = true;
                }
                lastStack = null;
            }
        }

        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 2F + 0.125F, (float) z + 0.5F);

        if(!flicker) {
            bindTexture(CommonProxy.MODEL_HOL);
        } else {
            bindTexture(CommonProxy.MODEL_HOL_FLICKER);
        }

        GL11.glPushMatrix();
        GL11.glRotatef(180, 90, 0, 0);
        this.modelHol.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(1F, 1F, 1F, 0.999999F);

        if(!flicker) {
            if (hasDevice) {
                this.modelHol.renderDevice((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            } else {
                this.modelHol.renderBlock((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            }
        } else {
            this.modelHol.renderDevice((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            this.modelHol.renderBlock((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            //flickerPerm = true;
        }

        GL11.glDisable(GL11.GL_BLEND);
        GL11.glColor4f(1f, 1f, 1f, 1f);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    //Set the lighting stuff, so it changes it's brightness properly.
    private void adjustLightFixture(World world, int i, int j, int k, Block block)
    {
        Tessellator tess = Tessellator.instance;
        float brightness = block.getMixedBrightnessForBlock(world, i, j, k);
        int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
        int modulousModifier = skyLight % 65536;
        int divModifier = skyLight / 65536;
        tess.setColorOpaque_F(brightness, brightness, brightness);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) modulousModifier,  divModifier);
    }
}