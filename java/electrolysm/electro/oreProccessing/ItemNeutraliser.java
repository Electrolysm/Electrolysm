package electrolysm.electro.oreProccessing;

import electrolysm.electro.Electrolysm;
import net.minecraft.client.renderer.texture.IIconRegister;
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

    @Override
    public void registerIcons(IIconRegister reg) {
        itemIcon = reg.registerIcon("electrolysm:neutraliser");
    }
}
