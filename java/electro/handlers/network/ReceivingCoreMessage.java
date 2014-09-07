package electro.handlers.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import electrolysm.api.powerSystem.tesla.TERecievingCore;
import io.netty.buffer.ByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Clarky158 on 03/09/2014.
 */
public class ReceivingCoreMessage implements IMessage, IMessageHandler<ReceivingCoreMessage, IMessage> {

    int x, y, z;
    int frequency;

    public ReceivingCoreMessage(TERecievingCore te, int freq){
        this.x = te.xCoord;
        this.y = te.yCoord;
        this.z = te.zCoord;
        this.frequency = freq;
    }

    public ReceivingCoreMessage(TERecievingCore te)
    {
        this(te, te.getFrequency());
    }

    public ReceivingCoreMessage()
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
    public IMessage onMessage(ReceivingCoreMessage message, MessageContext ctx)
    {
        if(message == null) { return null; }
        TileEntity te = MinecraftServer.getServer().getEntityWorld().getTileEntity(message.x, message.y, message.z);

        if (te instanceof TERecievingCore)
        {
            System.out.println("messageReceived: " + message.frequency);
            ((TERecievingCore) te).setFrequency(message.frequency);
            //return message;
        }

        return null;
    }
}
