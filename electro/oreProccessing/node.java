package assets.electrolysm.electro.oreProccessing;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.item.Item;

public class node extends Item {

	public node(int id) {
		super(id);
		this.setUnlocalizedName("anode");
		this.setMaxStackSize(1);
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
	}

}
