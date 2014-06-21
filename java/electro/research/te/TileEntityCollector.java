package electro.research.te;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import java.util.Random;

/**
 * Created by Ben on 21/06/2014.
 */
public class TileEntityCollector extends TileEntity
{

    private String owner;
    private int tier;
    public int engValue;
    public int sciValue;

    public TileEntityCollector(int t)
    {
        this.tier = t;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        nbt.setString("owner", owner);
        nbt.setInteger("eng", engValue);
        nbt.setInteger("sci", sciValue);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        owner = nbt.getString("owner");
        engValue = nbt.getInteger("eng");
        sciValue = nbt.getInteger("sci");
    }

    public void setOwner(String username)
    {
        owner = username;
    }

    public String getOwner()
    {
        return owner;
    }

    int time = 0;
    int maxTime = 600;
    int finalTime = 600;

    @Override
    public void updateEntity()
    {
        maxTime = finalTime / this.tier;
        Random rand = new Random();
        if(time >= maxTime)
        {
            time = 0;
            if(rand.nextBoolean())
            {
                this.sciValue = this.sciValue + 1;
            }
            else
            {
                this.engValue = this.engValue + 1;
            }
        }
        else
        {
            time = time + 1;
        }
    }
}
