package electro.research.machines.container;

import electro.Electrolysm;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotResearchNote extends Slot
{
    public SlotResearchNote(IInventory inventory, int id, int x, int y)
    {
        super(inventory, id, x, y);
    }

    public boolean isItemValid(ItemStack stack)
    {
        if (isStackResearchPaper(stack))
        {
            return true;
        }

        return false;
    }

    public static boolean isStackResearchPaper(ItemStack stack)
    {
        if (stack == null)
        {
            return false;
        }

        if (stack.getItem() ==  Electrolysm.researchPaper)
        {
            return true;
        }

        return false;
    }
}
