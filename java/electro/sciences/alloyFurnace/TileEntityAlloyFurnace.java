package electro.sciences.alloyFurnace;

import cpw.mods.fml.common.registry.GameRegistry;
import electro.handlers.helpers.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Ben on 15/07/2014.
 */
public class TileEntityAlloyFurnace extends TileEntity implements IInventory, ISidedInventory {
    ItemStack[] inventory = new ItemStack[4];

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        ItemStack stack = getStackInSlot(slot);

        if (stack != null) {
            if (stack.stackSize <= amount) {
                setInventorySlotContents(slot, null);
            } else {
                stack = stack.splitStack(amount);

                if (stack.stackSize == 0) {
                    setInventorySlotContents(slot, null);
                }
            }
        }

        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack stack = getStackInSlot(slot);

        if (stack != null) {
            setInventorySlotContents(slot, null);
        }

        return stack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        inventory[slot] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName() {
        return "Alloy Furnace";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return true;
    }

    @Override
    public void openInventory() {
    }

    @Override
    public void closeInventory() {
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        if(slot == 2 && this.getBurnTime(stack) > 0)
        {
            //fuel
            return true;
        }
        else if(slot != 3) {
            return true;
        }
        else {
            return false;
        }
    }

    public int timer = 0;
    public int maxTimer = 600;
    public int burnTime = 0;
    public int maxBurnTime = 0;

    @Override
    public void updateEntity() {
        boolean isBurning = false;
        ItemStack in1 = this.getStackInSlot(0);
        ItemStack in2 = this.getStackInSlot(1);
        ItemStack fuel = this.getStackInSlot(2);
        ItemStack output = this.getStackInSlot(3);
        ItemStack result = AlloyRecipes.smelting().getResult(in1, in2);

        if (in1 != null && in2 != null && result != null && isFormed(xCoord, yCoord, zCoord, worldObj)) {
            if (burnTime < maxBurnTime) {
                isBurning = true;
            }
            if (burnTime == maxBurnTime) {
                isBurning = false;
                burnTime = 0;
                maxBurnTime = 0;
            }
            if (maxBurnTime == 0) {
                isBurning = false;
                setBurnTime(fuel);
                return;
            }

            if (isBurning) {
                burnTime = burnTime + 1;
                if (timer == maxTimer) {
                    timer = 0;
                    if (output == null) {
                        this.decrStackSize(0, AlloyRecipes.smelting().getStackReduceAmount(this.getStackInSlot(0)));
                        this.decrStackSize(1, AlloyRecipes.smelting().getStackReduceAmount(this.getStackInSlot(1)));
                        this.setInventorySlotContents(3, result);
                        this.markDirty();
                    } else {
                        if (output.isItemEqual(result) && (output.stackSize + result.stackSize) <= 64) {
                            this.decrStackSize(0, 1);
                            this.decrStackSize(1, 1);
                            this.setInventorySlotContents(3, new ItemStack(result.getItem(), (output.stackSize + result.stackSize),
                                    result.getItemDamage()));
                            this.markDirty();
                        }
                    }
                } else {
                    timer = timer + 1;
                }
            }
        }
        else
        {
            timer = 0;
            maxBurnTime = 0;
            burnTime = 0;
        }
    }

    public void setBurnTime(ItemStack fuel) {
        maxBurnTime = getBurnTime(fuel);
        this.decrStackSize(2, 1);
    }

    public int getBurnTime(ItemStack fuel) {
        if (fuel == null) {
            return 0;
        } else {
            Item item = fuel.getItem();
            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
                Block block = Block.getBlockFromItem(item);
                if (block == Blocks.wooden_slab) {
                    return 150;
                }
                if (block.getMaterial() == Material.wood) {
                    return 300;
                }
                if (block == Blocks.coal_block) {
                    return 16000;
                }
            }
            if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe) item).getToolMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(fuel);
        }
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

        timer = nbtTagCompound.getInteger("time");
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
        nbtTagCompound.setInteger("time", timer);
    }

    public static boolean isFormed(int x, int y, int z, World world)
    {
        Block chamber = Blocks.brick_block;
        Block air = null;
        boolean isFormed = false;

        //Top row
        if (Utilities.Block.getBlock(world, x, y + 1, z) != chamber)
        {
            if (Utilities.Block.getBlock(world, x + 1, y + 1, z) == chamber)
            {
                if (Utilities.Block.getBlock(world, x + 1, y + 1, z + 1) == chamber)
                {
                    if (Utilities.Block.getBlock(world, x + 1, y + 1, z - 1) == chamber)
                    {
                        if (Utilities.Block.getBlock(world, x - 1, y + 1, z) == chamber)
                        {
                            if (Utilities.Block.getBlock(world, x - 1, y + 1, z + 1) == chamber)
                            {
                                if (Utilities.Block.getBlock(world, x - 1, y + 1, z - 1) == chamber)
                                {
                                    if (Utilities.Block.getBlock(world, x, y + 1, z + 1) == chamber)
                                    {
                                        if (Utilities.Block.getBlock(world, x, y + 1, z - 1) == chamber)
                                        {
                                            //Bottom Row
                                            if (Utilities.Block.getBlock(world, x + 1, y - 1, z) == chamber)
                                            {
                                                if (Utilities.Block.getBlock(world, x + 1, y - 1, z + 1) == chamber)
                                                {
                                                    if (Utilities.Block.getBlock(world, x + 1, y - 1, z - 1) == chamber)
                                                    {
                                                        if (Utilities.Block.getBlock(world, x - 1, y - 1, z) == chamber)
                                                        {
                                                            if (Utilities.Block.getBlock(world, x - 1, y - 1, z + 1) == chamber)
                                                            {
                                                                if (Utilities.Block.getBlock(world, x - 1, y - 1, z - 1) == chamber)
                                                                {
                                                                    if (Utilities.Block.getBlock(world, x, y - 1, z + 1) == chamber)
                                                                    {
                                                                        if (Utilities.Block.getBlock(world, x, y - 1, z - 1) == chamber)
                                                                        {
                                                                            //Middle Row
                                                                            if (Utilities.Block.getBlock(world, x + 1, y, z + 1) == chamber)
                                                                            {
                                                                                if (Utilities.Block.getBlock(world, x - 1, y, z + 1) == chamber)
                                                                                {
                                                                                    if (Utilities.Block.getBlock(world, x + 1, y, z - 1) == chamber)
                                                                                    {
                                                                                        if (Utilities.Block.getBlock(world, x - 1, y, z - 1) == chamber)
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

        return isFormed;
    }

    //======================================================================

    @Override
    public int[] getAccessibleSlotsFromSide(int side)
    {
        if(side > 0) {
            return new int[] {3};
        }
        else
        {
            return new int[] {0, 1, 2};
        }
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack stack, int side)
    {
        return side == 0 && this.isItemValidForSlot(slot, stack);
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack stack, int side)
    {
        return side != 0;
    }
}
