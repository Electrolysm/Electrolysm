package electro.handlers.helpers;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

/**
 * Created by Clarky158 on 18/06/2014.
 */
public class Utilities
{
    public static class Block {
        public static net.minecraft.block.Block getBlock(World world, int x, int y, int z) {
            return (world.getBlock(x, y, z));
        }

        public static void setBlock(World world, int x, int y, int z, net.minecraft.block.Block block) {
            world.setBlock(x, y, z, block);
        }

        public static Material getBlockMaterial(World world, int x, int y, int z) {
            return (getBlock(world, x, y, z).getMaterial());
        }
    }

    public static class Math {
        public static float calculatePi(int accuracy) {
            return 0F;
        }
    }
}
