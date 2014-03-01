package assets.electrolysm.electro.oreProccessing.te;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.oreProccessing.recipes.CrusherRecipes;

public class TileEntityCrusher extends TileEntity implements IInventory, ISidedInventory
{
    private ItemStack[] inventory;
    public boolean isOpen;

    public TileEntityCrusher()
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

    @Override
    public void updateEntity()
    {
    	this.onInventoryChanged();
    	
        ItemStack inStack = getStackInSlot(0);
        ItemStack output = getStackInSlot(1);
        ItemStack grindStone = getStackInSlot(2);
        ItemStack result = CrusherRecipes.smelting().getCrushingResult(inStack);
       
        int extraDust = 0;
        ItemStack result2 = result;
        Random rand = new Random();
        
        if(result != null)
        {
        	result2 = new ItemStack(result.getItem(), result.stackSize + extraDust, result.getItemDamage());
        }
        if(grindStone != null)
        {
        	extraDust = this.getExtraDust(grindStone);
        }
        
        if (inStack != null)
        {
            if (result != null)
            {
                if (output == null)
                {
                    int outputSize = 0;
                    int resultSize = result.stackSize;

                    if (((resultSize + outputSize) < 64))
                    {
                        this.decrStackSize(0, 1);
                        this.setInventorySlotContents(1, result2);
                        this.onInventoryChanged();
                    }
                }
                else
                {
                    int outputSize = output.stackSize;
                    int resultSize = result.stackSize;

                    if (((resultSize + outputSize) < 64))
                    {
                        this.decrStackSize(0, 1);
                        output.stackSize = (output.stackSize + result.stackSize + extraDust);
                        this.onInventoryChanged();
                    }
                }
            }
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
	int[] slots_sides = {2};
	
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
        return side != 0 || slot != 1 || item.getItem() == electrolysmCore.impureDusts;
    }
}
