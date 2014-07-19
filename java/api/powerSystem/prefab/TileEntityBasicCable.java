package api.powerSystem.prefab;

import api.powerSystem.interfaces.ICable;
import api.powerSystem.interfaces.IConnector;
import codechicken.multipart.TileMultipart;
import codechicken.multipart.TileMultipart$;
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
    public TEPowerCore findCore(ForgeDirection exclude, int clicks) {
        TileEntity[] adj = this.adjacentConnections;
        TEPowerCore[] coreArray = new TEPowerCore[6];
        for (int i = 0; i < adj.length; i++) {
            clicks++;
            if (i != exclude.ordinal() && adj[i] != null && adj[i] instanceof IConnector && clicks <= 500) {
                IConnector connector = (IConnector) adj[i];
                if (adj[i] instanceof TEPowerCore) {
                    return (TEPowerCore) adj[i];
                } else {
                    if (adj[i] instanceof ICable) {
                        ICable cable = (ICable) adj[i];
                        TEPowerCore te = cable.findCore(ForgeDirection.getOrientation(i).getOpposite(), clicks);
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