package assets.electrolysm.electro;

import assets.electrolysm.electro.handlers.IDHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.*;

public class TabElements extends CreativeTabs {
	
	public TabElements(int position, String tabID) 
	{
		super(position, tabID); //The constructor for your tab
	}


	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() //The item it displays for your tab
	{
		return electrolysmCore.elementProof.itemID; //For this we'll use the ruby
	}
	
	public String getTranslatedTabLabel()
	{
		return "Electrolysm|Elements & Wizardy"; //The name of the tab ingame
	}
}