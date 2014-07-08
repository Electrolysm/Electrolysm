// Date: 06/07/2014 11:30:10
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package electro.client;

import electro.assemblySystem.tileEntity.TileEntityRobotArm;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelRobotArm extends ModelBase {
    //fields
    ModelRenderer base;
    ModelRenderer Sholder;
    ModelRenderer Forearm;
    ModelRenderer arm;
    ModelRenderer toolBase;
    ModelRenderer extraBits;

    public ModelRobotArm() {
        textureWidth = 256;
        textureHeight = 32;

        base = new ModelRenderer(this, 0, 0);
        base.addBox(-8F, 0F, -8F, 16, 1, 16);
        base.setRotationPoint(0F, 23F, 0F);
        base.setTextureSize(256, 32);
        base.mirror = true;
        setRotation(base, 0F, 0F, 0F);
        Sholder = new ModelRenderer(this, 0, 0);
        Sholder.addBox(-2.5F, -5F, -2.5F, 5, 8, 5);
        Sholder.setRotationPoint(0F, 20F, 0F);
        Sholder.setTextureSize(256, 32);
        Sholder.mirror = true;
        setRotation(Sholder, 0F, 0F, 0F);
        Forearm = new ModelRenderer(this, 0, 0);
        Forearm.addBox(2.5F, -16F, -2F, 1, 18, 4);
        Forearm.setRotationPoint(0F, 17F, 0F);
        Forearm.setTextureSize(256, 32);
        Forearm.mirror = true;
        setRotation(Forearm, 0F, 0F, 0F);
        arm = new ModelRenderer(this, 0, 0);
        arm.addBox(-2F, -2F, -4F, 4, 4, 22);
        arm.addBox(-1F, -1F, -4F, 2, 2, 26);
        arm.setRotationPoint(0.5F, 3F, 0F);
        arm.setTextureSize(256, 32);
        arm.mirror = true;
        setRotation(arm, 0F, 0F, 0F);

        toolBase = new ModelRenderer(this, 0, 0);
        toolBase.addBox(-2F, -2F, -4F, 2, 6, 2);
        toolBase.setRotationPoint(0.5F, 3F, 0F);
        toolBase.setTextureSize(256, 32);
        toolBase.mirror = true;
        setRotation(arm, 0F, 0F, 0F);

        extraBits = new ModelRenderer(this, 0, 0);
        extraBits.addBox(-2.5F, -5F, -2.5F, 1, 5, 5);
        extraBits.setRotationPoint(0F, 20F, 0F);
        extraBits.setTextureSize(256, 32);
        extraBits.mirror = true;
        setRotation(extraBits, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
    }

    public void renderBase()
    {
        float scale = 0.0625F;

        this.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, scale);
        base.render(scale);
    }


    public void renderWithAngle(TileEntityRobotArm te)
    {
        this.renderWithAngle(te.forearm, te.arm);
    }

    public void renderWithAngle(float forearmAngle, float armAngle)
    {
        float scale = 0.0625F;

        float angle = forearmAngle * 57.3F + 180;
        float angleRAD = (float)(angle / 57.3);
        float radius = 18F;
        float cx = 0F;
        float cy = 0F;

        float Xp1 = (float)(cx + (radius * (Math.cos(angleRAD))));
        float Yp1 = (float)(cy + (radius * (Math.sin(angleRAD))));

        GL11.glPushMatrix();
        GL11.glRotatef(angle, 1.0F, 0.0F, 0.0F);
        GL11.glTranslatef(0.0F, 0F - (Xp1 / 16F) * (-1), (Yp1 / 16F) * (-1));
        Forearm.render(scale);
        Forearm.rotateAngleX = 0F;
        GL11.glPopMatrix();

        float angle2 = (float)(armAngle * 57.3);
        float angleRAD2 = (float)(angle2 / 57.3);
        float radius2 = 3F;

        float Xp2 = (float)(cx + (radius2 * (Math.cos(angleRAD2))));
        float Yp2 = (float)(cy + (radius2 * (Math.sin(angleRAD2))));

        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 3F + (((2F / 16F) + (Xp1 / 16F))) * (1) - 2.1F, 0.5F - (Yp1 / 16F) * (-1) - 0.5F);
        GL11.glTranslatef(0.0F, (0F + (Xp2 / 16F) * (-1)) + (2F / 16F), ((Yp2 / 16F) * (-1)));
        GL11.glRotatef(angle2, 1.0F, 0F, 0F);
        arm.render(scale);
        arm.rotateAngleX = 0F;
        GL11.glPopMatrix();

        float angle3 = (float)(armAngle/* * 57.3*/);
        float angleRAD3 = (float)(angle2 / 57.3);
        float radius3 = 20F;

        float Xp3 = (float)(cx + (radius2 * (Math.cos(angleRAD2))));
        float Yp3 = (float)(cy + (radius2 * (Math.sin(angleRAD2))));

        GL11.glPushMatrix();
        extraBits.render(scale);
        extraBits.setRotationPoint(5F, 20F, 0F);
        Sholder.render(scale);
        GL11.glPopMatrix();

    }

    public void getEndOfArm(TileEntityRobotArm te)
    {
        float outsideBAngle = te.arm;

        float scale = 0.0625F;
        float x = getPoints(te)[0];
        float y = getPoints(te)[1];
        float z = getPoints(te)[2];
        float hyp = 18F;

        float base = (float)((Math.cos(outsideBAngle)) * hyp);
        float height = (float)((Math.sin(outsideBAngle)) * hyp);

        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, (y - height - 2F) / 16F, (z + base + 3F) / 16F);
        toolBase.render(scale);
        GL11.glPopMatrix();
    }

    public float[] getPoints(TileEntityRobotArm te){

        float outsideXAngle = te.forearm;

        float insideXAngle = (90 - outsideXAngle);
        float insideTopAngle = 180 - (insideXAngle + 90);

        float hypotenuse = 14;
        float base = (float)((Math.sin(outsideXAngle)) * hypotenuse);
        float height = (float)((Math.cos(outsideXAngle)) * hypotenuse);


        return new float[] {0.5F, 17F - height, 0.0F - base};
        //wrist.setRotationPoint(-1F, 17F - height, 0.0F - base);

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
/*
package electro.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

public class ModelRobotArm extends ModelBase
{
    ModelRenderer Base;
    ModelRenderer BaseTurn;
    ModelRenderer BaseTurn2;
    ModelRenderer ArmBase1;
    ModelRenderer ArmBase2;
    ModelRenderer SupportMiddle;
    ModelRenderer ArmMiddle1;
    ModelRenderer ArmMiddle2;
    ModelRenderer LaserBase;
    ModelRenderer Laser;

    public ModelRobotArm()
    {
        this.textureHeight = 64;
        this.textureWidth = 64;

        this.Base = new ModelRenderer(this, 0, 0);
        this.Base.addBox(0.0F, 0.0F, 1.0F, 16, 1, 16);
        this.Base.setRotationPoint(-8.0F, 23.0F, -9.0F);
        this.Base.setTextureSize(64, 32);
        this.Base.mirror = true;
        setRotation(this.Base, 0.0F, 0.0F, 0.0F);
        this.BaseTurn = new ModelRenderer(this, 0, 17);
        this.BaseTurn.addBox(0.0F, 0.0F, 0.0F, 7, 1, 7);
        this.BaseTurn.setRotationPoint(-3.5F, 22.0F, -3.5F);
        this.BaseTurn.setTextureSize(64, 32);
        this.BaseTurn.mirror = true;
        setRotation(this.BaseTurn, 0.0F, 0.0F, 0.0F);
        this.BaseTurn2 = new ModelRenderer(this, 28, 17);
        this.BaseTurn2.addBox(0.0F, 0.0F, 0.0F, 4, 5, 4);
        this.BaseTurn2.setRotationPoint(-2.0F, 17.0F, -2.0F);
        this.BaseTurn2.setTextureSize(64, 32);
        this.BaseTurn2.mirror = true;
        setRotation(this.BaseTurn2, 0.0F, 0.0F, 0.0F);
        this.ArmBase1 = new ModelRenderer(this, 0, 25);
        this.ArmBase1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 8);
        this.ArmBase1.setRotationPoint(2.0F, 17.0F, -1.0F);
        this.ArmBase1.setTextureSize(64, 32);
        this.ArmBase1.mirror = true;
        setRotation(this.ArmBase1, 0.0F, 0.0F, 0.0F);
        this.ArmBase2 = new ModelRenderer(this, 0, 25);
        this.ArmBase2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 8);
        this.ArmBase2.setRotationPoint(-3.0F, 17.0F, -1.0F);
        this.ArmBase2.setTextureSize(64, 32);
        this.ArmBase2.mirror = true;
        setRotation(this.ArmBase2, 0.0F, 0.0F, 0.0F);
        this.SupportMiddle = new ModelRenderer(this, 0, 57);
        this.SupportMiddle.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1);
        this.SupportMiddle.setRotationPoint(-1.0F, 17.5F, 5.5F);
        this.SupportMiddle.setTextureSize(64, 32);
        this.SupportMiddle.mirror = true;
        setRotation(this.SupportMiddle, 0.0F, 0.0F, 0.0F);
        this.ArmMiddle1 = new ModelRenderer(this, 0, 35);
        this.ArmMiddle1.addBox(0.0F, 0.0F, 0.0F, 1, 17, 2);
        this.ArmMiddle1.setRotationPoint(-2.0F, 2.0F, 5.0F);
        this.ArmMiddle1.setTextureSize(64, 32);
        this.ArmMiddle1.mirror = true;
        setRotation(this.ArmMiddle1, 0.0F, 0.0F, 0.0F);
        this.ArmMiddle2 = new ModelRenderer(this, 0, 35);
        this.ArmMiddle2.addBox(0.0F, 0.0F, 0.0F, 1, 17, 2);
        this.ArmMiddle2.setRotationPoint(1.0F, 2.0F, 5.0F);
        this.ArmMiddle2.setTextureSize(64, 32);
        this.ArmMiddle2.mirror = true;
        setRotation(this.ArmMiddle2, 0.0F, 0.0F, 0.0F);
        this.LaserBase = new ModelRenderer(this, 8, 38);
        this.LaserBase.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3);
        this.LaserBase.setRotationPoint(-1.0F, 2.0F, 4.5F);
        this.LaserBase.setTextureSize(64, 32);
        this.LaserBase.mirror = true;
        setRotation(this.LaserBase, 0.0F, 0.0F, 0.0F);
        this.Laser = new ModelRenderer(this, 54, 59);
        this.Laser.addBox(0.0F, 0.0F, 0.0F, 1, 1, 32);
        this.Laser.setRotationPoint(-0.5F, 2.5F, 1.0F);
        this.Laser.setTextureSize(64, 32);
        this.Laser.mirror = true;
        setRotation(this.Laser, 0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Base.render(f5);
        this.BaseTurn.render(f5);
        this.BaseTurn2.render(f5);
        this.ArmBase1.render(f5);
        this.ArmBase2.render(f5);
        this.SupportMiddle.render(f5);
        this.ArmMiddle1.render(f5);
        this.ArmMiddle2.render(f5);
        this.LaserBase.render(f5);
        this.Laser.render(f5);
    }

    public void renderModel(float size, TileEntity te, float partialTicks)
    {*/
       /* if ((te instanceof TileEntity)) {
            TileEntityAssemblyLaser tile = (TileEntityAssemblyLaser)te;
            float[] renderAngles = new float[5];
            for (int i = 0; i < 5; i++) {
                renderAngles[i] = (tile.oldAngles[i] + (tile.angles[i] - tile.oldAngles[i]) * partialTicks);
            }
            renderModel(0.0625F, renderAngles, tile.isLaserOn);
        } else {*//*
            renderModel(size, new float[] { 0.0F, 0.0F, 35.0F, 55.0F, 0.0F }, false);
        //}
    }

    public void renderModel(float size, float[] angles, boolean laserOn) {
        this.Base.render(size);
        GL11.glPushMatrix();
        GL11.glRotatef(angles[0], 0.0F, 1.0F, 0.0F);
        this.BaseTurn.render(size);
        this.BaseTurn2.render(size);
        GL11.glTranslated(0.0D, 1.125D, 0.0D);
        GL11.glRotatef(angles[1], 1.0F, 0.0F, 0.0F);
        GL11.glTranslated(0.0D, -1.125D, 0.0D);
        this.ArmBase1.render(size);
        this.ArmBase2.render(size);
        this.SupportMiddle.render(size);
        GL11.glTranslated(0.0D, 1.125D, 0.375D);
        GL11.glRotatef(angles[2], 1.0F, 0.0F, 0.0F);
        GL11.glTranslated(0.0D, -1.125D, -0.375D);
        this.ArmMiddle1.render(size);
        this.ArmMiddle2.render(size);
        GL11.glTranslated(0.0D, 0.1875D, 0.375D);
        GL11.glRotatef(angles[3], 1.0F, 0.0F, 0.0F);
        GL11.glTranslated(0.0D, -0.1875D, -0.375D);
        this.LaserBase.render(size);
        if (laserOn) {
            GL11.glPushMatrix();
            GL11.glTranslated(0.0D, 0.171875D, 0.0625D);
            GL11.glDisable(3553);
            GL11.glColor4d(1.0D, 0.1D, 0.0D, 1.0D);

            this.Laser.render(size / 8.0F);
            GL11.glPopMatrix();
            GL11.glColor4d(1.0D, 1.0D, 1.0D, 1.0D);
            GL11.glEnable(3553);
        }
        double textSize = 0.006666666666666667D;
        GL11.glScaled(textSize, textSize, textSize);
        GL11.glRotated(-90.0D, 1.0D, 0.0D, 0.0D);
        GL11.glTranslated(0.0D, 0.0D, 18.0D);
        GL11.glDisable(2896);
        //GuiPneumaticContainerBase.drawTexture("pneumaticcraft:textures/gui/GuiLaserDanger.png", -8, -65);
        GL11.glEnable(2896);
        GL11.glPopMatrix();
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleX = y;
        model.rotateAngleX = z;
    }


    public boolean rotateModelBasedOnBlockMeta()
    {
        return false;
    }
}
*/