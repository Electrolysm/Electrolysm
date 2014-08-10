package electro.misc.item.basic;

import electro.Electrolysm;
import net.minecraft.item.Item;

public class drillHead extends Item
{
  public drillHead()
    {
        super();
        {
            this.setCreativeTab(Electrolysm.TabElectrolysm);
            this.setUnlocalizedName("Drill Head");
        }
    }
}

