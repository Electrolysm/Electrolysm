package electrolysm.api.powerSystem.interfaces;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Ben on 17/07/2014.
 */
public interface IConnector
{
    /**
     * Should be called every tick, in every direction, to update the adjacent connections.
     * @param from
     * @param source
     * @return
     */
    public boolean canConnect(ForgeDirection from, Object source);

    /**
     * Should be called by canConnect(from, source) to check that the adjacent tile entity
     * should connect the the tile entity it's being called by.
     * @param side
     * @return
     */
    public boolean canConnect(ForgeDirection side);

    /**
     * Gets an array of booleans to which the id is equal to whether it can connect to the block.
     * @return
     */
    public boolean[] getVisualConnections();

    /**
     * The same as getVisualConnections() but with a tile entity array
     * @return
     */
    public TileEntity[] getAdjConnections();
}
