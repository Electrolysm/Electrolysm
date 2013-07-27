package mods.Electrolysm.electro;

import mods.Electrolysm.electro.biology.bacteria.Bacteria;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.*;

public class TabElectrolysmBiology extends CreativeTabs {
	
public TabElectrolysmBiology(int position, String tabID) {
super(position, tabID); //The constructor for your tab
}


@SideOnly(Side.CLIENT)
public int getTabIconItemIndex() //The item it displays for your tab
{
return Bacteria.bacteriaFusoR.itemID; //For this we'll use the ruby
}
public String getTranslatedTabLabel()
{
return "Electrolysm - Biology"; //The name of the tab ingame
}
}