package electro.crafting.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * Created by Ben on 05/07/2014.
 */
public class BlockCrafting extends Block
{
    String unlocalName;

    public BlockCrafting(float hardness, String name, Material material)
    {
        super(material);

        this.setBlockName(name);
        this.setHardness(hardness);
        unlocalName = name;
    }

    @Override
    public void registerBlockIcons(IIconRegister reg)
    {
        this.blockIcon = reg.registerIcon("electrolysm:" + unlocalName);
    }
}
