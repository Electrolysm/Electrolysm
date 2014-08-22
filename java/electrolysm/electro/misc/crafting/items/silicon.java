package electrolysm.electro.misc.crafting.items;

import electrolysm.electro.Electrolysm;
import net.minecraft.item.Item;

public class silicon extends Item
{
    public silicon()
    {
        super();
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setUnlocalizedName("silicon");
    }
}