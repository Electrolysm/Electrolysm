package assets.electrolysm.electro.crafting.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class endoInsulator extends Item
{
    public endoInsulator(int id)
    {
        super(id);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName("endoInsulator");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister reg)
    {
        this.itemIcon = reg.registerIcon("electrolysm:" + "endoInsulator");
    }
}
