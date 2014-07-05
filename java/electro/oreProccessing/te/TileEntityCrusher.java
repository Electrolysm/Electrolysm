package electro.oreProccessing.te;

import java.util.Random;

import electro.Electrolysm;
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

public class TileEntityCrusher extends TileEntity implements IInventory, ISidedInventory, IMeterable
{
    private ItemStack[] inventory;
    public boolean isOpen;

    public TileEntityCrusher()
    {
        this.inventory = new ItemStack[4];
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
        // TODO Auto-generated method stub
        inventory[slot] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }
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
    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
    	if(stack != null)
    	{
	    	ItemStack recipe = CrusherRecipes.smelting().getCrushingResult(stack);
	    	if(slot == 0)
	    	{
	    		if(recipe != null)
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
    	else 
    	{
    		return false;
    	}
    }

    public int time = 0;
    public int maxCrushTime = 400;
    public int crushTime = 400;
    public int requiredEnergy = PowerUsage.getTeUFromMap(this.getBlock()).getValue();
    
    @Override
    public void updateEntity()
    {
    	this.markDirty();
    	
    	ItemStack battery = getStackInSlot(3);
        ItemStack inStack = getStackInSlot(0);
        ItemStack output = getStackInSlot(1);
        ItemStack grindStone = getStackInSlot(2);
        ItemStack result = CrusherRecipes.smelting().getCrushingResult(inStack);
        int extraDust = 0;
        ItemStack result2 = result;
        Random rand = new Random();

        if(grindStone != null)
        {
        	//extraDust = this.getExtraDust(grindStone);
        	if(this.getExtraDust(grindStone) != 0 || this.getExtraDust(grindStone) != -1)
        	{
        		crushTime = (int)(maxCrushTime / (this.getExtraDust(grindStone) + 1));
        	}
        	else
        	{
        		crushTime = maxCrushTime;
        	}
        }
        else
        {
        	crushTime = maxCrushTime;
        }
        if(result != null)
        {
        	result2 = new ItemStack(result.getItem(), result.stackSize + extraDust, result.getItemDamage());
        }
        
        if(battery != null && battery.getItemDamage() > 0)
        {
	        if (inStack != null)
	        {
	            if (result != null)
	            {
	                if (output == null)
	                {
	                    int outputSize = 0;
	                    int resultSize = result.stackSize;
	
	                    if (((resultSize + outputSize) <= 64))
	                    {
	                    	if(time == crushTime)
	                    	{
	                    		time = 0;
	                    		this.decrStackSize(0, 1);
		                        this.setInventorySlotContents(1, result2);
		                        this.markDirty();
		                		battery.setItemDamage(battery.getItemDamage() - this.requiredEnergy);
	                    	}
	                    	else
	                    	{
	                    		if((battery.getItemDamage() - this.requiredEnergy) > 0)
	                    		{
	                    			battery.setItemDamage(battery.getItemDamage() - this.requiredEnergy);
	                    		}
	                    		else
	                    		{
	                    			battery.setItemDamage(0);
	                    		}
	                    		time = time + 1;
	                    	}
	                    }
	                }
	                else
	                {
	                    int outputSize = output.stackSize;
	                    int resultSize = result.stackSize;
	
	                    if (((resultSize + outputSize) < 64))
	                    {
	                    	if(time == crushTime)
	                    	{
	                    		time = 0;
		                        this.decrStackSize(0, 1);
		                        output.stackSize = (output.stackSize + result.stackSize + extraDust);
		                        this.markDirty();
	                    		if((battery.getItemDamage() - this.requiredEnergy) > 0)
	                    		{
	                    			battery.setItemDamage(battery.getItemDamage() - this.requiredEnergy);
	                    		}
	                    		else
	                    		{
	                    			battery.setItemDamage(0);
	                    		}	                    	}
	                    	else
	                    	{
	                    		if((battery.getItemDamage() - this.requiredEnergy) > 0)
	                    		{
	                    			battery.setItemDamage(battery.getItemDamage() - this.requiredEnergy);
	                    		}
	                    		else
	                    		{
	                    			battery.setItemDamage(0);
	                    		}
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
        	return;
        }
    }

	private int getExtraDust(ItemStack grindStone)
	{
		if(grindStone == null)
		{
			return -1;
		}
		else
		{
			return (grindStone.getItemDamage());
		}
	}
	int[] slots_bottom = {1};
	int[] slots_top = {0};
	int[] slots_sides = {2, 1};
	
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

    public boolean canInsertItem(int slot, ItemStack item, int side)
    {
        return this.isItemValidForSlot(slot, item);
    }

    public boolean canExtractItem(int slot, ItemStack item, int side)
    {
        return side != 0 || slot != 1 || item.getItem() == Electrolysm.impureDusts;
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
        nbtTagCompound.setInteger("time", time);
    }
    
    
	@Override
	public Block getBlock() 
	{
		return Electrolysm.crusher;
	}

    @Override
    public void closeInventory() { }

    @Override
    public boolean hasCustomInventoryName() { return true; }

    @Override
    public String getInventoryName() { return "Crusher"; }

    @Override
    public void openInventory() { }
}
