package electrolysm.electro.client;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCollector extends ItemBlockModelBase
{
  //fields
    ModelRenderer base;
    ModelRenderer base1;
    ModelRenderer reel;
    ModelRenderer reel1;
    ModelRenderer reel2;
    ModelRenderer reel3;
    ModelRenderer reel4;
  
  public ModelCollector()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      base = new ModelRenderer(this, 0, 92);
      base.addBox(-5F, -6F, -5F, 10, 12, 10);
      base.setRotationPoint(1F, 17F, 0F);
      base.setTextureSize(128, 128);
      base.mirror = true;
      setRotation(base, 0F, 0F, 0F);
      base1 = new ModelRenderer(this, 0, 60);
      base1.addBox(-8F, 1F, -8F, 16, 1, 16);
      base1.setRotationPoint(0F, 22F, 0F);
      base1.setTextureSize(128, 128);
      base1.mirror = true;
      setRotation(base1, 0F, 0F, 0F);
      reel = new ModelRenderer(this, 0, 28);
      reel.addBox(-1F, -5.5F, -5.5F, 1, 11, 11);
      reel.setRotationPoint(-4F, 12F, 0F);
      reel.setTextureSize(128, 128);
      reel.mirror = true;
      setRotation(reel, 0F, 0F, 0F);
      reel1 = new ModelRenderer(this, 0, 0);
      reel1.addBox(-1F, -6.5F, -4.5F, 1, 1, 9);
      reel1.setRotationPoint(-4F, 12F, 0F);
      reel1.setTextureSize(128, 128);
      reel1.mirror = true;
      setRotation(reel1, 0F, 0F, 0F);
      reel2 = new ModelRenderer(this, 30, 0);
      reel2.addBox(-1F, -4.5F, -6.5F, 1, 9, 1);
      reel2.setRotationPoint(-4F, 12F, 0F);
      reel2.setTextureSize(128, 128);
      reel2.mirror = true;
      setRotation(reel2, 0F, 0F, 0F);
      reel3 = new ModelRenderer(this, 30, 0);
      reel3.addBox(-1F, -4.5F, 5.5F, 1, 9, 1);
      reel3.setRotationPoint(-4F, 12F, 0F);
      reel3.setTextureSize(128, 128);
      reel3.mirror = true;
      setRotation(reel3, 0F, 0F, 0F);
      reel4 = new ModelRenderer(this, 0, 0);
      reel4.addBox(-1F, 5.5F, -4.5F, 1, 1, 9);
      reel4.setRotationPoint(-4F, 12F, 0F);
      reel4.setTextureSize(128, 128);
      reel4.mirror = true;
      setRotation(reel4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    base.render(f5);
    base1.render(f5);
  }

  public void renderReel(float rotation, Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
      this.render(entity, f, f1, f2, f3, f4, f5);
      reel.render(f5);
      reel1.render(f5);
      reel2.render(f5);
      reel3.render(f5);
      reel4.render(f5);

      reel.rotateAngleX = rotation;
      reel1.rotateAngleX = rotation;
      reel2.rotateAngleX = rotation;
      reel3.rotateAngleX = rotation;
      reel4.rotateAngleX = rotation;
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
