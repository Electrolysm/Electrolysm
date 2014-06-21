package electro.world;

import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class copperOre extends Block
{
    public copperOre()
    {
        super(Material.rock);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(3.0F);
        this.setResistance(10.0F);
        this.setStepSound(Block.soundTypeStone);
    }

    @Override
    public void registerBlockIcons(IIconRegister reg)
    {
        this.blockIcon = reg.registerIcon("electrolysm:" + "CopperOre");
    }
}
