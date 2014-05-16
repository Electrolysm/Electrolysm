package assets.electrolysm.electro.block.liquids;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import assets.electrolysm.api.LoggerHandler;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.common.CommonProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class fluidStorage extends Item implements IFluidOre/*, IFluidContainerItem*/
{
    @SideOnly(Side.CLIENT)
    private Icon[] fluidIcons;

    public fluidStorage(int ID)
    {
        super(ID);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.hasSubtypes = true;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        int dmg = stack.getItemDamage();
        return "fluidStorage_" + CommonProxy.FLUIDS[dmg];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg)
    {
        fluidIcons = new Icon[CommonProxy.FLUIDS.length];

        for (int i = 0; i < CommonProxy.FLUIDS.length; i ++)
        {
            fluidIcons[i] = reg.registerIcon("electrolysm:fluidStorage/" +
                                             "fluidStorage_" + CommonProxy.FLUIDS[i].replace(" ", "_"));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int dmg)
    {
        return fluidIcons[dmg];
    }

    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        for (int i = 0; i < CommonProxy.FLUIDS.length; i++)
        {
            if (stack.getItemDamage() == i)
            {
                list.add("Holding 1000mB of: " + CommonProxy.FLUIDS[i]);
            }
        }
    }

    public void getSubItems(int id, CreativeTabs creativeTab, List list)
    {
        for (int i = 0; i < CommonProxy.FLUIDS.length; i++)
        {
            list.add(new ItemStack(electrolysmCore.fluidStorage, 1, i));
        }
    }

    @Override
    public String getOreFluid(ItemStack item)
    {
        if (CommonProxy.FLUIDS[item.getItemDamage()].contains("Sulphate"))
        {
            return CommonProxy.FLUIDS[item.getItemDamage()];
        }

        return null;
    }

    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y,
                             int z, int side, float clickX, float clickY, float clickZ)
    {
    	int xCoord = getXBasedSide(side);
    	int yCoord = getYBasedSide(side);
    	int zCoord = getZBasedSide(side);
    	
    	if(world.getBlockId(x + xCoord, y + yCoord, z + zCoord) == 0)
    	{
	        if (this.getBlockIDBasedOnItemStack(item) != 0)
	        {
	            if (side == 0)
	            {
	                //Bottom
	                world.setBlock(x, y - 1, z, this.getBlockIDBasedOnItemStack(item));
	                item.stackSize--;
	                this.setInventory(player, player.inventory, new ItemStack(electrolysmCore.fluidStorage, 1, 0));
	            }
	            else if (side == 1)
	            {
	                //Top
	                world.setBlock(x, y + 1, z, this.getBlockIDBasedOnItemStack(item));
	                item.stackSize--;
	                this.setInventory(player, player.inventory, new ItemStack(electrolysmCore.fluidStorage, 1, 0));
	            }
	            else if (side == 2)
	            {
	                //Right
	                world.setBlock(x, y, z - 1, this.getBlockIDBasedOnItemStack(item));
	                item.stackSize--;
	                this.setInventory(player, player.inventory, new ItemStack(electrolysmCore.fluidStorage, 1, 0));
	            }
	            else if (side == 3)
	            {
	                world.setBlock(x, y, z + 1, this.getBlockIDBasedOnItemStack(item));
	                item.stackSize--;
	                this.setInventory(player, player.inventory, new ItemStack(electrolysmCore.fluidStorage, 1, 0));
	            }
	            else if (side == 4)
	            {
	                world.setBlock(x - 1, y, z, this.getBlockIDBasedOnItemStack(item));
	                item.stackSize--;
	                this.setInventory(player, player.inventory, new ItemStack(electrolysmCore.fluidStorage, 1, 0));
	            }
	            else if (side == 5)
	            {
	                world.setBlock(x + 1, y, z, this.getBlockIDBasedOnItemStack(item));
	                item.stackSize--;
	                this.setInventory(player, player.inventory, new ItemStack(electrolysmCore.fluidStorage, 1, 0));
	            }
	            else
	            {
	                String message1 = "Unknown Error when placing liquid block!";
	                String message2 = "This is a bug! Please report it to the MOD author";
	
	                LoggerHandler.severe(message1);
	                LoggerHandler.severe(message2);
	                /*
	                player.sendChatToPlayer(
	                    ChatMessageComponent.createFromText(message1).setColor(EnumChatFormatting.DARK_RED));
	                player.sendChatToPlayer(
	                    ChatMessageComponent.createFromText(message2).setColor(EnumChatFormatting.DARK_RED));*/
	            }
	        }
    	}
    	else if(item.getItemDamage() == 0)
    	{
    		if(this.getMetaFromID(world.getBlockId(x + xCoord, y + yCoord, z + zCoord)) != 0);
    		{
    			int meta = this.getMetaFromID(world.getBlockId(x + xCoord, y + yCoord, z + zCoord));
    			if(item.stackSize > 1)
    			{
    				item = new ItemStack(electrolysmCore.fluidStorage, 1, meta);
    				world.setBlockToAir(x + xCoord, y + yCoord, z + zCoord);
    			}
    			else
    			{
    				item.stackSize--;
    				setInventory(player, player.inventory, new ItemStack(electrolysmCore.fluidStorage, 1, meta));
    				world.setBlockToAir(x + xCoord, y + yCoord, z + zCoord);
    			}
    		}
    	}
    	
        return false;
    }

	private int getXBasedSide(int side) 
	{
		if(side == 4)
		{
			return -1;
		}
		else if(side == 5)
		{
			return 1; 
		}
		return 0;
	}

	private int getZBasedSide(int side)
	{
		if(side == 2)
		{
			return -1;
		}
		else if(side == 3)
		{
			return 1;
		}
		return 0;
	}

	private int getYBasedSide(int side) 
	{
		if(side == 0)
		{
			return -1;
		}
		else if(side == 1)
		{
			return 1;
		}
			
		return 0;
	}

	private int getMetaFromID(int blockID) 
	{
		if(blockID == electrolysmCore.plasma.blockID)
		{
			return 1;
		}
		else if(blockID == electrolysmCore.sulpuricAcid.blockID)
		{
			return 2;
		}
		else if(blockID == Block.waterStill.blockID)
		{
			return 9;
		}
			
		return 0;
	}

	private void setInventory(EntityPlayer player, InventoryPlayer inventory, ItemStack itemStack) 
    {
    	for(int i = 0; i < inventory.mainInventory.length; i++)
    	{
    		ItemStack inslot = inventory.getStackInSlot(i);
    		
    		if((inslot == null || inslot.isItemEqual(itemStack)));
    		{
    			if(inslot == null)
    			{
    				inventory.setInventorySlotContents(i, itemStack);
    				return;
    			}
    			else if(inslot.getItemDamage() == itemStack.getItemDamage())
    			{
    				inventory.setInventorySlotContents(i, new ItemStack(itemStack.getItem(), itemStack.stackSize + 
    						inslot.stackSize, itemStack.getItemDamage()));
    				return;
    			}
    		}
    	}
    	
    	player.dropPlayerItem(itemStack);
    	return;
	}

	private int getBlockIDBasedOnItemStack(ItemStack item)
    {
        String displayName = CommonProxy.FLUIDS[item.getItemDamage()];

        if (displayName.toLowerCase().contains("plasma"))
        {
            return electrolysmCore.plasma.blockID;
        }
        else if (displayName.toLowerCase().contains("sulphuric"))
        {
            return electrolysmCore.sulpuricAcid.blockID;
        }
        else if (displayName.toLowerCase().contains("water"))
        {
            return Block.waterStill.blockID;
        }

        return 0;
    }
}