package api.powerSystem.prefab;

import api.powerSystem.interfaces.IConnector;
import api.powerSystem.interfaces.IPowerCore;
import api.powerSystem.TeU;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Ben on 18/07/2014.
 */
public class TEPowerCore extends TileEntity implements IConnector, IPowerCore
{

    private int teuData = 0;
    private int maxTeU = 100000;

    @Override
    public boolean canConnect(ForgeDirection from, Object source) {
        return true;
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
        return new TileEntity[0];
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

        if(this.getTeU() < 0) { setEmpty(); }
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
