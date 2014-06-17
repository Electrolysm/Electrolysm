package electro.crafting.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class crystalBase extends Item
{
    public crystalBase(int id)
    {
        super(id);
        this.setMaxStackSize(1);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName("crystalBase");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg)
    {
        this.itemIcon = reg.registerIcon("electrolysm:" + "crystal");
    }
}
