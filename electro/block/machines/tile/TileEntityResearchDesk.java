package assets.electrolysm.electro.block.machines.tile;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import assets.electrolysm.electro.research.Research;

public class TileEntityResearchDesk extends TileEntity implements IInventory {

	private ItemStack[] inventory;

	public TileEntityResearchDesk() {
		this.inventory = new ItemStack[3];
	}

	@Override
	public int getSizeInventory() 
	{
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
		// TODO Auto-generated method stub
		inventory[slot] = stack;

		if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
			stack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInvName() {
		// TODO Auto-generated method stub
		return "Research Desk";
	}

	@Override
	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
    public void updateEntity() 
	{
		int level;
		String posResearch = null;
		Random random = new Random();
		ItemStack inStack = getStackInSlot(0);
		ItemStack output = getStackInSlot(1);
		ItemStack card = getStackInSlot(2);
		int id = 0;
		int rand = random.nextInt(3);	
			if(card != null)
			{
				level = card.getItemDamage();
				try{
					if(level == 0)
					{
						posResearch = (String) Research.Level1.get(rand);
					}
					if(level == 1)
					{
						posResearch = (String) Research.Level1.get(rand);
					}
					if(level == 2)
					{
						posResearch = (String) Research.Level1.get(rand);
					}
					if(level == 3)
					{
						posResearch = (String) Research.Level1.get(rand);
					}	
					if(level == 4)
					{
						posResearch = (String) Research.Level1.get(rand);
					}
					if(level == 5)
					{
						posResearch = (String) Research.Level1.get(rand);
					}	
				}finally{
					
			}
			if(inStack != null)
			{
				id = inStack.itemID;
				if(posResearch.contains("" + id))
				{
					System.out.print("IT WORKS");
				}
			}
			System.out.println(posResearch);
			
		}
	}
}

