package electro.oreProccessing;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import electro.common.CommonProxy;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ingots extends Item {

	//tin = 0
	//silver = 1
	//lead = 2
	
	@SideOnly(Side.CLIENT)
	private Icon[] ingotIcon;
	
	public ingots(int id) {
		super(id);

		this.setCreativeTab(electrolysmCore.TabElectrolysm);
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
    public void registerIcons(IconRegister reg)
    {
        ingotIcon = new Icon[3];

        for (int i = 0; i < 3; i ++)
        {
            ingotIcon[i] = reg.registerIcon("electrolysm:" + "ingot_" + i);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int dmg)
    {
        return ingotIcon[dmg];
    }

    public void getSubItems(int id, CreativeTabs creativeTab, List list)
    {
        for (int i = 0; i < 3; i++)
        {
            list.add(new ItemStack(electrolysmCore.ingots, 1, i));
        }
    }

}
