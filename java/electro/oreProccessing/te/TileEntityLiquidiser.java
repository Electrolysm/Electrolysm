package electro.oreProccessing.te;

import electro.Electrolysm;
import electro.oreProccessing.recipes.LiquidiserRecipes;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityLiquidiser extends TileEntity implements IInventory, ISidedInventory
{
    private ItemStack[] inventory;
    public boolean isOpen;

    public TileEntityLiquidiser()
    {
        this.inventory = new ItemStack[2];
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
	    	ItemStack recipe = LiquidiserRecipes.liquidising().getLiquidisingResult(stack);
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
    
    @Override
    public void updateEntity()
    {
    	this.markDirty();

    	int connectedLiquids = this.getConnectedLiquids(worldObj, xCoord, yCoord, zCoord);
        
    	ItemStack inStack = getStackInSlot(0);
        ItemStack output = getStackInSlot(1);
        ItemStack result = LiquidiserRecipes.liquidising().getLiquidisingResult(inStack);
        ItemStack result2 = result;

        if(connectedLiquids > 0)
        {
        	crushTime = maxCrushTime / connectedLiquids;
        }
        
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
                    int resultSize = result.stackSize;

                    if (((resultSize + outputSize) < 64))
                    {
                    	if(time == crushTime)
                    	{
                    		time = 0;
	                        this.decrStackSize(0, 1);
	                        output.stackSize = (output.stackSize + result.stackSize);
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

	private int getConnectedLiquids(World world, int x, int y, int z) 
	{
		Block id1 = world.getBlock(x + 1, y, z);
        Block id2 = world.getBlock(x - 1, y, z);
        Block id3 = world.getBlock(x, y, z + 1);
        Block id4 = world.getBlock(x, y, z - 1);
		
		int overall = 0;
		
		if(id1 == Electrolysm.sulpuricAcid)
		{
			overall = overall + 1;
		}
		if(id2 == Electrolysm.sulpuricAcid)
		{
			overall = overall + 1;
		}
		if(id3 == Electrolysm.sulpuricAcid)
		{
			overall = overall + 1;
		}
		if(id4 == Electrolysm.sulpuricAcid)
		{
			overall = overall + 1;
		}
		
		return overall;
	}

	int[] slots_bottom = {1};
	int[] slots_top = {0};
	int[] slots_sides = {1};
	
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
        return side != 0 || slot != 1 || item.getItem() == Electrolysm.crystal;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
            super.readFromNBT(tagCompound);
            
            NBTTagList tagList = tagCompound.getTagList("Inventory", 0);
            for (int i = 0; i < tagList.tagCount(); i++) {
                    NBTTagCompound tag = (NBTTagCompound) tagList.getCompoundTagAt(i);
                    byte slot = tag.getByte("Slot");
                    if (slot >= 0 && slot < inventory.length) {
                            inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
                    }
            }
            
            time = tagCompound.getInteger("time");
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
            tagCompound.setInteger("time", time);
    }

	public void setGuiDisplayName(String displayName) {
		// TODO Auto-generated method stub
		
	}

    @Override
    public void closeInventory() { }

    @Override
    public boolean hasCustomInventoryName() { return true; }

    @Override
    public String getInventoryName() { return "Displacement Chamber"; }

    @Override
    public void openInventory() { }

}
