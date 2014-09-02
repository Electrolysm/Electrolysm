package electro.powerSystem.tesla.te;

import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.handlers.network.PacketHandler;
import electro.handlers.network.TeslaCoreMessage;
import electrolysm.api.powerSystem.tesla.TETeslaTower;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;

/**
 * Created by Clarky158 on 30/08/2014.
 */
public class TileEntityTeslaCore extends TETeslaTower
{
    @Override
    public void updateEntity() {
        super.updateEntity();
        //getWorldObj().markBlockForUpdate(x(), y(), z());
    }

    @Override
    public Packet getDescriptionPacket() {
        return super.getDescriptionPacket();
    }
}
