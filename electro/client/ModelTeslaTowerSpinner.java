package assets.electrolysm.electro.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTeslaTowerSpinner extends ModelBase
{
  //fields
    ModelRenderer Core;
    ModelRenderer BAR1;
    ModelRenderer Bar1;
    ModelRenderer block1;
    ModelRenderer block2;
    ModelRenderer block3;
    ModelRenderer block4;
  
  public ModelTeslaTowerSpinner()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Core = new ModelRenderer(this, 0, 0);
      Core.addBox(-8F, -8F, -8F, 12, 11, 12);
      Core.setRotationPoint(2F, 17F, 2F);
      Core.setTextureSize(128, 128);
      Core.mirror = true;
      setRotation(Core, 0F, 0F, 0F);
      BAR1 = new ModelRenderer(this, 0, 65);
      BAR1.addBox(-20F, -1F, -1F, 40, 2, 2);
      BAR1.setRotationPoint(0F, 15F, 0F);
      BAR1.setTextureSize(128, 128);
      BAR1.mirror = true;
      setRotation(BAR1, 0F, 0F, 0F);
      Bar1 = new ModelRenderer(this, 0, 27);
      Bar1.addBox(-1F, -1F, -20F, 2, 2, 40);
      Bar1.setRotationPoint(0F, 15F, 0F);
      Bar1.setTextureSize(128, 128);
      Bar1.mirror = true;
      setRotation(Bar1, 0F, 0F, 0F);
      block1 = new ModelRenderer(this, 0, 74);
      block1.addBox(0F, -5F, -5F, 6, 10, 10);
      block1.setRotationPoint(20F, 15F, 0F);
      block1.setTextureSize(128, 128);
      block1.mirror = true;
      setRotation(block1, 0F, 0F, 0F);
      block2 = new ModelRenderer(this, 0, 74);
      block2.addBox(-6F, -5F, -5F, 6, 10, 10);
      block2.setRotationPoint(-20F, 15F, 0F);
      block2.setTextureSize(128, 128);
      block2.mirror = true;
      setRotation(block2, 0F, 0F, 0F);
      block3 = new ModelRenderer(this, 0, 98);
      block3.addBox(-5F, -5F, -6F, 10, 10, 6);
      block3.setRotationPoint(0F, 15F, -20F);
      block3.setTextureSize(128, 128);
      block3.mirror = true;
      setRotation(block3, 0F, 0F, 0F);
      block4 = new ModelRenderer(this, 0, 98);
      block4.addBox(-5F, -5F, 0F, 10, 10, 6);
      block4.setRotationPoint(0F, 15F, 20F);
      block4.setTextureSize(128, 128);
      block4.mirror = true;
      setRotation(block4, 0F, 0F, 0F);

  }
  

public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Core.render(f5);
    BAR1.render(f5);
    Bar1.render(f5);
    block1.render(f5);
    block2.render(f5);
    block3.render(f5);
    block4.render(f5);
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
