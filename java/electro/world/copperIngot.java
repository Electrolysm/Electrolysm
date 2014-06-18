package electro.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class copperIngot extends Item
{
    public copperIngot()
    {
        super();
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName("CopperIngot");
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("electrolysm:" + "CopperIngot");
    }
}
