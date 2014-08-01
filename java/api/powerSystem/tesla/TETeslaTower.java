package api.powerSystem.tesla;

import api.powerSystem.interfaces.IWorkableMachine;
import api.powerSystem.prefab.TEPowerCore;
import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
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
public class TETeslaTower extends TileEntity implements ITeslaTower, IWorkableMachine{

    private TEPowerCore powerCore = null;

    @Override
    public int getTransmitPower()
    {
        return 100;
    }

    @Override
    public boolean isFormed(World world, int x, int y, int z) {
        Block copperCoil = Blocks.bedrock;//Electrolysm.largeCopperCoil;
        Block ironFrame = Electrolysm.ironFrames;

        if(world.canBlockSeeTheSky(x, y + 1, z))
        {
            if(world.getBlock(x, y - 1, z) == ironFrame)
            {
                if(world.getBlock(x, y - 2, z) == ironFrame)
                {
                    if(world.getBlock(x, y - 3, z) == ironFrame)
                    {
                        if(world.getBlock(x, y - 4, z) == ironFrame)
                        {
                            if(world.getTileEntity(x, y - 5, z) instanceof TEPowerCore)
                            {
                                for(int xx = -1; xx <= 1; xx++)
                                {
                                    for(int zz = -1; zz <= 1; zz++)
                                    {
                                        if(zz == 0 && xx == 0)
                                        {}
                                        else
                                        {
                                            if(world.getBlock(x + xx, y - 1, z + zz) == copperCoil)
                                            {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean canDistribute(World world, int x, int y, int z) {
        return isFormed(world, x, y, z) && this.canWork(getTransmitPower()) && isFormed(world, x, y, z);
    }

    @Override
    public void doNegativeAffects(World world, int x, int y, int z) {
        //TODO
    }

    @Override
    public void transmitPower(World world, int x, int y, int z, int power, int frequency) {
        TeslaTower tt = this.getCode();
        if (!getWorldObj().isRemote) {
            if (this.canWork(getTransmitPower())) {
                if (this.canDistribute(world, x, y, z)) {
                    work(getTransmitPower());
                    TeslaTransmittingServer.registerSendingTesla(tt);
                    return;
                }
            }
        }
        TeslaTransmittingServer.removeTesla(tt);
        return;
    }

    @Override
    public TeslaTower getCode() {
        return new TeslaTower(getWorld().provider.dimensionId, x(), y(), z(), getTransmitPower(), getFreqency());
    }

    @Override
    public int getFreqency() {
        return 0;
    }

    @Override
    public boolean canWork(int teu) {
        if(powerCore != null) {
            return (powerCore.canDrain(teu));
        }

        return false;
    }

    @Override
    public void work(int teU) {
        if(powerCore != null && powerCore.canDrain(teU))
        {
            powerCore.drainPower(teU);
        }
    }

    @Override
    public World getWorld() {
        return this.getWorldObj();
    }

    @Override
    public int x() {
        return xCoord;
    }

    @Override
    public int y() {
        return yCoord;
    }

    @Override
    public int z() {
        return zCoord;
    }

    @Override
    public void updateEntity() {
        keepChunkLoaded();
        this.transmitPower(getWorld(), x(), y(), z(), getTransmitPower(), getFreqency());
        powerCore = getPowerCore();
    }

    public void keepChunkLoaded()
    {
        getWorld().getChunkProvider().loadChunk(x(), z());
    }

    public TEPowerCore getPowerCore() {
        if(getWorld().getTileEntity(x(), y() - 5, z()) instanceof TEPowerCore) {
            return (TEPowerCore)(getWorld().getTileEntity(x(), y() - 5, z()));
        }
        return null;
    }

}
