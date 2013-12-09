package assets.electrolysm.electro.powerSystem;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.item.Item;

public class copperCoil extends Item {

	public copperCoil(int par1) {
		super(par1);

		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("copperCoil");
		this.setMaxStackSize(16);
	}

}
