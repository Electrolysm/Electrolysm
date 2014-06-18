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

public class crystalOre extends Item {
	
	@SideOnly(Side.CLIENT)
	private IIcon[] crystalIcon;
	
	public crystalOre() {
		super();
		
		this.setUnlocalizedName("crystalOre");
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.hasSubtypes = true;
	}
	
	public String getUnlocalizedName(ItemStack stack)
    {
        int dmg = stack.getItemDamage();
        return "crystalOre" + CommonProxy.DUSTS[dmg];
    }
	
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
        {
            crystalIcon = new IIcon[CommonProxy.DUSTS.length];

        for (int i = 0; i < CommonProxy.DUSTS.length; i ++)
        {
        	crystalIcon[i] = reg.registerIcon("electrolysm:crystals/" + "crystal-" + CommonProxy.DUSTS[i]);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int dmg)
    {
        return crystalIcon[dmg];
    }

    public void getSubItems(int id, CreativeTabs creativeTab, List list)
    {
        for (int i = 0; i < CommonProxy.DUSTS.length; i++)
        {
            list.add(new ItemStack(electrolysmCore.crystal, 1, i));
        }
    }

}
