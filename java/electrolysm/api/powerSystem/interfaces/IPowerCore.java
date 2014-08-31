package electrolysm.api.powerSystem.interfaces;

/**
 * Created by Ben on 18/07/2014.
 */

import electrolysm.api.powerSystem.prefab.TileEntityGenerator;
import electrolysm.api.powerSystem.prefab.TileEntityMachine;

/**
 * Implemented by any tile entity that will store energy
 */
public interface IPowerCore
{
    /**
     * @return (float) Math.sqrt((Math.sqrt(this.getTeU()))) + getCompValue();
     */
    public float getAmps();

    /**
     * @return (Math.sqrt(this.maxTeU) / Math.PI)
     */
    public float getMaxAmps();

    /**
     * @return the amount of TeU currently stored in the core
     */
    public int getTeU();

    /**
     * sets the current teu to teu
     * @param teu
     */
    public void setTeU(int teu);

    /**
     * @param teu
     * @return true if the currently stored teu take param teu is greater or equal to 0
     */
    public boolean canDrain(int teu);

    /**
     *  drains an amount of energy from the storage
     * @param amount
     */
    public void drainPower(int amount);

    /**
     * @param teu
     * @return return true if it can hold a teu amount without exceeding the max teu
     */
    public boolean canHold(int teu);

    /**
     * adds a teu amount to the currently stored teu
     * @param teu
     */
    public void charge(int teu);

    /**
     * sets the stored teu to the max teu
     */
    public void setFull();

    /**
     * sets the stored teu to 0
     */
    public void setEmpty();

    /**
     * @return returns true if this core is a creative core
     */
    public boolean isCreative();

    public void registerOnNetwork(TileEntityMachine te);

    public void registerOnNetwork(TileEntityGenerator te);

    public void clearNetwork();
}
