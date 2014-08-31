package electrolysm.api.powerSystem.prefab;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Clarky158 on 30/07/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class BlockEnergy  extends BlockContainer
{
    public BlockEnergy()
    {
        super(Material.iron);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return null;
    }

    @Override
    public Item getItemDropped(int i, Random rand, int i2) {
        return super.getItemDropped(i, rand, i2);
    }
}
