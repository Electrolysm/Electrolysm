package electro.client.itemRenderers;

import cpw.mods.fml.client.FMLClientHandler;
import electro.client.ModelMatrix;
import electro.client.ModelRobotArm;
import electro.common.CommonProxy;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by Ben on 10/07/2014.
 */
public class ItemRenderMatrix implements IItemRenderer {
    @Override
    public boolean handleRenderType(ItemStack stack, ItemRenderType itemRenderType) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType itemRenderType, ItemStack stack, ItemRendererHelper itemRendererHelper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack stack, Object... objects) {
        switch (type)
        {
            case ENTITY:
            {
                render(0, 1F, 0F);
                return;
            }
            case EQUIPPED:
            {
                render(0.25F, 1, 0.75F);
                return;
            }
            case EQUIPPED_FIRST_PERSON:
            {
                render(0, 1, 0);
                return;
            }
            case INVENTORY:
            {
                render(-0.2F, 0, 0);
                return;
            }
            default:
            {
            }
        }
    }

    public void render(float x, float y, float z)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef(x, y, z);
        GL11.glTranslatef(0.2F, 1F, 0F);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(CommonProxy.MODEL_MATRIX_CONSTRUCT);

        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        // Render
        new ModelMatrix().render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}
