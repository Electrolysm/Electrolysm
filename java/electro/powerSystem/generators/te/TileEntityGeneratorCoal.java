package electro.powerSystem.generators.te;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import assets.electrolysm.api.specialFuel.SpecialFuelHandler;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.powerSystem.generators.matterGen;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityGeneratorCoal extends TileEntityProducer implements IInventory, ISidedInventory
{
	private ItemStack[] inventory;
    private static int[] generatorPower = {260, 700, 5000, 100000};
    private int[] generatorIDs = {electrolysmCore.generator.blockID, 1, 1, electrolysmCore.matterGen.blockID,};
    private String[] generatorNames = {"Coal", "Geothermal", "Fusion", "Matter-Antimatter"};
    
    public TileEntityGeneratorCoal() 
    {
		super(generatorPower[0]);
		inventory = new ItemStack[2];
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

    public int burnTime = 10;
    public int time = 0;
    
    @Override
    public void updateEntity()
    {
    	if(!(worldObj.isRemote))
    	{
    		this.updateCoal();
    	}/*
    	if(this.getStackInSlot(1) != null)
    	{
    		this.getStackInSlot(1).setItemDamage((this.getStackInSlot(1).getItemDamage() + 1));
    	}*/

    	//worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, worldObj.getBlockId(xCoord, yCoord, zCoord));
    }
   
    private void updateCoal()
    {
    	if(this.getStackInSlot(1) != null)
    	{
    		if(this.getItemBurnTime(this.getStackInSlot(0)) != 0 && time == 0)
    		{
    			this.burnTime = this.getItemBurnTime(this.getStackInSlot(0));
    		}
    		else if(this.getItemBurnTime(this.getStackInSlot(0)) == 0)
    		{
    			this.burnTime = 0;
    		}
    		
    		if(this.getStackInSlot(0) != null && time == 0 && this.burnTime != 0)
    		{
    			this.time = this.burnTime;
    			if(time == burnTime)
    			{
    				this.decrStackSize(0, 1);
    				//this.time = time - 1;
    			}
    		}

    		if(time != 0 && (this.getStackInSlot(1).getItemDamage() + 1) <= this.getStackInSlot(1).getMaxDamage())
        	{
        		this.time = time - 1;
        		this.getStackInSlot(1).setItemDamage((this.getStackInSlot(1).getItemDamage() + 1));
        	}
        	else
        	{
        		return;
        	}    		
    	}
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
        ItemStack itemStack = getStackInSlot(slot);

        if (itemStack != null)
        {
            setInventorySlotContents(slot, null);
        }

        return itemStack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack)
    {
        this.inventory[slot] = itemStack;

        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
        {
            itemStack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public String getInvName()
    {
        return this.getNameTag(0);
    }

    public String getNameTag(int ID)
    {
    	if(generatorNames[ID] != null)
    	{
    		if(generatorNames[ID].toLowerCase().contains("fusion") || generatorNames[ID].toLowerCase().contains("matter"))
    		{
    			return generatorNames[ID] + " Reactor";
    		}
    		else
    		{
    			return generatorNames[ID] + "Generator";
    		}
    	}
    	else
    	{
    		return "UNKNOWN BLOCK";
    	}
    }

    @Override
    public boolean isInvNameLocalized()
    {
        return false;
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
    public void openChest()
    {
    }

    @Override
    public void closeChest()
    {
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
    	if(stack != null)
    	{
	    	if(this.getItemBurnTime(stack) != 0)
	    	{
	    		return true;
	    	}
    	}
        return true;
    }

    public static boolean isItemFuel(ItemStack itemStack)
    {
        return getItemBurnTime(itemStack) > 0;
    }

    public static int getItemBurnTime(ItemStack itemStack)
    {
        if (itemStack == null)
        {
            return 0;
        }
        else if(GameRegistry.getFuelValue(itemStack) > 0)
        {
            return GameRegistry.getFuelValue(itemStack);
        }
        else
        {
        	return 200;
        }
    }

    int[] genID0 = {0};
    int[] genID1 = {0};
    int[] genID2 = {0};
    int[] genID3 = {0, 1};
    
    @Override
    public int[] getAccessibleSlotsFromSide(int side)
    {
   		return this.genID0;
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemstack, int j)
    {
        return this.isItemValidForSlot(i, itemstack);
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j)
    {
        return false;
    }

    public void setGuiDisplayName(String displayName)
    {
    }

	public boolean doesRequireBuild(int ID) 
	{
		return false;
	}

	public boolean isBuilt(int id, World world, int x, int y, int z) 
	{
		return false;
	}

	private int getBlock(World world, int x, int y, int z) 
	{
		//world.setBlock(x, y, z, electrolysmCore.antiMatterCasing.blockID, 0, 0);
		return world.getBlockId(x, y, z);
	}

	@Override
	public int getSizeInventory() {
		return (this.inventory.length);
	}
}