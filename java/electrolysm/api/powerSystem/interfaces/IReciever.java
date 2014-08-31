package electrolysm.api.powerSystem.interfaces;

import electrolysm.api.powerSystem.tesla.TeslaTower;

/**
 * Created by Clarky158 on 30/08/2014.
 */
public interface IReciever
{
    public TeslaTower getTower();

    public int getRange();

    public int getFrequency();
}
