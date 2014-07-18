package api.powerSystem.interfaces;

import api.powerSystem.prefab.TEPowerCore;
import net.minecraft.world.World;

/**
 * Created by Ben on 18/07/2014.
 */
public interface ITeUNetworkTE
{
    public TEPowerCore findCore(World world, int x, int y, int z);
}
