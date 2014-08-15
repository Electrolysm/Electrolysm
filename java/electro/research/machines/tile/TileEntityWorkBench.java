package electro.research.machines.tile;

import electro.handlers.helpers.RecipeRegistry;
import electro.research.common.SavePlayerScanData;
import electro.research.system.Research;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityWorkBench extends TileEntity implements IInventory
{
    public ItemStack[] inventory;
    public boolean isOpen;
    private String userName;

    public TileEntityWorkBench()
    {
        this.inventory = new ItemStack[11];
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
    public void setInventorySlotContents(int slot, ItemStack stack)
    {
        inventory[slot] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
        return true;
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack)
    {
        return true;
    }

    public static ItemStack[] recipe = new ItemStack[9];

    @Override
    public void updateEntity()
    {
        if(worldObj.isRemote) { return; }

        for (int i = 0; i < 9; i++)
        {
            recipe[i] = this.getStackInSlot(i);
        }

        this.checkSetResearchRecipes();
    }

    public ItemStack[] recipe()
    {
        for (int i = 0; i < 9; i++)
        {
            recipe[i] = getStackInSlot(i);
        }

        return recipe;
    }

    public void clearInventory()
    {
        for (int i = 0; i < 9; i++)
        {
            ItemStack stack = this.getStackInSlot(i);

            if (stack != null)
            {
                if ((stack.stackSize - 1) >= 1)
                {
                    ItemStack replace = new ItemStack(stack.getItem(), stack.stackSize, stack.getItemDamage());
                    this.decrStackSize(i, 1);
                }
                else
                {
                    this.setInventorySlotContents(i, null);
                }
            }
        }
    }

    public void checkSetResearchRecipes()
    {
        if (this.getStackInSlot(10) != null && recipe != null)
        {
            //Research research = RecipeRegistry.getResearch(recipe);
            //System.out.println((getStackInSlot(10).stackTagCompound.getString("researchData")).equals(research.toAdvString()));
            //System.out.println(research.toAdvString());
            /*
            if(!(SavePlayerScanData.ResearchData.hasPlayerUnlocked(userName + "_active", research.getName()))) {
                return;
            }

            if(getStackInSlot(10).stackTagCompound != null && research != null &&
                (getStackInSlot(10).stackTagCompound.getString("researchData")).equals(research.toAdvString()))
            {
                this.setInventorySlotContents(9, RecipeRegistry.getResearchResult(recipe));
                //System.out.println("yep");

            }*/
        }
        else
        {
            this.setInventorySlotContents(9, null);
        }
    }

    @Override
    public void closeInventory() { }

    @Override
    public boolean hasCustomInventoryName() { return true; }

    @Override
    public String getInventoryName() { return "Injector"; }

    @Override
    public void openInventory() { }

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


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
