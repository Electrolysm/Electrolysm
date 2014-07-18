package api.powerSystem.prefab;

import api.powerSystem.interfaces.IConnector;
import api.powerSystem.interfaces.IPowerCore;
import api.powerSystem.TeU;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Ben on 18/07/2014.
 */
public class TEPowerCore extends TileEntity implements IConnector, IPowerCore
{

    private TeU teuData = new TeU(0);
    private TeU maxTeU = new TeU(20);

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
        int value = getTeU().getValue();
        float amps = (float)((value * Math.PI) / Math.E);
        amps = (float)(Math.sqrt(amps * Math.sin(amps)));

        return amps + getTeU().getValue();
    }

    @Override
    public TeU getTeU()
    {
        return this.teuData;
    }

    @Override
    public void setTeU(TeU teu) { this.teuData = teu; }

    @Override
    public boolean hasSuitablePower(TeU teu, float amps)
    {
        if(teu == null || this.getTeU() == null) { return false; }
        return (this.getTeU().getValue() >= teu.getValue()) && (this.getAmps() >= amps);
    }

    @Override
    public void drainPower(int amount)
    {
        this.setTeU(new TeU(this.getTeU().getValue() - amount));
    }

    @Override
    public void drainPower(TeU teu)
    {
        this.setTeU(new TeU(this.getTeU().getValue() - teu.getValue()));
    }

    @Override
    public boolean canHold(TeU teu) {
        return ((this.getTeU().getValue() + teu.getValue()) <= maxTeU.getValue());
    }

    @Override
    public void charge(TeU teu) {
        this.setTeU(new TeU(this.getTeU().getValue() + teu.getValue()));
    }

    @Override
    public void setFull() {
        this.setTeU(this.maxTeU);
    }

    @Override
    public void setEmpty() {
        this.setTeU(new TeU(0));
    }

    @Override
    public void updateEntity() {
        System.out.println("TeU" + this.getTeU().getValue());
        System.out.println("Amps" + this.getAmps());
    }
}
