package assets.electrolysm.electro;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.*;

public class TabElectrolysm extends CreativeTabs {
	
public TabElectrolysm(int position, String tabID) {
super(position, tabID); //The constructor for your tab
}


@SideOnly(Side.CLIENT)
public int getTabIconItemIndex() //The item it displays for your tab
{
return electrolysmCore.bionicHead.itemID; //For this we'll use the ruby
}
public String getTranslatedTabLabel()
{
return "Electrolysm - Basics of Science"; //The name of the tab ingame
}
}