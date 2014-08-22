package electro.client;

import electro.handlers.TickHandler;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelCharger extends ItemBlockModelBase
{
    //fields
    ModelRenderer Cover;
    ModelRenderer Cover1;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Injector1;
    ModelRenderer Injector2;
    ModelRenderer Injector3;
    ModelRenderer Injector10;
    ModelRenderer Injector11;
    ModelRenderer Injector12;
    ModelRenderer Beam;

    public ModelCharger()
    {
        textureWidth = 128;
        textureHeight = 128;
        Cover = new ModelRenderer(this, 0, 0);
        Cover.addBox(0F, 0F, 0F, 16, 2, 16);
        Cover.setRotationPoint(-8F, 22F, -8F);
        Cover.setTextureSize(128, 128);
        Cover.mirror = true;
        setRotation(Cover, 0F, 0F, 0F);
        Cover1 = new ModelRenderer(this, 0, 0);
        Cover1.addBox(0F, 0F, 0F, 16, 2, 16);
        Cover1.setRotationPoint(-8F, 8F, -8F);
        Cover1.setTextureSize(128, 128);
        Cover1.mirror = true;
        setRotation(Cover1, 0F, 0F, 0F);
        Leg1 = new ModelRenderer(this, 0, 20);
        Leg1.addBox(0F, 0F, 0F, 2, 12, 2);
        Leg1.setRotationPoint(-8F, 10F, 6F);
        Leg1.setTextureSize(128, 128);
        Leg1.mirror = true;
        setRotation(Leg1, 0F, 0F, 0F);
        Leg2 = new ModelRenderer(this, 0, 20);
        Leg2.addBox(0F, 0F, 0F, 2, 12, 2);
        Leg2.setRotationPoint(6F, 10F, -8F);
        Leg2.setTextureSize(128, 128);
        Leg2.mirror = true;
        setRotation(Leg2, 0F, 0F, 0F);
        Leg3 = new ModelRenderer(this, 0, 20);
        Leg3.addBox(0F, 0F, 0F, 2, 12, 2);
        Leg3.setRotationPoint(6F, 10F, 6F);
        Leg3.setTextureSize(128, 128);
        Leg3.mirror = true;
        setRotation(Leg3, 0F, 0F, 0F);
        Leg4 = new ModelRenderer(this, 0, 20);
        Leg4.addBox(0F, 0F, 0F, 2, 12, 2);
        Leg4.setRotationPoint(-8F, 10F, -8F);
        Leg4.setTextureSize(128, 128);
        Leg4.mirror = true;
        setRotation(Leg4, 0F, 0F, 0F);
        Injector1 = new ModelRenderer(this, 10, 21);
        Injector1.addBox(0F, 0F, 0F, 10, 1, 10);
        Injector1.setRotationPoint(-5F, 10F, -5F);
        Injector1.setTextureSize(128, 128);
        Injector1.mirror = true;
        setRotation(Injector1, 0F, 0F, 0F);
        Injector2 = new ModelRenderer(this, 0, 37);
        Injector2.addBox(0F, 0F, 0F, 8, 1, 8);
        Injector2.setRotationPoint(-4F, 11F, -4F);
        Injector2.setTextureSize(128, 128);
        Injector2.mirror = true;
        setRotation(Injector2, 0F, 0F, 0F);
        Injector3 = new ModelRenderer(this, 35, 38);
        Injector3.addBox(0F, 0F, 0F, 6, 1, 6);
        Injector3.setRotationPoint(-3F, 12F, -3F);
        Injector3.setTextureSize(128, 128);
        Injector3.mirror = true;
        setRotation(Injector3, 0F, 0F, 0F);
        Injector10 = new ModelRenderer(this, 10, 21);
        Injector10.addBox(0F, 0F, 0F, 10, 1, 10);
        Injector10.setRotationPoint(-5F, 21F, -5F);
        Injector10.setTextureSize(128, 128);
        Injector10.mirror = true;
        setRotation(Injector10, 0F, 0F, 0F);
        Injector11 = new ModelRenderer(this, 0, 37);
        Injector11.addBox(0F, 0F, 0F, 8, 1, 8);
        Injector11.setRotationPoint(-4F, 20F, -4F);
        Injector11.setTextureSize(128, 128);
        Injector11.mirror = true;
        setRotation(Injector11, 0F, 0F, 0F);
        Injector11.mirror = false;
        Injector12 = new ModelRenderer(this, 35, 38);
        Injector12.addBox(0F, 0F, 0F, 6, 1, 6);
        Injector12.setRotationPoint(-3F, 19F, -3F);
        Injector12.setTextureSize(128, 128);
        Injector12.mirror = true;
        setRotation(Injector12, 0F, 0F, 0F);
        Beam = new ModelRenderer(this, 55, 21);
        Beam.addBox(-1F, 0F, -1F, 2, 6, 2);
        Beam.setRotationPoint(0F, 13F, 0F);
        Beam.setTextureSize(128, 128);
        Beam.mirror = true;
        setRotation(Beam, 0F, 0.9666439F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        Cover.render(f5);
        Cover1.render(f5);
        Leg1.render(f5);
        Leg2.render(f5);
        Leg3.render(f5);
        Leg4.render(f5);
        Injector1.render(f5);
        Injector2.render(f5);
        Injector3.render(f5);
        Injector10.render(f5);
        Injector11.render(f5);
        Injector12.render(f5);

        //GL11.glPushMatrix();
        //GL11.glRotatef(TickHandler.rotation, 0F, 1F, 0F);
        Beam.render(f5);
        Beam.rotateAngleY = TickHandler.rotation;
        //GL11.glPopMatrix();
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
    }
}
