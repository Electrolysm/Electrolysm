package electro.research;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.Electrolysm;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class knowledge extends Item
{
    public knowledge()
    {
        super();
        this.setUnlocalizedName("knowledge");
        this.setCreativeTab(Electrolysm.TabElectrolysm);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("electrolysm:" + "knowledge");
    }
}
