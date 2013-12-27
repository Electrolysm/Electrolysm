package assets.electrolysm.electro.powerSystem;

import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.common.CommonProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class energyMeter extends Item {

	public energyMeter(int par1) {
		super(par1);

		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("energyMeter");
		this.setMaxStackSize(1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg)
	{
		this.itemIcon = reg.registerIcon("electrolysm:" + "energyMeter");
	}
	
}
