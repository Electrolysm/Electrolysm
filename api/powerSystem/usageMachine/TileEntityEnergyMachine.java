package assets.electrolysm.api.powerSystem.usageMachine;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.api.items.ItemFetcher;
import assets.electrolysm.api.powerSystem.TileEntityPlug;
import assets.electrolysm.api.powerSystem.meter.IMeterable;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.common.Loader;
/**
 * @author Clarky158
 * @Return Extend this file to allow usage of Tesla Energy Unit power. Remember to override the updateEntity() method
 * and to check canWork() before performing an operation. This way you will get the maximum out of the machine, and
 * prevents people exploiting the problem.
 */
public class TileEntityEnergyMachine extends TileEntity implements IEnergyMachine, IPullEnergy, IMeterable
{
    public boolean working;
    public static int activationEnergy;
    
    
    public void updateEntity()
    {
        if (Loader.isModLoaded("Electrolysm"))
        {
            this.canWork(worldObj, xCoord, yCoord, zCoord);
        }
    }

    @Override
    public boolean canWork(World world, int x, int y, int z)
    {
        if (this.isPowered(world, x, y, z))
        {
            if (this.getPlugRecievingTeU(world, x, y, z) >= this.getActivationEnergy())
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isPowered(World world, int x, int y, int z)
    {
        if (Loader.isModLoaded("Electrolysm"))
        {
            TileEntity teWorld = world.getBlockTileEntity(x, y - 1, z);

            if (teWorld instanceof TileEntityPlug)
            {
                TileEntityPlug te = (TileEntityPlug)teWorld;

                if (te.getRecievedTeUAfterResistance(world, x, y - 1, z) > 0)
                {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public float getPlugRecievingTeU(World world, int x, int y, int z)
    {
        if (Loader.isModLoaded("Electrolysm"))
        {
            TileEntity teWorld = world.getBlockTileEntity(x, y - 1, z);

            if (teWorld instanceof TileEntityPlug)
            {
                TileEntityPlug te = (TileEntityPlug)teWorld;
                return te.getRecievedTeUAfterResistance(world, x, y - 1, z);
            }
        }

        return 0;
    }
    
    @Override
    public int getActivationEnergy()
    {
        return activationEnergy;
    }
    
    public boolean setActivationEnergy(int energyTeU)
    {
    	if(energyTeU < 0)
    	{
    		activationEnergy = energyTeU;
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    

    @Override
    public boolean isWorking()
    {
        return working;
    }
}