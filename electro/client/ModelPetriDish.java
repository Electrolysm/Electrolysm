package mods.Electrolysm.electro.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPetriDish extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer s2;
    ModelRenderer s3;
    ModelRenderer s4;
    ModelRenderer s5;
  
  public ModelPetriDish()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(1F, 0F, -2F, 1, 1, 4);
      Shape1.setRotationPoint(0F, 23F, 0F);
      Shape1.setTextureSize(32, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      s2 = new ModelRenderer(this, 8, 5);
      s2.addBox(-1F, 0F, 1F, 2, 1, 1);
      s2.setRotationPoint(0F, 23F, 0F);
      s2.setTextureSize(32, 32);
      s2.mirror = true;
      setRotation(s2, 0F, 0F, 0F);
      s3 = new ModelRenderer(this, 0, 0);
      s3.addBox(-2F, 0F, -2F, 1, 1, 4);
      s3.setRotationPoint(0F, 23F, 0F);
      s3.setTextureSize(32, 32);
      s3.mirror = true;
      setRotation(s3, 0F, 0F, 0F);
      s4 = new ModelRenderer(this, 8, 5);
      s4.addBox(-1F, 0F, -2F, 2, 1, 1);
      s4.setRotationPoint(0F, 23F, 0F);
      s4.setTextureSize(32, 32);
      s4.mirror = true;
      setRotation(s4, 0F, 0F, 0F);
      s5 = new ModelRenderer(this, 0, 5);
      s5.addBox(-1F, 0F, -1F, 2, 0, 2);
      s5.setRotationPoint(0F, 23.9F, 0F);
      s5.setTextureSize(32, 32);
      s5.mirror = true;
      setRotation(s5, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Shape1.render(f5);
    s2.render(f5);
    s3.render(f5);
    s4.render(f5);
    s5.render(f5);
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
