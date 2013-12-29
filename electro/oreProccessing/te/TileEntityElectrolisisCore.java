package assets.electrolysm.electro.oreProccessing.te;

import cpw.mods.fml.common.Loader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.api.powerSystem.TileEntityPlug;
import assets.electrolysm.api.powerSystem.meter.IMeterable;
import assets.electrolysm.api.powerSystem.usageMachine.IPullEnergy;
import assets.electrolysm.api.powerSystem.usageMachine.TileEntityEnergyMachine;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.oreProccessing.recipes.electrolisisRecipes;

public class TileEntityElectrolisisCore extends TileEntityEnergyMachine implements IInventory, IPullEnergy, IMeterable
{
	//GUI STUFF
	
	public int furnaceBurnTime = 0;
	
	public int currentItemBurnTime = furnaceBurnTime;
	
	public int heat = 0;

	public int furnaceCookTime = 5000;

	public static boolean active = false;
	
	public static boolean powered = true;

	private ItemStack[] inventory;

	public TileEntityElectrolisisCore() {
		this.inventory = new ItemStack[5];
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

		World world = worldObj;
		active = powered;

		boolean canwork = (powered && heat > 10);

		int portID = electrolysmCore.electrolPort.blockID;
		boolean portSet = false;
		
		if (heat < 50)
		{
			heat = 100;
		}

		if (canwork && this.canWork(worldObj, xCoord, yCoord, zCoord)) 
		{
			furnaceCookTime = 5000 / heat;

			ItemStack input1 = getStackInSlot(0);
			ItemStack input2 = getStackInSlot(1);
			ItemStack output1 = getStackInSlot(2);
			ItemStack result1;
			ItemStack node1 = getStackInSlot(3);
			ItemStack node2 = getStackInSlot(4);
			
			ItemStack node = new ItemStack(electrolysmCore.node, 1);
			
			if(node1 == node2 && node1 == node)
			{
				return;
			}
			if(node1 == null || node2 == null)
			{
				return;
			}
			if(input1 != null && input2 != null)
			{
				if(input1.isItemEqual(input2))
				{
					result1 = electrolisisRecipes.smelting().getSmeltingResult(input1);
			    	worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord);

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
			
			if (result1 != null) 
			{
				this.working = true;
				if (furnaceBurnTime == furnaceCookTime)
				{		
					furnaceBurnTime = 0;
					if (output1 == null) 
					{
						if(this.getPorts(xCoord, yCoord, zCoord, worldObj) == 0)
						{
							decrStackSize(0, 1);
							decrStackSize(1, 1);
							setInventorySlotContents(2, result1);
							onInventoryChanged();
						}
					} 
					else 
					{
						if (output1.isItemEqual(result1)) 
						{
							decrStackSize(0, 1);
							decrStackSize(1, 1);
							for(int i = 0; i < 4; i++)
							{
								output1.stackSize++;
							}
						}
					}
				} 
				else 
				{
					furnaceBurnTime++;
					if (output1 != null && !output1.isItemEqual(result1))
					{
						furnaceBurnTime = 0;
					}
				}
			}
			else
			{
				working = false;
			}
			if (output1 != null && output1.stackSize == 0) 
			{
				output1.stackSize = 1;
			}
		}

		if (getStackInSlot(0) == null)
		{
			furnaceBurnTime = 0;
		}
		
	}

	private int getPorts(int x, int y, int z, World world)
	{
		int port = electrolysmCore.electrolPort.blockID;
		int ports = 0;
		
		if(world.getBlockId(x + 1, y, z) == port)
		{
			ports = ports + 1;
		}
		if(world.getBlockId(x - 1, y, z) == port)
		{
			ports = port + 1;
		}
		if(world.getBlockId(x, y, z + 1) == port)
		{
			ports = ports + 1;
		}
		if(world.getBlockId(x, y, z - 1) == port)
		{
			ports = ports + 1;
		}
			
		return ports;
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

	@Override
	public float getPlugRecievingTeU(World world, int x, int y, int z) 
	{
		if(Loader.isModLoaded("Electrolysm"))
		{
			TileEntity teWorld = world.getBlockTileEntity(x, y, z);
			if(teWorld instanceof TileEntityPlug)
			{
				TileEntityPlug te = (TileEntityPlug)teWorld;
				return te.getRecievedTeUAfterResistance(world, x, y, z);
			}
		}
		return 0;
	}

	@Override
	public int getActivationEnergy() 
	{
		return 90;
	}

	@Override
	public boolean isWorking() 
	{
		return working;
	}
}
