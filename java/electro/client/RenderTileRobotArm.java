package electro.client;

import electro.Electrolysm;
import electro.block.machines.tile.TileEntityResearchDesk;
import electro.common.CommonProxy;
import electro.research.researchDevice;
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
 * Created by Ben on 06/07/2014.
 */
public class RenderTileRobotArm extends TileEntitySpecialRenderer
{
    //The model of your block
    private final ModelRobotArm model;

    public RenderTileRobotArm()
    {
        this.model = new ModelRobotArm();
    }

    private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
    {
        int meta = world.getBlockMetadata(x, y, z);
        GL11.glPushMatrix();
        GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
        GL11.glPopMatrix();
    }
/*
    String[] defaults = new String[] {"place_rest", "rest", "working1};
    double[] forearmAngles = new int[] {0, 1.2, -0.15, -0.05};
    double[] armAngles = new int[] {0, 0.45, -0.9, -1};
*/

    double forearm;
    double arm;

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
    {
        ResourceLocation loc = new ResourceLocation(CommonProxy.MOD_ID_LOWER, "textures/models/ModelRobotArm.png");

        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        bindTexture(loc);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

        forearm = this.alterTo();

        model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        model.renderWithAngle((float)(forearm), (float)(arm), null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

        GL11.glPopMatrix();
        GL11.glPopMatrix();

    }

    public float alterTo(float to, float from)
    {
        if(to == from) {
            if (to < from) {
                return (from - 0.01F);
            } else if (to > from) {
                return (from + 0.01F);
            }
        }
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
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) modulousModifier, divModifier);
    }
}