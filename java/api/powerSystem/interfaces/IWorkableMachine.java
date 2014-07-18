package api.powerSystem.interfaces;

import api.powerSystem.TeU;
import net.minecraft.world.World;

/**
 * Created by Ben on 18/07/2014.
 */
public interface IWorkableMachine
{
    public boolean canWork(int teu);

    public void work(int teu);
}
