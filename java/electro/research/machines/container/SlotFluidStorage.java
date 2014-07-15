package electro.research.machines.container;

import electro.Electrolysm;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotFluidStorage extends Slot
{
    public SlotFluidStorage(IInventory inventory, int id, int x, int y)
    {
        super(inventory, id, x, y);
    }

    public boolean isItemValid(ItemStack stack)
    {
        if (isStackFluidStorage(stack))
        {
            return true;
        }/*
        else if(isStackSulphur(stack))
        {
        	return true;
        }*/

        return false;
    }

    private boolean isStackSulphur(ItemStack stack) 
    {
    	if (stack == null)
        {
            return false;
        }

        if (stack.getItem() == Electrolysm.sulphur)
        {
            return true;
        }
        else if(stack.getItem().getUnlocalizedName().contains("sulphur") ||
                stack.getItem().getUnlocalizedName().contains("sulfur"))
        {
        	return true;
        }
        
        return false;
    }

	public static boolean isStackFluidStorage(ItemStack stack)
    {
        if (stack == null)
        {
            return false;
        }

        if (stack.getItem() == Electrolysm.fluidStorage)
        {
            return true;
        }

        return false;
    }
}
