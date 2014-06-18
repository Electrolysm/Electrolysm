package electro.block.liquids;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import electro.electrolysmCore;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class oil extends BlockFluidClassic
{
    @SideOnly(Side.CLIENT)
    public IIcon flowing;
    @SideOnly(Side.CLIENT)
    public IIcon still;

    public oil()
    {
        super(new ModFluidOil(), Material.water);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
    }
}
