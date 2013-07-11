package mods.Electrolysm.electro;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.*;

public class TabElectrolysmPhysics extends CreativeTabs {
	
public TabElectrolysmPhysics(int position, String tabID) {
super(position, tabID); //The constructor for your tab
}


@SideOnly(Side.CLIENT)
public int getTabIconItemIndex() //The item it displays for your tab
{
return electrolysmCore.nanoTech.itemID; //For this we'll use the ruby
}
public String getTranslatedTabLabel()
{
return "Electrolysm - Physics"; //The name of the tab ingame
}
}