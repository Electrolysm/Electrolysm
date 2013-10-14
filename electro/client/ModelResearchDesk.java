package assets.electrolysm.electro.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelResearchDesk extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer Stand;
    ModelRenderer Stand2;
    ModelRenderer Book;
    ModelRenderer BookBack;
  
  public ModelResearchDesk()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(0F, 0F, 0F, 16, 10, 16);
      Base.setRotationPoint(-8F, 14F, -8F);
      Base.setTextureSize(128, 128);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Stand = new ModelRenderer(this, 0, 56);
      Stand.addBox(0F, 0F, 0F, 16, 3, 1);
      Stand.setRotationPoint(-8F, 11F, -7F);
      Stand.setTextureSize(128, 128);
      Stand.mirror = true;
      setRotation(Stand, 0F, 0F, 0F);
      Stand2 = new ModelRenderer(this, 0, 33);
      Stand2.addBox(0F, 0F, 0F, 16, 1, 14);
      Stand2.setRotationPoint(-8F, 10F, -6.8F);
      Stand2.setTextureSize(128, 128);
      Stand2.mirror = true;
      setRotation(Stand2, -0.2125997F, 0F, 0F);
      Book = new ModelRenderer(this, 0, 64);
      Book.addBox(0F, 0F, 0F, 12, 1, 7);
      Book.setRotationPoint(-6F, 9.5F, -4F);
      Book.setTextureSize(128, 128);
      Book.mirror = true;
      setRotation(Book, -0.2125986F, 0F, 0F);
      BookBack = new ModelRenderer(this, 0, 80);
      BookBack.addBox(0F, 0F, 0F, 14, 0, 9);
      BookBack.setRotationPoint(-7F, 10F, -5.13F);
      BookBack.setTextureSize(128, 128);
      BookBack.mirror = true;
      setRotation(BookBack, -0.2125986F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Base.render(f5);
    Stand.render(f5);
    Stand2.render(f5);
    Book.render(f5);
    BookBack.render(f5);
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
