package assets.electrolysm.electro.sciences.robotics;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class metalSheet extends Item
{
    public metalSheet(int id)
    {
        super(id);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName("metalSheet");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("Electrolysm:" + this.getUnlocalizedName().replace("item.", ""));
    }
}
