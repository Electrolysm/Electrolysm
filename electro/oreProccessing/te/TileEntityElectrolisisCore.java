package assets.electrolysm.electro.oreProccessing.te;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.oreProccessing.recipes.electrolisisRecipes;

public class TileEntityElectrolisisCore extends TileEntity implements IInventory
{

	public boolean isFormed(int x, int y, int z, World world, int chamberID, int waterID)
	{
		int chamber = electrolysmCore.electrolChamber.blockID;
		int water = Block.waterStill.blockID;
		boolean isFormed = false;
		
		//Top row
		if(world.getBlockId(x, y + 1, z) == water)
		{
			if(world.getBlockId(x + 1, y + 1, z) == chamber)
			{
				if(world.getBlockId(x + 1, y + 1, z + 1) == chamber)
				{
					if(world.getBlockId(x + 1, y + 1, z - 1) == chamber)
					{
						if(world.getBlockId(x - 1, y + 1, z) == chamber)
						{
							if(world.getBlockId(x - 1, y + 1, z + 1) == chamber)
							{
								if(world.getBlockId(x - 1, y + 1, z - 1) == chamber)
								{
									if(world.getBlockId(x, y + 1, z + 1) == chamber)
									{
										if(world.getBlockId(x, y + 1, z - 1) == chamber)
										{
		//Bottom Row
		if(world.getBlockId(x, y - 1, z) == chamber)
		{
			if(world.getBlockId(x + 1, y - 1, z) == chamber)
			{
				if(world.getBlockId(x + 1, y - 1, z + 1) == chamber)
				{
					if(world.getBlockId(x + 1, y - 1, z - 1) == chamber)
					{
						if(world.getBlockId(x - 1, y - 1, z) == chamber)
						{
							if(world.getBlockId(x - 1, y - 1, z + 1) == chamber)
							{
								if(world.getBlockId(x - 1, y - 1, z - 1) == chamber)
								{
									if(world.getBlockId(x, y - 1, z + 1) == chamber)
									{
										if(world.getBlockId(x, y - 1, z - 1) == chamber)
										{
		//Middle Row
		for(int xx = -1; xx <= 1; xx++)
		{
			for(int zz = -1; zz <= 1; zz++)
			{
				if(zz != 0 && xx != 0)
				{
					if(world.getBlockId(x + xx, y, z + zz) == chamber)
					{
						isFormed = true;
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
		
		return isFormed;
	}

	//GUI STUFF
	
private ItemStack[] inventory;

	
	public int furnaceBurnTime = 0;
	
	public int currentItemBurnTime = furnaceBurnTime;
	
	public int heat = 0;

	public int furnaceCookTime = 5000;

	public static boolean active = false;
	
	public static boolean powered = true;

	public TileEntityElectrolisisCore() {
		this.inventory = new ItemStack[4];
	}


		
		
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
	public String getInvName() {
		return "Electrolisis Chamber";
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

		
		active = powered;

		boolean canwork = (powered && heat > 10);

		if (heat < 50)
		{
			heat = 100;
		}

		if (canwork) {
			furnaceCookTime = 5000 / heat;

			ItemStack input1 = getStackInSlot(0);
			ItemStack input2 = getStackInSlot(1);
			ItemStack output1 = getStackInSlot(2);
			ItemStack output2 = getStackInSlot(3);
			ItemStack result;
			
			if(input1 != null && input2 != null)
			{
				if(input1.isItemEqual(input2))
				{
					result = electrolisisRecipes.smelting().getSmeltingResult(input1);
					System.out.println(result);			
				}
				else
				{
					return;
				}
			}
			else
			{
				return;
			}
			
			if (result != null) 
			{
				if (furnaceBurnTime == furnaceCookTime)
				{		
					furnaceBurnTime = 0;
					if (output1 == null && output2 == null) 
					{
						decrStackSize(0, 1);
						decrStackSize(1, 1);
						setInventorySlotContents(2, result);
						setInventorySlotContents(3, result);
						onInventoryChanged();
						System.out.println("Done Proccess");
					} 
					else 
					{
						if (output1.isItemEqual(result) && output2.isItemEqual(result)) 
						{
							decrStackSize(0, 1);
							decrStackSize(1, 1);
							output1.stackSize++;
							output2.stackSize++;
						}
					}
				} 
				else 
				{
					furnaceBurnTime++;
					if (output1 != null && !output1.isItemEqual(result) && output2 != null &&
							!output2.isItemEqual(result))
					{
						furnaceBurnTime = 0;
					}
				}
			}
			if (output1 != null && output1.stackSize == 0 &&
					output2 != null && output2.stackSize == 0) 
			{
				output1.stackSize = 1;
				output2.stackSize = 1;
			}
		}

		if (getStackInSlot(0) == null)
		{
			furnaceBurnTime = 0;
		}
	}




	@Override
	public boolean isInvNameLocalized() 
	{
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}
}
