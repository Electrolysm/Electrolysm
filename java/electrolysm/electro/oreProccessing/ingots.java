package electrolysm.electro.oreProccessing;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electrolysm.electro.Electrolysm;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ingots extends Item {

	//tin = 0
	//silver = 1
	//lead = 2
	
	@SideOnly(Side.CLIENT)
	private IIcon[] ingotIcon;
	
	public ingots() {
		super();

		this.setCreativeTab(Electrolysm.TabElectrolysm);
		this.hasSubtypes = true;
	}
	
	@Override
    public String getUnlocalizedName(ItemStack stack)
    {
        int dmg = stack.getItemDamage();
        return "ingot_" + dmg;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        ingotIcon = new IIcon[3];

        for (int i = 0; i < 3; i ++)
        {
            ingotIcon[i] = reg.registerIcon("electrolysm:" + "ingot_" + i);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int dmg)
    {
        return ingotIcon[dmg];
    }

    @Override
    public void getSubItems(Item id, CreativeTabs creativeTab, List list)
    {
        for (int i = 0; i < 3; i++)
        {
            list.add(new ItemStack(Electrolysm.ingots, 1, i));
        }
    }

}
