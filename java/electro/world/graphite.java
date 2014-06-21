package electro.world;

import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class graphite extends Block
{
    public graphite()
    {
        super(Material.rock);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(5.0F);
        this.setResistance(10.0F);
    }

    @Override
    public void registerBlockIcons(IIconRegister reg)
    {
        this.blockIcon = reg.registerIcon("electrolysm:" + "graphite");
    }
}
