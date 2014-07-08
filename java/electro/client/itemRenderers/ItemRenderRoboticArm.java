package electro.client.itemRenderers;

import cpw.mods.fml.client.FMLClientHandler;
import electro.client.ModelRobotArm;
import electro.common.CommonProxy;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by Ben on 08/07/2014.
 */
public class ItemRenderRoboticArm implements IItemRenderer
{
    ModelRobotArm model = new ModelRobotArm();

    public boolean handleRenderType(ItemStack itemStack, ItemRenderType itemRenderType)
    {
        return true;
    }

    public boolean shouldUseRenderHelper(ItemRenderType itemRenderType, ItemStack itemStack, ItemRendererHelper itemRendererHelper)
    {
        return true;
    }

    public void renderItem(ItemRenderType type, ItemStack itemStack, Object... objects)
    {
        switch (type)
        {
            case ENTITY:
            {
                renderResearchDesk(0, 1F, 0F);
                return;
            }
            case EQUIPPED:
            {
                renderResearchDesk(0.25F, 1, 0.75F);
                return;
            }
            case EQUIPPED_FIRST_PERSON:
            {
                renderResearchDesk(0, 1, 0);
                return;
            }
            case INVENTORY:
            {
                renderResearchDesk(-0.2F, 0, 0);
                return;
            }
            default:
            {
            }
        }
    }

    public void renderResearchDesk(float x, float y, float z)
    {
        ResourceLocation loc = new ResourceLocation(CommonProxy.MOD_ID_LOWER, "textures/models/ModelRobotArm.png");

        GL11.glPushMatrix();
        GL11.glTranslatef(x, y, z);
        GL11.glTranslatef(0.2F, 1F, 0F);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(loc);

        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        // Render
        new ModelRobotArm().renderWithAngle(1.2F, 0.45F);

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
        GL11.glPopMatrix();

    }

}
