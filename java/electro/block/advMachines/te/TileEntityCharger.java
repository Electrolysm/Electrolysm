package electro.block.advMachines.te;

import cpw.mods.fml.common.Loader;
import api.powerSystem.usageMachine.TileEntityEnergyMachine;

public class TileEntityCharger extends TileEntityEnergyMachine
{
    public int getActivationEnergy()
    {
        return 250;
    }
}