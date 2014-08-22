package electrolysm.api.powerSystem.tesla;

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
public abstract interface ITeslaTower extends IWorldMethods{
    public abstract int getTransmitPower();

    public abstract boolean isFormed(World world, int x, int y, int z);

    public boolean canDistribute(World world, int x, int y, int z);

    public abstract void doNegativeAffects(World world, int x, int y, int z);

    public void transmitPower(World world, int x, int y, int z, int power, int frequency);

    public TeslaTower getCode();

    public int getFreqency();
}