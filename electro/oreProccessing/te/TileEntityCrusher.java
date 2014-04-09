package assets.electrolysm.electro.oreProccessing.te;

import java.util.Random;

import universalelectricity.api.UniversalClass;

import net.minecraft.block.BlockFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.packetHandler;
import assets.electrolysm.electro.oreProccessing.crusher;
import assets.electrolysm.electro.oreProccessing.recipes.CrusherRecipes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@UniversalClass
public class TileEntityCrusher extends TileEntityElectrical implements IInventory, ISidedInventory
{
    private ItemStack[] inventory;
    public boolean isOpen;

    public TileEntityCrusher()
    {
    	super(500000);
        this.inventory = new ItemStack[3];
        //this.energy.setCapacity(5000);
    }

    @Override
    public int getSizeInventory()
    {
    	//Sets Inventory Size
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
        return "Crusher";
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

    public int time = 0;
    private int maxCrushTime = 400;
    public int crushTime = 400;
    
    public int rotations = 0;
    private int maxRotations = 100;
    private int maxRotaionsFinal = 100;
    
	private long requiredEnergy = 500;
    
    @Override
    public void updateEntity()
    {
    	this.onInventoryChanged();
    	this.currentEnergy = this.energy.getEnergy();
    	System.out.println(this.energy.getEnergy());
    	
    	if(!worldObj.isRemote && currentEnergy >= this.requiredEnergy)
    	{
    		
	        ItemStack inStack = getStackInSlot(0);
	        ItemStack output = getStackInSlot(1);
	        ItemStack grindStone = getStackInSlot(2);
	        ItemStack result = CrusherRecipes.smelting().getCrushingResult(inStack);
	        Random rand = new Random();
	
	        if(grindStone != null)
	        {
	        	//extraDust = this.getExtraDust(grindStone);
	        	if(this.getExtraDust(grindStone) != 0 || this.getExtraDust(grindStone) != -1)
	        	{
	        		if(active == false)
	        		{
	        			crushTime = (int)(maxCrushTime / (this.getExtraDust(grindStone) + 1));
	        			if(this.getExtraDust(grindStone) != 0)
	        			{
	        				//maxRotations = (int)(maxRotaionsFinal * (this.getExtraDust(grindStone)));
	        			}
	        		}
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

	        if (inStack != null)
	        {
	            if (result != null)
	            {
	            	if(rotations == maxRotations)
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
		                    		active = false;
		                    		this.decrStackSize(0, 1);
			                        this.setInventorySlotContents(1, result);
			                    	this.onInventoryChanged();
		                    	}
		                    	else
		                    	{
		                    		time = time + 1;
		                    		active = true;
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
		                    		active = false;
			                        this.decrStackSize(0, 1);
			                        output.stackSize = (output.stackSize + result.stackSize);
			                    	this.onInventoryChanged();
		                    	}
		                    	else
		                    	{
		                    		time = time + 1;
		                    		active = true;
		                    	}
		                    }
		                }
	            	}
	            	else
	            	{
	            		rotations = rotations + 1;
	            		active = true;
	            	}
	           	}
	            else
	            {
	            	time = 0;
	            	rotations = 0;
	            	active = false;
	            }
	        }
	        else
	        {
	        	time = 0;
	        	rotations = 0;
	        	active = false;
	        }
	        
    		if(this.rotations > 0)
    		{
    			this.energy.setEnergy(this.energy.getEnergy() - this.requiredEnergy);
    		}
    	}
    }    	
    
    public int getRotations()
    {
    	return this.rotations;
    }
	
    public int getScaledProgress(int scale)
    {
    	//46
    	return ((int)((this.time * scale) / this.crushTime));
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
        return side != 0 || slot != 1 || item.getItem() == electrolysmCore.impureDusts;
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
    
    //Energy 
    
}
