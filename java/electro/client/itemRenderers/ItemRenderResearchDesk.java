package electro.client.itemRenderers;

import electro.client.ModelResearchDesk;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

import electro.common.CommonProxy;
import electro.handlers.Referance;

public class ItemRenderResearchDesk implements IItemRenderer
{
    protected ModelResearchDesk model;

    float angle;

    public ItemRenderResearchDesk()
    {
        model = new ModelResearchDesk();
        angle = 0.0F;
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        if (type.equals(ItemRenderType.EQUIPPED_FIRST_PERSON)
                || type.equals(ItemRenderType.EQUIPPED)
                || type.equals(ItemRenderType.ENTITY))
        {
            return true;
        }

        return false;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
                                         ItemRendererHelper helper)
    {
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        float scale;

        switch (type)
        {
            case EQUIPPED_FIRST_PERSON:
            {
                GL11.glPushMatrix();
                {
                    Minecraft.getMinecraft().renderEngine
                    .bindTexture(CommonProxy.MODEL_RESEARCH_DESK);
                    scale = 1.2F;
                    GL11.glScalef(scale, scale, scale);
                    GL11.glRotatef(-85.0F, 0.0F, 0.0F, 1.0F);
                    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(65.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslatef(-2.3F, 1.5F, -3.8F);
                    model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F,
                                 0.0F, 0.0625F);
                }
                GL11.glPopMatrix();
            }

            case EQUIPPED:
            {
                if (!type.equals(ItemRenderType.EQUIPPED_FIRST_PERSON))
                {
                    GL11.glPushMatrix();
                    {
                        Minecraft.getMinecraft().renderEngine
                        .bindTexture(CommonProxy.MODEL_RESEARCH_DESK);
                        scale = 0.3F;
                        GL11.glScalef(scale, scale, scale);
                        GL11.glRotatef(-85.0F, 0.0F, 0.0F, 1.0F);
                        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                        GL11.glRotatef(-20.0F, 1.0F, 0.0F, 0.0F);
                        GL11.glTranslatef(0.1F, 2.0F, -0.2F);
                        model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F,
                                     0.0F, 0.0625F);
                    }
                    GL11.glPopMatrix();
                }
            }

            case ENTITY:
            {
                if (!type.equals(ItemRenderType.EQUIPPED)
                        && !type.equals(ItemRenderType.EQUIPPED_FIRST_PERSON))
                {
                    GL11.glPushMatrix();
                    {
                        Minecraft.getMinecraft().renderEngine
                        .bindTexture(CommonProxy.MODEL_RESEARCH_DESK);
                        scale = 0.7F;
                        GL11.glScalef(scale, scale, scale);
                        GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
                        GL11.glRotatef(angle, 0.0F, 1.0F, 0.0F);
                        GL11.glTranslatef(0.0F, -1.3F, 0.0F);
                        model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F,
                                     0.0F, 0.0625F);
                    }
                    GL11.glPopMatrix();
                    angle += 1.0F;

                    if (angle == 360.0F)
                    {
                        angle = 0.0F;
                    }
                }
            }

            default:
                break;
        }
    }
}