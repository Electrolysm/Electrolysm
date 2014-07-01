package electro.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import java.util.Random;

public class ModelHologram extends ModelBase
{
  //fields
    ModelRenderer Projector;
    ModelRenderer Earth;
    ModelRenderer device;

  public ModelHologram()
  {
      textureWidth = 64;
      textureHeight = 32;

      Projector = new ModelRenderer(this, 0, 0);
      Projector.addBox(0F, 0F, 0F, 8, 1, 8);
      Projector.setRotationPoint(-4F, 23F, -4F);
      Projector.setTextureSize(64, 32);
      Projector.mirror = true;
      setRotation(Projector, 0F, 0F, 0F);
      Earth = new ModelRenderer(this, 0, 12);
      Earth.addBox(-3F, -3F, -3F, 6, 6, 6);
      Earth.setRotationPoint(0F, 15F, 0F);
      Earth.setTextureSize(64, 32);
      Earth.mirror = true;
      setRotation(Earth, 0F, 0F, 0F);
      device = new ModelRenderer(this, 34, 0);
      device.addBox(-3F, 0F, -3F, 6, 1, 6);
      device.setRotationPoint(0F, 18F, 0F);
      device.setTextureSize(64, 32);
      device.mirror = true;
      setRotation(device, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Projector.render(f5);
  }

  public void renderBlock(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
      if(deviceRotation >= 360){
          deviceRotation = 0;
      } else {
          deviceRotation = deviceRotation + 0.0125F;
      }

      Earth.rotateAngleZ = deviceRotation;
      Earth.rotateAngleY = deviceRotation;
      Earth.rotateAngleZ = -deviceRotation;
      Earth.render(f5);
  }

   float deviceRotation = 0;

  public void renderDevice(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
      Random rand = new Random();
      if(deviceRotation >= 360){
          deviceRotation = 0;
      } else {
          deviceRotation = deviceRotation + 0.0125F;
      }

      device.rotateAngleZ = deviceRotation;
      device.rotateAngleY = deviceRotation;
      device.rotateAngleZ = -deviceRotation;
      /*if(rand.nextInt(100) != 5) { */device.render(f5); //}
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
