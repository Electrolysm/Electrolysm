package electro.client;

import electro.Electrolysm;
import electro.block.machines.tile.TileEntityResearchDesk;
import electro.common.CommonProxy;
import electro.handlers.TickHandler;
import electro.research.ItemReel;
import electro.research.researchDevice;
import electro.research.te.TileEntityCollector;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

/**
 * Created by Ben on 05/07/2014.
 */
public class RenderTileCollector extends TileEntitySpecialRenderer
{
    private ModelCollector model;

    public RenderTileCollector()
    {
        this.model = new ModelCollector();
    }

    private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
    {
        int meta = world.getBlockMetadata(x, y, z);
        GL11.glPushMatrix();
        GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
        GL11.glPopMatrix();
    }

    float Rotation = 0;

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
    {
        ResourceLocation loc = new ResourceLocation(CommonProxy.MOD_ID_LOWER, "textures/models/ModelCollector.png");

        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        bindTexture(loc);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();

        if(te instanceof TileEntityCollector) {
            TileEntityCollector teCollector = (TileEntityCollector)te;
            if(teCollector.getStackInSlot(0) != null && teCollector.getStackInSlot(0).getItem() instanceof ItemReel)
            {
                Rotation = TickHandler.rotation;

                GL11.glPushMatrix();
                GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
                bindTexture(loc);
                GL11.glPushMatrix();
                GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
                this.model.renderReel(Rotation, (Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                GL11.glPopMatrix();
                GL11.glPopMatrix();
            }
        }
    }
}
