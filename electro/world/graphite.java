package assets.electrolysm.electro.world;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import assets.electrolysm.electro.electrolysmCore;

public class graphite extends Block
{
    public graphite(int id, Material mat)
    {
        super(id, Material.rock);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName("graphite");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
    }

    public void registerIcons(IconRegister reg)
    {
        this.blockIcon = reg.registerIcon("electrolysm:" + "graphite");
    }
}
