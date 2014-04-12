package assets.electrolysm.electro.powerSystem.generators.te;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import assets.electrolysm.api.specialFuel.FuelData;
import assets.electrolysm.api.specialFuel.SpecialFuelHandler;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.common.CommonProxy;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.server.FMLServerHandler;

public class TileEntityGenerator extends TileEntityProducer implements IInventory, ISidedInventory
{
	private ItemStack[] inventory;
    private static int[] generatorPower = {10, 100, 5000, 100000};
    private int[] generatorIDs = {electrolysmCore.generator.blockID, 1, 1, electrolysmCore.matterGen.blockID,};
    private String[] generatorNames = {"Coal", "Geothermal", "Fusion", "Matter-Antimatter"};
    public static int genID;
    
    public TileEntityGenerator(int ID) 
    {
		super(generatorPower[ID]);
		this.genID = ID;
		inventory = new ItemStack[ID + 1];
	}

    @Override
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        int itemID = tag.getInteger("itemID");
        int stackSize = tag.getInteger("stackSize");
        int itemDamage = tag.getInteger("itemMeta");
        ItemStack stack = new ItemStack(itemID, stackSize, itemDamage);
        this.setInventorySlotContents(0, stack);
        this.onInventoryChanged();
    }

    /**
     * Writes a tile entity to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);

        if (this.getStackInSlot(0) != null)
        {
            tag.setInteger("itemID", this.getStackInSlot(0).itemID);
            tag.setInteger("stackSize", this.getStackInSlot(0).stackSize);
            tag.setInteger("itemMeta", this.getStackInSlot(0).getItemDamage());
        }
    }

    public int burnTime = 10;
    public int time = 0;
    
    @Override
    public void updateEntity()
    {
        if(this.genID == 0)
        {
        	this.updateCoal();
        }
        else if(this.genID == 1)
        {
        	
        }
        else if(this.genID == 2)
        {
        	
        }
        else if (this.genID == 3)
        {
        	this.updateAntiMatter();
        }
        	
    }
   
    private void updateCoal()
    {
    	if(this.getItemBurnTime(this.getStackInSlot(0)) != 0)
        {
        	burnTime = this.getItemBurnTime(this.getStackInSlot(0));
            this.energy.setEnergy((this.generatorPower[genID]));
            produce(this.generatorPower[genID]);
        }
        
        if(this.getStackInSlot(0) != null || time != 0)
        {
        	this.time = burnTime;
        	if(time == burnTime)
        	{
        		this.decrStackSize(0, 1);
        		this.onInventoryChanged();
        		time = time - 1;
        	}
        	else if(time != 0)
        	{
        		time = time - 1;
        	}
        }
    }
    
    private void updateAntiMatter()
    {
    	if(!this.isAntiMatterBuilt(worldObj, xCoord, yCoord, zCoord))
    	{
    		return;
    	}
    	
    	ItemStack nuggetGold = new ItemStack(Item.goldNugget);
    	ItemStack antiMatter = new ItemStack(electrolysmCore.antiMatter);
    	
    	if((this.getItemBurnTime(this.getStackInSlot(0)) != 0 && this.getStackInSlot(1) != null) && time == 0)
        {
        	burnTime = this.getItemBurnTime(this.getStackInSlot(0));
        }
        if((this.getStackInSlot(0) != null && this.getStackInSlot(1) != null) && time == 0)
        {
	        if((this.getStackInSlot(0).isItemEqual(antiMatter) && this.getStackInSlot(1).isItemEqual(nuggetGold)))
	        {
	        	this.time = burnTime;
	        	if(time == burnTime)
	        	{
	        		this.decrStackSize(0, 1);
	        		this.decrStackSize(1, 1);
	        		this.onInventoryChanged();
	        		time = time - 1;
	        	}
	        }
        }
    	if(time != 0)
    	{
    		time = time - 1;
            this.energy.setEnergy((this.generatorPower[genID]));
            produce(this.generatorPower[genID]);
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
    public String getInvName()
    {
        return this.getNameTag(this.genID);
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
    	ItemStack antiMatter = new ItemStack(electrolysmCore.antiMatter);
    	ItemStack nuggetGold = new ItemStack(Item.goldNugget);
    	
    	if(stack != null)
    	{
	    	if(this.genID == 0)
	    	{
	    		if(this.getItemBurnTime(stack) != 0)
	    		{
	    			return true;
	    		}
	    	}
	    	else if(this.genID == 3)
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
        else if(GameRegistry.getFuelValue(itemStack) > 0 && ((genID + 1) < 2))
        {
            return GameRegistry.getFuelValue(itemStack);
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
    	if(this.genID == 0)
    	{
    		return this.genID0;
    	}
    	else if(this.genID == 1)
    	{
    		return genID1;
    	}
    	else if(this.genID == 2)
    	{
    		return genID2;
    	}
    	else if(this.genID == 3)
    	{
    		return genID2;
    	}
    	
    	return null;
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
			overall[i+1] = checkCircle(world, x, y + i, z);
		}
		
		if(overall[0] && overall[1] && overall[2] && overall[3])
		{
			return true;
		}
		return false;
	}

	private boolean checkCircle(World world, int x, int y, int z) 
	{
		int casingID = electrolysmCore.antiMatterCasing.blockID;
		
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
					if(getBlock(world, x + 1, y, z - 5) == casingID)
					{
						if(getBlock(world, x + 2, y, z - 4) == casingID)
						{
							if(getBlock(world, x + 2, y, z - 4) == casingID)
							{
								if(getBlock(world, x + 3, y, z - 3) == casingID)
								{
									if(getBlock(world, x + 4, y, z - 2) == casingID)
									{ 
										if(getBlock(world, x + 5, y, z - 1) == casingID)
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
		
		return false;
	}

	private int getBlock(World world, int x, int y, int z) 
	{
		world.setBlock(x, y, z, electrolysmCore.antiMatterCasing.blockID, 0, 0);
		return world.getBlockId(x, y, z);
	}
}