package assets.electrolysm.electro.powerSystem;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.item.Item;

public class copperwire extends Item {

	public copperwire(int id) {
		super(id);
	
	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.setUnlocalizedName("copperWire");
	}

}
