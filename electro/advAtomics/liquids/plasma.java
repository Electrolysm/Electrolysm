package assets.electrolysm.electro.advAtomics.liquids;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class plasma extends BlockFluidClassic {

	@SideOnly(Side.CLIENT)
	public Icon flowing;
	@SideOnly(Side.CLIENT)
	public Icon still;

    public plasma(int id) {
            super(id, new ModFluidPlasma(), Material.water);
            this.setCreativeTab(electrolysmCore.TabElectrolysm);
            this.setUnlocalizedName("fluidPlasma");
    }
    @Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon( int side, int meta )
	{
		if( side <= 1 )
		{
			return this.still;
		}
		else
		{
			return this.flowing;
		}
	}
    
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register)
    {
        this.flowing = register.registerIcon("electrolysm:" + "plasma");
        this.still = register.registerIcon("electrolysm:" + "plasma_still");
    }
}
