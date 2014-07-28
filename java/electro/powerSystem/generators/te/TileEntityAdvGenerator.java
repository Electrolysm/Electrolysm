package electro.powerSystem.generators.te;

import api.powerSystem.PowerUsage;
import api.powerSystem.TeU;
import electro.Electrolysm;
import electro.oreProccessing.smeltory;
import electro.powerSystem.generators.advancedGenerator;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityAdvGenerator extends TileEntityProducer implements IInventory, ISidedInventory
{
    private ItemStack[] inventory;
    private static int[] generatorPower = {260, 700, 5000, 100000};
    private Block[] generatorIDs = {Electrolysm.generator, null, null, Electrolysm.matterGen,};
    private String[] generatorNames = {"Coal", "Geothermal", "Fusion", "Matter-Antimatter"};

    public TileEntityAdvGenerator()
    {
        super(generatorPower[0]);
        inventory = new ItemStack[2];
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
    }

    public int burnTime = 10;
    public int time = 0;

    @Override
    public void updateEntity()
    {
        super.updateEntity();
        if(worldObj.isRemote) { return; }
        if(time == 0) {
            advancedGenerator.updateFurnaceBlockState(false, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
        } else {
            advancedGenerator.updateFurnaceBlockState(true, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
        }
        this.updateCoal();
    }

    private void updateCoal()
    {
        if(this.canProduce(PowerUsage.getTeUFromMap(Electrolysm.advancedGenerator)))
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

            if(time != 0)
            {
                this.time = time - 1;
                //this.getStackInSlot(1).setItemDamage((this.getStackInSlot(1).getItemDamage() + 1));
                this.produce(PowerUsage.getTeUFromMap(Electrolysm.advancedGenerator));
            }
            else
            {
                return;
            }
        }
        else
        {
            time = 0;
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
            return (int)(GameRegistry.getFuelValue(itemStack));
        }
        else
        {
            return (int)(TileEntityFurnace.getItemBurnTime(itemStack));
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

    private Block getBlock(World world, int x, int y, int z)
    {
        //world.setBlock(x, y, z, electrolysmCore.antiMatterCasing.blockID, 0, 0);
        return world.getBlock(x, y, z);
    }

    @Override
    public int getSizeInventory() {
        return (this.inventory.length);
    }

    @Override
    public void closeInventory() { }

    @Override
    public boolean hasCustomInventoryName() { return true; }

    @Override
    public String getInventoryName() { return "Advanced Generator"; }

    @Override
    public void openInventory() { }
}