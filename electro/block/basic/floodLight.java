package assets.electrolysm.electro.block.basic;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class floodLight extends Block {

	public floodLight(int id, Material mat) {
		super(id, Material.iron);
		
		this.setUnlocalizedName("floodLight");
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setHardness(2.35685F);
	}
	
	

}
