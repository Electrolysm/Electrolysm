package electrolysm.electro.misc.block.basic;

import electrolysm.electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class floodLight extends Block
{
    public floodLight()
    {
        super(Material.iron);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(2.35685F);
    }
}
