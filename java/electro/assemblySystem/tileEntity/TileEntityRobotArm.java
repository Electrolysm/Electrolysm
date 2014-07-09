package electro.assemblySystem.tileEntity;

import electro.Electrolysm;
import electro.assemblySystem.roboticArm;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import javax.swing.text.StyledEditorKit;
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
    boolean shouldWork;
    float workRotation = 0F;
    public boolean hasDone = false;
    public boolean isWelding = false;

    public void updateEntity()
    {
        Random rand = new Random();
        boolean canWork = worldObj.getBlock(xCoord, yCoord - 1, zCoord) == Electrolysm.roboticBase;

        shouldWork = true;

        if(!canWork) { return; }
        if(direction == ForgeDirection.UNKNOWN) { STATE = 0; workRotation = 0; } else { STATE = 1; this.work(); }

        direction = this.getDirection();
        rotation = this.alterToDegree(getRotationFromDirs(direction) + workRotation, rotation);
        forearm = this.alterTo((float)(forearmAngles[STATE]), (float)forearm);
        arm = this.alterTo((float)(armAngles[STATE]), (float)arm);

        //System.out.println(forearm + ":" + arm);
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

        if(SOUTH == Electrolysm.advancedCrafting) { return ForgeDirection.SOUTH; }
        else if(NORTH == Electrolysm.advancedCrafting) { return ForgeDirection.NORTH; }
        else if(WEST == Electrolysm.advancedCrafting) { return ForgeDirection.WEST; }
        else if(EAST == Electrolysm.advancedCrafting) { return ForgeDirection.EAST; }
        else { return ForgeDirection.UNKNOWN; }
    }
}
