package electro.crafting.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import electro.electrolysmCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class endoInsulator extends Item
{
    public endoInsulator()
    {
        super();
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName("endoInsulator");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister reg)
    {
        this.itemIcon = reg.registerIcon("electrolysm:" + "endoInsulator");
    }
}
