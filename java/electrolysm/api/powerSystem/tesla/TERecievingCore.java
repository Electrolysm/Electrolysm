package electrolysm.api.powerSystem.tesla;

import electrolysm.api.powerSystem.interfaces.IConnector;
import electrolysm.api.powerSystem.interfaces.IPowerCore;
import electrolysm.api.powerSystem.interfaces.IReciever;
import electrolysm.api.powerSystem.prefab.TileEntityGenerator;
import electrolysm.api.powerSystem.prefab.TileEntityMachine;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Clarky158 on 30/08/2014.
 */
public class TERecievingCore extends TileEntity implements IReciever, IConnector, IPowerCore {
    @Override
    public int getTeU() {
        if(getTower() != null) {
            return getTower().getPower();
        }
        return 0;
    }

    @Override
    public boolean canHold(int teu) {
        return false;
    }

    @Override
    public TeslaTower getTower() {
        return TeslaTransmittingServer.getTeslaTower(worldObj.provider.dimensionId, xCoord, yCoord, zCoord, getFrequency(), getRange());
    }

    @Override
    public int getRange() {
        return 100;
    }

    @Override
    public int getFrequency() {
        return 0;
    }

    //Core

    private TileEntity[] adjConnections = new TileEntity[6];

    @Override
    public boolean canConnect(ForgeDirection from, Object source) {
        if(source instanceof TileEntity)
        {
            TileEntity te = (TileEntity)source;
            if(te instanceof IConnector)
            {
                IConnector con = (IConnector)te;
                adjConnections[from.ordinal()] = te;
                return con.canConnect(from.getOpposite());
            }
            adjConnections[from.ordinal()] = null;
        }
        adjConnections[from.ordinal()] = null;
        return false;
    }

    @Override
    public boolean canConnect(ForgeDirection side) {
        return true;
    }

    @Override
    public boolean[] getVisualConnections() {
        return new boolean[0];
    }

    @Override
    public TileEntity[] getAdjConnections() {
        return adjConnections;
    }

    @Override
    public float getAmps()
    {
        return 0;
    }

    @Override
    public float getMaxAmps() {
        return 0;
    }

    @Override
    public void setTeU(int teu) {
    }

    @Override
    public boolean canDrain(int teu)
    {
        return getTower() != null && getTeU() > teu;
    }

    @Override
    public void drainPower(int amount)
    {
    }

    @Override
    public void charge(int teu) {
    }

    @Override
    public void setFull() {
    }

    @Override
    public void setEmpty() {
    }

    @Override
    public boolean isCreative() {
        return false;
    }

    @Override
    public void registerOnNetwork(TileEntityMachine te) { }

    @Override
    public void registerOnNetwork(TileEntityGenerator te) { }

    @Override
    public void clearNetwork() { }

    @Override
    public void updateEntity() {

        for (byte i = 0; i < 6; i++)
        {
            ForgeDirection dir = ForgeDirection.getOrientation(i);
            this.canConnect(dir, this.worldObj.getTileEntity(this.xCoord + dir.offsetX, this.yCoord + dir.offsetY,
                    this.zCoord + dir.offsetZ));
        }
        if(worldObj.isRemote) { return; }

        //getDescriptionPacket();
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);

        if(this.getTeU() < 0) { setEmpty(); }
    }
}
