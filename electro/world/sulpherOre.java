package assets.electrolysm.electro.world;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.block.BlockOre;

public class sulpherOre extends BlockOre {

	public sulpherOre(int id) {
		super(id);

	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.setUnlocalizedName("sulphurOre");
	this.setHardness(2F);
	}

}
