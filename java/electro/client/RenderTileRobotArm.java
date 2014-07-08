package electro.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.Electrolysm;
import electro.assemblySystem.tileEntity.TileEntityRobotArm;
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
@SideOnly(Side.CLIENT)
public class RenderTileRobotArm extends TileEntitySpecialRenderer
{
    //The model of your block
    private ModelRobotArm model;

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

    @Override
    public void renderTileEntityAt(TileEntity teWORLD, double x, double y, double z, float scale)
    {
        if(!(teWORLD instanceof TileEntityRobotArm)) { return; }
        TileEntityRobotArm te = (TileEntityRobotArm)teWORLD;


        ResourceLocation loc = new ResourceLocation(CommonProxy.MOD_ID_LOWER, "textures/models/ModelRobotArm.png");

        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        bindTexture(loc);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        model.renderBase();
        GL11.glPopMatrix();

        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        //FMLClientHandler.instance().getClient().getTextureManager().bindTexture(loc);
        bindTexture(loc);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glRotatef(te.rotation, 0F, 1F, 0F);
        //model.r((float)(te.forearm), (float)(te.arm), null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        model.renderWithAngle(te);
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
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) modulousModifier, divModifier);
    }
}