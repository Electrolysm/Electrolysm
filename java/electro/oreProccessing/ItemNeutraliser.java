package electro.oreProccessing;

import electro.Electrolysm;
import net.minecraft.item.Item;

/**
 * Created by Ben on 12/07/2014.
 */
public class ItemNeutraliser extends Item
{
    public ItemNeutraliser()
    {
        super();
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setUnlocalizedName("itemNeutraliser");
    }
}
