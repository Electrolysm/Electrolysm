package electrolysm.electro.oreProccessing.container;

import electrolysm.electro.Electrolysm;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotGrinder extends Slot
{
    public SlotGrinder(IInventory inventory, int id, int x, int y)
    {
        super(inventory, id, x, y);
    }

    public boolean isItemValid(ItemStack stack)
    {
        if (isStackGrinder(stack))
        {
            return true;
        }

        return false;
    }

    public static boolean isStackGrinder(ItemStack stack)
    {
        if (stack == null)
        {
            return false;
        }
        else if (stack.getItem() == Electrolysm.grindStone)
        {
            return true;
        }
        else 
        {
        	return false;
        }
    }
}
