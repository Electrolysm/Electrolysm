package electrolysm.electro.misc.block.liquids;

import java.util.List;

import electrolysm.electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;

import org.apache.commons.lang3.text.WordUtils;

import electrolysm.electro.common.CommonProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class fluidRegistry extends Item /*implements IFluidContainerItem*/
{
    @SideOnly(Side.CLIENT)
    private IIcon[] fluidIcons;

	Fluid[] fluid = new Fluid[100];

    public fluidRegistry()
    {
        super();
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.hasSubtypes = true;
        /*
        System.out.println(Integer.MAX_VALUE);
    	
        for(int b = 0; b < Block.blocksList.length; b++)
    	{
        	for(int i = 0; i < fluid.length; i++)
    		{
    			if(FluidRegistry.lookupFluidForBlock(Block.blocksList[b]) != null)
    			{
   					System.out.println("Setting Fluid");
   					fluid[i] = FluidRegistry.lookupFluidForBlock(Block.blocksList[b]);
    			}
    		}
    	}*/
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        int dmg = stack.getItemDamage();
        return "fluidRegistry_" + fluid[dmg].getName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        fluidIcons = new IIcon[fluid.length];
        
        for(int i = 0; i < fluidIcons.length; i++)
        {
        	fluidIcons[i] = reg.registerIcon("electrolysm:fluidRegistry/" 
        					+ "fluidIcon_" + WordUtils.capitalize(fluid[i].getName().replace(" ", "_")));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int dmg)
    {
        return fluidIcons[dmg];
    }

    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
    	String name = fluid[stack.getItemDamage()].getName();
    	
    	list.add("Holding 1000mB of: " + name);
    }

    public void getSubItems(int id, CreativeTabs creativeTab, List list)
    {
    	boolean stop = false;
    	
        for (int i = 0; i < fluid.length; i++)
        {
        	if(fluid[i] != fluid[0] && stop == false)
        	{
        		list.add(new ItemStack(Electrolysm.fluidRegistry, 1, i));
        		stop = true;
        	}
        }
    }

    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y,
                             int z, int side, float clickX, float clickY, float clickZ)
    {/*
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

                LoggerHandler.severe(message1);
                LoggerHandler.severe(message2);
                /*
                player.sendChatToPlayer(
                    ChatMessageComponent.createFromText(message1).setColor(EnumChatFormatting.DARK_RED));
                player.sendChatToPlayer(
                    ChatMessageComponent.createFromText(message2).setColor(EnumChatFormatting.DARK_RED));*//*
            }
        }*/

        return false;
    }

    private Block getBlockBasedOnItemStack(ItemStack item)
    {
        String displayName = CommonProxy.FLUIDS[item.getItemDamage()];

        if (displayName.toLowerCase().contains("plasma"))
        {
            return Electrolysm.plasma;
        }
        else if (displayName.toLowerCase().contains("sulphuric"))
        {
            return Electrolysm.sulpuricAcid;
        }

        return null;
    }
}