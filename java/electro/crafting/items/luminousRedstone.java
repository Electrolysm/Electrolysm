package electro.crafting.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.electrolysmCore;
import electro.common.CommonProxy;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class luminousRedstone extends Item
{
    public luminousRedstone()
    {
        super();
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setMaxStackSize(4);
        this.setUnlocalizedName("luminousRedstone");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        this.itemIcon = reg.registerIcon("electrolysm:" + "luminousRedstone");
    }
}
