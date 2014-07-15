package electro.machines.assemblySystem.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Ben on 10/07/2014.
 */
public class TileEntityCrafting extends TileEntity implements IInventory, ISidedInventory
{
    ItemStack[] inventory = new ItemStack[(3*3) + 9 + 1];

    //1...9 = crafting grid
    //1 = result
    //10...19 = resources

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return inventory[i];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
            if (stack.stackSize <= amount) {
                setInventorySlotContents(slot, null);
            } else {
                stack = stack.splitStack(amount);
                if (stack.stackSize == 0) {
                    setInventorySlotContents(slot, null);
                }
            }
        }
        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack stack = getStackInSlot(slot);

        if (stack != null) {
            setInventorySlotContents(slot, null);
        }
        return stack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        inventory[slot] = stack;
        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName() {
        return "Crafting Matrix";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void openInventory() { }

    @Override
    public void closeInventory() { }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack stack) {
        //TODO
        return true;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int i) {
        //TODO
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack stack, int i2) {
        if(slot >= 10) { return true; } else { return false; }
    }

    @Override
    public boolean canExtractItem(int i, ItemStack stack, int i2) {
        //TODO
        return false;
    }

    @Override
    public void updateEntity() {
        //TODO

       // formation();

    }
}
