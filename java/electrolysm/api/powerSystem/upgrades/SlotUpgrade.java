package electrolysm.api.powerSystem.upgrades;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Clarky158 on 31/08/2014.
 */
public class SlotUpgrade extends Slot {

    TileEntity entity;

    public SlotUpgrade(IInventory inv, int id, int x, int y) {
        super(inv, id, x, y);
    }

    public SlotUpgrade(TileEntity te, int id, int x, int y){
        this((IInventory)te, id, x, y);
        entity = te;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        if(stack != null && stack.stackTagCompound != null && stack.stackTagCompound.getString("upgrade") != null) {
            if (entity instanceof IUpgradeMachine && ((IUpgradeMachine) entity).canUpgrade()) {
                if (((IUpgradeMachine) entity).doesUpgradeFit(new Upgrade(stack.stackTagCompound.getString("upgrade")))) {
                    return true;
                }
            }
        }
        return false;
    }
}
