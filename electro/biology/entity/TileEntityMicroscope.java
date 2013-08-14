package mods.Electrolysm.electro.biology.entity;

import mods.Electrolysm.electro.electrolysmCore;
import mods.Electrolysm.electro.basic.recipes.MicroscopeRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;


public class TileEntityMicroscope extends TileEntity implements IInventory{
	private ItemStack[] inventory;

	
	public int furnaceBurnTime = 0;
	
	public int currentItemBurnTime = furnaceBurnTime;
	
	public int heat = 0;

	public int furnaceCookTime = 5000;

	public static boolean active = false;

	public TileEntityMicroscope() {
		this.inventory = new ItemStack[3];
	}


		
		
	@Override
	public int getSizeInventory()
	{
		return this.inventory.length;
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
	public String getInvName() {
		return "Microscope";
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord,
				this.zCoord) != this ? false : player.getDistanceSq(
				(double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D,
				(double) this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	@Override
	public void updateEntity() {
		boolean powered = worldObj.getBlockId(xCoord, yCoord - 1, zCoord) == electrolysmCore.desk.blockID
				&& this.inventory[2] != null;
			
			
		active = powered;

		boolean canwork = (powered && heat > 10);

		if (heat < 50){
			heat++;
		}

		if (canwork) {
			furnaceCookTime = 5000 / heat;

			ItemStack stack = getStackInSlot(0);
			ItemStack output = getStackInSlot(1);
			ItemStack result = MicroscopeRecipes.smelting().getSmeltingResult(stack);

			if (result != null) {
				if (furnaceBurnTime == furnaceCookTime) {
					furnaceBurnTime = 0;
					if (output == null) {
						decrStackSize(0, 1);
						setInventorySlotContents(1, result);
						onInventoryChanged();
					} else {
						if (output.isItemEqual(result)) {
							decrStackSize(0, 1);
							output.stackSize++;
						}
					}
				} else {
					furnaceBurnTime++;
					if (output != null && !output.isItemEqual(result)) {
						furnaceBurnTime = 0;
					}
				}
			}
			if (output != null && output.stackSize == 0) {
				output.stackSize = 1;
			}
		}

		if (getStackInSlot(0) == null) {
			furnaceBurnTime = 0;
				}
		}
/*
		electroFurnace.updateState(worldObj.getBlockId(xCoord, yCoord - 1, zCoord) == Block.lavaStill.blockID || worldObj.getBlockId(xCoord, yCoord - 1,
						zCoord) == Block.lavaMoving.blockID,
						worldObj, xCoord, yCoord, zCoord);
*/
	
	public boolean isSmelting() {
		return furnaceBurnTime > 0;
	}

	public int getBurnTimeRemainingScaled(int par1) {
		if (this.currentItemBurnTime == 0) {
			this.currentItemBurnTime = 200;
		}

		return this.furnaceBurnTime * par1 / this.currentItemBurnTime;
	}

	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		NBTTagList tagList = new NBTTagList();

		for (int currentIndex = 0; currentIndex < this.inventory.length; ++currentIndex)
		{
			if (this.inventory[currentIndex] != null)
			{
				NBTTagCompound tagCompound = new NBTTagCompound();
				tagCompound.setByte("Slot", (byte) currentIndex);
				this.inventory[currentIndex].writeToNBT(tagCompound);
				tagList.appendTag(tagCompound);
			}
		}

		compound.setShort("Heat", (short) heat);
		compound.setShort("Progress", (short) furnaceBurnTime);
		compound.setTag("Items", tagList);
	}

	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		NBTTagList tagList = compound.getTagList("Items");

		this.heat = (int) compound.getShort("Heat");
		this.furnaceBurnTime = (int) compound.getShort("Progress");

		this.inventory = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < tagList.tagCount(); ++i)
		{
			NBTTagCompound tagCompound = (NBTTagCompound) tagList.tagAt(i);
			byte slot = tagCompound.getByte("Slot");
			if (slot >= 0 && slot < inventory.length)
			{
				this.inventory[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
			}
		}
	}

	@Override
	public boolean isInvNameLocalized() 
	{
		return false;
	}
	@Override
	public boolean isStackValidForSlot(int i, ItemStack itemstack) 
	{
		return true;
	}
	
	}

