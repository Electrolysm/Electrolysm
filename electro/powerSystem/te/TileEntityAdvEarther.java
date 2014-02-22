package assets.electrolysm.electro.powerSystem.te;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityAdvEarther extends TileEntityEarther
{
    @Override
    public boolean isFormed(World world, int x, int y, int z)
    {
        int id1 = world.getBlockId(x, y - 1, z);
        int id2 = world.getBlockId(x, y - 2, z);

        if (id1 == 0)
        {
            if (id2 == electrolysmCore.sulpuricAcid.blockID)
            {
                return true;
            }
        }

        return false;
    }
}
