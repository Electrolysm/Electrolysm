package electrolysm.api.powerSystem.interfaces;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Ben on 17/07/2014.
 *
 * Impelement for any TileEntity that is a cable
 */
public interface ICable
{
    /**
     * @return the max amount of TeU that the cable can hold
     */
    public float getMaxTeu();

    /**
     * @return return the amount of amps that a cable can handle
     */
    public float getMaxResistance();

    /**
     * Called by a tile entity, to find the core that power should be added to or drawn from.
     * @param exclude
     * @param clicks
     * @return returns the TEPowerCore that the cable network has foun d
     */
    public IPowerCore findCore(ForgeDirection exclude, int clicks);
}
