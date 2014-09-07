package electrolysm.api.powerSystem.tesla;

import electrolysm.api.items.Fetcher;
import electrolysm.api.powerSystem.interfaces.IWorkableMachine;
import electrolysm.api.powerSystem.prefab.TEPowerCore;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockStone;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
public class TETeslaTower extends TileEntity implements ITeslaTower, IWorkableMachine {

    private TEPowerCore powerCore = null;
    public boolean isTransmitting = false;
    private boolean goodFrequency = true;
    private int frequency = 0;
    private int lastFreq;
    private boolean lastGoodFreq;
    private boolean lastTransmitting;

    @Override
    public int getTransmitPower() {
        int FULL = 100;
        if (receiverList.size() == 1 || receiverList.size() == 0) {
            return FULL;
        } else {
            return FULL / receiverList.size();
        }
    }

    @Override
    public boolean isFormed(World world, int x, int y, int z) {
        Block copperCoil = Block.getBlockFromItem(Fetcher.getItem("copperCoil", 1).getItem());
        Block ironFrame = Block.getBlockFromItem(Fetcher.getItem("ironFrames", 1).getItem());

        if (world.canBlockSeeTheSky(x, y + 1, z)) {
            if (world.getBlock(x, y - 1, z) == ironFrame) {
                if (world.getBlock(x, y - 2, z) == ironFrame) {
                    if (world.getBlock(x, y - 3, z) == ironFrame) {
                        if (world.getBlock(x, y - 4, z) == ironFrame) {
                            if (world.getTileEntity(x, y - 5, z) instanceof TEPowerCore) {
                                for (int xx = -1; xx <= 1; xx++) {
                                    for (int zz = -1; zz <= 1; zz++) {
                                        if (zz == 0 && xx == 0) {
                                        } else {
                                            if (world.getBlock(x + xx, y - 1, z + zz) == copperCoil) {
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
        return isFormed(world, x, y, z) && this.canWork(getTransmitPower()) && this.getFrequency() > 0 && goodFrequency;
    }

    @Override
    public void doNegativeAffects(World world, int x, int y, int z) {
        //TODO
    }

    private float[] calculateNegativeRatio(World world, int x, int y, int z, EntityPlayer player) {
        //TODO
        float distance = TeslaTransmittingServer.calculateDistance(player.posX, player.posY, player.posY, x, y, z);
        int weight = calculatePlayerWeight(player.inventory);
        return new float[]{weight, (float) Math.pow(distance, 1.8)};
    }

    private int calculatePlayerWeight(InventoryPlayer inventory) {
        int weight = 1;
        for (int i = 0; i < inventory.mainInventory.length; i++) {
            if (inventory.mainInventory[i] != null) {
                weight = weight + (2 * inventory.mainInventory[i].stackSize);
            }
        }
        return weight;
    }

    public EntityLightningBolt spawnLighningBolt(World world, double x, double y, double z) {
        Random rand = new Random();
        EntityLightningBolt bolt = new EntityLightningBolt(world, x, y, z);
        EntityLightningBolt entity = bolt;
        bolt.setLocationAndAngles(x, y, z, MathHelper
                .wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
        //world.spawnEntityInWorld(bolt);
        if (world.isRemote) {
            this.worldObj.playSoundEffect(x, y, z, "ambient.weather.thunder1",
                    10000.0F, 0.8F + rand.nextFloat() * 0.2F);
            this.worldObj.playSoundEffect(x, y, z, "random.explode1",
                    2.0F, 0.5F + rand.nextFloat() * 0.2F);
        }
        return bolt;
    }


    @Override
    public void transmitPower(World world, int x, int y, int z, int power, int frequency) {
        if (lastFreq != frequency || lastGoodFreq != goodFrequency || lastTransmitting != isTransmitting) {
            world.markBlockForUpdate(x, y, z);
        }
        lastFreq = frequency;
        lastGoodFreq = goodFrequency;
        lastTransmitting = isTransmitting;
        TeslaTower tt = this.getCode();
        if (!getWorldObj().isRemote) {
            this.checkFrequency(this.getFrequency());
            this.checkReceivers();
            if (this.canWork(getTransmitPower())) {
                if (this.canDistribute(world, x, y, z)) {
                    //this.doNegativeAffects(world, x, y, z);
                    this.isTransmitting = true;
                    work(getTransmitPower());
                    TeslaTransmittingServer.registerSendingTesla(tt);
                    return;
                }
            }
            TeslaTransmittingServer.removeTesla(tt);
            this.isTransmitting = false;
        }
        return;
    }

    private void checkReceivers() {
        for (int i = 0; i < receiverList.size(); i++) {
            Receiver rec = receiverList.get(i);
            TERecievingCore te = rec.getTileEntity();
            if (te == null) {
                receiverList.clear();
            }
            else if(te != null && te.getTeU() == 0){
                receiverList.clear();
            }
        }
    }

    private void checkFrequency(int frequency) {
        TeslaTower tt = TeslaTransmittingServer.doesFrequencyExist(frequency);
        if (tt != null && !tt.equals(getCode())) {
            goodFrequency = false;
        } else {
            goodFrequency = true;
        }
    }

    public boolean isGoodFrequency() {
        return goodFrequency;
    }

    @Override
    public TeslaTower getCode() {
        return new TeslaTower(getWorld().provider.dimensionId, x(), y(), z(), getTransmitPower(), getFrequency());
    }

    @Override
    public int getFrequency() {
        return frequency;
    }

    @Override
    public void setFrequency(int frequency) {
        receiverList.clear();
        TeslaTransmittingServer.towerList.clear();
        this.frequency = frequency;
    }

    @Override
    public boolean canWork(int teu) {
        if (powerCore != null) {
            return (powerCore.canDrain(teu));
        }

        return false;
    }

    @Override
    public void work(int teU) {
        if (powerCore != null && powerCore.canDrain(teU)) {
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
        this.transmitPower(getWorld(), x(), y(), z(), getTransmitPower(), getFrequency());
        powerCore = getPowerCore();
    }

    public void keepChunkLoaded() {
        getWorld().getChunkProvider().loadChunk(x(), z());
    }

    public TEPowerCore getPowerCore() {
        if (getWorld().getTileEntity(x(), y() - 5, z()) instanceof TEPowerCore) {
            return (TEPowerCore) (getWorld().getTileEntity(x(), y() - 5, z()));
        }
        return null;
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setBoolean("isTransmitting", isTransmitting);
        tag.setBoolean("goodFrequency", goodFrequency);
        tag.setInteger("frequency", frequency);
        receiverList.clear();
        return new S35PacketUpdateTileEntity(x(), y(), z(), 0, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        isTransmitting = pkt.func_148857_g().getBoolean("isTransmitting");
        goodFrequency = pkt.func_148857_g().getBoolean("goodFrequency");
        setFrequency(pkt.func_148857_g().getInteger("frequency"));
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);

        tag.setBoolean("isTransmitting", isTransmitting);
        tag.setBoolean("goodFrequency", goodFrequency);
        tag.setInteger("frequency", frequency);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        isTransmitting = tag.getBoolean("isTransmitting");
        goodFrequency = tag.getBoolean("goodFrequency");
        setFrequency(tag.getInteger("frequency"));
    }

    List<Receiver> receiverList = new ArrayList<Receiver>();

    public void registerReciever(Receiver receiver) {
        if (!receiverList.contains(receiver)) {
            receiverList.add(receiver);
        }
    }
}
