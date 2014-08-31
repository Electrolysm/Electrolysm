package electrolysm.api.powerSystem.prefab;

import electrolysm.api.powerSystem.interfaces.ICable;
import electrolysm.api.powerSystem.interfaces.IConnector;
import electrolysm.api.powerSystem.interfaces.IPowerCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;


public class TileEntityBasicCable extends TileEntity implements ICable {

    protected boolean[] visuallyConnected = new boolean[6];
    protected TileEntity[] adjacentConnections = new TileEntity[6];

    @Override
    public float getMaxTeu() {
        return 10000;
    }

    @Override
    public float getMaxResistance() {
        return 10000;
    }

    @Override
    public IPowerCore findCore(ForgeDirection exclude, int clicks) {
        TileEntity[] adj = this.adjacentConnections;
        int click = clicks + 1;
        for (int i = 0; i < adj.length; i++) {
            if (i != exclude.ordinal() && adj[i] != null && adj[i] instanceof IConnector && click <= 250) {
                if (adj[i] instanceof IPowerCore) {
                    return (IPowerCore) adj[i];
                } else {
                    if (adj[i] instanceof ICable) {
                        ICable cable = (ICable) adj[i];
                        IPowerCore te = cable.findCore(ForgeDirection.getOrientation(i).getOpposite(), click);
                        if(i == (adj.length - 1) && te == null) { return null; }
                        else if(te == null) {  }
                        else if(te != null) { return te; }
                    }
                }
            }
        }
        return null;
    }
}