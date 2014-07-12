package electro.block.machines.container;

import electro.block.machines.tile.TileEntityWorkBench;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Ben on 12/07/2014.
 */
public class SlotCraftingResult extends Slot {
    public SlotCraftingResult(TileEntityWorkBench entity, int i, int i1, int i2) {
        super(entity, i, i1, i2);
    }

    public boolean isItemValid(ItemStack stack)
    {
        return false;
    }
}
