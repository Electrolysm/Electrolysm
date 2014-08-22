package electrolysm.electro.misc.block.liquids;

import electrolysm.electro.Electrolysm;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidClassic;
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
        this.setCreativeTab(Electrolysm.TabElectrolysm);
    }
}
