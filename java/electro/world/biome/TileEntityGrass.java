package electro.world.biome;

import electro.Electrolysm;
import electro.handlers.helpers.Utilities;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Clarky158 on 23/07/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class TileEntityGrass extends TileEntity {

    public void update(World world, int x, int y, int z, Random random) {
        if(random.nextInt(1000) == 5) {
            for(int dy = -1; dy < 1; dy++) {
                if (Utilities.Block.getBlock(world, x + 1, y + dy, z) == Blocks.grass) {
                    Utilities.Block.setBlock(world, x + 1, y + dy, z, Electrolysm.diseaseGrass);
                }
                if (Utilities.Block.getBlock(world, x - 1, y + dy, z) == Blocks.grass) {
                    Utilities.Block.setBlock(world, x - 1, y + dy, z, Electrolysm.diseaseGrass);
                }
                if (Utilities.Block.getBlock(world, x, y + dy, z + 1) == Blocks.grass) {
                    Utilities.Block.setBlock(world, x, y + dy, z + 1, Electrolysm.diseaseGrass);
                }
                if (Utilities.Block.getBlock(world, x, y + dy, z - 1) == Blocks.grass) {
                    Utilities.Block.setBlock(world, x, y + dy, z - 1, Electrolysm.diseaseGrass);
                }
            }
        }
    }

    @Override
    public void updateEntity() {
        update(worldObj, xCoord, yCoord, zCoord, new Random());
    }
}
