package electro.block.liquids;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class oil extends BlockFluidClassic
{
    @SideOnly(Side.CLIENT)
    public Icon flowing;
    @SideOnly(Side.CLIENT)
    public Icon still;

    public oil(int id)
    {
        super(id, new ModFluidOil(), Material.water);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName("Oil");
    }
}
