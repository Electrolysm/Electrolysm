package assets.electrolysm.electro.powerSystem.generators.te;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.block.te.TileEntityIronFrame;
import assets.electrolysm.electro.powerSystem.te.TileEntityTeslaTower;
import assets.electrolysm.electro.powerSystem.te.TileEntityWire;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityGenerator extends TileEntity implements IInventory, ISidedInventory{

	private ItemStack[] inventory = new ItemStack[1];
	private int[] generatorPower = {100, 1000, 10000, 100000};
	private int[] generatorIDs = {electrolysmCore.generator.blockID, 1, 1, electrolysmCore.matterGen.blockID,};
	private String[] generatorNames = {"Coal", "Geothermal", "Fusion", "Matter-Antimatter"}; 
	protected boolean[] visuallyConnected = new boolean[6];
    protected TileEntity[] adjacentConnections = new TileEntity[6];
	
	public boolean isWorking(World world, int x, int y, int z)
	{
		//int electrolysmCore.ironFrames.blockID = electrolysmCore.ironFrames.blockID;
		//int electrolysmCore.teslaTowerCore.blockID = electrolysmCore.teslaTowerCore.blockID;
		
		int id = world.getBlockId(x, y, z);
		
		if(this.getStackInSlot(0) != null)
		{
			for(int i = 0; i < adjacentConnections.length; i++)
			{
				if(visuallyConnected[i])
				{
					TileEntityWire te = (TileEntityWire)adjacentConnections[i];
					if(te.backToTesla(world, te.xCoord, te.yCoord, te.zCoord))
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	@Override
    public void updateEntity()
    {
        for (byte i = 0; i < 6; i++)
        {
            ForgeDirection dir = ForgeDirection.getOrientation(i);
            this.updateConnection(this.worldObj.getBlockTileEntity(this.xCoord + dir.offsetX, this.yCoord + dir.offsetY,
            		this.zCoord + dir.offsetZ), dir);
        }
    }
    
    public void updateConnection(TileEntity that, ForgeDirection side)
    {
        if (!this.worldObj.isRemote && that != null && this.canConnect(side))
        {
        }
        else if (that instanceof TileEntityWire)
        {
          	TileEntityWire tileEntityIns = (TileEntityWire) that;
               
            if (((TileEntityWire) that).canConnect(side.getOpposite()))
            {
                  this.adjacentConnections[side.ordinal()] = that;
                  this.visuallyConnected[side.ordinal()] = true;
                      
                  return;
            }
        }
        else if (that instanceof TileEntityIronFrame)
        {
        	TileEntityIronFrame tileEntityIns = (TileEntityIronFrame) that;
	           
	        if (((TileEntityIronFrame) that).canConnect(side.getOpposite()))
	        {
	             this.adjacentConnections[side.ordinal()] = that;
	             this.visuallyConnected[side.ordinal()] = true;
	                
	             return;
	        }
	    }
        else if (that instanceof TileEntityGenerator)
	    {
        	TileEntityGenerator tileEntityIns = (TileEntityGenerator) that;
	            
	        if (((TileEntityGenerator) that).canConnect(side.getOpposite()))
	        {
	            this.adjacentConnections[side.ordinal()] = that;
	            this.visuallyConnected[side.ordinal()] = true;
	                
	            return;
	        }
	    }
        
        this.adjacentConnections[side.ordinal()] = null;
        this.visuallyConnected[side.ordinal()] = false;
    }

	public int getSendTeU(World world, int x, int y, int z)
	{
		int blockID = world.getBlockId(x, y, z);
		
		for(int i = 0; i < this.generatorIDs.length; i++)
		{
			if(this.isWorking(world, x, y, z))
			{
				return this.generatorPower[i];
			}
		}
		
		return 0;
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
   
        if(this.getStackInSlot(0) != null)
        {
        	tag.setInteger("itemID", this.getStackInSlot(0).itemID);
        	tag.setInteger("stackSize", this.getStackInSlot(0).stackSize);
        	tag.setInteger("itemMeta", this.getStackInSlot(0).getItemDamage());
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

	@SuppressWarnings("null")
	@Override
	public ItemStack decrStackSize(int slot, int amount)
	{
		ItemStack stack = getStackInSlot(slot);
		if (stack != null)
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
		for(int i = 0; i < generatorIDs.length; i++)
		{
			int id = generatorIDs[i];
			if(world.getBlockId(x, y, z) == id)
			{
				String names = generatorNames[i];
				if(names.contains("Antimatter") || names.contains("Fusion"))
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
		for(int i = 0; i < generatorIDs.length; i++)
		{
			int id = generatorIDs[i];
			if(blockID == id)
			{
				String names = generatorNames[i];
				if(names.contains("Antimatter") || names.contains("Fusion"))
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
	public void openChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
    public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack)
    {
        return par1 == 2 ? false : (par1 == 1 ? isItemFuel(par2ItemStack) : true);
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

		else
		{
			int i = itemStack.getItem().itemID;
			Item item = itemStack.getItem();

			if (itemStack.getItem() instanceof ItemBlock && Block.blocksList[i] != null)
			{
				Block block = Block.blocksList[i];

				if (block == Block.woodSingleSlab)
				{
					return 150;
				}

				if (block.blockMaterial == Material.wood)
				{
					return 300;
				}
			}

			if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) return 200;
			if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) return 200;
			if (i == Item.bucketLava.itemID) return 1000;
			return GameRegistry.getFuelValue(itemStack);
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
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setGuiDisplayName(String displayName) 
	{
		
	}

	public boolean canConnect(ForgeDirection side) {
		// TODO Auto-generated method stub
		return true;
	}
}
