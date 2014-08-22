package electro.handlers.network;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import electro.machines.assemblySystem.crafting.TileEntityMatrix;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Ben on 17/07/2014.
 */
public class MessageMatrix implements IMessage, IMessageHandler<MessageMatrix, IMessage> {

    int x, y, z;
    boolean isState;

    public MessageMatrix(TileEntityMatrix te)
    {
        this.x = te.xCoord;
        this.y = te.yCoord;
        this.z = te.zCoord;
        this.isState = (te.isConstruct);
    }

    public MessageMatrix()
    {
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.isState = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeBoolean(isState);
    }

    @Override
    public IMessage onMessage(MessageMatrix message, MessageContext ctx)
    {
        System.out.println("messageReceived");
        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

        if (tileEntity instanceof TileEntityMatrix)
        {
            ((TileEntityMatrix) tileEntity).isConstruct = (message.isState);
        }

        return null;
    }
}
