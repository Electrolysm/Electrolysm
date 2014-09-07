package electrolysm.api.powerSystem.tesla;

import electrolysm.api.CompareHandler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Clarky158 on 04/09/2014.
 */
public class Receiver implements IWorldMethods
{
    int[] dataArray = new int[5];
    int freqency;

    public Receiver(int dimID, int x, int y, int z, int freq) {
        dataArray = new int[]{dimID, x, y, z, freq};
        freqency = freq;
    }

    public int[] getWorldData() {
        return new int[]{dataArray[0], dataArray[1], dataArray[2], dataArray[3]};
    }

    public int getFreq() {
        return freqency;
    }


    @Override
    public World getWorld() {
        return null;
    }

    @Override
    public int x() {
        return dataArray[1];
    }

    @Override
    public int y() {
        return dataArray[2];
    }

    @Override
    public int z() {
        return dataArray[3];
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Receiver && CompareHandler.comparatorReceiver.compare(this, (Receiver)obj) == 0;
    }

    @Override
    public int hashCode() {
        int code = 1;
        for (int i = 0; i < dataArray.length; i++) {
            code = (37 * code) + dataArray[i];
        }
        return code;
    }

    public TERecievingCore getTileEntity() {
        TileEntity te = MinecraftServer.getServer().getEntityWorld().getTileEntity(x(), y(), z());
        if(te != null && te instanceof TERecievingCore && ((TERecievingCore) te).getFrequency() == getFreq()){
            return (TERecievingCore) te;
        }
        return null;
    }
}
