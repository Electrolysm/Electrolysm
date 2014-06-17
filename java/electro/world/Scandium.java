package electro.world;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.common.CommonProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Scandium extends Item {

	@SideOnly(Side.CLIENT)
	private Icon iconIngot;
	
	public Scandium(int id) {
		super(id);

		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.hasSubtypes = true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg)
    {
        this.itemIcon = reg.registerIcon("electrolysm:" + "ScandiumDust");
        this.iconIngot = reg.registerIcon("electrolysm:" + "ScandiumIngot");
    }
	
	@Override
    public String getUnlocalizedName(ItemStack stack)
    {
        int dmg = stack.getItemDamage();
        return "scandium" + dmg;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int dmg)
    {
    	if(dmg == 0)
    	{
    		return itemIcon;
    	}
    	else
    	{
    		return this.iconIngot;
    	}
    }
    
    @Override
    public void getSubItems(int id, CreativeTabs creativeTab, List list)
    {
    	list.add(new ItemStack(this, 1, 0));
    	list.add(new ItemStack(this, 1, 1));
    }
	
	

}
