package assets.electrolysm.electro.powerSystem;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import assets.electrolysm.api.LoggerHandler;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWire extends Item
{
    String[] name = {"wire", "advWire"};
    @SideOnly(Side.CLIENT)
    private Icon[] wireIcon;

    public ItemWire(int par1)
    {
        super(par1);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg)
    {
        wireIcon = new Icon[1];
        wireIcon[0] = reg.registerIcon("electrolysm:" + "basicWire");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int dmg)
    {
        return wireIcon[dmg];
    }

    public String getUnlocalizedName(ItemStack stack)
    {
        int dmg = stack.getItemDamage();
        return "itemWire" + this.name[dmg];
    }

    public void getSubItems(int id, CreativeTabs creativeTab, List list)
    {
    	list.add(new ItemStack(electrolysmCore.ItemWire, 1, 0));
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
    	
        if (this.getBlockIDBasedOnItemStack(item) != 0)
        {
            if (side == 0)
            {
                //Bottom
                if (world.getBlockId(x, y - 1, z) == 0)
                {
                    world.setBlock(x, y - 1, z, this.getBlockIDBasedOnItemStack(item));
                    item.stackSize = item.stackSize - deductAmount;
                    return true;
                }
            }
            else if (side == 1)
            {
                //Top
                if (world.getBlockId(x, y + 1, z) == 0)
                {
                    world.setBlock(x, y + 1, z, this.getBlockIDBasedOnItemStack(item));
                    item.stackSize = item.stackSize - deductAmount;
                    return true;
                }
            }
            else if (side == 2)
            {
                //Right
                if (world.getBlockId(x, y, z - 1) == 0)
                {
                    world.setBlock(x, y, z - 1, this.getBlockIDBasedOnItemStack(item));
                    item.stackSize = item.stackSize - deductAmount;
                    return true;
                }
            }
            else if (side == 3)
            {
                if (world.getBlockId(x, y, z + 1) == 0)
                {
                    world.setBlock(x, y, z + 1, this.getBlockIDBasedOnItemStack(item));
                    item.stackSize = item.stackSize - deductAmount;
                    return true;
                }
            }
            else if (side == 4)
            {
                if (world.getBlockId(x - 1, y, z) == 0)
                {
                    world.setBlock(x - 1, y, z, this.getBlockIDBasedOnItemStack(item));
                    item.stackSize = item.stackSize - deductAmount;
                    return true;
                }
            }
            else if (side == 5)
            {
                if (world.getBlockId(x + 1, y, z) == 0)
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

    private int getBlockIDBasedOnItemStack(ItemStack item)
    {
        int meta = item.getItemDamage();

        if (meta == 0)
        {
            return electrolysmCore.endoCable.blockID;
        }
            return 0;
    }
}