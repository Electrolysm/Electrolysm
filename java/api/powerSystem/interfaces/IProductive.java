package api.powerSystem.interfaces;

import api.powerSystem.TeU;

/**
 * Created by Ben on 18/07/2014.
 */
public interface IProductive
{
    public boolean canProduce(int teu);

    public void produce(int teu);
}
