package assets.electrolysm.electro.block.advMachines.te;

import cpw.mods.fml.common.Loader;
import assets.electrolysm.api.powerSystem.usageMachine.TileEntityEnergyMachine;

public class TileEntityCharger extends TileEntityEnergyMachine
{
    public int getActivationEnergy()
    {
        return 250;
    }
}
