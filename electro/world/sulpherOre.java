package assets.electrolysm.electro.world;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import assets.electrolysm.electro.electrolysmCore;

public class sulpherOre extends Block {

	public sulpherOre(int id, Material mat) {
		super(id, Material.ground);

	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.setUnlocalizedName("sulphurOre");
	this.setHardness(2F);
	}

}
