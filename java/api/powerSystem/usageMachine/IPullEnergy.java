package assets.electrolysm.api.powerSystem.usageMachine;

import net.minecraft.world.World;

public interface IPullEnergy
{
    float getPlugRecievingTeU(World world, int x, int y, int z);

    int getActivationEnergy();
}
