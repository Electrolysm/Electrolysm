package assets.electrolysm.electro.world;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class sulphur extends Item {

	public sulphur(int par1) {
		super(par1);

	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.setUnlocalizedName("sulphurcrystal");
	}

	@Override 
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg)
	{
		this.itemIcon = reg.registerIcon("electrolysm:" + "sulphur-crystal");
	}
}
