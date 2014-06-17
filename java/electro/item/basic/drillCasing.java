package electro.item.basic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class drillCasing extends Item
{
    public drillCasing(int id)
    {
        super(id);
        this.setUnlocalizedName("drillCasing");
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("electrolysm:" + "drillCasing");
    }
}
