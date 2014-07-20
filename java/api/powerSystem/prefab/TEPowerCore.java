package api.powerSystem.prefab;

import api.powerSystem.interfaces.ICable;
import api.powerSystem.interfaces.IConnector;
import api.powerSystem.interfaces.IPowerCore;
import api.powerSystem.TeU;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;

/**
 * Created by Ben on 18/07/2014.
 */
public class TEPowerCore extends TileEntity implements IConnector, IPowerCore
{

    private int teuData = 0;
    private int maxTeU = 100000;
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
        return (float)(Math.abs(Math.sin(getTeU())));
    }

    @Override
    public int getTeU()
    {
        return teuData;
    }

    @Override
    public void setTeU(int teu) {
        this.teuData = teu;
    }

    @Override
    public boolean hasSuitablePower(int teu, float amps)
    {
        return (teuData > 0);// && (this.getAmps() >= amps);
    }

    @Override
    public void drainPower(int amount)
    {
        this.setTeU(getTeU() - amount);
    }

    @Override
    public boolean canHold(int teu) {
        return ((this.getTeU() + teu) <= maxTeU);
        //return true;
    }

    @Override
    public void charge(int teu) {
        this.setTeU((this.getTeU() + teu));
    }

    @Override
    public void setFull() {
        this.setTeU(this.maxTeU);
    }

    @Override
    public void setEmpty() {
        this.setTeU((0));
    }

    @Override
    public void updateEntity() {

        for (byte i = 0; i < 6; i++)
        {
            ForgeDirection dir = ForgeDirection.getOrientation(i);
            this.canConnect(dir, this.worldObj.getTileEntity(this.xCoord + dir.offsetX, this.yCoord + dir.offsetY,
                    this.zCoord + dir.offsetZ));
        }

        if(this.getTeU() < 0) { setEmpty(); }

    }

    public void shareWithCores(ArrayList<TEPowerCore> coreList)
    {
        int size = coreList.size() + 1;
        int teuPerCore = getTeU() / size;

        this.setTeU(teuPerCore);
        for(int i = 0; i < coreList.size(); i++)
        {
            coreList.get(i).charge(teuPerCore);
        }
    }

    public ArrayList<TEPowerCore> findOtherCores()
    {
        ArrayList<TEPowerCore> coreList = new ArrayList<TEPowerCore>();
        TileEntity[] adj = this.adjConnections;
        for (int i = 0; i < adj.length; i++) {
            if (adj[i] != null && adj[i] instanceof IConnector) {
                IConnector connector = (IConnector) adj[i];
                if (adj[i] instanceof TEPowerCore && !this.checkCoords(adj[i])) {
                    coreList.add((TEPowerCore) adj[i]);
                } else {
                    if (adj[i] instanceof ICable && !this.checkCoords(adj[i])) {
                        ICable cable = (ICable) adj[i];
                        coreList.add(cable.findCore(ForgeDirection.getOrientation(i).getOpposite(), 0));
                    }
                }
            }
        }
        return coreList;
    }

    public boolean checkCoords(TileEntity te)
    {
        return ((this.xCoord == te.xCoord) && (this.yCoord == te.yCoord) && (this.zCoord == te.zCoord));
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setInteger("teuCurrent", teuData);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        teuData = nbt.getInteger("teuCurrent");
    }
}
