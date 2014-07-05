package electro.oreProccessing.te;

import electro.Electrolysm;
import electro.oreProccessing.recipes.electrolisisRecipes;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import api.powerSystem.meter.IMeterable;

public class TileEntityElectrolisisCore extends TileEntity implements IInventory, /*IPullEnergy,
																				IMeterable, */ISidedInventory, IMeterable
{
    //GUI STUFF
    private ItemStack[] inventory;

    public TileEntityElectrolisisCore()
    {
        this.inventory = new ItemStack[5];
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
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this)
        {
        	return true;
        }
        else if((player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D,(double) this.zCoord + 0.5D) 
        		<= 64.0D))
        {
        	return true;
        }/*
        else if(active)
        {
        	return true;
        }
        else*/
        {
        	return false;
        }
    }
    

    public int time = 0;
    public int MaxElectroTime = 100;
    public int electroTime = 100;
    public boolean active = false;
    
    @Override
    public void updateEntity()
    {
    	this.markDirty();
    	
        if(time == 0)
        {
        	active = false;
        }
        else
        {
        	active = true;
        }
        
        if (true)
        {
            ItemStack input1 = getStackInSlot(0);
            ItemStack input2 = getStackInSlot(1);
            ItemStack output = getStackInSlot(2);
            ItemStack result1 = electrolisisRecipes.smelting().getSmeltingResult(input1);
            ItemStack result2 = electrolisisRecipes.smelting().getSmeltingResult(input2);
            ItemStack node1 = getStackInSlot(3);
            ItemStack node2 = getStackInSlot(4);
            ItemStack node = new ItemStack(Electrolysm.node, 1);

            if (node1 == null || node2 == null)
            {
            	time = 0;
                return;
            }
            
            if(input1 != null && input2 != null && node1.isItemEqual(node2))
            {
            	if(input1.isItemEqual(input2))
            	{
            		if(result1 != null && result2 != null)
            		{
            			if(result1.isItemEqual(result2))
            			{
            				//output check!!
            				if(output == null)
            				{
            					int outputSize = 0;
                                int resultSize = result1.stackSize;

                                if (((resultSize + outputSize) <= 64))
                                {
                                	if(time == electroTime)
                                	{
                                		time = 0;
                                		this.decrStackSize(0, 1);
                                		this.decrStackSize(1, 1);
                                		this.setInventorySlotContents(2, new ItemStack(result1.getItem(), 
                                				result1.stackSize, result1.getItemDamage()));
                                		this.markDirty();
                                	}
                                	else
                                	{
                                		time = time + 1;
                                	}
                                }
            				}
            				else
            				{
            					int outputSize = output.stackSize;
                                int resultSize = result1.stackSize;

                                if (((resultSize + outputSize) <= 64))
                                {
                                	if(time == electroTime)
                                	{
                                		time = 0;
                                		this.decrStackSize(0, 1);
                                		this.decrStackSize(1, 1);
                                		this.setInventorySlotContents(2, new ItemStack(result1.getItem(), 
                                				result1.stackSize + outputSize, result1.getItemDamage()));
                                		this.markDirty();
                                	}
                                	else
                                	{
                                		time = time + 1;
                                	}
                                }
            				}
            			}
            			else
            			{
            				time = 0;
            			}
            		}
            		else
            		{
            			time = 0;
            		}
            	}
            	else
            	{
            		time  = 0;
            	}
            }
            else
            {
            	time = 0;
            }

        }
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemstack)
    {
    	if(slot == 0 || slot == 1)
    	{
    		 if(electrolisisRecipes.smelting().getSmeltingResult(itemstack) != null)
    		 {
    			 return true;
    		 }
    		 else
    		 {
    			 return false;
    		 }
    	}
    	else if(slot == 3 || slot == 4)
    	{
    		if(itemstack.getItem() == Electrolysm.node)
    		{
    			return true;
    		}
    		else
    		{
    			return false;
    		}
    	}
    	else
    	{
    		return false;
    	}
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

	int[] slots_bottom = {2};
	int[] slots_top = {0, 1, 3, 4};
	int[] slots_sides = {2};
	
	@Override
	public int[] getAccessibleSlotsFromSide(int side)
    {
        if(side == 0)
        {
        	return slots_bottom;
        }
        else if(side == 1)
        {
        	return slots_top;
        }
        else
        {
        	return slots_sides;
        }
    }

	@Override
    public boolean canInsertItem(int slot, ItemStack item, int side)
    {
        return this.isItemValidForSlot(slot, item);
    }

	@Override
    public boolean canExtractItem(int slot, ItemStack item, int side)
    {
        return side != 0 || slot != 1 || slot != 3 || slot != 4 || item.getItem() == Electrolysm.dusts
        		|| active != false; 
    }
	
	@Override
	public Block getBlock() 
	{
		return Electrolysm.electrolisisCore;
	}

    @Override
    public void closeInventory() { }

    @Override
    public boolean hasCustomInventoryName() { return true; }

    @Override
    public String getInventoryName() { return "Electrolysis Chamber"; }

    @Override
    public void openInventory() { }
}
