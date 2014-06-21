package electro.crafting.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.Electrolysm;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class grindStone extends Item{

	@SideOnly(Side.CLIENT)
    private IIcon[] grindStoneIcon;
	
	public grindStone() {
		super();
		
		this.hasSubtypes = true;
		this.setCreativeTab(Electrolysm.TabElectrolysm);
	}
	
	public String getUnlocalizedName(ItemStack stack)
    {
        int dmg = stack.getItemDamage();
        return "grindStone_" + dmg;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        grindStoneIcon = new IIcon[3];
    	
        for (int i = 0; i < grindStoneIcon.length; i ++)
        {
        	grindStoneIcon[i] = reg.registerIcon("electrolysm:" + "grindStone-" + i);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int dmg)
    {
        return grindStoneIcon[dmg];
    }

    public void getSubItems(int id, CreativeTabs creativeTab, List list)
    {
        for (int i = 0; i < 3; i++)
        {
            list.add(new ItemStack(Electrolysm.grindStone, 1, i));
        }
    }

}
