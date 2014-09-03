package electro.powerSystem.tesla.gui;

import electrolysm.api.powerSystem.tesla.TERecievingCore;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

/**
 * Created by Clarky158 on 03/09/2014.
 */
public class ContainerReceivingCore extends ContainerTeslaTower {
    public ContainerReceivingCore(TERecievingCore te, InventoryPlayer player) {
        super(te, player);
    }
}
