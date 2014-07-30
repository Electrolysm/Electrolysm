package api.powerSystem.interfaces;

import api.powerSystem.prefab.TEPowerCore;
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
 */
public interface IEnergyRelay
{
    public TEPowerCore findCore(World world, int x, int y, int z, int SideState);
}
