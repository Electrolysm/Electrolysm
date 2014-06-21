package electro.block.advMachines;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.Electrolysm;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class injectionArm extends Item
{
    public injectionArm()
    {
        super();
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setUnlocalizedName("injectionArm");
        this.setMaxStackSize(1);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("electrolysm:" + "injectionArm");
    }
}
