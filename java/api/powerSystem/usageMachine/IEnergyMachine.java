package api.powerSystem.usageMachine;

import net.minecraft.world.World;

public interface IEnergyMachine
{
    boolean canWork(World world, int x, int y, int z);

    boolean isPowered(World world, int x, int y, int z);
}