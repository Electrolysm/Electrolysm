package electro.research.te;

import java.util.Random;

import electro.Electrolysm;
import electro.common.CommonProxy;
import electro.research.ItemReel;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import api.powerSystem.PowerUsage;
import api.powerSystem.meter.IMeterable;
import electro.oreProccessing.recipes.CrusherRecipes;

public class TileEntityCollector extends TileEntity implements IInventory, ISidedInventory
{
    private ItemStack[] inventory;
    public boolean isOpen;
    int tier = 0;

    public TileEntityCollector(int value)
    {
        this.inventory = new ItemStack[1];
        tier = value;
    }

    @Override
    public int getSizeInventory()
    {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount)
    {
        ItemStack stack = getStackInSlot(slot);

        if (stack != null)
        {
            if (stack.stackSize <= amount)
            {
                setInventorySlotContents(slot, null);
            }
            else
            {
                stack = stack.splitStack(amount);

                if (stack.stackSize == 0)
                {
                    setInventorySlotContents(slot, null);
                }
            }
        }

        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        ItemStack stack = getStackInSlot(slot);

        if (stack != null)
        {
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
    public int getInventoryStackLimit()
    {
        return 1;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
        return true;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
        if(stack != null)
        {
            if(stack.getItem() instanceof ItemReel)
            {
                return true;
            }
        }

        return false;
    }

    public int timer = 0;
    public int maxTimer = 400;

    @Override
    public void updateEntity()
    {
        ItemStack reel = this.getStackInSlot(0);
        Random random = new Random();
        if(reel != null && reel.getItem() instanceof ItemReel)
        {
            if(timer >= maxTimer)
            {
                //System.out.println("tick");
                timer = 0;
                if(reel.stackTagCompound == null) { reel.stackTagCompound = new NBTTagCompound(); }
                int meta = reel.getItemDamage();

                if(random.nextBoolean()) {
                    if((reel.stackTagCompound.getInteger("engValue") + 1) <= CommonProxy.REEL_MAX_VALUE[meta]) {
                        reel.stackTagCompound.setInteger("engValue", reel.stackTagCompound.getInteger("engValue") + 1);
                    }
                }
                else {
                    if((reel.stackTagCompound.getInteger("sciValue") + 1) <= CommonProxy.REEL_MAX_VALUE[meta]) {
                        reel.stackTagCompound.setInteger("sciValue", reel.stackTagCompound.getInteger("sciValue") + 1);
                    }
                }
            }
            else
            {
                timer = timer + 1;
            }
        }
    }

    public int[] getAccessibleSlotsFromSide(int side)
    {
        return new int[] {0};
    }

    public boolean canInsertItem(int slot, ItemStack item, int side)
    {
        return this.isItemValidForSlot(slot, item);
    }

    public boolean canExtractItem(int slot, ItemStack item, int side)
    {
        return true;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);

        // Read in the ItemStacks in the inventory from NBT
        NBTTagList tagList = nbtTagCompound.getTagList("Items", 10);
        inventory = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < tagList.tagCount(); ++i)
        {
            NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
            byte slotIndex = tagCompound.getByte("Slot");
            if (slotIndex >= 0 && slotIndex < inventory.length)
            {
                inventory[slotIndex] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);

        // Write the ItemStacks in the inventory to NBT
        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < inventory.length; ++currentIndex)
        {
            if (inventory[currentIndex] != null)
            {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                inventory[currentIndex].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag("Items", tagList);
    }


    @Override
    public void closeInventory() { }

    @Override
    public boolean hasCustomInventoryName() { return true; }

    @Override
    public String getInventoryName() { return "Collector"; }

    @Override
    public void openInventory() { }
}
