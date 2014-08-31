package electro.powerSystem;

import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import electrolysm.api.LoggerHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWire extends Item
{
    String[] name = {"wire", "advWire"};
    @SideOnly(Side.CLIENT)
    private IIcon[] wireIcon;

    public ItemWire()
    {
        super();
        this.setCreativeTab(Electrolysm.TabElectrolysm);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        wireIcon = new IIcon[1];
        wireIcon[0] = reg.registerIcon("electrolysm:" + "basicWire");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int dmg)
    {
        return wireIcon[dmg];
    }

    public String getUnlocalizedName(ItemStack stack)
    {
        int dmg = stack.getItemDamage();
        return "itemWire" + this.name[dmg];
    }


    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y,
                             int z, int side, float clickX, float clickY, float clickZ)
    {
    	int deductAmount = 0;
    	
    	if(player.capabilities.isCreativeMode)
    	{
    		deductAmount = 0;
    	}
    	else
    	{
    		deductAmount = 1;
    	}
    	
        if (this.getBlockIDBasedOnItemStack(item) != null)
        {
            if (side == 0)
            {
                //Bottom
                if (world.getBlock(x, y - 1, z) == null)
                {
                    world.setBlock(x, y - 1, z, this.getBlockIDBasedOnItemStack(item));
                    item.stackSize = item.stackSize - deductAmount;
                    return true;
                }
            }
            else if (side == 1)
            {
                //Top
                if (world.getBlock(x, y + 1, z) == null)
                {
                    world.setBlock(x, y + 1, z, this.getBlockIDBasedOnItemStack(item));
                    item.stackSize = item.stackSize - deductAmount;
                    return true;
                }
            }
            else if (side == 2)
            {
                //Right
                if (world.getBlock(x, y, z - 1) == null)
                {
                    world.setBlock(x, y, z - 1, this.getBlockIDBasedOnItemStack(item));
                    item.stackSize = item.stackSize - deductAmount;
                    return true;
                }
            }
            else if (side == 3)
            {
                if (world.getBlock(x, y, z + 1) == null)
                {
                    world.setBlock(x, y, z + 1, this.getBlockIDBasedOnItemStack(item));
                    item.stackSize = item.stackSize - deductAmount;
                    return true;
                }
            }
            else if (side == 4)
            {
                if (world.getBlock(x - 1, y, z) == null)
                {
                    world.setBlock(x - 1, y, z, this.getBlockIDBasedOnItemStack(item));
                    item.stackSize = item.stackSize - deductAmount;
                    return true;
                }
            }
            else if (side == 5)
            {
                if (world.getBlock(x + 1, y, z) == null)
                {
                    world.setBlock(x + 1, y, z, this.getBlockIDBasedOnItemStack(item));
                    item.stackSize = item.stackSize - deductAmount;
                    return true;
                }
            }
            else
            {
                String message1 = "Unknown Error when placing wire block!";
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

        return false;
    }

    private Block getBlockIDBasedOnItemStack(ItemStack item)
    {/*
        int meta = item.getItemDamage();

        if (meta == 0)
        {*/
            return Electrolysm.basicCable;/*
        }
        return null;*/
    }
}