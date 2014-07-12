package electro.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelIronFrame extends ItemBlockModelBase
{
    //fields
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer base;
    ModelRenderer top;
    ModelRenderer core;

    public ModelIronFrame()
    {
        textureWidth = 64;
        textureHeight = 64;
        Leg1 = new ModelRenderer(this, 19, 47);
        Leg1.addBox(0F, 0F, 0F, 2, 12, 2);
        Leg1.setRotationPoint(6F, 10F, 6F);
        Leg1.setTextureSize(64, 64);
        Leg1.mirror = true;
        setRotation(Leg1, 0F, 0F, 0F);
        Leg2 = new ModelRenderer(this, 19, 47);
        Leg2.addBox(0F, 0F, 0F, 2, 12, 2);
        Leg2.setRotationPoint(-8F, 10F, 6F);
        Leg2.setTextureSize(64, 64);
        Leg2.mirror = true;
        setRotation(Leg2, 0F, 0F, 0F);
        Leg3 = new ModelRenderer(this, 19, 47);
        Leg3.addBox(0F, 0F, 0F, 2, 12, 2);
        Leg3.setRotationPoint(6F, 10F, -8F);
        Leg3.setTextureSize(64, 64);
        Leg3.mirror = true;
        setRotation(Leg3, 0F, 0F, 0F);
        Leg4 = new ModelRenderer(this, 19, 47);
        Leg4.addBox(0F, 0F, 0F, 2, 12, 2);
        Leg4.setRotationPoint(-8F, 10F, -8F);
        Leg4.setTextureSize(64, 64);
        Leg4.mirror = true;
        setRotation(Leg4, 0F, 0F, 0F);
        base = new ModelRenderer(this, 0, 46);
        base.addBox(0F, 0F, 0F, 16, 2, 16);
        base.setRotationPoint(-8F, 22F, -8F);
        base.setTextureSize(64, 64);
        base.mirror = true;
        setRotation(base, 0F, 0F, 0F);
        top = new ModelRenderer(this, 0, 46);
        top.addBox(0F, 0F, 0F, 16, 2, 16);
        top.setRotationPoint(-8F, 8F, -8F);
        top.setTextureSize(64, 64);
        top.mirror = true;
        setRotation(top, 0F, 0F, 0F);
        core = new ModelRenderer(this, 0, 5);
        core.addBox(0F, 0F, 0F, 4, 12, 4);
        core.setRotationPoint(-2F, 10F, -2F);
        core.setTextureSize(64, 64);
        core.mirror = true;
        setRotation(core, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        Leg1.render(f5);
        Leg2.render(f5);
        Leg3.render(f5);
        Leg4.render(f5);
        base.render(f5);
        top.render(f5);
        core.render(f5);
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
