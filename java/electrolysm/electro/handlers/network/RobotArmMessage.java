package electrolysm.electro.handlers.network;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import electrolysm.electro.machines.assemblySystem.inventory.TileEntityRobotArm;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Ben on 07/07/2014.
 */
public class RobotArmMessage implements IMessage, IMessageHandler<RobotArmMessage, IMessage> {

    int x, y, z, state;

    public RobotArmMessage(TileEntityRobotArm te)
    {
        this.x = te.xCoord;
        this.y = te.yCoord;
        this.z = te.zCoord;
        this.state = (byte) te.STATE;
    }

    public RobotArmMessage()
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
    public IMessage onMessage(RobotArmMessage message, MessageContext ctx)
    {
        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

        if (tileEntity instanceof TileEntityRobotArm)
        {
            ((TileEntityRobotArm) tileEntity).setState(message.state);
        }

        return null;
    }
}
