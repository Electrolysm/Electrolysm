package assets.electrolysm.electro.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTransformer extends ModelBase
{
  //fields
    ModelRenderer heatSink1;
    ModelRenderer heatSink2;
    ModelRenderer heatSink3;
    ModelRenderer heatSink4;
    ModelRenderer heatSink5;
    ModelRenderer heatSink6;
    ModelRenderer heatSink7;
    ModelRenderer heatSink8;
    ModelRenderer heatSinkInner;
    ModelRenderer top;
    ModelRenderer connector;
  
  public ModelTransformer()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      heatSink1 = new ModelRenderer(this, 0, 0);
      heatSink1.addBox(0F, 0F, 0F, 6, 6, 1);
      heatSink1.setRotationPoint(0F, 12F, -4F);
      heatSink1.setTextureSize(128, 128);
      heatSink1.mirror = true;
      setRotation(heatSink1, 0F, 0F, 0.7853982F);
      heatSink2 = new ModelRenderer(this, 0, 0);
      heatSink2.addBox(0F, 0F, 0F, 6, 6, 1);
      heatSink2.setRotationPoint(0F, 12F, -8F);
      heatSink2.setTextureSize(128, 128);
      heatSink2.mirror = true;
      setRotation(heatSink2, 0F, 0F, 0.7853982F);
      heatSink3 = new ModelRenderer(this, 0, 0);
      heatSink3.addBox(0F, 0F, 0F, 6, 6, 1);
      heatSink3.setRotationPoint(0F, 12F, 5F);
      heatSink3.setTextureSize(128, 128);
      heatSink3.mirror = true;
      setRotation(heatSink3, 0F, 0F, 0.7853982F);
      heatSink4 = new ModelRenderer(this, 0, 0);
      heatSink4.addBox(0F, 0F, 0F, 6, 6, 1);
      heatSink4.setRotationPoint(0F, 12F, 1F);
      heatSink4.setTextureSize(128, 128);
      heatSink4.mirror = true;
      setRotation(heatSink4, 0F, 0F, 0.7853982F);
      heatSink5 = new ModelRenderer(this, 0, 0);
      heatSink5.addBox(0F, 0F, 0F, 6, 6, 1);
      heatSink5.setRotationPoint(0F, 12F, 7F);
      heatSink5.setTextureSize(128, 128);
      heatSink5.mirror = true;
      setRotation(heatSink5, 0F, 0F, 0.7853982F);
      heatSink6 = new ModelRenderer(this, 0, 0);
      heatSink6.addBox(0F, 0F, 0F, 6, 6, 1);
      heatSink6.setRotationPoint(0F, 12F, 3F);
      heatSink6.setTextureSize(128, 128);
      heatSink6.mirror = true;
      setRotation(heatSink6, 0F, 0F, 0.7853982F);
      heatSink7 = new ModelRenderer(this, 0, 0);
      heatSink7.addBox(0F, 0F, 0F, 6, 6, 1);
      heatSink7.setRotationPoint(0F, 12F, -2F);
      heatSink7.setTextureSize(128, 128);
      heatSink7.mirror = true;
      setRotation(heatSink7, 0F, 0F, 0.7853982F);
      heatSink8 = new ModelRenderer(this, 0, 0);
      heatSink8.addBox(0F, 0F, 0F, 6, 6, 1);
      heatSink8.setRotationPoint(0F, 12F, -6F);
      heatSink8.setTextureSize(128, 128);
      heatSink8.mirror = true;
      setRotation(heatSink8, 0F, 0F, 0.7853982F);
      heatSinkInner = new ModelRenderer(this, 18, 0);
      heatSinkInner.addBox(0F, 0F, 0F, 3, 3, 15);
      heatSinkInner.setRotationPoint(0F, 14F, -7F);
      heatSinkInner.setTextureSize(128, 128);
      heatSinkInner.mirror = true;
      setRotation(heatSinkInner, 0F, 0F, 0.7853982F);
      top = new ModelRenderer(this, 0, 47);
      top.addBox(0F, 0F, 0F, 12, 6, 16);
      top.setRotationPoint(-6F, 8F, -8F);
      top.setTextureSize(128, 128);
      top.mirror = true;
      setRotation(top, 0F, 0F, 0F);
      connector = new ModelRenderer(this, 0, 28);
      connector.addBox(0F, 0F, 0F, 4, 10, 4);
      connector.setRotationPoint(-2F, 14F, -2F);
      connector.setTextureSize(128, 128);
      connector.mirror = true;
      setRotation(connector, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    heatSink1.render(f5);
    heatSink2.render(f5);
    heatSink3.render(f5);
    heatSink4.render(f5);
    heatSink5.render(f5);
    heatSink6.render(f5);
    heatSink7.render(f5);
    heatSink8.render(f5);
    heatSinkInner.render(f5);
    top.render(f5);
    connector.render(f5);
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
