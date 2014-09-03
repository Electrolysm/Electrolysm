package electro.client;

import electro.common.CommonProxy;
import electro.configHandler;
import electro.handlers.AdvancedModelHandler;
import electro.handlers.TickHandler;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import org.lwjgl.opengl.GL11;

/**
 * Created by Clarky158 on 03/09/2014.
 */
public class RenderTileReceiver extends TileEntitySpecialRenderer{

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f1) {

        if(configHandler.useSpheres) {
            GL11.glPushMatrix();
            GL11.glDisable(GL11.GL_CULL_FACE);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glTranslatef((float) x, (float) y, (float) z + 1F);
            GL11.glRotatef(90F, -1F, 0F, 0F);
            GL11.glPushMatrix();
            bindTexture(new ResourceLocation(CommonProxy.MOD_ID_LOWER, "textures/blocks/blastProof.png"));
            AdvancedModelHandler.advancedModel.getModelReceiver().renderPart("Cube_Cube");
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            bindTexture(new ResourceLocation(CommonProxy.MOD_ID_LOWER, "textures/models/obj/receiver_ball.png"));
            AdvancedModelHandler.advancedModel.getModelReceiver().renderPart("Icosphere_Icosphere");
            GL11.glPopMatrix();
            GL11.glEnable(GL11.GL_CULL_FACE);
            GL11.glPopMatrix();
        } else {
            GL11.glPushMatrix();
            GL11.glDisable(GL11.GL_CULL_FACE);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glTranslatef((float) x, (float) y, (float) z + 1F);
            GL11.glRotatef(90F, -1F, 0F, 0F);

            GL11.glPushMatrix();
            bindTexture(new ResourceLocation(CommonProxy.MOD_ID_LOWER, "textures/models/obj/receiver_ball.png"));
            AdvancedModelHandler.advancedModel.getModelReceiverNoSpheres().renderPart("Cube");
            GL11.glPopMatrix();

            GL11.glPushMatrix();
            bindTexture(new ResourceLocation(CommonProxy.MOD_ID_LOWER, "textures/blocks/blastProof.png"));
            AdvancedModelHandler.advancedModel.getModelReceiverNoSpheres().renderPart("Bar");
            AdvancedModelHandler.advancedModel.getModelReceiverNoSpheres().renderPart("Air");
            GL11.glPopMatrix();

            GL11.glEnable(GL11.GL_CULL_FACE);
            GL11.glPopMatrix();
        }
    }
}
