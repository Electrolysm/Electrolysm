package assets.electrolysm.electro;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import assets.electrolysm.api.specialFuel.FuelData;
import assets.electrolysm.api.specialFuel.IFuelStorage;
import assets.electrolysm.api.specialFuel.ISpecialFuel;
import assets.electrolysm.api.specialFuel.SpecialFuelHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class electroContain extends Item implements IFuelStorage {

	@SideOnly(Side.CLIENT)
	private Icon[] containIcon;
	
	public electroContain(int id) {
		super(id);
		
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.hasSubtypes = true;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
    {
        int dmg = stack.getItemDamage();
        if(dmg != 0)
        {
        	return "electroContain_" + ((FuelData)(SpecialFuelHandler.getFuelList().get(dmg - 1))).getName();
        }
        return "electroContain_empty";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg)
    {
    	containIcon = new Icon[SpecialFuelHandler.getFuelList().size() + 1];

        for (int i = 0; i < SpecialFuelHandler.getFuelList().size() + 1; i ++)
        {
        	if(i == 0)
        	{
        		containIcon[i] = reg.registerIcon("electrolysm:electroContain/" + "electroContain_empty");
        	}
        	else
        	{
        		containIcon[i] = reg.registerIcon("electrolysm:electroContain/" + "electroContain_" + 
        						((FuelData)(SpecialFuelHandler.getFuelList().get(i - 1))).getName());
        	}
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int dmg)
    {
        return containIcon[dmg];
    }

    public void getSubItems(int id, CreativeTabs creativeTab, List list)
    {
        for (int i = 0; i < (SpecialFuelHandler.getFuelList().size() + 1); i++)
        {
            list.add(new ItemStack(electrolysmCore.electroContain, 1, i));
        }
    }
    

    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        for (int i = 0; i < (SpecialFuelHandler.getFuelList().size() + 1); i++)
        {
            if (stack.getItemDamage() == i)
            {
            	if(stack.getItemDamage() == 0)
            	{
            		list.add("Storing: Nothing" );
            	}
            	else
            	{
            		list.add("Storing: " + ((FuelData) (SpecialFuelHandler.getFuelList().get(i - 1))).getName());
            	}
            }
        }
    }

	@Override
	public boolean isFull(int meta) 
	{
		if(meta == 1)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isUsingNegativeMeta() 
	{
		return true;
	}
}
