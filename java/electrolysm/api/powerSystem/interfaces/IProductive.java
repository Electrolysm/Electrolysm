package electrolysm.api.powerSystem.interfaces;

/**
 * Created by Ben on 18/07/2014.
 */

/**
 * Implemented by any tile entity that can produce teu.
 */
public interface IProductive
{
    /**
     * returns true if the producer can charge the core by an amount
     * @param teu
     * @return returns true if the producer can charge the core by an amount
     */
    public boolean canProduce(int teu);

    /**
     * adds an amount of teu to the core
     * @param teu
     */
    public void produce(int teu);
}
