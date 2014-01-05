package assets.electrolysm.electro.powerSystem;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.item.Item;

public class copperCoil extends Item {

	public copperCoil(int par1) {
		super(par1);

		this.setUnlocalizedName("copperCoil");
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
	}

}
