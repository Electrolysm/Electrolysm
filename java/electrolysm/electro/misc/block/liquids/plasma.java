package electrolysm.electro.misc.block.liquids;

import electrolysm.electro.Electrolysm;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidClassic;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class plasma extends BlockFluidClassic
{
    @SideOnly(Side.CLIENT)
    public IIcon flowing;
    @SideOnly(Side.CLIENT)
    public IIcon still;

    public plasma()
    {
        super(new ModFluidPlasma(), Material.water);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if (side <= 1)
        {
            return this.still;
        }
        else
        {
            return this.flowing;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register)
    {
        this.flowing = register.registerIcon("electrolysm:" + "plasma");
        this.still = register.registerIcon("electrolysm:" + "plasma_still");
    }
}
