package electro.machines.assemblySystem;

import electro.Electrolysm;
import net.minecraft.item.Item;

/**
 * Created by Ben on 09/07/2014.
 */
public class ItemBluePrint extends Item
{
    public ItemBluePrint()
    {
        super();
        this.setUnlocalizedName("ItemBluePrint");
        this.setMaxStackSize(1);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
    }
}
