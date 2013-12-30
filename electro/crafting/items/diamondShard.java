package assets.electrolysm.electro.crafting.items;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.item.Item;

public class diamondShard extends Item 
{

	public diamondShard(int par1) {
		super(par1);

		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("diamondShard");
	}

}
