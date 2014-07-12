package electro.item.fuels;

import electro.Electrolysm;
import net.minecraft.item.Item;

/**
 * Created by Ben on 12/07/2014.
 */
public class ItemImprovedCoal extends Item
{
    public ItemImprovedCoal()
    {
        super();
        this.setUnlocalizedName("improvedCoal");
        this.setCreativeTab(Electrolysm.TabElectrolysm);
    }
}
