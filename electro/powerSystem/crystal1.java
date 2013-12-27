package assets.electrolysm.electro.powerSystem;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.item.Item;

public class crystal1 extends Item {

	public crystal1(int id) {
		super(id);

		this.setUnlocalizedName("crystal-tier-1");
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
	}
	
	public static String[] getData()
	{
		String[] result = {"1", "username"};
		return result;
	}

}
