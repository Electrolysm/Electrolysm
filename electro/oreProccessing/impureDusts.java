package assets.electrolysm.electro.oreProccessing;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.common.CommonProxy;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class impureDusts extends Item {

	@SideOnly(Side.CLIENT)
	private Icon[] dustIcon;
	
	public impureDusts(int par1) {
		super(par1);

	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	}

	public String getUnlocalizedName(ItemStack stack)
	{
		int dmg = stack.getItemDamage();
		return "impureDust" + CommonProxy.DUSTS[dmg];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg)
	{
		dustIcon = new Icon[CommonProxy.DUSTS.length];
		
		for(int i = 0; i < CommonProxy.DUSTS.length; i ++)
		{
			dustIcon[i] = reg.registerIcon("electrolysm:impureDusts/" + "impureDusts" + CommonProxy.DUSTS[i]);
		}
	}
   
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg)
	{
		return dustIcon[dmg];
	}
	
	public void getSubItems(int id, CreativeTabs creativeTab, List list)
    {
    	for(int i = 0; i < CommonProxy.DUSTS.length; i++)
    	{
    		list.add(new ItemStack(electrolysmCore.impureDusts, 1, i));
    	}
    }
}
