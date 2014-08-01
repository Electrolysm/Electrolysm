package api.powerSystem.interfaces;

import api.powerSystem.prefab.TEPowerCore;
import net.minecraft.world.World;

/**
 * Created by Ben on 18/07/2014.
 */
public interface ITeUNetworkTE
{
    /**
     * Called by a tile entity, to find the core that power should be added to or drawn from.
     * @param world
     * @param x
     * @param y
     * @param z
     * @return
     */
    public TEPowerCore findCore(World world, int x, int y, int z);
}
