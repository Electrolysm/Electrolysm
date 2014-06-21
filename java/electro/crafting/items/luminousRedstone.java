package electro.crafting.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.Electrolysm;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class luminousRedstone extends Item
{
    public luminousRedstone()
    {
        super();
        this.setCreativeTab(Electrolysm.TabElectrolysm);
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
