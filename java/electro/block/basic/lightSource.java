package electro.block.basic;

import cpw.mods.fml.common.registry.LanguageRegistry;
import electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class lightSource extends Block
{
    public lightSource(int par1, Material par2Material)
    {
        super(Material.air);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setHardness(0F);
        this.setLightLevel(1.0F);
        LanguageRegistry.addName(this, "lightSource");
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return null;
    }
}
