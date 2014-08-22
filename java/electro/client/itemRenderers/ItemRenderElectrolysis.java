package electro.client.itemRenderers;

import cpw.mods.fml.client.FMLClientHandler;
import electro.client.ModelCollector;
import electro.client.ModelElectrolysisCore;
import electro.common.CommonProxy;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by Ben on 12/07/2014.
 */
public class ItemRenderElectrolysis implements IItemRenderer
{
    ModelElectrolysisCore model = new ModelElectrolysisCore();

    public boolean handleRenderType(ItemStack itemStack, IItemRenderer.ItemRenderType itemRenderType)
    {
        return true;
    }

    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType itemRenderType, ItemStack itemStack, IItemRenderer.ItemRendererHelper itemRendererHelper)
    {
        return true;
    }

    public void renderItem(IItemRenderer.ItemRenderType type, ItemStack itemStack, Object... objects)
    {
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
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(CommonProxy.MODEL_ELECTROLYSIS_CORE_EMPTY);

        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        // Render
        model.render();

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
        GL11.glPopMatrix();

    }

}


