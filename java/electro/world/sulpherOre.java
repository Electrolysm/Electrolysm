package electro.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import assets.electrolysm.electro.electrolysmCore;

public class sulpherOre extends Block
{
    public sulpherOre(int id, Material mat)
    {
        super(id, Material.rock);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName("sulphurOre");
        this.setHardness(1F);
    }

    public void registerIcons(IconRegister reg)
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
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return electrolysmCore.sulphur.itemID;
    }
}
