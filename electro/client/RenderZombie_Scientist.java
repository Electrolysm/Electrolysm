package assets.electrolysm.electro.client;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import assets.electrolysm.electro.common.CommonProxy;
import assets.electrolysm.electro.world.biome.EntityZombie_Scientist;

public class RenderZombie_Scientist extends RenderLiving
{
    public RenderZombie_Scientist(ModelZombie_Scientist par1ModelBase, float par2)

    {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getEntityTexture1(EntityZombie_Scientist entityScientist)
    {
        return CommonProxy.ZOMBIE_SCIENTIST_TEXTURE;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture1((EntityZombie_Scientist)entity);
    }
}