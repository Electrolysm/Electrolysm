package electrolysm.electro;

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
        return new ItemStack(Electrolysm.plasmaDrill, 1, 1);
    }

    @Override
    public Item getTabIconItem() { return Electrolysm.plasmaDrill; }


    public String getTranslatedTabLabel()
    {
        return TabLabel; //The name of the tab ingame
    }
}