package electro.block.liquids;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import electro.electrolysmCore;
import cpw.mods.fml.common.registry.GameRegistry;
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
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
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
