package electrolysm.api.powerSystem.tesla;

import electrolysm.api.powerSystem.interfaces.IConnector;
import electrolysm.api.powerSystem.interfaces.IPowerCore;
import electrolysm.api.powerSystem.interfaces.IReciever;
import electrolysm.api.powerSystem.prefab.TEPowerCore;
import electrolysm.api.powerSystem.prefab.TileEntityGenerator;
import electrolysm.api.powerSystem.prefab.TileEntityMachine;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Clarky158 on 30/08/2014.
 */
public class TERecievingCore extends TileEntity implements IReciever, IConnector, IPowerCore {

    private int teu = 0;
    private int frequency = 0;

    @Override
    public int getTeU() {
        if(getTower() != null && isBuilt()) {
            return teu = (((getTower().getPower() - (int)(this.getDistanceFrom((double)getTower().x(),
                    (double)getTower().y(), (double)getTower().z()) * 0.005))));
        }
        return 0;
    }

    private boolean isBuilt() {
        return worldObj.getTileEntity(xCoord, yCoord + 1, zCoord) instanceof IAerial;
    }

    @Override
    public boolean canHold(int teu) {
        return false;
    }

    @Override
    public TeslaTower getTower() {
        return TeslaTransmittingServer.getTeslaTower(worldObj, xCoord, yCoord, zCoord, getFrequency(), getRange());
    }

    @Override
    public int getRange() {
        return 100;
    }

    //Needs to balance

    @Override
    public int getFrequency() {
        return frequency;
    }

    @Override
    public Receiver makeReceiver() {
        return null;
    }

    public void setFrequency(int frequency) {
        if(!worldObj.isRemote) {
            TeslaTransmittingServer.clearTileEntities();
        }
        this.frequency = frequency;
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
        teu = getTeU() - amount;
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
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        if(worldObj.isRemote) { return; }

        for(int i = 0; i < adjConnections.length; i++) {
            if (adjConnections[i] instanceof TEPowerCore && ((TEPowerCore)adjConnections[i]).canHold(50) && this.canDrain(50)){
                this.drainPower(50);
                ((TEPowerCore)adjConnections[i]).charge(50);
            }
        }
        if(getTower() != null && worldObj != null) {
            TileEntity te = worldObj.getTileEntity(getTower().x(), getTower().y(), getTower().z());
            if (te != null && te instanceof TETeslaTower && this.getTeU() > 0 && isBuilt()) {
                ((TETeslaTower) te).registerReciever(new Receiver(worldObj.provider.dimensionId, xCoord, yCoord, zCoord, frequency));
            }
        }
        //if(this.getTeU() < 0) { setEmpty(); }
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setInteger("frequency", frequency);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        frequency = (pkt.func_148857_g().getInteger("frequency"));
        super.onDataPacket(net, pkt);
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);

        tag.setInteger("frequency", frequency);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        frequency = tag.getInteger("frequency");
    }
}
