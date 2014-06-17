package electro;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import electro.handlers.Referance;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;

public class packetHandler  implements IPacketHandler
{
    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
    {
        try
        {
            ByteArrayDataInput data = ByteStreams.newDataInput(packet.data);
            int x = data.readInt();
            int y = data.readInt();
            int z = data.readInt();
            int id = data.readInt();
            int l = data.readInt();
            EntityPlayer ePlayer = (EntityPlayer)player;

            if (ePlayer != null)
            {
                TileEntity tileEntity = ePlayer.worldObj.getBlockTileEntity(x, y, z);

                if (tileEntity != null)
                {
                    // if(tileEntity instanceof IPacketReceiver)
                    {
                        //((IPacketReceiver)tileEntity).handlePacketData(manager, packet.channel, data);
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static int[] getTeUPacket(Packet250CustomPayload packet)
    {
        ByteArrayInputStream bos = new ByteArrayInputStream(packet.data);
        DataInputStream dis = new DataInputStream(bos);
        int x = 0;
        int y = 0;
        int z = 0;
        int freq = 0;
        int TeU = 0;
        int Range = 0;

        try
        {
            x = dis.readInt();
            y = dis.readInt();
            z = dis.readInt();
            freq = dis.readInt();
            TeU = dis.readInt();
            Range = dis.readInt();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        int[] data = {x, y, z, freq, TeU, Range};
        return data;
    }
    public static void sendTeUPacket(int x, int y, int z, int freq, int TeU, int Range)
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream outputStream = new DataOutputStream(bos);

        try
        {
            outputStream.writeInt(x);
            outputStream.writeInt(y);
            outputStream.writeInt(z);
            outputStream.writeInt(freq);
            outputStream.writeInt(TeU);
            outputStream.writeInt(Range);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        Packet250CustomPayload packet = new Packet250CustomPayload();
        packet.channel = Referance.MOD_REF.CHANNEL;
        packet.data = bos.toByteArray();
        packet.length = bos.size();

        if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER)
        {
            PacketDispatcher.sendPacketToAllPlayers(packet);
        }
        else
        {
            PacketDispatcher.sendPacketToServer(packet);
        }
    }
}
