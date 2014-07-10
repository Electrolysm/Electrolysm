package electro.handlers.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import electro.common.CommonProxy;

/**
 * Created by Clarky158 on 02/07/2014.
 */

public class PacketHandler {

    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(CommonProxy.MOD_ID_LOWER);

    public static void init(){
        INSTANCE.registerMessage(RobotArmMessage.class, RobotArmMessage.class, 0, Side.CLIENT);
    }
}
