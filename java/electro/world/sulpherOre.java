package electro.world;

import java.util.Random;

import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class sulpherOre extends Block
{
    public sulpherOre()
    {
        super(Material.rock);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(1F);
    }

    @Override
    public void registerBlockIcons(IIconRegister reg)
    {
        this.blockIcon = reg.registerIcon("electrolysm:" + "sulphureOre");
    }

    @Override
    public int quantityDropped(Random rand)
    {
        int dropped = rand.nextInt(8);

        if (dropped >= 5)
        {
            return dropped;
        }
        else
        {
            return 5;
        }
    }

    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return Electrolysm.sulphur;
    }
}
