// Date: 10/07/2014 19:37:49
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package electro.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMatrix extends ModelBase
{
  //fields
    ModelRenderer Box;
    ModelRenderer Base;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer side1;
    ModelRenderer side2;
    ModelRenderer side3;
    ModelRenderer side4;
  
  public ModelMatrix()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Box = new ModelRenderer(this, 0, 0);
      Box.addBox(-7F, -7F, -7F, 14, 14, 14);
      Box.setRotationPoint(0F, 16F, 0F);
      Box.setTextureSize(128, 128);
      Box.mirror = true;
      setRotation(Box, 0F, 0F, 0F);
      Base = new ModelRenderer(this, 61, 0);
      Base.addBox(-8F, 0F, -8F, 16, 1, 16);
      Base.setRotationPoint(0F, 23F, 0F);
      Base.setTextureSize(128, 128);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 30);
      leg1.addBox(0F, -16F, 0F, 1, 15, 1);
      leg1.setRotationPoint(7F, 24F, 7F);
      leg1.setTextureSize(128, 128);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 30);
      leg2.addBox(0F, 0F, 0F, 1, 15, 1);
      leg2.setRotationPoint(7F, 8F, -8F);
      leg2.setTextureSize(128, 128);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 0, 30);
      leg3.addBox(0F, 0F, 0F, 1, 15, 1);
      leg3.setRotationPoint(-8F, 8F, -8F);
      leg3.setTextureSize(128, 128);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 0, 30);
      leg4.addBox(0F, 0F, 0F, 1, 15, 1);
      leg4.setRotationPoint(-8F, 8F, 7F);
      leg4.setTextureSize(128, 128);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      side1 = new ModelRenderer(this, 10, 30);
      side1.addBox(0F, 0F, 0F, 14, 1, 1);
      side1.setRotationPoint(-7F, 8F, -8F);
      side1.setTextureSize(128, 128);
      side1.mirror = true;
      setRotation(side1, 0F, 0F, 0F);
      side2 = new ModelRenderer(this, 10, 30);
      side2.addBox(0F, 0F, 0F, 14, 1, 1);
      side2.setRotationPoint(-7F, 8F, 7F);
      side2.setTextureSize(128, 128);
      side2.mirror = true;
      setRotation(side2, 0F, 0F, 0F);
      side3 = new ModelRenderer(this, 10, 35);
      side3.addBox(0F, 0F, 0F, 1, 1, 14);
      side3.setRotationPoint(7F, 8F, -7F);
      side3.setTextureSize(128, 128);
      side3.mirror = true;
      setRotation(side3, 0F, 0F, 0F);
      side4 = new ModelRenderer(this, 10, 35);
      side4.addBox(0F, 0F, 0F, 1, 1, 14);
      side4.setRotationPoint(-8F, 8F, -7F);
      side4.setTextureSize(128, 128);
      side4.mirror = true;
      setRotation(side4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Box.render(f5);
    Base.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    leg3.render(f5);
    leg4.render(f5);
    side1.render(f5);
    side2.render(f5);
    side3.render(f5);
    side4.render(f5);
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
