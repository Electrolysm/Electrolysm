package mods.Electrolysm.electro.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.electro.advAtomics.GUIs.Entity.EntityZombie_Scientist;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderZombie_Scientist extends RenderLiving{
    /** Model of the Zombie_Scientist. */
    protected ModelZombie_Scientist ModelZombie_Scientist;

    public RenderZombie_Scientist(mods.Electrolysm.electro.client.ModelZombie_Scientist modelZombie_Scientist2, float f)
    {
        super(new ModelZombie_Scientist(), 0.5F);
        this.ModelZombie_Scientist = (ModelZombie_Scientist)this.mainModel;
    }

    /**
     * Determines wether Zombie_Scientist Render pass or not.
     */
    protected int shouldZombie_ScientistRenderPass(EntityZombie_Scientist par1EntityZombie_Scientist, int par2, float par3)
    {
        return -1;
    }

    public void renderZombie_Scientist(EntityZombie_Scientist par1EntityZombie_Scientist, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityZombie_Scientist, par2, par4, par6, par8, par9);
    }

    protected void renderZombie_ScientistEquipedItems(EntityZombie_Scientist par1EntityZombie_Scientist, float par2)
    {
        super.renderEquippedItems(par1EntityZombie_Scientist, par2);
    }

    protected void preRenderZombie_Scientist(EntityZombie_Scientist par1EntityZombie_Scientist, float par2)
    {
        float f1 = 0.9375F;

        GL11.glScalef(f1, f1, f1);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        this.preRenderZombie_Scientist((EntityZombie_Scientist)par1EntityLiving, par2);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
    {
        return this.shouldZombie_ScientistRenderPass((EntityZombie_Scientist)par1EntityLiving, par2, par3);
    }

    protected void renderEquippedItems(EntityLiving par1EntityLiving, float par2)
    {
        this.renderZombie_ScientistEquipedItems((EntityZombie_Scientist)par1EntityLiving, par2);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderZombie_Scientist((EntityZombie_Scientist)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderZombie_Scientist((EntityZombie_Scientist)par1Entity, par2, par4, par6, par8, par9);
    }
}
