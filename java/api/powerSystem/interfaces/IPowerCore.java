package api.powerSystem.interfaces;

import api.powerSystem.TeU;

/**
 * Created by Ben on 18/07/2014.
 */
public interface IPowerCore
{
    public float getAmps();

    public TeU getTeU();

    public void setTeU(TeU teu);

    public boolean hasSuitablePower(TeU teu, float amps);

    public void drainPower(int amount);

    public void drainPower(TeU teu);

    public boolean canHold(TeU teu);

    public void charge(TeU teu);

    public void setFull();

    public void setEmpty();
}
