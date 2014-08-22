package electrolysm.electro.misc.crafting.items;

import electrolysm.electro.Electrolysm;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class pureCopperIngot extends Item
{
    public pureCopperIngot()
    {
        super();
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setUnlocalizedName("pureIngotCopper");
    }

    @Override
    public void registerIcons(IIconRegister reg) {
        itemIcon = reg.registerIcon("electrolysm:pureCopperIngot");
    }
}

