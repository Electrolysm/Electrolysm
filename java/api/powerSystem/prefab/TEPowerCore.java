package api.powerSystem.prefab;

import api.powerSystem.interfaces.IConnector;
import api.powerSystem.interfaces.IPowerCore;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Clarky158 on 18/07/2014.
 */
public class TEPowerCore extends TileEntity implements IConnector, IPowerCore
{

    public int maxTeU = 100000;
    public int teuData = 0;
    private TileEntity[] adjConnections = new TileEntity[6];
    private int tier = 0;
    public boolean isCreative = false;

    public TEPowerCore(int tier1) {
        if (tier1 == (-1)) {
            isCreative = true;
            tier = -1;
        } else {
            tier = tier1;
            if (tier1 > 1) {
                maxTeU = 100000 * (((tier1) * 2) * 10);
            }
        }
    }

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
        return (float) Math.sqrt((Math.sqrt(this.getTeU()))) + getCompValue();
    }

    @Override
    public float getMaxAmps() {
        return (float)(Math.sqrt(this.maxTeU) / Math.PI);
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
        return (teuData > 0) || isCreative;// && (this.getAmps() >= amps);
    }

    @Override
    public void drainPower(int amount)
    {
        if(!isCreative) { this.setTeU(getTeU() - amount); }
    }

    @Override
    public boolean canHold(int teu) {
        return ((this.getTeU() + teu) <= maxTeU) || isCreative;
        //return true;
    }

    @Override
    public void charge(int teu) {
        if(!isCreative) { this.setTeU((this.getTeU() + teu)); }
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
    public boolean isCreative() {
        return isCreative;
    }

    @Override
    public void updateEntity() {

        if(worldObj.isRemote) { return; }

        for (byte i = 0; i < 6; i++)
        {
            ForgeDirection dir = ForgeDirection.getOrientation(i);
            this.canConnect(dir, this.worldObj.getTileEntity(this.xCoord + dir.offsetX, this.yCoord + dir.offsetY,
                    this.zCoord + dir.offsetZ));
        }

        if(this.getTeU() < 0) { setEmpty(); }
        if(this.getTeU() >= (maxTeU - 5)) { setFull(); }
        if(new Random().nextInt(50) == 5) { this.drainPower(1); }
        if(getAmps() > getMaxAmps() && !isCreative)
        {
            drainPower((int)(maxTeU * 0.001F));
            if(this.getTeU() <= 0) {
                worldObj.createExplosion(null, xCoord, yCoord, zCoord, 1, true);
            }
        }

        this.checkConnections();
    }

    public void checkConnections()
    {
        if(teList.size() == 0) { return; }
        for(int i = 0; i < teList.size(); i++)
        {
            if(worldObj.getTileEntity(teList.get(i).xCoord, teList.get(i).yCoord, teList.get(i).zCoord) != teList.get(i))
            {
                this.clearNetwork();
            }
            else if(teList.get(i) instanceof TileEntityGenerator)
            {
                TileEntityGenerator te = (TileEntityGenerator)teList.get(i);
                if(te.findCore(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord) != this)
                {
                    this.clearNetwork();
                }
            }
            else if(teList.get(i) instanceof TileEntityMachine)
            {
                TileEntityMachine te = (TileEntityMachine)teList.get(i);
                if(te.findCore(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord) != this)
                {
                    this.clearNetwork();
                }
            }
        }
    }

    public void ampAlgorithm()
    {
        if(this.getAmps() > this.getMaxAmps() && !isCreative)
        {
            float diff = getMaxAmps() - getAmps();
            float ampPerOver = (float)Math.sqrt(Math.PI);

            this.drainPower((int)(diff * ampPerOver));
/*
            if(diff > getMaxAmps())
            {
                System.out.println("Explosion");
                worldObj.createExplosion(null, xCoord, yCoord, zCoord, (int)(diff / ampPerOver), true);
            }*/
        }
    }

    List<TileEntity> teList = new ArrayList<TileEntity>();

    public void clearNetwork()
    {
        teList.clear();
    }

    public void registerOnNetwork(TileEntityMachine te)
    {
        if(!(teList.contains(te)))
        {
            teList.add(te);
        }
    }

    public void registerOnNetwork(TileEntityGenerator te)
    {
        if(!(teList.contains(te)))
        {
            teList.add(te);
        }
    }

    public int getCompValue()
    {
        int value = 1;
        for(int i = 0; i < teList.size(); i++)
        {
            if(teList.get(i) instanceof TileEntityGenerator)
            {
                value = value + 10;
            }
            if(teList.toArray()[i] instanceof TileEntityMachine)
            {
                value = value + 5;
            }
        }

        return value;
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
