package assets.electrolysm.electro.powerSystem.te;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.electro.powerSystem.TeslaTransmittingServer;
import assets.electrolysm.electro.powerSystem.crystal1;

public class TileEntityPlug extends TileEntity implements IInventory{

	@Override
	public void updateEntity()
	{
		this.isRecieving();
	}

	private boolean getClosestTowerWithinRange(World world, int x, int y, int z, int freq, String username) 
	{
		for(int i = 0; i < TeslaTransmittingServer.taken.size(); i++)
		{
			String[] serverData = TeslaTransmittingServer.getData(this.getStackInSlot(1));
			int towerX = Integer.parseInt(serverData[0]);
			int towerY = Integer.parseInt(serverData[1]);
			int towerZ = Integer.parseInt(serverData[2]);
			
			int distance = this.calculateDistance(x, y, z, towerX, towerY, towerZ);
			int towerRange = Integer.parseInt(serverData[3]);
			
			if(distance <= towerRange)
			{
				return true;
			}
		}
		
		return false;
	}

	private int calculateDistance(int x, int y, int z, int towerX, int towerY, int towerZ) 
	{
		int xPower = (int)Math.pow((x - towerX), 2);
		int yPower = (int)Math.pow((y - towerY), 2);
		int zPower = (int)Math.pow((z - towerZ), 2);
		
		return (int)(Math.sqrt(xPower + yPower + zPower));
	}
	
	public boolean isRecieving()
	{
		ItemStack crystalStack = this.getStackInSlot(0);
		crystal1 crystal;
		if(crystalStack != null)
		{
			crystal = (crystal1) crystalStack.getItem();
			if(crystal != null)
			{
				String username = /*crystal.getData()[1]*/ "user";
				int freq = /*Integer.parseInt(crystal.getData()[0])*/ 1;
				if(this.getClosestTowerWithinRange(worldObj, xCoord, yCoord, zCoord, freq, username))
				{
					return true;
				}
			}
		}
		return false;
	}

	/*
 * =========================================================
 * 					GUI Code
 * =========================================================
 */
	private ItemStack[] inventory;
	public boolean isOpen;
	
	public TileEntityPlug() {
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
}
