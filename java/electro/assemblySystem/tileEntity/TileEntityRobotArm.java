package electro.assemblySystem.tileEntity;

import electro.Electrolysm;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Ben on 06/07/2014.
 */
public class TileEntityRobotArm extends TileEntity
{
    public int STATE = 0;
    ForgeDirection direction;


    public void updateEntity()
    {
        boolean canWork = worldObj.getBlock(xCoord, yCoord, zCoord) == Electrolysm.roboticBase;
        this.getBlockAdjacient();
    }

    public void getBlockAdjacient()
    {
        if(wor)
    }
}
