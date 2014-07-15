package electro.machines.assemblySystem.crafting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Ben on 10/07/2014.
 */
public class TileEntityMatrixInventory extends TileEntity implements IInventory/*, ISidedInventory*/
{
    public int columns = 3;
    public int rows = 9;

    ItemStack[] inventory = new ItemStack[columns + rows * 9];

    @Override
    public void openInventory() { }

    @Override
    public String getInventoryName() { return "Matrix"; }

    @Override
    public int getInventoryStackLimit() { return 64; }

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
    public boolean isItemValidForSlot(int i, ItemStack stack) { return true; }

    @Override
    public boolean hasCustomInventoryName() { return true; }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) { return true; }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        inventory[slot] = stack;
        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public void closeInventory() { }

    @Override
    public int getSizeInventory() { return inventory.length; }

    @Override
    public ItemStack getStackInSlot(int slot) { return inventory[slot]; }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
            setInventorySlotContents(slot, null);
        }
        return stack;
    }
}
