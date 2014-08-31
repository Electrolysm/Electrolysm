package electrolysm.api.powerSystem.tesla;

import electrolysm.api.CompareHandler;
import net.minecraft.world.World;

/**
 * Created by Clarky158 on 01/08/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class TeslaTower implements IWorldMethods{
    int[] dataArray = new int[6];
    int power;
    int freqency;

    public TeslaTower(int dimID, int x, int y, int z, int power1, int freq) {
        dataArray = new int[]{dimID, x, y, z, power1, freq};
        power = power1;
        freqency = freq;
    }

    public int[] getWorldData() {
        return new int[]{dataArray[0], dataArray[1], dataArray[2], dataArray[3]};
    }

    public int getPower() {
        return power;
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
        return obj instanceof TeslaTower && CompareHandler.comparatorTeslaTower.compare(this, (TeslaTower)obj) == 0;
    }
}
