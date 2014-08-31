package electrolysm.api.powerSystem.interfaces;

import net.minecraft.world.World;

/**
 * Created by Clarky158 on 30/07/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 *
 * Implemented by any tile entity that is an energy relay.
 */
public interface IEnergyRelay
{
    /**
     * Called by a tile entity, to find the core that power should be added to or drawn from.
     * @param world
     * @param x
     * @param y
     * @param z
     * @param SideState
     * @return
     */
    public IPowerCore findCore(World world, int x, int y, int z, int SideState);
}
