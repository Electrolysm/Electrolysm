package api.powerSystem.interfaces;

/**
 * Created by Ben on 18/07/2014.
 */
public interface IPowerCore
{
    public float getAmps();

    public float getMaxAmps();

    public int getTeU();

    public void setTeU(int teu);

    public boolean canDrain(int teu);

    public void drainPower(int amount);

    public boolean canHold(int teu);

    public void charge(int teu);

    public void setFull();

    public void setEmpty();

    public boolean isCreative();
}
