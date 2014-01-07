package assets.electrolysm.electro.advAtomics.elements;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.handlers.ElementHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class elementProof extends Item {

	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public elementProof(int id) {
		super(id);

		this.setCreativeTab(electrolysmCore.TabElements);
		
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister reg)
	{
		this.icons = new Icon[ElementHandler.elements.length];
		
		for(int i = 0; i < icons.length; i++)
		{
			this.icons[i] = reg.registerIcon("electrolysm:atomics/" + "element-" + i);
			this.icons[0] = reg.registerIcon("electrolysm:atomics/" + "atomBase");
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIconFromDamage(int dmg)
	{
		return this.icons[dmg];
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		int dmg = stack.getItemDamage();
		return "elementProof" + ElementHandler.elements[dmg];
	}
	
	public void getSubItems(int id, CreativeTabs creativeTab, List list)
    {
    	for(int i = 0; i < ElementHandler.elements.length; i++)
    	{
    		list.add(new ItemStack(electrolysmCore.elementProof, 1, i));
    	}
    }
}
