package assets.electrolysm.electro.research;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class knowledge extends Item
{
    public knowledge(int par1)
    {
        super(par1);
        this.setUnlocalizedName("knowledge");
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("electrolysm:" + "knowledge");
    }
}
