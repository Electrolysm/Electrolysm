package electro.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDesk extends ItemBlockModelBase
{
    //fields
    ModelRenderer Top;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Shape1;

    public ModelDesk()
    {
        textureWidth = 64;
        textureHeight = 64;
        Top = new ModelRenderer(this, 0, 0);
        Top.addBox(0F, 0F, 0F, 16, 2, 16);
        Top.setRotationPoint(-8F, 8F, -8F);
        Top.setTextureSize(64, 64);
        Top.mirror = true;
        setRotation(Top, 0F, 0F, 0F);
        Leg1 = new ModelRenderer(this, 0, 48);
        Leg1.addBox(0F, 0F, 0F, 2, 14, 2);
        Leg1.setRotationPoint(6F, 10F, -8F);
        Leg1.setTextureSize(64, 64);
        Leg1.mirror = true;
        setRotation(Leg1, 0F, 0F, 0F);
        Leg2 = new ModelRenderer(this, 0, 48);
        Leg2.addBox(0F, 0F, 0F, 2, 14, 2);
        Leg2.setRotationPoint(-8F, 10F, -8F);
        Leg2.setTextureSize(64, 64);
        Leg2.mirror = true;
        setRotation(Leg2, 0F, 0F, 0F);
        Leg3 = new ModelRenderer(this, 0, 48);
        Leg3.addBox(0F, 0F, 0F, 2, 14, 2);
        Leg3.setRotationPoint(-8F, 10F, 6F);
        Leg3.setTextureSize(64, 64);
        Leg3.mirror = true;
        setRotation(Leg3, 0F, 0F, 0F);
        Leg4 = new ModelRenderer(this, 0, 48);
        Leg4.addBox(0F, 0F, 0F, 2, 14, 2);
        Leg4.setRotationPoint(6F, 10F, 6F);
        Leg4.setTextureSize(64, 64);
        Leg4.mirror = true;
        setRotation(Leg4, 0F, 0F, 0F);
        Shape1 = new ModelRenderer(this, 0, 21);
        Shape1.addBox(0F, 0F, 0F, 12, 14, 12);
        Shape1.setRotationPoint(-6F, 10F, -6F);
        Shape1.setTextureSize(64, 64);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        Top.render(f5);
        Leg1.render(f5);
        Leg2.render(f5);
        Leg3.render(f5);
        Leg4.render(f5);
        Shape1.render(f5);
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
