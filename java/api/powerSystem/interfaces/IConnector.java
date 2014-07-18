package api.powerSystem.interfaces;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Ben on 17/07/2014.
 */
public interface IConnector
{
    public boolean canConnect(ForgeDirection from, Object source);

    public boolean canConnect(ForgeDirection side);

    public boolean[] getVisualConnections();

    public TileEntity[] getAdjConnections();
}
