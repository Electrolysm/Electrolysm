package assets.electrolysm.electro.oreProccessing.te;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.oreProccessing.recipes.electrolisisRecipes;

public class TileEntityElectrolisisCore extends TileEntityElectrical implements IInventory, /*IPullEnergy,
																				IMeterable, */ISidedInventory
{
    //GUI STUFF
    private ItemStack[] inventory;

    public TileEntityElectrolisisCore()
    {
    	super(50000000);
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
    public String getInvName()
    {
        return "Electrolisis Chamber";
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        if(this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) == this)
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
    

    @Override
    public void openChest()
    {
    }

    @Override
    public void closeChest()
    {
    }

    public int time = 0;
    public int MaxElectroTime = 100;
    public int electroTime = 100;
    public boolean active = false;
    private int requiredEnergy = 5000;
    
    @Override
    public void updateEntity()
    {
    	this.onInventoryChanged();
    	
        if(time == 0)
        {
        	active = false;
        }
        else
        {
        	active = true;
        }
        
        if (this.energy.getEnergy() > this.requiredEnergy)
        {
            ItemStack input1 = getStackInSlot(0);
            ItemStack input2 = getStackInSlot(1);
            ItemStack output = getStackInSlot(2);
            ItemStack result1 = electrolisisRecipes.smelting().getSmeltingResult(input1);
            ItemStack result2 = electrolisisRecipes.smelting().getSmeltingResult(input2);
            ItemStack node1 = getStackInSlot(3);
            ItemStack node2 = getStackInSlot(4);
            ItemStack node = new ItemStack(electrolysmCore.node, 1);

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
                                		this.onInventoryChanged();
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
                                		this.onInventoryChanged();
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
        
        if(time > 0)
        {
        	this.energy.setEnergy(this.energy.getEnergy() - this.requiredEnergy);
        }
    }

    @Override
    public boolean isInvNameLocalized()
    {
        return false;
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
    		if(itemstack.getItem() == electrolysmCore.node)
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
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        
        NBTTagList tagList = tagCompound.getTagList("Inventory");
        for (int i = 0; i < tagList.tagCount(); i++) {
                NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
                byte slot = tag.getByte("Slot");
                if (slot >= 0 && slot < inventory.length) {
                        inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
                }
        }
        
    }
	
	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
	        super.writeToNBT(tagCompound);
	                        
	        NBTTagList itemList = new NBTTagList();
	        for (int i = 0; i < inventory.length; i++) {
	                ItemStack stack = inventory[i];
	                if (stack != null) {
	                        NBTTagCompound tag = new NBTTagCompound();
	                        tag.setByte("Slot", (byte) i);
	                        stack.writeToNBT(tag);
	                        itemList.appendTag(tag);
	                }
	        }
	        tagCompound.setTag("Inventory", itemList);
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
        return side != 0 || slot != 1 || slot != 3 || slot != 4 || item.getItem() == electrolysmCore.dusts
        		|| active != false; 
    }
}
