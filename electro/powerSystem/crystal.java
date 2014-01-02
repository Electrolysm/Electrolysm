package assets.electrolysm.electro.powerSystem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class crystal extends Item {

	public crystal(int id) {
		super(id);

		this.setMaxStackSize(1);
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("crystal");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg)
	{
		this.itemIcon = reg.registerIcon("electrolysm:" + "crystal");
	}
	
}
