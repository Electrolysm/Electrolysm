package assets.electrolysm.electro.powerSystem.generators.te;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import universalelectricity.api.CompatibilityModule;
import universalelectricity.api.UniversalClass;
import universalelectricity.api.energy.EnergyStorageHandler;
import universalelectricity.api.energy.IEnergyContainer;
import universalelectricity.api.energy.IEnergyInterface;
import universalelectricity.api.vector.Vector3;

@UniversalClass
public class TileEntityProducer extends TileEntity implements IEnergyInterface, IEnergyContainer
{
  public EnergyStorageHandler energy;

  public TileEntityProducer(long producing)
  {
    super();
    energy = new EnergyStorageHandler(producing * 1000);
  }

  public boolean canConnect(ForgeDirection direction, Object obj)
  {
    if (CompatibilityModule.isHandler(obj))
    {
      if ((direction == null) || (direction.equals(ForgeDirection.UNKNOWN)))
      {
        return false;
      }

      return (getInputDirections().contains(direction)) || (getOutputDirections().contains(direction));
    }

    return false;
  }

  public void readFromNBT(NBTTagCompound nbt)
  {
    super.readFromNBT(nbt);
    if (this.energy != null)
    {
      this.energy.readFromNBT(nbt);
    }
  }

  public void writeToNBT(NBTTagCompound nbt)
  {
    super.writeToNBT(nbt);
    if (this.energy != null)
    {
      this.energy.writeToNBT(nbt);
    }
  }

  public long getEnergy(ForgeDirection from)
  {
    if (this.energy != null)
    {
      return this.energy.getEnergy();
    }

    return 0L;
  }

  public long getEnergyCapacity(ForgeDirection from)
  {
    if (this.energy != null)
    {
      return this.energy.getEnergyCapacity();
    }

    return 0L;
  }

  public long onReceiveEnergy(ForgeDirection from, long receive, boolean doReceive)
  {
    if ((this.energy != null) && ((from == ForgeDirection.UNKNOWN) || (getInputDirections().contains(from))))
    {
      return this.energy.receiveEnergy(receive, doReceive);
    }

    return 0L;
  }

  public long onExtractEnergy(ForgeDirection from, long extract, boolean doExtract)
  {
    if ((this.energy != null))
    {
      return this.energy.extractEnergy(extract, doExtract);
    }

    return 0L;
  }

  public void setEnergy(ForgeDirection from, long energy)
  {
    if (this.energy != null)
      this.energy.setEnergy(energy);
  }

  protected long produce(long outputEnergy)
  {
    long usedEnergy = 0L;

    for (ForgeDirection direction : getOutputDirections())
    {
      if (outputEnergy > 0L)
      {
        TileEntity tileEntity = new Vector3(this).translate(direction).getTileEntity(this.worldObj);

        if (tileEntity != null)
        {
          usedEnergy += CompatibilityModule.receiveEnergy(tileEntity, direction.getOpposite(), outputEnergy, true);
        }
      }
    }

    return usedEnergy;
  }

  protected long produce()
  {
    long totalUsed = 0L;

    for (ForgeDirection direction : getOutputDirections())
    {
      if (this.energy.getEnergy() > 0L)
      {
        TileEntity tileEntity = new Vector3(this).translate(direction).getTileEntity(this.worldObj);

        if (tileEntity != null)
        {
          long used = CompatibilityModule.receiveEnergy(tileEntity, direction.getOpposite(), this.energy.extractEnergy(this.energy.getEnergy(), false), true);
          totalUsed += this.energy.extractEnergy(used, true);
        }
      }
    }

    return totalUsed;
  }
  
  
  public List<ForgeDirection> getInputDirections()
  {
	  List<ForgeDirection> dirs = new ArrayList<ForgeDirection>();

    for (int i = 0; i < 6; i++)
    {
    	dirs.add(i, ForgeDirection.VALID_DIRECTIONS[i]);
    }

    return dirs;
  }

  public List<ForgeDirection> getOutputDirections()
  {
	  List<ForgeDirection> dirs = new ArrayList<ForgeDirection>();

    for (int i = 0; i < 6; i++)
    {
    	dirs.add(i, ForgeDirection.VALID_DIRECTIONS[i]);
    }

    return dirs;
  }
}