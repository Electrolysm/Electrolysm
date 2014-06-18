package electro.world;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import electro.electrolysmCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class sulphur extends Item
{
    public sulphur()
    {
        super();
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName("sulphurcrystal");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        this.itemIcon = reg.registerIcon("electrolysm:" + "sulphur-crystal");
    }
}
