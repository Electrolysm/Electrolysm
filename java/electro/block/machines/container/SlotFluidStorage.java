package electro.block.machines.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import assets.electrolysm.electro.electrolysmCore;

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

        if (stack.itemID == electrolysmCore.sulphur.itemID)
        {
            return true;
        }
        else if(OreDictionary.getOreName(stack.itemID).contains("sulphur") || 
        		OreDictionary.getOreName(stack.itemID).contains("sulfur"))
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

        if (stack.itemID == electrolysmCore.fluidStorage.itemID)
        {
            return true;
        }

        return false;
    }
}
