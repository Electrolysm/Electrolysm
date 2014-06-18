package electro.oreProccessing;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.electrolysmCore;
import electro.common.CommonProxy;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class dusts extends Item
{
    @SideOnly(Side.CLIENT)
    private IIcon[] dustIcon;

    public dusts()
    {
        super();
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.hasSubtypes = true;
    }

    public String getUnlocalizedName(ItemStack stack)
    {
        int dmg = stack.getItemDamage();
        return "dust" + CommonProxy.DUSTS[dmg];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        dustIcon = new IIcon[CommonProxy.DUSTS.length];

        for (int i = 0; i < CommonProxy.DUSTS.length; i ++)
        {
            dustIcon[i] = reg.registerIcon("electrolysm:dusts/" + "dusts-" + CommonProxy.DUSTS[i]);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int dmg)
    {
        return dustIcon[dmg];
    }

    public void getSubItems(int id, CreativeTabs creativeTab, List list)
    {
        for (int i = 0; i < CommonProxy.DUSTS.length; i++)
        {
            list.add(new ItemStack(electrolysmCore.dusts, 1, i));
        }
    }
}
