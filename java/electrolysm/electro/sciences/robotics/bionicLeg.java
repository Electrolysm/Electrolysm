package electrolysm.electro.sciences.robotics;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class bionicLeg extends Item
{
    public bionicLeg()
    {
        super();
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.setUnlocalizedName("bionicLeg");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("Electrolysm:" + this.getUnlocalizedName().replace("item.", ""));
    }
}
