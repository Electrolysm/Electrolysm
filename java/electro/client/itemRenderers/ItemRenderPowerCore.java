package electro.client.itemRenderers;

import cpw.mods.fml.client.FMLClientHandler;
import electro.client.ModelCharger;
import electro.client.ModelEnergyCube;
import electro.common.CommonProxy;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by Clarky158 on 25/07/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class ItemRenderPowerCore implements IItemRenderer {
    ModelEnergyCube model = new ModelEnergyCube();

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
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(CommonProxy.MODEL_ENERGY_CUBE);

        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        // Render
        model.render();

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
        GL11.glPopMatrix();

    }
}
