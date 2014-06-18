package electro.world;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import electro.electrolysmCore;

public class graphite extends Block
{
    public graphite()
    {
        super(Material.rock);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setHardness(5.0F);
        this.setResistance(10.0F);
    }

    @Override
    public void registerBlockIcons(IIconRegister reg)
    {
        this.blockIcon = reg.registerIcon("electrolysm:" + "graphite");
    }
}
