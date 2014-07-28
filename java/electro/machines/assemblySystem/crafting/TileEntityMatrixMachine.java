package electro.machines.assemblySystem.crafting;

/**
 * Created by Ben on 10/07/2014.
 *//*
public class TileEntityMatrixMachine extends TileEntity
{
    int[] matrixLocation;
    int matrixX, matrixY, matrixZ;
    boolean isFuctional;


    public void setMatrixLocation(int[] location)
    {
        matrixLocation = location;
        matrixX = location[0];
        matrixY = location[1];
        matrixZ = location[2];
        notifyMatrix();
    }

    public TileEntityMatrix getMatrixTE()
    {
        return (TileEntityMatrix)(worldObj.getTileEntity(matrixX, matrixY, matrixZ));
    }

    public void notifyMatrix()
    {
        TileEntityMatrix gui = getMatrixTE();
        int numberOfArms = this.getNumberOfArms(worldObj, xCoord, yCoord, zCoord);
        gui.notify("MACHINE", numberOfArms, new int[] {xCoord, yCoord, zCoord});
    }

    public void returnNotify(String data)
    {
        if(data.contains("OK"))
        {
            isFuctional = true;
        }
        else if(data.contains("FAILED"))
        {
            isFuctional = false;
        }
    }

    public void notifyBuild(float speed)
    {
        List<int[]> armPosition = getArmPosition();

        for(int i = 0; i < armPosition.size(); i++)
        {
            TileEntityRobotArm gui = (TileEntityRobotArm)worldObj.getTileEntity(armPosition.get(i)[0], armPosition.get(i)[1], armPosition.get(i)[2]);
            gui.shouldWork = true;
        }
    }

    public List<int[]> getArmPosition()
    {
        List<int[]> list = new ArrayList<int[]>();

        if(worldObj.getTileEntity(xCoord + 1, yCoord + 1, zCoord) instanceof TileEntityRobotArm)
        { list.add(new int[] {xCoord + 1, yCoord + 1, zCoord}); }
        if(worldObj.getTileEntity(xCoord - 1, yCoord + 1, zCoord) instanceof TileEntityRobotArm)
        { list.add(new int[] {xCoord - 1, yCoord + 1, zCoord}); }
        if(worldObj.getTileEntity(xCoord, yCoord + 1, zCoord + 1) instanceof TileEntityRobotArm)
        { list.add(new int[] {xCoord, yCoord + 1, zCoord + 1}); }
        if(worldObj.getTileEntity(xCoord, yCoord + 1, zCoord - 1) instanceof TileEntityRobotArm)
        { list.add(new int[] {xCoord, yCoord + 1, zCoord - 1}); }

        return list;
    }



    public int getNumberOfArms(World world, int x, int y, int z)
    {
        int arms = 0;

        if(world.getTileEntity(x + 1, y + 1, z) instanceof TileEntityRobotArm) { arms = arms + 1; }
        if(world.getTileEntity(x - 1, y + 1, z) instanceof TileEntityRobotArm) { arms = arms + 1; }
        if(world.getTileEntity(x, y + 1, z + 1) instanceof TileEntityRobotArm) { arms = arms + 1; }
        if(world.getTileEntity(x, y + 1, z - 1) instanceof TileEntityRobotArm) { arms = arms + 1; }

        return arms;
    }
}*/
