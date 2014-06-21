package electro.world;

import java.util.List;

import electro.Electrolysm;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Scandium extends Item {

	@SideOnly(Side.CLIENT)
	private IIcon iconIngot;
	
	public Scandium() {
		super();

		this.setCreativeTab(Electrolysm.TabElectrolysm);
		this.hasSubtypes = true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
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
    public IIcon getIconFromDamage(int dmg)
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
    public void getSubItems(Item id, CreativeTabs creativeTab, List list)
    {
    	list.add(new ItemStack(this, 1, 0));
    	list.add(new ItemStack(this, 1, 1));
    }
	
	

}
