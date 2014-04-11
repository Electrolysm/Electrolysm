package assets.electrolysm.electro.powerSystem.generators.te;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import assets.electrolysm.api.specialFuel.FuelData;
import assets.electrolysm.api.specialFuel.SpecialFuelHandler;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityGenerator extends TileEntityProducer implements IInventory, ISidedInventory
{
	private ItemStack[] inventory = new ItemStack[1];
    private static int[] generatorPower = {10, 100, 5000, 100000};
    private int[] generatorIDs = {electrolysmCore.generator.blockID, 1, 1, electrolysmCore.matterGen.blockID,};
    private String[] generatorNames = {"Coal", "Geothermal", "Fusion", "Matter-Antimatter"};
    private static int genID;
    
    public TileEntityGenerator(int ID) 
    {
		super(generatorPower[ID]);
		this.genID = ID;
	}
    
    /*
    public boolean isWorking(World world, int x, int y, int z)
    {
        //int electrolysmCore.ironFrames.blockID = electrolysmCore.ironFrames.blockID;
        //int electrolysmCore.teslaTowerCore.blockID = electrolysmCore.teslaTowerCore.blockID;
        //x + 1
        int i = world.getBlockId(x, y, z);

        if (this.getStackInSlot(0) != null)
        {
            if (world.getBlockId(x + 1, y, z) == electrolysmCore.ironFrames.blockID)
            {
                if (world.getBlockId(x + 1, y + 5, z) == electrolysmCore.teslaTowerCore.blockID)
                {
                    TileEntityTeslaTower te = (TileEntityTeslaTower)world.getBlockTileEntity(x + 1, y + 5, z);

                    if (te instanceof TileEntityTeslaTower)
                    {
                        if (te.isTowerFormed(world, x + 1, y + 5, z))
                        {
                            if (this.getStackInSlot(0) != null)
                            {
                                return true;
                            }
                        }
                    }
                }
            }
            //x - 1
            else if (world.getBlockId(x - 1, y, z) == electrolysmCore.ironFrames.blockID &&
                     world.getBlockId(x - 1, y + 5, z) == electrolysmCore.teslaTowerCore.blockID)
            {
                TileEntityTeslaTower te = (TileEntityTeslaTower)world.getBlockTileEntity(x - 1, y + 5, z);

                if (te instanceof TileEntityTeslaTower)
                {
                    if (te.isTowerFormed(world, x - 1, y + 5, z))
                    {
                        if (this.getStackInSlot(0) != null)
                        {
                            return true;
                        }
                    }
                }
            }
            //z + 1
            else if (world.getBlockId(x, y, z + 1) == electrolysmCore.ironFrames.blockID &&
                     world.getBlockId(x, y + 5, z + 1) == electrolysmCore.teslaTowerCore.blockID)
            {
                TileEntityTeslaTower te = (TileEntityTeslaTower)world.getBlockTileEntity(x, y + 5, z + 1);

                if (te instanceof TileEntityTeslaTower)
                {
                    if (te.isTowerFormed(world, x, y + 5, z + 1))
                    {
                        if (this.getStackInSlot(0) != null)
                        {
                            return true;
                        }
                    }
                }
            }
            //z - 1
            else if (world.getBlockId(x, y, z - 1) == electrolysmCore.ironFrames.blockID &&
                     world.getBlockId(x, y + 5, z - 1) == electrolysmCore.teslaTowerCore.blockID)
            {
                TileEntityTeslaTower te = (TileEntityTeslaTower)world.getBlockTileEntity(x, y + 5, z - 1);

                if (te instanceof TileEntityTeslaTower)
                {
                    if (te.isTowerFormed(world, x, y + 5, z - 1))
                    {
                        if (this.getStackInSlot(0) != null)
                        {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public int getSendTeU(World world, int x, int y, int z)
    {
        int blockID = world.getBlockId(x, y, z);

        for (int i = 0; i < this.generatorIDs.length; i++)
        {
            if (this.isWorking(world, x, y, z))
            {
                return this.generatorPower[i];
            }
        }

        return 0;
    }*/

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

    int burnTime = 10;
    int time = 0;
    
    @Override
    public void updateEntity()
    {
    	//System.out.println(SpecialFuelHandler.getFuelData(this.getStackInSlot(0)).toString());
    	
    	FuelData data = SpecialFuelHandler.getFuelData(this.getStackInSlot(0));
    	if(data != null && data.getExplosive())
    	{
    		//worldObj.getClosestPlayer();
    		worldObj.createExplosion(null, xCoord, yCoord, zCoord, data.getExplosiveRadius(), false);
    		data = null;
    		this.setInventorySlotContents(0, null);
    	}
    	
    	if((this.energy.getEnergy() + 101) >= this.energy.getEnergyCapacity())
    	{
    		return;
    	}
        if(this.getStackInSlot(0) != null)
        {
        	burnTime = this.getItemBurnTime(this.getStackInSlot(0));
            this.energy.receiveEnergy((this.generatorPower[genID] + 1), true);
            produce(this.generatorPower[genID]);
        }
        
        if(this.getStackInSlot(0) != null)
        {
        	if(time == burnTime)
        	{
        		time = 0;
        		this.decrStackSize(0, 1);
        		this.onInventoryChanged();
        	}
        	else
        	{
        		time = time + 1;
        	}
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
        return this.getNameTag(worldObj, xCoord, yCoord, zCoord);
    }

    @SuppressWarnings("unused")
    public String getNameTag(World world, int x, int y, int z)
    {
        int lengh = this.generatorIDs.length;

        for (int i = 0; i < generatorIDs.length; i++)
        {
            int id = generatorIDs[i];

            if (world.getBlockId(x, y, z) == id)
            {
                String names = generatorNames[i];

                if (names.contains("Antimatter") || names.contains("Fusion"))
                {
                    return names + " Reactor";
                }
                else
                {
                    return names + " Generator";
                }
            }
            else
            {
                return "UNKNOWN BLOCK";
            }
        }

        return "UNKNOWN BLOCK";
    }

    @SuppressWarnings("unused")
    public String getNameTag(int blockID)
    {
        int lengh = this.generatorIDs.length;

        for (int i = 0; i < generatorIDs.length; i++)
        {
            int id = generatorIDs[i];

            if (blockID == id)
            {
                String names = generatorNames[i];

                if (names.contains("Antimatter") || names.contains("Fusion"))
                {
                    return names + " Reactor";
                }
                else
                {
                    return names + " Generator";
                }
            }
            else
            {
                return "UNKNOWN BLOCK";
            }
        }

        return "UNKNOWN BLOCK";
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
    public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack)
    {
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
        else if (SpecialFuelHandler.getFuelData(itemStack) != null && 
        		((genID + 1) > SpecialFuelHandler.getFuelData(itemStack).getTier()))
        {
        	return SpecialFuelHandler.getFuelData(itemStack).getBurnTime();
        }
        else
        {
        	return 0;
        }
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int var1)
    {
        int[] slots = new int[] {0};
        return slots;
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemstack, int j)
    {
        return this.isItemValidForSlot(i, itemstack);
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j)
    {
        // TODO Auto-generated method stub
        return false;
    }

    public void setGuiDisplayName(String displayName)
    {
    }
}