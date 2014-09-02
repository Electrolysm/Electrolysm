package electro.handlers.network;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.server.FMLServerHandler;
import electro.powerSystem.tesla.te.TileEntityTeslaCore;
import io.netty.buffer.ByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Clarky158 on 02/09/2014.
 */
public class TeslaCoreMessage implements IMessage, IMessageHandler<TeslaCoreMessage, IMessage> {

    int x, y, z;
    int frequency;

    public TeslaCoreMessage(TileEntityTeslaCore te, int freq){
        this.x = te.xCoord;
        this.y = te.yCoord;
        this.z = te.zCoord;
        this.frequency = freq;
    }

    public TeslaCoreMessage(TileEntityTeslaCore te)
    {
        this(te, te.getFrequency());
    }

    public TeslaCoreMessage()
    {
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.frequency = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeInt(frequency);
    }

    @Override
    public IMessage onMessage(TeslaCoreMessage message, MessageContext ctx)
    {
        if(message == null) { return null; }
        TileEntity te = MinecraftServer.getServer().getEntityWorld().getTileEntity(message.x, message.y, message.z);

        if (te instanceof TileEntityTeslaCore)
        {
            //System.out.println("messageReceived: " + message.frequency);
            ((TileEntityTeslaCore) te).setFrequency(message.frequency);
            //return message;
        }

        return null;
    }
}
