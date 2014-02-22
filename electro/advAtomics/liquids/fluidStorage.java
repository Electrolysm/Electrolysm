package assets.electrolysm.electro.advAtomics.liquids;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.common.CommonProxy;
import assets.electrolysm.electro.research.Research;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;
import net.minecraftforge.fluids.ItemFluidContainer;

public class fluidStorage extends ItemFluidContainer implements IFluidOre/*, IFluidContainerItem*/
{
    @SideOnly(Side.CLIENT)
    private Icon[] fluidIcons;

    public fluidStorage(int ID)
    {
        super(ID);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.hasSubtypes = true;
    }

    public String getUnlocalizedName(ItemStack stack)
    {
        int dmg = stack.getItemDamage();
        return "fluidStorage_" + CommonProxy.HOLDABLE_FLUIDS[dmg];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg)
    {
        fluidIcons = new Icon[CommonProxy.HOLDABLE_FLUIDS.length];

        for (int i = 0; i < CommonProxy.HOLDABLE_FLUIDS.length; i ++)
        {
            fluidIcons[i] = reg.registerIcon("electrolysm:fluidStorage/" +
                                             "fluidStorage_" + CommonProxy.HOLDABLE_FLUIDS[i].replace(" ", "_"));
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
        for (int i = 0; i < CommonProxy.HOLDABLE_FLUIDS.length; i++)
        {
            if (stack.getItemDamage() == i)
            {
                list.add("Holding 1000mB of: " + CommonProxy.HOLDABLE_FLUIDS[i]);
            }
        }
    }

    public void getSubItems(int id, CreativeTabs creativeTab, List list)
    {
        for (int i = 0; i < CommonProxy.HOLDABLE_FLUIDS.length; i++)
        {
            list.add(new ItemStack(electrolysmCore.fluidStorage, 1, i));
        }
    }

    @Override
    public String getOreFluid(ItemStack item)
    {
        if (CommonProxy.HOLDABLE_FLUIDS[item.getItemDamage()].contains("Sulphate"))
        {
            return CommonProxy.HOLDABLE_FLUIDS[item.getItemDamage()];
        }

        return null;
    }

    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y,
                             int z, int side, float clickX, float clickY, float clickZ)
    {
        if (this.getBlockIDBasedOnItemStack(item) != 0)
        {
            if (side == 0)
            {
                //Bottom
                world.setBlock(x, y - 1, z, this.getBlockIDBasedOnItemStack(item));
            }
            else if (side == 1)
            {
                //Top
                world.setBlock(x, y + 1, z, this.getBlockIDBasedOnItemStack(item));
            }
            else if (side == 2)
            {
                //Right
                world.setBlock(x, y, z - 1, this.getBlockIDBasedOnItemStack(item));
            }
            else if (side == 3)
            {
                world.setBlock(x, y, z + 1, this.getBlockIDBasedOnItemStack(item));
            }
            else if (side == 4)
            {
                world.setBlock(x - 1, y, z, this.getBlockIDBasedOnItemStack(item));
            }
            else if (side == 5)
            {
                world.setBlock(x + 1, y, z, this.getBlockIDBasedOnItemStack(item));
            }
            else
            {
                String message1 = "Unknown Error when placing liquid block!";
                String message2 = "This is a bug! Please report it to the MOD author";
                System.out.println(message1);
                System.out.println(message2);
                player.sendChatToPlayer(
                    ChatMessageComponent.createFromText(message1).setColor(EnumChatFormatting.DARK_RED));
                player.sendChatToPlayer(
                    ChatMessageComponent.createFromText(message2).setColor(EnumChatFormatting.DARK_RED));
            }
        }

        return false;
    }

    private int getBlockIDBasedOnItemStack(ItemStack item)
    {
        String displayName = CommonProxy.HOLDABLE_FLUIDS[item.getItemDamage()];

        if (displayName.toLowerCase().contains("plasma"))
        {
            return electrolysmCore.plasma.blockID;
        }
        else if (displayName.toLowerCase().contains("sulphuric"))
        {
            return electrolysmCore.sulpuricAcid.blockID;
        }

        return 0;
    }
}
