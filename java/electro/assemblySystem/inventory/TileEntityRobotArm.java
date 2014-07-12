package electro.assemblySystem.inventory;

import electro.Electrolysm;
import electro.assemblySystem.BlockMatrix;
import electro.handlers.network.RobotArmMessage;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

/**
 * Created by Ben on 06/07/2014.
 */
public class TileEntityRobotArm extends TileEntity
{
    public int STATE = 0;
    ForgeDirection direction;
    public float rotation = 0F;

    String[] defaults = new String[] {"place_rest", "rest", "working1", "working2"};
    double[] forearmAngles = new double[] {0, 1.2, -0.15, -0.05};
    double[] armAngles = new double[] {0, 0.45, -0.9, -1};
    public float forearm = 0F;
    public float arm = 0F;
    public boolean shouldWork;
    float workRotation = 0F;
    public boolean hasDone = false;
    public boolean isWelding = false;

    public void updateEntity()
    {
        new RobotArmMessage(this);

        Random rand = new Random();
        boolean canWork = worldObj.getBlock(xCoord, yCoord - 1, zCoord) == Electrolysm.roboticBase;

        if(!canWork) { return; }
        if(direction == ForgeDirection.UNKNOWN) { STATE = 0; shouldWork = false; workRotation = 0; }
        else {
            if(shouldWork) { STATE = 2; } else { STATE = 1; }
        }

        direction = this.getDirection();
        rotation = this.alterToDegree(getRotationFromDirs(direction) + workRotation, rotation);
        forearm = this.alterTo((float)(forearmAngles[STATE]), (float)forearm);
        arm = this.alterTo((float)(armAngles[STATE]), (float)arm);

    }

    String[] patterns = new String[] {"ARK", "LINE_HOR", "LINE_VERT"};
    String current_pattern = null;

    public void work()
    {
        Random rand = new Random();
        //if(!shouldWork) { STATE = 1; return; }
        //if(current_pattern == null) { current_pattern = patterns[/*rand.nextInt(patterns.length - 1)*/ 0]; }

        this.work("ARK");
    }

    public void work(String pattern)
    {
        if(pattern.contains("ARK"))
        {

        }
    }

    public void setState(int state)
    {
        this.STATE = state;
    }

    public float toRadians(float degrees)
    {
        return (degrees / 57.3F);
    }

    public float getRotationFromDirs(ForgeDirection direction)
    {
        switch (direction)
        {
            case SOUTH:
            {
                return 180;
            }
            case NORTH:
            {
                return 0;
            }
            case WEST:
            {
                return -90;
            }
            case EAST:
            {
                return 90;
            }
            case UNKNOWN:
            {
                return 0;
            }
            default:
            {
                return 0;
            }
        }
    }

    public float alterTo(float to, float from)
    {
        float upper = to + 0.01F;
        float lower = to - 0.01F;

        if(from > upper || from < lower) {
            if (to < from) {
                return (float)(from - 0.01);
            } else if (to > from) {
                return (float)(from + 0.01);
            }
        }

        return (float)to;
    }

    public float alterToDegree(float to, float from)
    {
        float upper = to + 1F;
        float lower = to - 1F;

        if(from > upper || from < lower) {
            if (to < from) {
                return (float)(from - 1);
            } else if (to > from) {
                return (float)(from + 1);
            }
        }

        return (float)to;
    }

    public ForgeDirection getDirection()
    {
        World world = worldObj;
        int x = xCoord; int y = yCoord - 1; int z = zCoord;

        Block SOUTH = world.getBlock(x, y, z + 1);
        Block NORTH = world.getBlock(x, y, z - 1);
        Block WEST = world.getBlock(x - 1, y, z);
        Block EAST = world.getBlock(x + 1, y, z);

        Block SOUTH1 = world.getBlock(x, y - 1, z + 1);
        Block NORTH1 = world.getBlock(x, y - 1, z - 1);
        Block WEST1 = world.getBlock(x - 1, y - 1, z);
        Block EAST1 = world.getBlock(x + 1, y - 1, z);

        if(SOUTH == Electrolysm.advancedCrafting) { return ForgeDirection.SOUTH; }
        else if(NORTH == Electrolysm.advancedCrafting) { return ForgeDirection.NORTH; }
        else if(WEST == Electrolysm.advancedCrafting) { return ForgeDirection.WEST; }
        else if(EAST == Electrolysm.advancedCrafting) { return ForgeDirection.EAST; }

        else if(SOUTH1 instanceof BlockMatrix) { return ForgeDirection.SOUTH; }
        else if(NORTH1 instanceof BlockMatrix) { return ForgeDirection.NORTH; }
        else if(WEST1 instanceof BlockMatrix) { return ForgeDirection.WEST; }
        else if(EAST1 instanceof BlockMatrix) { return ForgeDirection.EAST; }
        else { return ForgeDirection.UNKNOWN; }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        float[] saveData = new float[] {this.arm, forearm, this.rotation, this.workRotation};

        nbt.setInteger("state", STATE);
        nbt.setFloat("arm", saveData[0]);
        nbt.setFloat("forearm", saveData[1]);
        nbt.setFloat("rotation", saveData[2]);
        nbt.setFloat("workRotation", saveData[3]);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        STATE = nbt.getInteger("state");
        arm = nbt.getFloat("arm");
        forearm = nbt.getFloat("forearm");
        rotation = nbt.getFloat("rotation");
        workRotation = nbt.getFloat("workRotation");
    }
}
