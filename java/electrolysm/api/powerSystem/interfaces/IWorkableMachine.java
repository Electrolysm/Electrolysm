package electrolysm.api.powerSystem.interfaces;

/**
 * Created by Ben on 18/07/2014.
 */

/**
 * implemented by a machine that uses teu
 */
public interface IWorkableMachine
{
    /**
     * returns true if the machine can work
     * @param teu
     * @return
     */
    public boolean canWork(int teu);

    /**
     * drains a amount to teu from a core
     * @param teu
     */
    public void work(int teu);
}
