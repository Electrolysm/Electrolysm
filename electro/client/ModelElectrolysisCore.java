package assets.electrolysm.electro.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelElectrolysisCore extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer Side2;
    ModelRenderer Side1;
    ModelRenderer Side3;
    ModelRenderer Side4;
    ModelRenderer stand1;
    ModelRenderer stand2;
    ModelRenderer standShelf;
    ModelRenderer node1;
    ModelRenderer node2;
    ModelRenderer Liquid;
  
  public ModelElectrolysisCore()
  {
    textureWidth = 256;
    textureHeight = 256;
    
      Base = new ModelRenderer(this, 0, 25);
      Base.addBox(0F, 0F, 0F, 16, 1, 16);
      Base.setRotationPoint(-8F, 23F, -8F);
      Base.setTextureSize(256, 256);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Side2 = new ModelRenderer(this, 0, 80);
      Side2.addBox(0F, 0F, 0F, 16, 8, 1);
      Side2.setRotationPoint(-8F, 15F, -8F);
      Side2.setTextureSize(256, 256);
      Side2.mirror = true;
      setRotation(Side2, 0F, 0F, 0F);
      Side1 = new ModelRenderer(this, 0, 80);
      Side1.addBox(0F, 0F, 0F, 16, 8, 1);
      Side1.setRotationPoint(-8F, 15F, 7F);
      Side1.setTextureSize(256, 256);
      Side1.mirror = true;
      setRotation(Side1, 0F, 0F, 0F);
      Side3 = new ModelRenderer(this, 0, 50);
      Side3.addBox(0F, 0F, 0F, 1, 8, 14);
      Side3.setRotationPoint(7F, 15F, -7F);
      Side3.setTextureSize(256, 256);
      Side3.mirror = true;
      setRotation(Side3, 0F, 0F, 0F);
      Side4 = new ModelRenderer(this, 0, 50);
      Side4.addBox(0F, 0F, 0F, 1, 8, 14);
      Side4.setRotationPoint(-8F, 15F, -7F);
      Side4.setTextureSize(256, 256);
      Side4.mirror = true;
      setRotation(Side4, 0F, 0F, 0F);
      stand1 = new ModelRenderer(this, 73, 7);
      stand1.addBox(0F, 0F, 0F, 1, 5, 2);
      stand1.setRotationPoint(-8F, 10F, -1F);
      stand1.setTextureSize(256, 256);
      stand1.mirror = true;
      setRotation(stand1, 0F, 0F, 0F);
      stand2 = new ModelRenderer(this, 85, 7);
      stand2.addBox(0F, 0F, 0F, 1, 5, 2);
      stand2.setRotationPoint(7F, 10F, -1F);
      stand2.setTextureSize(256, 256);
      stand2.mirror = true;
      setRotation(stand2, 0F, 0F, 0F);
      standShelf = new ModelRenderer(this, 69, 0);
      standShelf.addBox(0F, 0F, 0F, 14, 1, 2);
      standShelf.setRotationPoint(-7F, 10F, -1F);
      standShelf.setTextureSize(256, 256);
      standShelf.mirror = true;
      setRotation(standShelf, 0F, 0F, 0F);
      node1 = new ModelRenderer(this, 12, 0);
      node1.addBox(0F, 0F, 0F, 1, 9, 1);
      node1.setRotationPoint(-4F, 9F, 1F);
      node1.setTextureSize(256, 256);
      node1.mirror = true;
      setRotation(node1, 0F, 0F, 0F);
      node2 = new ModelRenderer(this, 23, 0);
      node2.addBox(0F, 0F, 0F, 1, 9, 1);
      node2.setRotationPoint(3F, 9F, 1F);
      node2.setTextureSize(256, 256);
      node2.mirror = true;
      setRotation(node2, 0F, 0F, 0F);
      Liquid = new ModelRenderer(this, 0, 100);
      Liquid.addBox(0F, 0F, 0F, 14, 1, 14);
      Liquid.setRotationPoint(-7F, 17F, -7F);
      Liquid.setTextureSize(256, 256);
      Liquid.mirror = true;
      setRotation(Liquid, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Base.render(f5);
    Side2.render(f5);
    Side1.render(f5);
    Side3.render(f5);
    Side4.render(f5);
    stand1.render(f5);
    stand2.render(f5);
    standShelf.render(f5);
    node1.render(f5);
    node2.render(f5);
    Liquid.render(f5);
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
