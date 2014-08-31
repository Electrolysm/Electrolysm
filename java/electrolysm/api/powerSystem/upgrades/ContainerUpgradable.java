package electrolysm.api.powerSystem.upgrades;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Clarky158 on 31/08/2014.
 */
public class ContainerUpgradable extends Container {

    public ContainerUpgradable(TileEntity te){
        this(te, null);
    }

    public ContainerUpgradable(TileEntity te, String guiState) {
        super();
        if(guiState == null) { return; }
        else{
            if(guiState.contains(Upgrades.SCREENS.UPGRADE)){
                System.out.println(guiState);
                for (int i = 0; i < 4; i++) {
                    this.addSlotToContainer(new SlotUpgrade(te, i, 0, 0 + (16 * 0)));
                }
            }
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return true;
    }
}
