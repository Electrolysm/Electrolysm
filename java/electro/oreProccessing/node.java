package electro.oreProccessing;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class node extends Item
{
    public node()
    {
        super();
        this.setUnlocalizedName("anode");
        this.setMaxStackSize(1);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("electrolysm:" + "electrolysisNode");
    }
}
