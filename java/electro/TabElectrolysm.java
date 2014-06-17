package electro;

import electro.handlers.IDHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.*;

public class TabElectrolysm extends CreativeTabs
{
	String TabLabel;
	
    public TabElectrolysm(int position, String tabID)
    {
        super(position, tabID); //The constructor for your tab
        TabLabel = tabID;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack getIconItemStack()
    {
        return new ItemStack(electrolysmCore.plasmaDrill, 1, 1);
    }


    public String getTranslatedTabLabel()
    {
        return TabLabel; //The name of the tab ingame
    }
}