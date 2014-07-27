package electro.world;

import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class tinOre extends Block
{
    public tinOre()
    {
        super(Material.rock);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(3.0F);
        this.setResistance(10.0F);
        this.setStepSound(Block.soundTypeStone);
    }
}