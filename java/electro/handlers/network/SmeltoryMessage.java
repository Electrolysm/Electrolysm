package electro.handlers.network;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import electro.oreProccessing.te.TileEntitySmeltory;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Ben on 12/07/2014.
 */
public class SmeltoryMessage implements IMessage, IMessageHandler<SmeltoryMessage, IMessage>
{
    int x, y, z, state;

    public SmeltoryMessage(TileEntitySmeltory te)
    {
        this.x = te.xCoord;
        this.y = te.yCoord;
        this.z = te.zCoord;
        this.state = (byte) te.temp;
    }

    public SmeltoryMessage()
    {
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.state = buf.readByte();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeByte(state);
    }

    @Override
    public IMessage onMessage(SmeltoryMessage message, MessageContext ctx)
    {
        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

        if (tileEntity instanceof TileEntitySmeltory)
        {
            ((TileEntitySmeltory) tileEntity).temp = message.state;
        }

        return null;
    }
}
