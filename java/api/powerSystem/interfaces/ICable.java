package api.powerSystem.interfaces;

import api.powerSystem.prefab.TEPowerCore;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Ben on 17/07/2014.
 */
public interface ICable
{
    public float getMaxTeu();

    public float getMaxResistance();

    public TEPowerCore findCore(ForgeDirection exclude, int clicks);
}
