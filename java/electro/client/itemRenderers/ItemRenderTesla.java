package electro.client.itemRenderers;

import electro.common.CommonProxy;
import electro.configHandler;
import electro.handlers.AdvancedModelHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

/**
 * Created by Clarky158 on 07/09/2014.
 */
public class ItemRenderTesla implements IItemRenderer
{
    IModelCustom model = AdvancedModelHandler.advancedModel.getModelReceiver();
    IModelCustom modelNo = AdvancedModelHandler.advancedModel.getModelReceiverNoSpheres();

    public boolean handleRenderType(ItemStack itemStack, IItemRenderer.ItemRenderType itemRenderType) {
        return true;
    }

    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType itemRenderType, ItemStack itemStack, IItemRenderer.ItemRendererHelper itemRendererHelper) {
        return true;
    }

    public void renderItem(IItemRenderer.ItemRenderType type, ItemStack itemStack, Object... objects) {
        switch (type) {
            case ENTITY: {
                render(0, 0.3F, 0.48F);
                return;
            }
            case EQUIPPED: {
                render(0.8F, 1F, 1F);
                return;
            }
            case EQUIPPED_FIRST_PERSON: {
                render(1F, 1F, 0.8F);
                return;
            }
            case INVENTORY: {
                render(-0.25F, 0, 0);
                return;
            }
            default: {
            }
        }
    }

    public void render(float x, float y, float z) {
        GL11.glPushMatrix();
        GL11.glTranslatef(x, y, z);
        GL11.glTranslatef(-0.75F, -0.7F, 0F);
        GL11.glPushMatrix();
        //GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(90F, -1F, 0F, 0F);

        if(configHandler.useSpheres) {
            GL11.glPushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(CommonProxy.MOD_ID_LOWER, "textures/blocks/blastProof.png"));
            model.renderPart("Cube_Cube");
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(CommonProxy.MOD_ID_LOWER, "textures/models/obj/tesla_ball.png"));
            model.renderPart("Icosphere_Icosphere");
            GL11.glPopMatrix();
        }
        else {
            GL11.glPushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(CommonProxy.MOD_ID_LOWER, "textures/models/obj/tesla_ball_red.png"));
            modelNo.renderPart("Cube");
            GL11.glPopMatrix();

            GL11.glPushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(CommonProxy.MOD_ID_LOWER, "textures/blocks/blastProof.png"));
            modelNo.renderPart("Bar");
            modelNo.renderPart("Air");
            GL11.glPopMatrix();
        }

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
        GL11.glPopMatrix();

    }
}
