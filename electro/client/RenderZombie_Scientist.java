package assets.electrolysm.electro.client;

import assets.electrolysm.electro.biome.EntityZombie_Scientist;
import assets.electrolysm.electro.common.CommonProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderZombie_Scientist extends RenderLiving
{
	
	public RenderZombie_Scientist(ModelZombie_Scientist par1ModelBase, float par2)

	{
		super(par1ModelBase, par2);	
	}

	protected ResourceLocation func_110832_a(EntityZombie_Scientist entityScientist)
	{
		return CommonProxy.ZOMBIE_SCIENTIST_TEXTURE;
	}

	protected ResourceLocation func_110775_a(Entity par1Entity)
	{
		return this.func_110832_a((EntityZombie_Scientist)par1Entity);
	}
}