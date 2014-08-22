package electrolysm.electro.sciences.chemistry.elements;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class elementProof extends Item
{
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public elementProof()
    {
        super();
        //this.setCreativeTab(electrolysmCore.TabElements);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister reg)
    {
        this.icons = new IIcon[ElementHandler.elements.length];

        for (int i = 0; i < icons.length; i++)
        {
            this.icons[i] = reg.registerIcon("electrolysm:atomics/" + "element-" + i);
            this.icons[0] = reg.registerIcon("electrolysm:atomics/" + "atomBase");
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int dmg)
    {
        return this.icons[dmg];
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        int dmg = stack.getItemDamage();
        return "elementProof" + ElementHandler.elements[dmg];
    }

    @Override
    public void getSubItems(Item item, CreativeTabs creativeTab, List list)
    {
        for (int i = 0; i < ElementHandler.elements.length; i++)
        {
            list.add(new ItemStack(item, 1, i));
        }
    }
}
