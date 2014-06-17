package electro.oreProccessing.container;

import assets.electrolysm.electro.electrolysmCore;
import electro.handlers.IDHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;

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
        else if (stack.getItem() == electrolysmCore.grindStone)
        {
            return true;
        }
        else 
        {
        	return false;
        }
    }
}
