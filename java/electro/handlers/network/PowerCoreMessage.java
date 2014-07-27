package electro.handlers.network;

import api.powerSystem.prefab.TEPowerCore;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Clarky158 on 27/07/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class PowerCoreMessage implements IMessage, IMessageHandler<PowerCoreMessage, IMessage> {

    int x, y, z, teu;

    public PowerCoreMessage(TEPowerCore te)
    {
        this.x = te.xCoord;
        this.y = te.yCoord;
        this.z = te.zCoord;
        this.teu = te.getTeU();
    }

    public PowerCoreMessage()
    {
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.teu = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeInt(teu);
    }

    @Override
    public IMessage onMessage(PowerCoreMessage message, MessageContext ctx)
    {
        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

        if (tileEntity instanceof TEPowerCore)
        {
            ((TEPowerCore) tileEntity).setTeU(message.teu);
        }

        return null;
    }
}
