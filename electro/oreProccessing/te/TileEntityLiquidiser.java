package assets.electrolysm.electro.oreProccessing.te;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import assets.electrolysm.api.powerSystem.meter.IMeterable;
import assets.electrolysm.api.powerSystem.usageMachine.TileEntityEnergyMachine;
import assets.electrolysm.electro.oreProccessing.recipes.LiquidiserRecipes;

public class TileEntityLiquidiser extends TileEntityEnergyMachine implements IMeterable, IInventory//, ISidedInventory
{
    private ItemStack[] inventory;
    public boolean isOpen;
        
	public TileEntityLiquidiser()
	{
		super();
		
		this.activationEnergy = 67;
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

    public int time;
    public int maxLiquidTime = 600;
    public int liquidTime = 600;
    
    @Override
    public void updateEntity()
    {
    	ItemStack input = this.getStackInSlot(0);
    	ItemStack output = this.getStackInSlot(1);
    	ItemStack result = LiquidiserRecipes.liquidising().getLiquidisingResult(input);
    	int NoInput = LiquidiserRecipes.liquidising().getNoInput(result);
    	
    	if(input != null)
    	{
    		if(result != null && input.stackSize >= NoInput)
    		{
    			if(output == null)
    			{
    				int outputSize = 0;
    				int resultSize = result.stackSize;
    				
    				if((outputSize + resultSize) <= 64)
    				{
    					if(time == liquidTime)
    					{
    						time = 0;
    						this.decrStackSize(0, NoInput);
    						this.setInventorySlotContents(1, result);
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
    				int resultSize = result.stackSize;
    				int result2Size = (outputSize + resultSize);
    				
    				if((outputSize + resultSize) <= 64)
    				{
    					if(time == liquidTime)
    					{
    						time = 0;
    						this.decrStackSize(0, NoInput);
    						this.setInventorySlotContents(1, new ItemStack(result.getItem(), result2Size,
    								result.getItemDamage()));
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

	public void setGuiDisplayName(String displayName) {
		
	}

}
