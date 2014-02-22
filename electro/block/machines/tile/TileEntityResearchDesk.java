package assets.electrolysm.electro.block.machines.tile;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.research.Research;

public class TileEntityResearchDesk extends TileEntity implements IInventory
{
    private ItemStack[] inventory;
    public boolean isOpen;

    public TileEntityResearchDesk()
    {
        this.inventory = new ItemStack[3];
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
        // TODO Auto-generated method stub
        inventory[slot] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInvName()
    {
        // TODO Auto-generated method stub
        return "Research Desk";
    }

    @Override
    public boolean isInvNameLocalized()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getInventoryStackLimit()
    {
        // TODO Auto-generated method stub
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void openChest()
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void closeChest()
    {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack)
    {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void updateEntity()
    {
        int deskID = electrolysmCore.desk.blockID;
        int desksClose = 0;
        ItemStack inStack = getStackInSlot(0);
        ItemStack card = getStackInSlot(2);
        ItemStack output = getStackInSlot(1);
        ItemStack result = Research.research().getResearch(inStack, card);
        Random rand = new Random();

        for (int x = -2; x <= 2; x++)
        {
            for (int z = -2; z <= 2; z++)
            {
                for (int y = 0; y <= 1; y++)
                {
                    if (worldObj.getBlockId(xCoord + x, yCoord + y, zCoord + z) == deskID)
                    {
                        desksClose = desksClose + 1;
                    }
                }
            }
        }

        if (card != null)
        {
            if (inStack != null)
            {
                if (result != null)
                {
                    if (output == null)
                    {
                        if (inStack.stackSize >= 10)
                        {
                            if (desksClose <= Research.cardToDesk(card.getItemDamage()))
                            {
                                decrStackSize(0, rand.nextInt(10));

                                if (rand.nextInt(card.getItemDamage() + 1) == 1)
                                {
                                    setInventorySlotContents(1, result);
                                }

                                onInventoryChanged();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        int itemID = tag.getInteger("itemID");
        int stackSize = tag.getInteger("stackSize");
        int itemDamage = tag.getInteger("itemMeta");
        ItemStack stack = new ItemStack(itemID, stackSize, itemDamage);
        this.setInventorySlotContents(2, stack);
        this.onInventoryChanged();
    }

    /**
     * Writes a tile entity to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);

        if (this.getStackInSlot(2) != null)
        {
            tag.setInteger("itemID", this.getStackInSlot(2).itemID);
            tag.setInteger("stackSize", this.getStackInSlot(2).stackSize);
            tag.setInteger("itemMeta", this.getStackInSlot(2).getItemDamage());
        }
    }
}
