package assets.electrolysm.electro.crafting.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.common.CommonProxy;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class luminousRedstone extends Item {

	public luminousRedstone(int par1) {
		super(par1);

		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setMaxStackSize(4);
		this.setUnlocalizedName("luminousRedstone");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg)
	{
		this.itemIcon = reg.registerIcon("electrolysm:" + "luminousRedstone");
	}
	

}
