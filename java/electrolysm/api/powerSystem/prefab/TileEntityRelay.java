package electrolysm.api.powerSystem.prefab;

import electrolysm.api.powerSystem.interfaces.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

/**
 * Created by Clarky158 on 30/07/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class TileEntityRelay extends TileEntity implements IConnector, ISidedWrenchable, IEnergyRelay {

    public TileEntityRelay() {
    }

    int TEU = 50;
    TileEntity[] adjConnections = new TileEntity[6];

    @Override
    public boolean canConnect(ForgeDirection from, Object source) {
        if (source instanceof TileEntity) {
            TileEntity te = (TileEntity) source;
            if (te instanceof IConnector && this.getState(from.ordinal()) != this.DEFAULT) {
                IConnector con = (IConnector) te;
                adjConnections[from.ordinal()] = te;
                return con.canConnect(from.getOpposite());
            }
        }
        adjConnections[from.ordinal()] = null;
        return false;
    }

    @Override
    public boolean canConnect(ForgeDirection side) {
        /*System.out.println(this.getState(side.ordinal()) + " : " + side.ordinal() + " : " + side);
        for(int i = 0; i < 6; i++) {
            System.out.println("Sides: " + i + "-" + sideStates[i]);
        }*/

        return side != ForgeDirection.UNKNOWN && this.getState(getSideID(side)) != this.DEFAULT;
    }

    private int getSideID(ForgeDirection side) {
        switch (side)
        {
            case UP: return 0;
            case DOWN: return 1;
            case NORTH: return ForgeDirection.SOUTH.ordinal();
            case EAST: return ForgeDirection.WEST.ordinal();
            case SOUTH: return ForgeDirection.NORTH.ordinal();
            case WEST: return ForgeDirection.EAST.ordinal();
            default: return 0;
        }
    }

    @Override
    public boolean[] getVisualConnections() {
        return null;
    }

    @Override
    public TileEntity[] getAdjConnections() {
        return adjConnections;
    }

    IPowerCore FromPowerCore = null;
    IPowerCore ToPowerCore = null;

    @Override
    public void updateEntity() {

        if (worldObj.isRemote) {
            return;
        }
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        for (byte i = 0; i < 6; i++) {
            //worldObj.getBlock(xCoord, yCoord, zCoord).updateTick(worldObj, xCoord, yCoord, zCoord, new Random());
            ForgeDirection dir = ForgeDirection.getOrientation(i);
            this.canConnect(dir, this.worldObj.getTileEntity(this.xCoord + dir.offsetX, this.yCoord + dir.offsetY,
                    this.zCoord + dir.offsetZ));
        }

        Random rand = new Random();
        //Get TE From
        if (FromPowerCore == null) {
            if (rand.nextInt(50) == 5) {
                FromPowerCore = findCore(worldObj, xCoord, yCoord, zCoord, INPUT);
            }
        } else {
            if (rand.nextInt(100) == 5) {
                FromPowerCore = findCore(worldObj, xCoord, yCoord, zCoord, INPUT);
            }
        }
        //Get TE To
        if (ToPowerCore == null) {
            if (rand.nextInt(50) == 5) {
                ToPowerCore = findCore(worldObj, xCoord, yCoord, zCoord, OUTPUT);
            }
        } else {
            if (rand.nextInt(100) == 5) {
                ToPowerCore = findCore(worldObj, xCoord, yCoord, zCoord, OUTPUT);
            }
        }

        //Taking from "FromPowerCore" and give to "ToPowerCore"
        if (FromPowerCore != null && ToPowerCore != null /*&& FromPowerCore != ToPowerCore*/) {
            //System.out.println("take and give");
            this.takeAndGive(FromPowerCore, ToPowerCore);
        }

        //worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        //worldObj.scheduleBlockUpdate(xCoord, yCoord, zCoord, worldObj.getBlock(xCoord, yCoord, zCoord), 1);
        if (worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 0) {
            worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1, 0);
        } else {
            worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0, 0);
        }
    }

    private void takeAndGive(IPowerCore from, IPowerCore to) {
        //System.out.println(from + " : " + to);
        if(from.canDrain(TEU) && to.canHold(TEU))
        {
            from.drainPower(TEU);
            to.charge(TEU);
        }
    }

    int[] sideStates = new int[6];
    int DEFAULT = 0;
    int INPUT = 1;
    int OUTPUT = 2;

    @Override
    public void setSide(int side) {
        int currentSide = sideStates[side];
        int toSide = -1;
        if(currentSide == DEFAULT) {
            toSide = INPUT;
        }
        if(currentSide == INPUT) {
            toSide = OUTPUT;
        }
        if(currentSide == OUTPUT){
            toSide = DEFAULT;
        }

        sideStates[side] = toSide;
    }

    @Override
    public int getState(int side) {
        return sideStates[side];
    }

    //Find Core when taking energy
    @Override
    public IPowerCore findCore(World world, int x, int y, int z, int SideState) {
        TileEntity[] adj = this.adjConnections;
        for (int i = 0; i < adj.length; i++) {
            if (getState(i) == SideState && adj[i] != null && adj[i] instanceof IConnector) {
                IConnector connector = (IConnector) adj[i];
                if (adj[i] instanceof TEPowerCore) {
                    return (TEPowerCore) adj[i];
                } else {
                    if (adj[i] instanceof ICable) {
                        ICable cable = (ICable) adj[i];
                        return cable.findCore(ForgeDirection.getOrientation(i).getOpposite(), 0);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        sideStates = tag.getIntArray("sideSetting");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);

        tag.setIntArray("sideSetting", sideStates);
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setIntArray("sideSetting", sideStates);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        sideStates = pkt.func_148857_g().getIntArray("sideSetting");
    }
}
