package assets.electrolysm.electro.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSoldering extends ModelBase
{
  //fields
    ModelRenderer Top;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Base;
    ModelRenderer Base2;
    ModelRenderer Iron;
    ModelRenderer Shape1;
  
  public ModelSoldering()
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
      Base = new ModelRenderer(this, 11, 55);
      Base.addBox(0F, 0F, 0F, 4, 2, 7);
      Base.setRotationPoint(-2F, 6F, -4F);
      Base.setTextureSize(64, 64);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Base2 = new ModelRenderer(this, 11, 45);
      Base2.addBox(0F, 0F, 0F, 4, 2, 5);
      Base2.setRotationPoint(-2F, 4F, -4F);
      Base2.setTextureSize(64, 64);
      Base2.mirror = true;
      setRotation(Base2, 0F, 0F, 0F);
      Iron = new ModelRenderer(this, 16, 35);
      Iron.addBox(0F, 0F, 0F, 1, 1, 7);
      Iron.setRotationPoint(-0.5F, 5F, 0F);
      Iron.setTextureSize(64, 64);
      Iron.mirror = true;
      setRotation(Iron, 0.7807508F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 20, 25);
      Shape1.addBox(-1F, 0F, -1F, 2, 2, 2);
      Shape1.setRotationPoint(5F, 6F, 0F);
      Shape1.setTextureSize(64, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, -0.3346075F, 0F);
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
    Base.render(f5);
    Base2.render(f5);
    Iron.render(f5);
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
