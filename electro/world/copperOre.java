package assets.electrolysm.electro.world;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import assets.electrolysm.electro.electrolysmCore;

public class copperOre extends Block {

	public copperOre(int id, Material mat) {
		super(id, Material.rock);
		
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("CopperOre");
		this.setHardness(3.0F);
		this.setResistance(10.0F);
		this.setStepSound(soundStoneFootstep);

	}

	
	public void registerIcons(IconRegister reg)
    {
		this.blockIcon = reg.registerIcon("electrolysm:" + "CopperOre");
    }
    
}
	


