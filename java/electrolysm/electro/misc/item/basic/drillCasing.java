package electrolysm.electro.misc.item.basic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electrolysm.electro.Electrolysm;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class drillCasing extends Item
{
    public drillCasing()
    {
        super();
        this.setUnlocalizedName("drillCasing");
        this.setCreativeTab(Electrolysm.TabElectrolysm);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("electrolysm:" + "drillCasing");
    }
}
