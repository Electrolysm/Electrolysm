package electro.powerSystem.generators.te;

import electro.handlers.helpers.Utilities;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import api.specialFuel.SpecialFuelHandler;
import electro.electrolysmCore;
import electro.powerSystem.generators.matterGen;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityGeneratorAntimatter extends TileEntityProducer implements IInventory, ISidedInventory
{
	private ItemStack antiMatter = new ItemStack(electrolysmCore.electroContain, 1, 
				Integer.parseInt((String.valueOf(SpecialFuelHandler.getFuelListRev().get(SpecialFuelHandler.antiMatter)))));
	private ItemStack[] inventory;
    private static int[] generatorPower = {10, 100, 5000, 100000};
    private Block[] generatorIDs = {electrolysmCore.generator, null, null, electrolysmCore.matterGen,};
    private String[] generatorNames = {"Coal", "Geothermal", "Fusion", "Matter-Antimatter"};
    
    public TileEntityGeneratorAntimatter() 
    {
		super(generatorPower[3]);
		inventory = new ItemStack[3];
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

    public int burnTime = 10;
    public int time = 0;
    
    @Override
    public void updateEntity()
    {
    	if(!(worldObj.isRemote))
	        	this.updateAntiMatter();
    }
   
    private void updateAntiMatter()
    {
    	if(this.getStackInSlot(2) != null)
    	{
	    	boolean canProduce = true;
	    	
	    	if(!(this.isAntiMatterBuilt(worldObj, xCoord, yCoord, zCoord)))
	    	{
	    		time = 0;
	    		return;
	    	}
	    	
	    	ItemStack nuggetGold = new ItemStack(Items.gold_nugget);
	    	
	    	if((this.getItemBurnTime(this.getStackInSlot(0)) != 0 && this.getStackInSlot(1) != null) && time == 0 && canProduce)
	        {
	        	burnTime = this.getItemBurnTime(this.getStackInSlot(0));
	        }
	        if((this.getStackInSlot(0) != null && this.getStackInSlot(1) != null) && time == 0 && canProduce)
	        {
		        if((this.getStackInSlot(0).isItemEqual(antiMatter) && this.getStackInSlot(1).isItemEqual(nuggetGold)) && canProduce)
		        {
		        	this.time = burnTime;
		        	if(time == burnTime)
		        	{
		        		this.decrStackSize(0, 1);
		        		this.decrStackSize(1, 1);
		        		this.markDirty();
		        		time = time - 1;
		        	}
		        }
	        }
	    	if(time != 0)
	    	{
	    		time = time - 1;
	    		
	    		if(canProduce)
	    		{
	    			this.setInventorySlotContents(2, this.chargedBatteryWithAmount(this.generatorPower[0], this.getStackInSlot(2), 
		    				this.getStackInSlot(2).getMaxDamage()));
	    			this.worldObj.createExplosion(null, xCoord, yCoord, zCoord, 2, true);
	    		}
	    	}
	    	//matterGen.updateFurnaceBlockState(time != 0, worldObj, xCoord, yCoord, zCoord);
    	}
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
    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
    	ItemStack nuggetGold = new ItemStack(Items.gold_nugget);
    	
    	if(stack != null)
    	{
    		if(slot == 0 && stack.isItemEqual(antiMatter))
    		{
    			return true;
    		}
    		else if(slot == 1 && stack.isItemEqual(nuggetGold))
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
        else if (SpecialFuelHandler.getFuelData(itemStack) != null)
        {
        	return SpecialFuelHandler.getFuelData(itemStack).getBurnTime();
        }
        else
        {
        	return 0;
        }
    }

    int[] genID0 = {0};
    int[] genID1 = {0};
    int[] genID2 = {0};
    int[] genID3 = {0, 1};
    
    @Override
    public int[] getAccessibleSlotsFromSide(int side)
    {

    	return genID3;
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
		if(ID == 3)
		{
			 return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isBuilt(int id, World world, int x, int y, int z) 
	{
		if(this.doesRequireBuild(id))
		{
			if(id == 3)
			{
				 return this.isAntiMatterBuilt(world, x, y, z);
			}
			return true;
		}
		return false;
	}

	private boolean isAntiMatterBuilt(World world, int x, int y, int z) 
	{
		boolean[] overall = new boolean[4];
		for(int i = -1; i < 3; i++)
		{
			overall[i+1] = checkCircle(world, x, y + i, z, electrolysmCore.antiMatterCasing);
		}
		
		if(overall[0] && overall[1] && overall[2] && overall[3])
		{
			if(this.getBlock(world, x, y + 2, z) == Blocks.water)
			{
				if(this.getBlock(world, x, y + 1, z) == electrolysmCore.magnet)
				{
					if(this.getBlock(world, x, y - 1, z) == electrolysmCore.magnet)
					{
						if(checkCircle(world, x, y + 3, z, electrolysmCore.blastProof))
						{
							if(this.getBlock(world, x + 4, y + 2, z) == Blocks.water)
							{
								if(this.getBlock(world, x - 4, y + 2, z) == Blocks.water)
								{
									if(this.getBlock(world, x, y + 2, z + 4) == Blocks.water)
									{
										if(this.getBlock(world, x, y + 2, z - 4) == Blocks.water)
										{
											return true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	private boolean checkCircle(World world, int x, int y, int z, Block ID)
	{
		Block casingID = ID;
		
		if(getBlock(world, x + 5, y, z) == casingID)
		{
			if(getBlock(world, x + 5, y, z + 1) == casingID)
			{
				if(getBlock(world, x + 4, y, z + 2) == casingID)
				{
					if(getBlock(world, x + 4, y, z + 3) == casingID)
					{
						if(getBlock(world, x + 3, y, z + 4) == casingID)
						{
							if(getBlock(world, x + 2, y, z + 4) == casingID)
							{
								if(getBlock(world, x + 1, y, z + 5) == casingID)
								{
									if(getBlock(world, x, y, z + 5) == casingID)
									{
										if(getBlock(world, x - 1, y, z + 5) == casingID)
										{
											if(getBlock(world, x - 2, y, z + 4) == casingID)
											{
												if(getBlock(world, x - 3, y, z + 4) == casingID)
												{
													if(getBlock(world, x - 4, y, z + 3) == casingID)
													{
														if(getBlock(world, x - 4, y, z + 2) == casingID)
														{
															if(getBlock(world, x - 5, y, z + 1) == casingID)
															{
																if(getBlock(world, x - 5, y, z) == casingID)
																{
																	if(getBlock(world, x - 5, y, z - 1) == casingID)
																	{
																		if(getBlock(world, x - 4, y, z - 2) == casingID)
																		{
																			if(getBlock(world, x - 4, y, z - 3) == casingID)
																			{
																				if(getBlock(world, x - 3, y, z - 4) == casingID)
																				{
		if(getBlock(world, x - 2, y, z - 4) == casingID)
		{
			if(getBlock(world, x - 1, y, z - 5) == casingID)
			{
				if(getBlock(world, x, y, z - 5) == casingID)
				{
					if(getBlock(world, x + 1, y, z - 5) == casingID)/**/
					{
						if(getBlock(world, x + 2, y, z - 4) == casingID)//
						{
							if(getBlock(world, x + 2, y, z - 4) == casingID)//
							{
								if(getBlock(world, x + 4, y, z - 2) == casingID)//
								{
									if(getBlock(world, x + 4, y, z - 3) == casingID)//
									{ 
										if(getBlock(world, x + 5, y, z - 1) == casingID)
										{
											if(getBlock(world, x + 3, y, z - 4) == casingID)
											{
												return true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		return false;
	}

	private Block getBlock(World world, int x, int y, int z)
	{
		//world.setBlock(x, y, z, electrolysmCore.antiMatterCasing.blockID, 0, 0);
		return Utilities.Block.getBlock(world, x, y, z);
	}


    @Override
    public void closeInventory() { }

    @Override
    public boolean hasCustomInventoryName() { return true; }

    @Override
    public String getInventoryName() { return "Antimatter Reactor"; }

    @Override
    public void openInventory() { }
}