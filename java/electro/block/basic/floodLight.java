package electro.block.basic;

import electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class floodLight extends Block
{
    public floodLight()
    {
        super(Material.iron);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setHardness(2.35685F);
    }
}
